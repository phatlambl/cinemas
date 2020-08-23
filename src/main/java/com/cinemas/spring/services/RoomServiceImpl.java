package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Theater;
import com.cinemas.spring.repositories.RoomRepository;
import com.cinemas.spring.repositories.TheaterRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;

	@Override
	public Room save(Room entity) {
		return roomRepository.save(entity);
	}

	@Override
	public List<Room> saveAll(List<Room> entities) {
		return (List<Room>)roomRepository.saveAll(entities);
	}

	@Override
	public Optional<Room> findById(Integer id) {
		return roomRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return roomRepository.existsById(id);
	}

	@Override
	public Iterable<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> findAllById(List<Integer> ids) {
		return (List<Room>)roomRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return roomRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		roomRepository.deleteById(id);
	}

	@Override
	public void delete(Room entity) {
		roomRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Room> entities) {
		roomRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roomRepository.deleteAll();
	}
	
	@Override
	public List<Theater> findAllTheater(){
		return (List<Theater>) theaterRepository.findAll();
	}

	@Override
	public List<Room> findRoomByTheater(int id) {
		return roomRepository.findRoomByTheater(id);
	}

	
	
	
	

}
