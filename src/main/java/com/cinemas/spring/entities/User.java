package com.cinemas.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	public Integer userid;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	public String email;
	
	@Column(name="clientname")
	public String clientname;
	
	@Column(name="phonenumber")
	public String phonenumber;
	
	@ManyToMany
	@JoinTable(
	name = "user_role",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id")			
	)
	private Set<Role> roles;
	
	private boolean active;


	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private transient Set<Bookings> bookings;

	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	public User(Integer userid, String userName, String password, String email, String clientname, String phonenumber,
			Set<com.cinemas.spring.entities.Role> roles, boolean active,  Set<Bookings> bookings) {
		super();
		this.userid = userid;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.clientname = clientname;
		this.phonenumber = phonenumber;
		this.roles = roles;
		this.active = active;		
		this.bookings = bookings;
	}

	public User() {
		
	}


	




	
	
	
	
	
}
