package com.cinemas.spring.entities;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="schedules")
public class Schedules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scheduleid;
	
	@ManyToOne
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="roomid")
	private Room room;	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date time;


	public Integer getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Schedules(Integer scheduleid, Movie movie, Room room, Date date, Date time) {
		super();
		this.scheduleid = scheduleid;
		this.movie = movie;
		this.room = room;
		this.date = date;
		this.time = time;
	}

	public Schedules() {
		super();
	}

	

	
	

}
