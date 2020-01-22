package com.tadigital.wa3.customer.dao;

public interface CustomerPreparedStatement {
	String LOGIN_CUSTOMER ="SELECT * FROM customer_info WHERE email=? AND password=?";
	String REGISTER_CUSTOMER ="INSERT INTO customer_info(name,email,password,fname,lname) VALUES (?,?,?,?,?)";
	String SELECT_ALL_CUSTOMERS ="SELECT * FROM customer_info ";
}
