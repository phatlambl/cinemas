package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cinemas.spring.entities.Seat;

public interface SeatService extends CrudRepository<Seat, Integer>{

	void deleteAll();

	void deleteAll(List<Seat> entities);

	void delete(Seat entity);

	void deleteById(Integer id);

	long count();

	Iterable<Seat> findAllById(Iterable<Integer> ids);

	Iterable<Seat> findAll();

	boolean existsById(Integer id);

	Optional<Seat> findById(Integer id);

	List<Seat> saveAll(List<Seat> entities);

	Seat save(Seat entity);

	List<Seat> findByRoomid(Integer id);

	List<Seat> findByRoomIdAndCol(Integer roomid, int col);

	List<Seat> findByRoomIdAndRow(Integer roomid, String row);

	List<Seat> findBySeatid(Integer seat1, Integer seat2, Integer seat3, Integer seat4);

	List<Seat> ListSelectseat(Integer seat1, Integer seat2, Integer seat3, Integer seat4);

}
