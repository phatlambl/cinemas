package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import com.cinemas.spring.entities.Room;
import com.cinemas.spring.entities.Theater;

public interface RoomService {

	void deleteAll();

	void deleteAll(List<Room> entities);

	void delete(Room entity);

	void deleteById(Integer id);

	long count();

	List<Room> findAllById(List<Integer> ids);

	Iterable<Room> findAll();

	boolean existsById(Integer id);

	Optional<Room> findById(Integer id);

	List<Room> saveAll(List<Room> entities);

	Room save(Room entity);

	List<Theater> findAllTheater();

	List<Room> findRoomByTheater(int id);

	

}
