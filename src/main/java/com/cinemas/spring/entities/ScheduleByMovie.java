package com.cinemas.spring.entities;

import java.util.List;

public class ScheduleByMovie {

	private Movie movie;
	private List<Schedules> schedule;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<Schedules> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedules> schedule) {
		this.schedule = schedule;
	}
	public ScheduleByMovie(Movie movie, List<Schedules> schedule) {
		super();
		this.movie = movie;
		this.schedule = schedule;
	}
	public ScheduleByMovie() {
		
	}
	
	
}
