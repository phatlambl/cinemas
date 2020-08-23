package com.cinemas.spring.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.cinemas.spring.entities.Movie;


public interface MovieService {

	void deleteAll();

	void deleteAll(List<Movie> entities);

	void delete(Movie entity);

	void deleteById(Integer id);

	long count();

	List<Movie> findAllById(List<Integer> ids);

	Iterable<Movie> findAll();

	boolean existsById(Integer id);

	Optional<Movie> findById(Integer id);

	List<Movie> saveAll(List<Movie> entities);

	Movie save(Movie entity);
	


	/*
	 * List<Movie> getFiles();
	 * 
	 * Optional<Movie> getFile(Integer fileId);
	 * 
	 * Movie saveFile(MultipartFile file);
	 */
	/* List<Movie> findByEndBefore(Date premiere); */
		
	Movie findByMovieId(int id);
	
	List<Movie> findByMovieByDate();

	List<Movie> movieUpcoming(); 

	List<Movie> movielist = new ArrayList<Movie>();

}
