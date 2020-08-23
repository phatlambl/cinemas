package com.cinemas.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.services.MovieService;

@Controller
public class HomeController {

	@Autowired
	MovieService movieService;
	
	
	
	@RequestMapping(value= {"", "/home"}, method =RequestMethod.GET )
	public String home(ModelMap model) {
		List<Movie> movieCurrent = movieService.findByMovieByDate();
		model.addAttribute("movieCurrent", movieCurrent);
		
		List<Movie> movieUpcoming = movieService.movieUpcoming();
		model.addAttribute("movieUpcoming", movieUpcoming);
		
		model.addAttribute("title", "Trang chủ");
	
		return "home";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping(value="/admin")
	public String homeAdmin() {
		
		return "admin/homeAdmin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:home";
	}
}
