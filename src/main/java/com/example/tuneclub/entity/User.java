package com.example.tuneclub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @GeneratedValue(strategy= GenerationType.UUID)
	@Id
	String userid;
	String username;
	String email;
	String password;
	String gender;
	String role;
	String address;
	boolean isPremium;
	
	public User() {
		super();
	}
	public User(String userid, String username, String email, String password, String gender, String role,
			String address, boolean isPremium) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.isPremium=isPremium;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	
	@Override
	public String toString() {
		return "User [userid= " + userid + ", username= " + username + ", email= " + email + ", password= " + password
				+ ", gender= " + gender + ", role= " + role + ", address=" + address + ", premium= "+isPremium+"]";

	}
}