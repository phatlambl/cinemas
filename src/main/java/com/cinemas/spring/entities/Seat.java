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
@Table(name="seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seatid;
	
	@ManyToOne
	@JoinColumn(name="roomid")
	private Room roomid;
	
	@Column
	private String rowseat;
	
	private String imgchar;
	
	@Column
	private String columnseat;
	
	@OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
	private transient Set<Bookings> bookings;
	
	

	public String getImgchar() {
		return imgchar;
	}

	public void setImgchar(String imgchar) {
		this.imgchar = imgchar;
	}

	public Integer getSeatid() {
		return seatid;
	}

	public void setSeatid(Integer seatid) {
		this.seatid = seatid;
	}

	public Room getRoomid() {
		return roomid;
	}

	public void setRoomid(Room roomid) {
		this.roomid = roomid;
	}

	public String getRowseat() {
		return rowseat;
	}

	public void setRowseat(String rowseat) {
		this.rowseat = rowseat;
	}

	public String getColumnseat() {
		return columnseat;
	}

	public void setColumnseat(String columnseat) {
		this.columnseat = columnseat;
	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}


	public Seat(Integer seatid, Room roomid, String rowseat, String imgchar, String columnseat, Set<Bookings> bookings) {
		super();
		this.seatid = seatid;
		this.roomid = roomid;
		this.rowseat = rowseat;
		this.imgchar = imgchar;
		this.columnseat = columnseat;
		this.bookings = bookings;
	}

	public Seat() {
		
	}
	
	
			
	

	
}
