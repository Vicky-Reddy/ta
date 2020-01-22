package com.tadigital.wa3.customer.entity;

public class Customer {
	
	private int id;
	private String username;
	private String fname;
	private String lname;
	private String password;
	private String email;
	public Customer(){
		
	}
	/*
	 * Customer Constructor
	 */
	public Customer(String username, String fname, String lname, String password,String email) {
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email=email;
	}
	/*
	 * To get Customer Id
	 */
	public int getId() {
		return id;
	}
	/*
	 * To get Customer Username
	 */
	public String getUsername() {
		return username;
	}
	/*
	 * To get Customer First Name
	 */
	public String getFname() {
		return fname;
	}
	/*
	 * To get Customer Last Name
	 */
	public String getLname() {
		return lname;
	}
	/*
	 * To get Customer Password
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * To get Customer Email
	 */
	public String getEmail() {
		return email;
	}
	/*
	 * To set Customer Email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/*
	 * To set Customer Id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * To set Customer Username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * To set Customer First Name
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/*
	 * To set Customer Last Name
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/*
	 * To set Customer Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	 * Customer Constructor
	 */
	public Customer(int id, String username, String fname, String lname, String password,String email) {
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email=email;
	}
	
}
