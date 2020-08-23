package com.cinemas.spring.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingid;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User userid;
	
	@ManyToOne
	@JoinColumn(name="seatid")
	private Seat seatid;	
			
	@ManyToOne
	@JoinColumn(name="schedulesid")
	private Schedules schedulesid;
	
	@Temporal(TemporalType.TIMESTAMP)	
	private Date date;	

	@Column
	private Double cost;


	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Seat getSeatid() {
		return seatid;
	}

	public void setSeatid(Seat seatid) {
		this.seatid = seatid;
	}

	public Schedules getSchedulesid() {
		return schedulesid;
	}

	public void setSchedulesid(Schedules schedulesid) {
		this.schedulesid = schedulesid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}


	public Bookings(Integer bookingid, User userid, Seat seatid, Schedules schedulesid, Date date, Double cost
			) {
		super();
		this.bookingid = bookingid;
		this.userid = userid;
		this.seatid = seatid;
		this.schedulesid = schedulesid;
		this.date = date;
		this.cost = cost;
		
	}

	public Bookings() {
		super();
	}

	
		
	
}
