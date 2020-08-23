package com.cinemas.spring.controllers;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cinemas.spring.dtos.ScheduleDto;
import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.ScheduleByMovie;
import com.cinemas.spring.entities.ScheduleByTheater;
import com.cinemas.spring.entities.Schedules;
import com.cinemas.spring.entities.Theater;
import com.cinemas.spring.repositories.ScheduleRepository;
import com.cinemas.spring.services.MovieService;
import com.cinemas.spring.services.RoomService;
import com.cinemas.spring.services.ScheduleService;
import com.cinemas.spring.services.TheaterService;
import com.google.gson.Gson;




@Controller
@RequestMapping("/schedules")
public class ScheduledController {
	
	
	@Autowired
	private ScheduleService scheduleServie;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private RoomService roomService;

	@Autowired
	private ScheduleRepository scheduleRepository;


	@GetMapping("/add")
	public String add(ModelMap model) {
		ScheduleDto scheduleDto = new ScheduleDto();
		model.addAttribute("scheduleDto", scheduleDto);
		
		return "admin/addOrEditSchedule";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @Validated ScheduleDto scheduleDto, BindingResult result) {
		
		
		if(result.hasErrors()) { 
			model.addAttribute("message", "please input all required!!");
			model.addAttribute("scheduleDto", scheduleDto);
		  
		  return "admin/addOrEditSchedule";
		}
		//kiem tra xem co trung voi schedule nao khong
		Date Date = scheduleDto.getDate();
		Format formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatDate.format(Date);	
		
		Date dateTime = scheduleDto.getTime();
		Format formatTimer = new SimpleDateFormat("HH:mm:ss");
		String time = formatTimer.format(dateTime);
		 
		System.out.println(scheduleDto.getRoom());
		System.out.println(date);
		System.out.println(time);
		
		Optional<Schedules> scheduleopt = scheduleServie.findByRoomAndDate(scheduleDto.getRoom(), date, time);
	
		if(scheduleopt.isPresent())
		{
			
			model.addAttribute("message", "schedule is duplicated, please review");
			System.out.println("trung lap");
			return "admin/addOrEditSchedule";
		}
		
		 
		if(scheduleDto.getScheduleid() != null && scheduleDto.getScheduleid() > 0)
		{
			model.addAttribute("message", "The Schedule is update");			
		}else {
			model.addAttribute("message", "The schedule is inserted");
		}
		Schedules schedules = new Schedules();		
		schedules.setDate(scheduleDto.getDate());
		schedules.setTime(scheduleDto.getTime());
		schedules.setScheduleid(scheduleDto.getScheduleid());		
		
		
		//movie
		Movie movie = new Movie();
		movie.setMovieid(scheduleDto.getMovie());
		schedules.setMovie(movie);
		
		//room
		Room room = new Room();
		room.setRoomid(scheduleDto.getRoom());
		schedules.setRoom(room);	
		scheduleServie.save(schedules);			
		model.addAttribute("scheduleDto", scheduleDto);
		
		return "admin/addOrEditSchedule";
	}
	
	
	
