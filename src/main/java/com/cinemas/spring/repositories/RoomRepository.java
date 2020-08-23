package com.cinemas.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinemas.spring.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	
	@Query(value = "select * from room where theaterid = :id", nativeQuery = true)
	public List<Room> findRoomByTheater(@Param("id") int id);
}
