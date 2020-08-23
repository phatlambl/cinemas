package com.cinemas.spring.dtos;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class RoomDto implements Serializable{

	
	private Integer roomid;
	
	@NotNull
	private Integer theater;	
	
	@NotNull
	@NotEmpty
	private String numberRoom;

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getTheater() {
		return theater;
	}

	public void setTheater(Integer theater) {
		this.theater = theater;
	}

	public String getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}
	
	
	
}
