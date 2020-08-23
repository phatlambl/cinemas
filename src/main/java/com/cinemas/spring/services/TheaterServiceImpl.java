package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.Theater;
import com.cinemas.spring.repositories.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService{

	@Autowired
	private TheaterRepository theaterRepository;

	@Override
	public Theater save(Theater entity) {
		return theaterRepository.save(entity);
	}

	@Override
	public List<Theater> saveAll(List<Theater> entities) {
		return (List<Theater>)theaterRepository.saveAll(entities);
	}

	@Override
	public Optional<Theater> findById(Integer id) {
		return theaterRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return theaterRepository.existsById(id);
	}

	@Override
	public Iterable<Theater> findAll() {
		return theaterRepository.findAll();
	}

	@Override
	public List<Theater> findAllById(List<Integer> ids) {
		return (List<Theater>)theaterRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return theaterRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		theaterRepository.deleteById(id);
	}

	@Override
	public void delete(Theater entity) {
		theaterRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Theater> entities) {
		theaterRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		theaterRepository.deleteAll();
	}
	
	
}
