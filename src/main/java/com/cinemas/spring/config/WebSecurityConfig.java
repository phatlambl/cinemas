package com.cinemas.spring.config;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(PasswordEncoder());
	}	
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.antMatchers("/movies/add").hasRole("ADMIN")
						.antMatchers("/movies/saveOrUpdate").hasRole("ADMIN")
						.antMatchers("/movies/edit/{id}").hasRole("ADMIN")
						.antMatchers("/movies/delete/{id}").hasRole("ADMIN")
						.antMatchers("/movies/list").hasRole("ADMIN")
						.antMatchers("/movies/list/").hasRole("ADMIN")
						.antMatchers("/movies/**").permitAll()
					
						.antMatchers("/schedules/add").hasRole("ADMIN")
						.antMatchers("/schedules/saveOrUpdate").hasRole("ADMIN")
						.antMatchers("/schedules/list").hasRole("ADMIN")
						.antMatchers("/schedules/delete/{id}").hasRole("ADMIN")
						.antMatchers("/schedules/**").permitAll()
						
						.antMatchers("/theater/**").hasRole("ADMIN")
						.antMatchers("/getseat/**").hasRole("USER")						
						
						.antMatchers("/**").permitAll()
						.and().formLogin()
						.usernameParameter("username")
						.passwordParameter("password")
						.defaultSuccessUrl("/home")
						.failureUrl("/403")
						.and()
						.logout().logoutUrl("/logout")
						.logoutSuccessUrl("/home")
						.and()
						.exceptionHandling().accessDeniedPage("/403");

						
						
							  		
		  			
	}
	
	

	
	
	


}
