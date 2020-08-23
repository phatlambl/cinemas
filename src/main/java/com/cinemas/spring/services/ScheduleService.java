package com.cinemas.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Schedules;

public interface ScheduleService {

	List<Movie> findAllMovie();

	void deleteAll();

	void deleteAll(List<Schedules> entities);

	void delete(Schedules entity);

	void deleteById(Integer id);

	long count();

	List<Schedules> findAllById(List<Integer> ids);

	Iterable<Schedules> findAll();

	boolean existsById(Integer id);

	Optional<Schedules> findById(Integer id);

	List<Schedules> saveAll(List<Schedules> entities);

	Schedules save(Schedules entity);

	List<Room> findRoomByTheater(int id);

	List<Schedules> findByMovie(Integer movieid, String date);

	List<Schedules> findByRoom(String date);

	Optional<Schedules> findByRoomAndDate(Integer roomid, String date, String time);

	

}
