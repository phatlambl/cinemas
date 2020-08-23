package com.cinemas.spring.services;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ResourceServerConfig extends WebSecurityConfigurerAdapter{
	
	  @Override	  
	  @Bean public AuthenticationManager authenticationManagerBean() throws
	  Exception { return super.authenticationManagerBean(); }
	 

}
