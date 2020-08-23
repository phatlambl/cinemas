package com.cinemas.spring.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TheaterDto implements Serializable {

	private Integer theaterid;
	
	@NotNull
	@NotEmpty(message= "Name is empty")
	private String Name;
	
	@NotNull
	@NotEmpty(message= "Manager is empty")
	private String Manager;
	
	@NotNull
	@NotEmpty
	private String phoneNumber;
	
	@NotNull
	@NotEmpty
	private String Address;

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
	
	
}
