package com.cinemas.spring.controllers;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cinemas.spring.dtos.UserDto;
import com.cinemas.spring.entities.Role;
import com.cinemas.spring.entities.User;
import com.cinemas.spring.repositories.RoleRepository;
import com.cinemas.spring.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	 @Autowired 
	 private PasswordEncoder passwordEncoder;
	 
	  @Autowired
	    private RoleRepository roleRepository;
	

	
	
	@RequestMapping("/login")
	public String Login(ModelMap model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your name and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logout successfully");

		return "customers/login";
	}
	 
	
	@GetMapping("/register")
	public String register(ModelMap model,UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Please input all required fields!!");
			model.addAttribute("register", userDto);

			return "customers/register";
		}
		model.addAttribute("title", "Đăng Ký");
		model.addAttribute("register", userDto);
		
		return "customers/register";
	}
		
	
	@PostMapping("/saveOrUpdate")
	public String SaveOrUpdate(ModelMap model, @Validated UserDto userDto, BindingResult Result) {
		
	
		model.addAttribute("register", userDto);
		 if(Result.hasErrors())
		 {
			 model.addAttribute("message", "Please input all required fields");
			 return "customers/register";
		 }
		 User user = new User();
		 user.setUserid(userDto.getUserid());
		 user.setUserName(userDto.getUsername());
		 
		 String password = passwordEncoder.encode(userDto.getPassword());
		 user.setPassword(password);
		 user.setClientname(userDto.getClientname());
		 user.setPhonenumber(userDto.getPhonenumber());
		 user.setEmail(userDto.getEmail());
		 user.setActive(true);
		 HashSet<Role> roles = new HashSet<>();
		 roles.add(roleRepository.findByName("ROLE_USER"));
		 user.setRoles(roles);
		 
		 
		 userService.save(user);
		 model.addAttribute("message", "Register successfully");		
		
		return "redirect:/home";		

	}
	
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<User> list = (List<User>) userService.findAll();
		model.addAttribute("users", list);
		
		return "admin/list";
	}
	
	
	
	
}
