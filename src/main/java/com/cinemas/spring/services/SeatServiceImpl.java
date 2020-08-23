package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.spring.entities.Seat;
import com.cinemas.spring.repositories.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<Seat> findByRoomid(Integer id) {
		return seatRepository.findByRoomid(id);
	}

	@Override
	public Seat save(Seat entity) {
		return seatRepository.save(entity);
	}

	@Override
	public List<Seat> saveAll(List<Seat> entities) {
		return (List<Seat>)seatRepository.saveAll(entities);
	}

	@Override
	public Optional<Seat> findById(Integer id) {
		return seatRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return seatRepository.existsById(id);
	}

	@Override
	public Iterable<Seat> findAll() {
		return seatRepository.findAll();
	}

	@Override
	public Iterable<Seat> findAllById(Iterable<Integer> ids) {
		return seatRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return seatRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		seatRepository.deleteById(id);
	}

	@Override
	public void delete(Seat entity) {
		seatRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Seat> entities) {
		seatRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		seatRepository.deleteAll();
	}

	@Override
	public <S extends Seat> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll(Iterable<? extends Seat> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seat> findByRoomIdAndCol(Integer roomid, int col) {
		return seatRepository.findByRoomIdAndCol(roomid, col);
	}

	@Override
	public List<Seat> findByRoomIdAndRow(Integer roomid, String row) {
		return seatRepository.findByRoomIdAndRow(roomid, row);
	}

	@Override
	public List<Seat> findBySeatid(Integer seat1, Integer seat2, Integer seat3, Integer seat4) {
		return seatRepository.findBySeatid(seat1, seat2, seat3, seat4);
	}

	@Override
	public List<Seat> ListSelectseat(Integer seat1, Integer seat2, Integer seat3, Integer seat4) {
		return seatRepository.ListSelectseat(seat1, seat2, seat3, seat4);
	}			
	
	
	
}
