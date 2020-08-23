package com.cinemas.spring.services;

import java.util.List;
import java.util.Optional;
import com.cinemas.spring.entities.Bookings;


public interface BookingService {

	void deleteAll();

	void deleteAll(List<Bookings> entities);

	void delete(Bookings entity);

	void deleteById(Integer id);

	long count();

	Iterable<Bookings> findAllById(Iterable<Integer> ids);

	Iterable<Bookings> findAll();

	boolean existsById(Integer id);

	Optional<Bookings> findById(Integer id);

	List<Bookings> saveAll(List<Bookings> entities);

	Bookings save(Bookings entity);


	List<Bookings> findBookingByScheduleid(Integer id);

	Bookings bookTicket(Integer userId, Integer seatId, Integer scheduleId, Double cost, Integer seatStatus);

}
