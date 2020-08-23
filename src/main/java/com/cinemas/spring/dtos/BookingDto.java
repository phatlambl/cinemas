package com.cinemas.spring.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.cinemas.spring.entities.Schedules;
import com.cinemas.spring.entities.Seat;
import com.cinemas.spring.entities.User;

public class BookingDto implements Serializable {

	

	private Integer bookingid;	
	
	@NotNull
	private Integer userid;
	
	@NotNull
	private Integer seatid;
	
	@NotNull
	private Integer schedulesid;
	
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;	

	@NotNull
	private Double cost;
	

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getSeatid() {
		return seatid;
	}

	public void setSeatid(Integer seatid) {
		this.seatid = seatid;
	}

	public Integer getSchedulesid() {
		return schedulesid;
	}

	public void setSchedulesid(Integer schedulesid) {
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



	public BookingDto(Integer bookingid, @NotNull Integer userid, @NotNull Integer seatid, @NotNull Integer schedulesid,
			Date date, @NotNull Double cost) {
		super();
		this.bookingid = bookingid;
		this.userid = userid;
		this.seatid = seatid;
		this.schedulesid = schedulesid;
		this.date = date;
		this.cost = cost;
		
	}

	public BookingDto() {
		super();
	}

	

	
	
}
