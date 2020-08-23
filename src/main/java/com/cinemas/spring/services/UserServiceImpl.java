package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.User;
import com.cinemas.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	private String username;
	
	@Override
	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public Integer findByAccountname(String name){
		return userRepository.findByAccountname(name);
	}
	
	public UserServiceImpl(String username)
	{
		this.username = username;
	}
	public UserServiceImpl() {
		
	}
	
	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public List<User> saveAll( List<User> entities) {
		return ( List<User>) userRepository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public  List<User> findAllById(List<Integer> ids) {
		return ( List<User>) userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAll( List<User> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	

}
