package com.cinemas.spring.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cinemas.spring.entities.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query(value = "select * from movie where movieid = :id", nativeQuery = true)
	public Movie findByMovieId(@Param("id") int id);
	
	@Query(value = "select * from movie where end > current_date AND premiere < CURRENT_DATE ", nativeQuery = true)
	public List<Movie> findByMovieByDate();

	
	  @Query(value = "SELECT * FROM movie WHERE premiere > CURRENT_DATE ",
	  nativeQuery = true) public List<Movie> movieUpcoming();
	 
}
