package com.tadigital.wa3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.tadigital.wa3.customer.dao.CustomerPreparedStatement;

public class Dao {
	public static final Properties properties = new Properties();
	private static Connection con;
	private static PreparedStatement customerLoginPreparedStatement;
	private static PreparedStatement customerRegisterPreparedStatement;
	private static PreparedStatement customerListPreparedStatement;
	
	/*
	 * Creating Database Connection
	 */
	static {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		
		try {
			properties.load(inputStream);
		String driverClass=properties.getProperty("db.driver");
		String connectionUrl=properties.getProperty("db.connection");
		String username=properties.getProperty("db.username");
		String password=properties.getProperty("db.password");
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(connectionUrl,username,password);
		
		customerLoginPreparedStatement=con.prepareStatement(CustomerPreparedStatement.LOGIN_CUSTOMER);
		customerRegisterPreparedStatement=con.prepareStatement(CustomerPreparedStatement.REGISTER_CUSTOMER);
		customerListPreparedStatement=con.prepareStatement(CustomerPreparedStatement.SELECT_ALL_CUSTOMERS);
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch(ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	}
	/*protected Connection getConnection() {
		Connection con=null;
		String connectionUrl=properties.getProperty("db.connection");
		String username=properties.getProperty("db.username");
		String password=properties.getProperty("db.password");
		try {
			con=DriverManager.getConnection(connectionUrl,username,password);
		}catch (SQLException s) {
			s.printStackTrace();
		}
		return con;
	}
	protected Statement getStatement(Connection con) {
		Statement st=null;
		try {
			st=con.createStatement();
			}catch (SQLException s) {
			s.printStackTrace();
		}
		return st;
	}*/
	/*
	 * To get Customer Prepared Statement
	 */
	protected PreparedStatement getCustomerPreparedStatement(String process) {
		if(process.equals("LOGIN"))
		{
			return customerLoginPreparedStatement;
		}else if(process.equals("REGISTER"))
		{
			return customerRegisterPreparedStatement;
		}
		else if(process.equals("SELECTALL"))
		{
			return customerListPreparedStatement;
		}
		return null;
	}
	/*
	 * To Close Database Connection
	 */
	protected void closeConnection(Connection con) {
		try {
			if(con!=null)
				con.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	}
	/*
	 * To Close Database Statement
	 */
	protected void closeStatement(Statement st) {
		try {
			if(st!=null)
				st.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	}
	/*
	 * To Close Database Prepared Statement
	 */
	protected void closePreparedStatement(PreparedStatement pst) {
		try {
			if(pst!=null)
				pst.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	}
	/*
	 * To Close Database ResultSet
	 */
	protected void closeResultSet(ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
