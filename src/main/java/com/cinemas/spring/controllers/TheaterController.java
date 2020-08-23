package com.cinemas.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemas.spring.dtos.TheaterDto;
import com.cinemas.spring.entities.Theater;
import com.cinemas.spring.services.TheaterService;

@Controller
@RequestMapping("/theater")
public class TheaterController {
	
	@Autowired
	private TheaterService theaterServie;
	
	@GetMapping("/add")
	public String add(ModelMap model)
	{
		TheaterDto rap = new TheaterDto();
		model.addAttribute("theaterDto", rap);
		return "admin/addOrEditTheater";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@Validated TheaterDto theaterDto, BindingResult result ) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Please input all required fields!!");
			model.addAttribute("theaterDto", theaterDto);		
			
			return "admin/addOrEditTheater";
		
		}
		
		if(theaterDto.getTheaterid() != null && theaterDto.getTheaterid() >0) {
			model.addAttribute("message", "The movie theater update!");
		}else {
			model.addAttribute("message", "The movie theater inserted");
		}
		Theater theater = new Theater();
		theater.setTheaterid(theaterDto.getTheaterid());
		theater.setName(theaterDto.getName());
		theater.setAddress(theaterDto.getAddress());
		theater.setManager(theaterDto.getManager());
		theater.setPhoneNumber(theaterDto.getPhoneNumber());
		
		theaterServie.save(theater);			
		return"admin/addOrEditTheater";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name="id") Integer id, TheaterDto theaterDto) {
		
		Optional<Theater> optTheater = theaterServie.findById(id);			
		if(optTheater.isPresent()) {
			model.addAttribute("theaterDto", optTheater.get());			
		}else {
			return list(model);
		}				
		
		return "admin/addOrEditTheater";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name="id") Integer id) {
		theaterServie.deleteById(id);
		
		return list(model);
	}
	
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Theater> list = (List<Theater>) theaterServie.findAll();
		model.addAttribute("theater", list);
		return "admin/listTheater";
	}
		
	
	
	
}
