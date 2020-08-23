package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import com.cinemas.spring.entities.Theater;

public interface TheaterService {

	void deleteAll();

	void deleteAll(List<Theater> entities);

	void delete(Theater entity);

	void deleteById(Integer id);

	long count();

	List<Theater> findAllById(List<Integer> ids);

	Iterable<Theater> findAll();

	boolean existsById(Integer id);

	Optional<Theater> findById(Integer id);

	List<Theater> saveAll(List<Theater> entities);

	Theater save(Theater entity);

}
