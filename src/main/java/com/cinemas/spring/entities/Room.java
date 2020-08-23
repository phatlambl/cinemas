package com.cinemas.spring.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="room")
public class Room {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomid;	
	
	@ManyToOne	
	@JoinColumn(name="theaterid")
	private Theater theater;	
	
	@Column(name="numberRoom", length=50)
	private String numberRoom;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private transient Set<Schedules> schedules;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private transient Set<Seat> seat;
		
	
	public Set<Seat> getSeat() {
		return seat;
	}

	public void setSeat(Set<Seat> seat) {
		this.seat = seat;
	}

	public Set<Schedules> getSchedules() {
		return schedules;
	}

	public void setSchedules(Set<Schedules> schedules) {
		this.schedules = schedules;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public String getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}

	public Room(Integer roomid, Theater theater, String numberRoom) {
		super();
		this.roomid = roomid;
		this.theater = theater;
		this.numberRoom = numberRoom;
	}

	public Room() {
		super();
	}
	
	
	
	
}
