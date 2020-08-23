package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.Movie;

import com.cinemas.spring.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie save(Movie entity) {
		return movieRepository.save(entity);
	}

	@Override
	public List<Movie> saveAll(List<Movie> entities) {
		return (List<Movie>) movieRepository.saveAll(entities);
	}

	@Override
	public Optional<Movie> findById(Integer id) {
		return movieRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return movieRepository.existsById(id);
	}

	@Override
	public Iterable<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findAllById(List<Integer> ids) {
		return (List<Movie>) movieRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return movieRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		movieRepository.deleteById(id);
	}

	@Override
	public void delete(Movie entity) {
		movieRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Movie> entities) {
		movieRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		movieRepository.deleteAll();
	}

	@Override
	public Movie findByMovieId(int id) {
		return movieRepository.findByMovieId(id);
	}

	@Override
	public List<Movie> findByMovieByDate() {
		return (List<Movie>) movieRepository.findByMovieByDate();
	}
	
	@Override
	public List<Movie> movieUpcoming() {
		return (List<Movie>) movieRepository.movieUpcoming();
	}
	
    
        
	

	
}
