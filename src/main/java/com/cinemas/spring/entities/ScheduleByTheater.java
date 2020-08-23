package com.cinemas.spring.entities;

import java.util.List;

public class ScheduleByTheater {
	
	private int id;
	private Theater theater;
	private List<Schedules> schedule;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public List<Schedules> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedules> schedule) {
		this.schedule = schedule;
	}
	public ScheduleByTheater(int id, Theater theater, List<Schedules> schedule) {
		super();
		this.id = id;
		this.theater = theater;
		this.schedule = schedule;
	}
	public ScheduleByTheater() {
		super();
	}

	
	

	

	
	
	
}
