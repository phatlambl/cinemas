package com.cinemas.spring.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cinemas.spring.dtos.MovieDto;
import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.repositories.MovieRepository;
import com.cinemas.spring.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	

	/*
	 * @GetMapping("/findone")
	 * 
	 * @ResponseBody public Optional<Movie> findOne(Integer id) {
	 * 
	 * return movieRepository.findById(id);
	 * 
	 * }
	 */
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		MovieDto movie = new MovieDto();
		model.addAttribute("movieDto", movie);
		return "admin/addOrEditMovie";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @Validated MovieDto movieDto, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("message", "Please input all required fields!!");
			model.addAttribute("movieDto", movieDto);

			return "admin/addOrEditMovie";
		}
		Path path = Paths.get("images/");

		String message = "new movie inserted!";

		if (movieDto.getMovieid() != null && movieDto.getMovieid() > 0) {
			message = "The movie updated!";

		}

		try (InputStream inputStream = movieDto.getPoster().getInputStream()) {
			Files.copy(inputStream, path.resolve(movieDto.getPoster().getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			String filename = movieDto.getPoster().getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Error: " + e.getMessage());
		}

		Movie movie = new Movie();
		movie.setMovieid(movieDto.getMovieid());
		movie.setMoviename(movieDto.getMoviename());
		movie.setActor(movieDto.getActor());
		movie.setDirector(movieDto.getDirector());
		movie.setIntroduction(movieDto.getIntroduction());
		movie.setPoster(movieDto.getPoster().getOriginalFilename());
		movie.setEnd(movieDto.getEnd());
		movie.setPremiere(movieDto.getPremiere());
		movie.setType(movieDto.getType());

		//lay trailer
		String trailer = new String();
		trailer = movieDto.getTrailer();		
		String[] youtube = trailer.split("=");
		System.out.println(youtube);
		movie.setTrailer(youtube[1]);			
		
		
		
		movieService.save(movie);
		model.addAttribute(movieDto);
		model.addAttribute("message", message);

		
		return "admin/addOrEditMovie";

	}
	
	
	
	

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Integer id) {
		Optional<Movie> optMovie = movieService.findById(id);
		if (optMovie.isPresent()) {
			Movie movie = new Movie();
			movie = optMovie.get();
			movie.setTrailer("https://www.youtube.com/watch?v=" + optMovie.get().getTrailer());
			
			model.addAttribute("movieDto", movie);
		} else {
			return list(model);
		}

		return "admin/addOrEditMovie";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
		movieService.deleteById(id);

		return list(model);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		/*
		 * List<Movie> list = (List<Movie>) movieService.findAll();
		 * model.addAttribute("movies", list);
		 */

		return "redirect:/movies/list/";
	}
	@RequestMapping(value="/list/", method = RequestMethod.GET)
	public String listShowPage(ModelMap model, @RequestParam(defaultValue = "0") int page) {
		
		model.addAttribute("movies", movieRepository.findAll(PageRequest.of(page, 5)));
		model.addAttribute("CurrentPage", page);

		return "admin/listMovie";
	}
	
	/*
	 * @GetMapping("/") public String showPage(ModelMap
	 * model, @RequestParam(defaultValue = "0") int page) {
	 * 
	 * model.addAttribute("movies", movieRepository.findAll(PageRequest.of(page,
	 * 4))); model.addAttribute("CurrentPage", page);
	 * 
	 * return "admin/index"; }
	 */

	@GetMapping("/phimdangchieu")
	public String listCurrent(ModelMap model) {
		List<Movie> movieCurrent = movieService.findByMovieByDate();
		model.addAttribute("movieCurrent", movieCurrent);	
		model.addAttribute("title", "Phim Đang Chiếu");
		
		return "movies/movieCurrent";
	}
	
	
	@GetMapping("/phimsapchieu")
	public String listUpcoming(ModelMap model) {
		List<Movie> movieUpcoming = movieService.movieUpcoming();
		model.addAttribute("movieUpcoming", movieUpcoming);
		
		model.addAttribute("title", "Phim Sắp Chiếu");
		

		return "movies/movieUpcoming";
	}
	 

	/*
	 * @PostMapping("/detail") public String detail(ModelMap
	 * model, @ModelAttribute("movieForm") Movie movie) {
	 * 
	 * List<Movie> movielist =(List<Movie>)movieService.findAll();
	 * model.addAttribute("movies",movielist); return "redirect:movies/movieDetail";
	 * }
	 */
	
	@GetMapping("/detail/{id}")
	public String detail(ModelMap model, @PathVariable(name="id") int id) {
		Movie movieid = movieService.findByMovieId(id);
		model.addAttribute("movieDetail", movieid);	
	
		
		return "movies/movieDetail";
	}

}
