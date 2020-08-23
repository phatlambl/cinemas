package com.cinemas.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinemas.spring.entities.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {
	
	@Query(value ="Select * from seat where roomid = :id ", nativeQuery = true)
	public List<Seat> findByRoomid(@Param("id") Integer id);

	@Query(value="Select * from seat where roomid =?1 AND columnseat=?2", nativeQuery = true)
	public List<Seat> findByRoomIdAndCol(Integer roomid, int col);
	
	@Query(value="Select * from seat where roomid =?1 AND rowseat=?2", nativeQuery = true)
	public List<Seat> findByRoomIdAndRow(Integer roomid, String row);
	
	@Query(value="Select * from seat where seatid IN (?1, ?2, ?3, ?4)", nativeQuery = true)
	public List<Seat> findBySeatid(Integer seat1, Integer seat2, Integer seat3, Integer seat4);
	
	@Query(value="SELECT CONCAT_WS('',rowseat, columnseat) as selectseat FROM seat  ", nativeQuery = true)
	public List<Seat> ListSelectseat(Integer seat1, Integer seat2, Integer seat3, Integer seat4);
}