	@GetMapping("/list")
	public String listSchedules(ModelMap model, @RequestParam(defaultValue = "0") int page) {
		Page<Schedules> list = scheduleRepository.findAll(PageRequest.of(page, 10));
		model.addAttribute("Schedules", list);
		model.addAttribute("CurrentPage", page);
		
		return "admin/listSchedules";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name="id") Integer id) {
		Optional<Schedules> optSchedules = scheduleServie.findById(id);
		if (optSchedules.isPresent()) {
			model.addAttribute("scheduleDto", optSchedules.get());
		} else {
			return "redirect:admin/listSchedules";
		}
		return "admin/addOrEditSchedule";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name="id") Integer id) {
		
		scheduleServie.deleteById(id);
		return "admin/addOrEditSchedule";
	}
	
	@ModelAttribute(name="movies")
	public List<Movie> listMovies(){
		return scheduleServie.findAllMovie();
	}
	
	@ModelAttribute(name="moviesCurrent")
	public List<Movie> listMoviesCurrent(){
		return movieService.findByMovieByDate();
	}
	@ModelAttribute(name="theaters")
	public List<Theater> listTheater(){
		return roomService.findAllTheater();
	}
	/*
	 * @ModelAttribute(name="rooms") public List<Room> listRoom(@RequestParam
	 * Integer theaterid, Theater theater){ theater.getTheaterid(); return
	 * roomService.findRoomByTheater(theaterid); }
	 */
	
	@ResponseBody
	@RequestMapping(value="/loadRoomByTheater/{id}", method = RequestMethod.GET)
	public String loadRoomByTheater(@PathVariable("id") int id) {
		
		Gson gson = new Gson();			
		return gson.toJson(roomService.findRoomByTheater(id));
	}
	
	//lich chieu theo phim
	@RequestMapping(value="/scheduleByFilm/{movieid}", method = RequestMethod.GET)
	public String scheduleByFilm(@PathVariable("movieid") Integer movieid, ModelMap model) {
		
		  Date date = new Date(); 
		  Format formatter = new SimpleDateFormat("yyyy-MM-dd"); String s = formatter.format(date);	
		  model.addAttribute("date", s);
		  
		  Optional<Movie> movie = movieService.findById(movieid);
		  model.addAttribute("movie", movie.get());
		  
		  
		  //lay lich chieu cua tat ca cac rap
		  List<Schedules> schedulesByFilm = scheduleServie.findByMovie(movieid, s);		  
		  model.addAttribute("schedule", schedulesByFilm);
		  
		 
		  //lay danh sach rap chieu phim co phim can tim
		  Set<Integer> listTheater = new HashSet<Integer>();
		  List<Integer> listId = new ArrayList<Integer>(); 
		  for(Schedules schedule : schedulesByFilm)
		  {
			  listTheater.add(schedule.getRoom().getTheater().getTheaterid());
			 
		  }
			/* System.out.println(listTheater); */
		  for(Integer ids : listTheater)
		  {  
			 listId.add(ids);
			  
		  }
		  List<Theater> theater = theaterService.findAllById(listId);		  
		  model.addAttribute("Theater", theater); // ta duoc danh sach rap chieu phim can tim
		  
		  //lay lich chieu theo tung rap		
		Set<ScheduleByTheater> list = new HashSet<ScheduleByTheater>();		
		for (Integer getTheater : listTheater) {
			
			List<Schedules> listSchedule = new ArrayList<Schedules>();
			ScheduleByTheater scheduleByTheater = new ScheduleByTheater();
			Optional<Theater> theaterid = theaterService.findById(getTheater);
			
			for (Schedules schedule : schedulesByFilm) {
				if (schedule.getRoom().getTheater().getTheaterid()==getTheater) {
					listSchedule.add(schedule);
				}
			}						
			scheduleByTheater.setId(getTheater);			
			scheduleByTheater.setTheater(theaterid.get());
			scheduleByTheater.setSchedule(listSchedule);
			list.add(scheduleByTheater);			
		}
		/* System.out.println(list); */
		model.addAttribute("list", list);	
		model.addAttribute("title", "Lịch chiếu theo phim");
		 
		return "schedules/scheduleByFilm";
	}
	
	//lich chieu theo rap
	@RequestMapping(value="/scheduleByTheater/{theater}", method = RequestMethod.GET)	
	public String scheduleByTheater(@PathVariable("theater") Integer theaterid, ModelMap model) {
				
		//select schedule by date
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = formatter.format(date);		
		List<Schedules> schedules = new ArrayList<Schedules>();
		schedules = scheduleServie.findByRoom(datetime);
		/* System.out.println(schedules); */
		
		
		  //select schedule date by theater 
		List<Schedules> listByTheater = new ArrayList<Schedules>(); 
		for(Schedules schedule : schedules)
		{			
			if(schedule.getRoom().getTheater().getTheaterid() == theaterid) 
			{
				listByTheater.add(schedule);
			} 		 
		}
		 
		//danh sach phim co trong rap
		Set<Movie> listMovie = new HashSet<Movie>();
		for(Schedules schedule : schedules)
		{
			if(schedule.getRoom().getTheater().getTheaterid() == theaterid)
			{
				listMovie.add(schedule.getMovie());
			}
		}
		
		
		//lay lich chieu theo tung phim
		Set<ScheduleByMovie> list = new HashSet<ScheduleByMovie>();
		for(Movie movie: listMovie)
		{
			List<Schedules> listSchedule = new ArrayList<Schedules>();
			ScheduleByMovie scheduleByMovie = new ScheduleByMovie();
			for(Schedules schedule : listByTheater)
			{
				if(schedule.getMovie()==movie)
				{
					listSchedule.add(schedule);
				}				
			}
			scheduleByMovie.setMovie(movie);
			scheduleByMovie.setSchedule(listSchedule);
			list.add(scheduleByMovie);
		}
		
		model.addAttribute("list", list);	 	
		model.addAttribute("title", "Lịch Chiếu Theo Rạp");
		
		return "schedules/scheduleByTheater";
	}
		
	@RequestMapping(value="/selectTheater", method = RequestMethod.GET)
	public String selectTheater(ModelMap model) {
		List<Theater> list = (List<Theater>) theaterService.findAll();
		model.addAttribute("theater", list);
		model.addAttribute("title", "Lịch Chiếu Theo Rạp");
		return "schedules/selectTheater";
	}
	
	@GetMapping(value="/selectFilm")
	public String selectFilm(ModelMap model) {
		List<Movie> movieCurrent = movieService.findByMovieByDate();
		model.addAttribute("movies", movieCurrent);	
		model.addAttribute("title", "Lịch Chiếu Theo Phim");
		return "schedules/selectFilm";
	}
	
}
