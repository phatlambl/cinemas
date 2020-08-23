package com.cinemas.spring.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleDto implements Serializable{

	private Integer scheduleid;
	
	 @NotNull 
	private Integer movie;
	
	 @NotNull 	
	private Integer room;
	
	@NotNull 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;	
	
	@NotNull 
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")	
	private Date time;

	public Integer getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}

	public Integer getMovie() {
		return movie;
	}

	public void setMovie(Integer movie) {
		this.movie = movie;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
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

	public ScheduleDto(Integer scheduleid, @NotNull Integer movie, @NotNull Integer room, @NotNull Date date,
			@NotNull Date time) {
		super();
		this.scheduleid = scheduleid;
		this.movie = movie;
		this.room = room;
		this.date = date;
		this.time = time;
	}

	public ScheduleDto() {
		super();
	}

	
	
	
}
