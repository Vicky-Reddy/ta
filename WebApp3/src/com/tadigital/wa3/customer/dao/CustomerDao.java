package com.tadigital.wa3.customer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tadigital.wa3.customer.entity.Customer;
import com.tadigital.wa3.dao.Dao;

public class CustomerDao extends Dao{
	private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
	
	/*
	 * Customer login
	 */
	public boolean userLogin(Customer customer) {
		LOGGER.info("Execution Started.");
		boolean status = false;
		ResultSet rs=null;
		try {
			PreparedStatement pStmt=getCustomerPreparedStatement("LOGIN");
			pStmt.setString(1, customer.getEmail());
			pStmt.setString(2, customer.getPassword());
			rs=pStmt.executeQuery();
			if(rs.next()) {
				status=true;
				customer.setUsername(rs.getString(1));
				customer.setFname(rs.getString(4));
				customer.setLname(rs.getString(5));
				customer.setId(rs.getInt(6));
			}
			
			}catch(SQLException sqlEx)
			{
				LOGGER.error(sqlEx);
			}finally {
				closeResultSet(rs);
			}
		LOGGER.info("Execution Ended.");
		return status;
	}
	/*
	 * Customer Registration
	 */
	public boolean userRegistration(Customer customer) {
		LOGGER.info("Execution Started.");
		boolean status = false;
		try {
			PreparedStatement pStmt=getCustomerPreparedStatement("REGISTER");
			
			pStmt.setString(1, customer.getUsername());
			pStmt.setString(2, customer.getEmail());
			pStmt.setString(3, customer.getPassword());
			pStmt.setString(4, customer.getFname());
			pStmt.setString(5, customer.getLname());
			
			int rs=pStmt.executeUpdate();
			if(rs!=0) {
				status=true;
			}
			
			}catch(SQLException sqlEx)
			{
				LOGGER.error(sqlEx);
			}
		LOGGER.info("Execution Ended.");
		return status;
	}
	/*
	 * Customer Listing
	 */
	public List<Customer> customerList() {
		List<Customer> custList = new ArrayList<>();
		LOGGER.info("Execution Started.");
		ResultSet rs=null;
		try {
			PreparedStatement pStmt=getCustomerPreparedStatement("SELECTALL");
			rs=pStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setUsername(rs.getString(1));
				customer.setEmail(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customer.setFname(rs.getString(4));
				customer.setLname(rs.getString(5));
				customer.setId(rs.getInt(6));
				custList.add(customer);
			}
			
			}catch(SQLException sqlEx)
			{
				LOGGER.error(sqlEx);
			}finally {
				closeResultSet(rs);
			
			}
		LOGGER.info("Execution Ended.");
		return custList;
	}
}
