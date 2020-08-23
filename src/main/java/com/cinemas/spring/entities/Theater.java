package com.cinemas.spring.entities;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="theater")
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="theaterid")
	private Integer theaterid;
		
	@Column(name="Name", length = 50)
	private String Name;
	
	@Column(name="Manager", length = 50)
	private String Manager;

	@Column(name="phoneNumber",length = 50)
	private String phoneNumber;

	@Column(name="Address",length = 250)
	private String Address;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private transient Set<Room> room;
	
	public Integer getTheaterid() {
		return theaterid;
	}

	public void setTheaterid(Integer theaterid) {
		this.theaterid = theaterid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getManager() {
		return Manager;
	}

	public void setManager(String manager) {
		Manager = manager;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Theater(Integer theaterid, String name, String manager, String phoneNumber, String address) {
		super();
		this.theaterid = theaterid;
		Name = name;
		Manager = manager;
		this.phoneNumber = phoneNumber;
		Address = address;
	}

	public Theater() {
		super();
	}

	
	
		

	
	
	
}
