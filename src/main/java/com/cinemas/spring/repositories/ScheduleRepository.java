 package com.cinemas.spring.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cinemas.spring.entities.Schedules;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Integer>{

	
	@Query(value="Select * from schedules where movieid=?1 and date=?2 and time > CURRENT_TIME", nativeQuery = true)
	public List<Schedules> findByMovie(Integer movieid, String date);
	
	@Query(value="Select * from schedules where date=?1 and time > CURRENT_TIME", nativeQuery = true)
	public List<Schedules> findByRoom(String date);
	
	@Query(value="Select * from schedules where roomid=?1 and date=?2 and time=?3", nativeQuery = true)
	public Optional<Schedules> findByRoomAndDate(Integer roomid, String date, String time);
}
