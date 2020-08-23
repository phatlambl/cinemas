package com.cinemas.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.Movie;
import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Schedules;
import com.cinemas.spring.repositories.MovieRepository;
import com.cinemas.spring.repositories.RoomRepository;
import com.cinemas.spring.repositories.ScheduleRepository;
import com.cinemas.spring.repositories.TheaterRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	ScheduleRepository schedueRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Schedules save(Schedules entity) {
		return schedueRepository.save(entity);
	}

	@Override
	public List<Schedules> saveAll(List<Schedules> entities) {
		return (List<Schedules>)schedueRepository.saveAll(entities);
	}

	@Override
	public Optional<Schedules> findById(Integer id) {
		return schedueRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return schedueRepository.existsById(id);
	}

	@Override
	public Iterable<Schedules> findAll() {
		return schedueRepository.findAll();
	}

	@Override
	public List<Schedules> findAllById(List<Integer> ids) {
		return (List<Schedules>)schedueRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return schedueRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		schedueRepository.deleteById(id);
	}

	@Override
	public void delete(Schedules entity) {
		schedueRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Schedules> entities) {
		schedueRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		schedueRepository.deleteAll();
	}
	
	@Override
	public List<Movie> findAllMovie(){
		return (List<Movie>)movieRepository.findAll();
	}

	@Override
	public List<Room> findRoomByTheater(int id) {
		return roomRepository.findRoomByTheater(id);
	}

	@Override
	public List<Schedules> findByMovie(Integer movieid, String date) {
		return schedueRepository.findByMovie(movieid, date);
	}

	@Override
	public List<Schedules> findByRoom(String date) {
		return schedueRepository.findByRoom(date);
	}

	@Override
	public Optional<Schedules> findByRoomAndDate(Integer roomid, String date, String time) {
		return schedueRepository.findByRoomAndDate(roomid, date, time);
	}

	

	
	
	
		
	

}
