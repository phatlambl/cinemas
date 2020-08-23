package com.cinemas.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemas.spring.entities.Bookings;

@Repository
public interface BookingRepository extends CrudRepository<Bookings, Integer>{

	
	//update status seat
	@Transactional
	@Query(value = "UPDATE `bookings` SET `seatStatus = '1' Where `userid`=?1 AND `bookingid`=?2 ", nativeQuery = true)
	Integer updateStatus(Integer userid, Integer bookingid);
	//chen booking
	@Transactional
	@Query(value="INSERT INTO `bookings`(`userid`, `seatid`, `schedulesid`, `cost`, `seatStatus`, 'date') VALUE(?1, ?2, ?3, ?4, ?5, NOW()", nativeQuery = true)
	Bookings bookTicket(Integer userId, Integer seatId, Integer scheduleId, Double cost, Integer seatStatus);
	
	
	@Query(value="SELECT * FROM `bookings` WHERE `schedulesid`=?1", nativeQuery = true)
	List<Bookings> findBookingByScheduleid(Integer id);
}
