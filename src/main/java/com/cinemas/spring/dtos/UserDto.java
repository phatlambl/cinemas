package com.cinemas.spring.dtos;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class UserDto implements Serializable{

	
	private Integer userid;
	
	@NotNull
	@NotEmpty(message= "Name is empty")
	private String username;
	
	@NotNull
	@NotEmpty(message= "Password is empty")
	private String password;
	
	@NotNull
	@NotEmpty(message= "Name is empty")
	private String email;
	
	@NotNull
	@NotEmpty(message= "Name is empty")
	private String clientname;
	
	@NotNull
	@NotEmpty(message="PhoneNumber is Empty")
	private String phonenumber;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public UserDto(Integer userid, @NotEmpty(message = "Name is empty") String username,
			@NotEmpty(message = "Password is empty") String password, @NotEmpty(message = "Name is empty") String email,
			@NotEmpty(message = "Name is empty") String clientname,
			@NotEmpty(message = "PhoneNumber is Empty") String phonenumber) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.clientname = clientname;
		this.phonenumber = phonenumber;
	}

	public UserDto() {
		
	}
	
	
	
}
