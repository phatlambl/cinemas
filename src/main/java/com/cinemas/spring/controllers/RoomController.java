
package com.cinemas.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemas.spring.dtos.RoomDto;
import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Seat;
import com.cinemas.spring.entities.Theater;
import com.cinemas.spring.services.RoomService;
import com.cinemas.spring.services.SeatService;



@Controller
@RequestMapping("/theater/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	SeatService seatService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		RoomDto room = new RoomDto();			
		model.addAttribute("roomDto", room);
		
		return "admin/addOrEditRoom";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@Validated RoomDto roomDto, BindingResult result) {
				
		if(result.hasErrors())
		{
			model.addAttribute("message", " please input all required fields!!");
			model.addAttribute("roomDto", roomDto);
			
			return "admin/addOrEditRoom";
		}
		if(roomDto.getRoomid() != null && roomDto.getRoomid() >0) {
			model.addAttribute("message", "The room is updated");			
		}else {
			model.addAttribute("message", "The room inserted");
		}
		Room room = new Room();
		
		
		//theater id
		Theater theater = new Theater();
		theater.setTheaterid(roomDto.getTheater());
		
		room.setTheater(theater);
		room.setRoomid(roomDto.getRoomid());
		room.setNumberRoom(roomDto.getNumberRoom());
		
		roomService.save(room);
		
	
		
		//tao ghe cho phong
		
		/*
		 * Room roomid = new Room(); roomid.setRoomid(roomDto.getRoomid());
		 * System.out.println(roomid);
		 * 
		 * Seat seatA = new Seat(); seatA.setRoomid(roomid); seatA.setRowseat("A");
		 * seatA.setColumnseat("1"); seatService.save(seatA);
		 */
		/*
		 * for (int i = 1; i <= 4; i++) {
		 * 
		 * Seat seatA = new Seat(); Seat seatB = new Seat(); Seat seatC = new Seat();
		 * 
		 * seatA.setRoomid(roomid); seatA.setRowseat("A");
		 * seatA.setColumnseat(String.valueOf(i));
		 * 
		 * seatB.setRoomid(roomid); seatB.setRowseat("B");
		 * seatB.setColumnseat(String.valueOf(i));
		 * 
		 * seatC.setRoomid(roomid); seatC.setRowseat("C");
		 * seatC.setColumnseat(String.valueOf(i));
		 * 
		 * seatService.save(seatA); seatService.save(seatB); seatService.save(seatC);
		 * 
		 * }
		 */
			 
		 
		
		
		
		model.addAttribute("roomDto", roomDto);
				
		return "admin/addOrEditRoom";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name="id") Integer id) {
		Optional<Room> room = roomService.findById(id);
		if(room.isPresent()) {
			model.addAttribute("roomDto", room.get());
		}else {
			return list(model);
		}
		
		return "admin/addOrEditRoom";
	}
	
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Room> list = (List<Room>) roomService.findAll();
		model.addAttribute("room", list);		
		
		return "admin/listRoom";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name="id") Integer id) {
		roomService.deleteById(id);
		
		return list(model);
	}
	
	@ModelAttribute(name="theaters")
	public List<Theater> listTheater(){
		return roomService.findAllTheater();
	}

	
}
