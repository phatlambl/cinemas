package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinemas.spring.entities.Bookings;
import com.cinemas.spring.repositories.BookingRepository;



@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	


	@Override
	public Bookings save(Bookings entity) {
		return bookingRepository.save(entity);
	}

	@Override
	public List<Bookings>  saveAll(List<Bookings> entities) {
		return (List<Bookings>)bookingRepository.saveAll(entities);
	}

	@Override
	public Optional<Bookings> findById(Integer id) {
		return bookingRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return bookingRepository.existsById(id);
	}

	@Override
	public Iterable<Bookings> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Iterable<Bookings> findAllById(Iterable<Integer> ids) {
		return bookingRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return bookingRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		bookingRepository.deleteById(id);
	}

	@Override
	public void delete(Bookings entity) {
		bookingRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Bookings> entities) {
		bookingRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookingRepository.deleteAll();
	}
	

	@Override
	public Bookings bookTicket(Integer userId, Integer seatId, Integer scheduleId, Double cost, Integer seatStatus) {
		return bookingRepository.bookTicket(userId, seatId, scheduleId, cost, seatStatus);
	}

	@Override
	public List<Bookings> findBookingByScheduleid(Integer id) {
		return bookingRepository.findBookingByScheduleid(id);
	}
	
		

}
