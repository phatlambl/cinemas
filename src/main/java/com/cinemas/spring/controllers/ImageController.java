package com.cinemas.spring.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinemas.spring.entities.Bookings;
import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.entities.Seat;
import com.cinemas.spring.services.BookingService;
import com.cinemas.spring.services.MovieService;
import com.cinemas.spring.services.SeatService;


@Controller
public class ImageController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="getimage/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> dowloadLinkimage(@PathVariable int id){
		Optional<Movie> sop = movieService.findById(id);
		
		if(sop.isPresent()){
			Movie movie= sop.get();
			try {
				Path filename =  Paths.get("images", movie.getPoster());
				byte[] buffer = Files.readAllBytes(filename);
				
				ByteArrayResource bsr = new ByteArrayResource(buffer);
				
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("images/png"))
						.body(bsr);
								
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@Autowired
	private SeatService seatService;
	
	
	//lay hinh status seat
	@RequestMapping(value ="seatStatus/{scheduleid}/{seatid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> seatStatus(@PathVariable(value="seatid") int id, 
			@PathVariable(value="scheduleid") int scheduleid){
		Optional<Seat> sop = seatService.findById(id);
		Seat seat = sop.get();
		String imgseat =sop.get().getColumnseat();		
		String img = imgseat +".jpg";
		
		if(sop.isPresent()){		
			
			List<Bookings> bookings = bookingService.findBookingByScheduleid(scheduleid);
			for(Bookings b: bookings)
			{
				
				if(b.getSeatid().getSeatid().equals(seat.getSeatid()) == true)
				{
					img="sold.jpg";
				}
			}
			
			try {
				Path filename =  Paths.get("images", img);
				byte[] buffer = Files.readAllBytes(filename);
				
				ByteArrayResource bsr = new ByteArrayResource(buffer);
				
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("images/png"))
						.body(bsr);
								
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return ResponseEntity.badRequest().build();
	}
}
