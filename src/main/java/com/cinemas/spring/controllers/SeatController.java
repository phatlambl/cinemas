package com.cinemas.spring.controllers;


import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cinemas.spring.dtos.BookingDto;
import com.cinemas.spring.entities.Bookings;
import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Schedules;
import com.cinemas.spring.entities.Seat;
import com.cinemas.spring.entities.User;
import com.cinemas.spring.services.BookingService;
import com.cinemas.spring.services.ScheduleService;
import com.cinemas.spring.services.SeatService;
import com.cinemas.spring.services.UserService;

@Controller
@RequestMapping("/getseat")
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private UserService userService;
		

	
	
	@RequestMapping(value="/{scheduleid}", method = RequestMethod.GET )
	public String getSeatBySchedule(@PathVariable("scheduleid") Integer id, ModelMap model) {
		Optional<Schedules> sop = scheduleService.findById(id);
		if(sop.isPresent())
		{
			Schedules schedule = sop.get();
			Integer scheduleid = schedule.getScheduleid();
			Integer roomid= schedule.getRoom().getRoomid();			
			
			List<Seat> seatRowA = seatService.findByRoomIdAndRow(roomid, "A");
			List<Seat> seatRowB = seatService.findByRoomIdAndRow(roomid, "B");
			List<Seat> seatRowC = seatService.findByRoomIdAndRow(roomid, "C");
					
			
			
			
			if (seatRowA.isEmpty() && seatRowB.isEmpty() && seatRowC.isEmpty()) {

				for (int i = 1; i <= 4; i++) {

					Seat seatA = new Seat();
					Seat seatB = new Seat();
					Seat seatC = new Seat();

					seatA.setRoomid(schedule.getRoom());
					seatA.setRowseat("A");
					seatA.setColumnseat(String.valueOf(i));

					seatB.setRoomid(schedule.getRoom());
					seatB.setRowseat("B");
					seatB.setColumnseat(String.valueOf(i));

					seatC.setRoomid(schedule.getRoom());
					seatC.setRowseat("C");
					seatC.setColumnseat(String.valueOf(i));

					seatService.save(seatA);
					seatService.save(seatB);
					seatService.save(seatC);

				}
			}
			 
			
			seatRowA = seatService.findByRoomIdAndRow(roomid, "A");
			seatRowB = seatService.findByRoomIdAndRow(roomid, "B");
			seatRowC = seatService.findByRoomIdAndRow(roomid, "C");
			
			model.addAttribute("seatRowA", seatRowA);
			model.addAttribute("seatRowB", seatRowB);
			model.addAttribute("seatRowC", seatRowC);
			model.addAttribute("scheduleid", scheduleid);			
			
			Optional<Schedules> scheduleopt =  scheduleService.findById(id);			
			Schedules scheduleSelect= scheduleopt.get();
			int cost = 60000;
			
			
			model.addAttribute("scheduleSelect", scheduleSelect);			
			model.addAttribute("cost", cost);	
			
		}
		
		
		return "seat";
	}
	
	/*
	 * @RequestMapping(value="/{scheduleid}/{seatid}", method = RequestMethod.GET)
	 * public String book(@PathVariable ("scheduleid") Integer
	 * id, @PathVariable("seatid") Integer seatid, ModelMap model) {
	 * 
	 * Optional<Seat> seatopt = seatService.findById(seatid); Optional<Schedules>
	 * scheduleopt = scheduleService.findById(id); Seat seat = seatopt.get();
	 * Schedules schedule= scheduleopt.get(); int cost = 60000;
	 * 
	 * model.addAttribute("seat", seat); model.addAttribute("schedule", schedule);
	 * model.addAttribute("cost", cost);
	 * 
	 * 
	 * return "seat"; }
	 */
	

	
	//lay data seatid
	@RequestMapping(value="/{scheduleid}/save", method = RequestMethod.POST)	
	public String selectseatid(@PathVariable ("scheduleid") Integer scheduleid,@RequestParam(value="selectseatid") Integer[] select, ModelMap model) {
		
		BookingDto bookingDto = new BookingDto();
		model.addAttribute("bookingDto", bookingDto);
		 
		 //lay Movie, room, date
		 Optional<Schedules> scheduleopt = scheduleService.findById(scheduleid);
		 Schedules schedule = scheduleopt.get();
		 model.addAttribute("schedule", schedule);
		
		
		//lay cost theo so ve
		int cost= 50000;
		int total = cost * select.length;
		model.addAttribute("cost", total);
		
		 //lay seat
		//c1: dung dieu kien if
		if(select.length == 1)
		{
			List<Seat> seat = seatService.findBySeatid(select[0], null, null, null);			
			model.addAttribute("Listseat", seat);
			
			
		}else if(select.length==2)
		{
			List<Seat> seat = seatService.findBySeatid(select[0], select[1], null, null);
			model.addAttribute("Listseat", seat);
		
		}else if(select.length==3)
		{
			List<Seat> seat = seatService.findBySeatid(select[0], select[1], select[2], null);			
			model.addAttribute("Listseat", seat);
			
		}else if(select.length==4)
		{
			List<Seat> seat = seatService.findBySeatid(select[0], select[1], select[2], select[3]);			
			model.addAttribute("Listseat", seat);
			
		}
		
		//c2: dung vong lap for
		/*
		 * for(int i = 0; i < select.length; i++) { List<Seat> seat =
		 * seatService.findBySeatid(select[0], select[1], select[2], select[3]);
		 * List<Seat> seatDisplay = seatService.ListSelectseat(select[0], select[1],
		 * select[2], select[3]); model.addAttribute("Listseat", seat);
		 * 
		 * }
		 */	
		
		
		
		return "booking";
	}

	@PostMapping(value="/{schedulesid}/booking")
	public String savebooking(@PathVariable("schedulesid") Integer scheduleid, ModelMap model, BookingDto bookingDto,
			@RequestParam("seatid") Integer[] seatid, HttpServletRequest request, BindingResult result ) {
	
		for (Integer integer : seatid) {
			System.out.println(integer);
		}
		double cost= 50000;
		/*
		 * double total = cost * seatid.length; model.addAttribute("cost", total);
		 */
		model.addAttribute("bookingDto", bookingDto);
		
		//Lay current time date
		Date date = new Date();
		Long time = date.getTime();		
		Timestamp ts = new Timestamp(time);
		
		
		Optional<Schedules> scheduleopt = scheduleService.findById(scheduleid);
		if(scheduleopt.isPresent()) {
			
			for (Integer integer : seatid) {
				Schedules schedule = scheduleopt.get();
				Optional<Seat> seat = seatService.findById(integer);
				Seat selectSeatid = seat.get();
				
								
				Principal principal = request.getUserPrincipal();
				User user = userService.findByUsername(principal.getName().toString());	
				
				Bookings bookings = new Bookings();
				bookings.setSchedulesid(schedule);
				bookings.setSeatid(selectSeatid);
				bookings.setUserid(user);
				bookings.setBookingid(bookingDto.getBookingid());
				bookings.setCost(cost);
				bookings.setDate(ts);
				
				bookingService.save(bookings);			
			}			
		}
		
		model.addAttribute("message", "Đặt vé thành công");
		
		
		return "redirect:/";
	}
	
	
	
	
	
	
	/*
	 * @RequestMapping(value="/{scheduleid}/{seatid}", method = RequestMethod.POST)
	 * public String savebook(@PathVariable ("scheduleid") Integer
	 * id, @PathVariable("seatid") Integer seatid, ModelMap model, BookingDto
	 * bookingDto, HttpServletRequest request) {
	 * 
	 * Optional<Seat> seatopt = seatService.findById(seatid); Optional<Schedules>
	 * scheduleopt = scheduleService.findById(id); Seat seat = seatopt.get();
	 * Schedules schedule= scheduleopt.get(); int cost = 60000;
	 * 
	 * model.addAttribute("seat", seat); model.addAttribute("schedule", schedule);
	 * model.addAttribute("cost", cost);
	 * 
	 * Schedules schedules = new Schedules();
	 * schedules.setScheduleid(bookingDto.getSchedulesid()); Seat seats = new
	 * Seat(); seats.setSeatid(bookingDto.getSeatid());
	 * 
	 * User user = new User(); user = (User)
	 * request.getSession().getAttribute("currentUser");
	 * 
	 * 
	 * Bookings bookings = new Bookings();
	 * bookings.setBookingid(bookingDto.getBookingid());
	 * bookings.setSchedulesid(schedules); bookings.setSeatStatus(1);
	 * bookings.setSeatid(seats); bookings.setUserid(user);
	 * bookingService.save(bookings); model.addAttribute("booking", bookings);
	 * request.getSession().setAttribute("booking", bookings);
	 * 
	 * 
	 * 
	 * 
	 * return "seat"; }
	 */
	
	

}
