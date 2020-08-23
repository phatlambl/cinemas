	package com.cinemas.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieid;
	

	@Column(name="moviename", length=250)
	private String moviename;	
	
	
	@Lob
	private String poster;	
	
	
	@Column(name="director", length=250)
	private String director;
	
	
	@Column(name="actor", length=250)
	private String actor;
	
	
	@Column(name="introduction", length=10000)
	private String introduction;
	
	@Column(name="trailer")
	private String trailer;
	
	@Column(name="type")
	private String type;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date premiere;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date end;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private Set<Schedules> schedues;
	
	public Integer getMovieid() {
		return movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getPremiere() {
		return premiere;
	}

	public void setPremiere(Date premiere) {
		this.premiere = premiere;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}	

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Movie(Integer movieid, String moviename, String poster, String director, String actor, String introduction,
			String trailer, String type, Date premiere, Date end, Set<Schedules> schedues) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		this.poster = poster;
		this.director = director;
		this.actor = actor;
		this.introduction = introduction;
		this.trailer = trailer;
		this.type = type;
		this.premiere = premiere;
		this.end = end;
		this.schedues = schedues;
	}

	public Movie() {
		super();
	}
		
	

	
	
	
	

}
