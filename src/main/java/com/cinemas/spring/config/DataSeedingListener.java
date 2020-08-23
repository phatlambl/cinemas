package com.cinemas.spring.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cinemas.spring.entities.Role;
import com.cinemas.spring.entities.User;
import com.cinemas.spring.repositories.RoleRepository;
import com.cinemas.spring.repositories.UserRepository;


@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent>{

	  @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired 
	    private PasswordEncoder passwordEncoder;

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			//Roles
			if(roleRepository.findByName("ROLE_ADMIN")==null) {
				roleRepository.save(new Role("ROLE_ADMIN"));	
				
			}
			if(roleRepository.findByName("ROLE_USER")==null) {
				roleRepository.save(new Role("ROLE_USER"));
			}
			
			//admin account
			if(userRepository.findByUsername("admin")==null) {
				User admin = new User();
				admin.setUserName("admin");
				admin.setPassword(passwordEncoder.encode("123456"));
				HashSet<Role> roles = new HashSet<>();
				roles.add(roleRepository.findByName("ROLE_ADMIN"));
				roles.add(roleRepository.findByName("ROLE_USER")); 
				admin.setRoles(roles);
				userRepository.save(admin);
			}
			
			//user account
			if(userRepository.findByUsername("user")==null)
			{
				User user = new User();
				user.setUserName("user");
				user.setPassword(passwordEncoder.encode("123456"));
				HashSet<Role> roles = new HashSet<>();
				roles.add(roleRepository.findByName("ROLE_USER"));
				user.setRoles(roles);
				userRepository.save(user);
			}
	   
			
		}

}
