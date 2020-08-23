package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import com.cinemas.spring.entities.User;

public interface UserService {

	void deleteAll();

	void deleteAll(List<User> entities);

	void delete(User entity);

	void deleteById(Integer id);

	long count();

	List<User> findAllById(List<Integer> ids);

	Iterable<User> findAll();

	boolean existsById(Integer id);

	Optional<User> findById(Integer id);

	List<User> saveAll(List<User> entities);

	User save(User entity);

	Integer findByAccountname(String name);

	User findByUsername(String userName);

}
