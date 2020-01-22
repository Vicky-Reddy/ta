package com.tadigital.wa3.customer.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.tadigital.wa3.service.Service;

import com.tadigital.wa3.customer.dao.CustomerDao;
import com.tadigital.wa3.customer.entity.Customer;

public class CustomerService extends Service {
	private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
	CustomerDao customerDao = new CustomerDao();
	/*
	 * User login Service
	 */
	public boolean login(Customer customer) {
		LOGGER.info("Method Execution Started.");
		boolean status= customerDao.userLogin(customer);
		LOGGER.info("Method Execution Ended.");
		return status;
	}
	/*
	 * User Registration Service
	 */
	public boolean register(Customer customer)
	{
		LOGGER.info("Method Execution Started.");
		boolean status= customerDao.userRegistration(customer);
		LOGGER.info("Method Execution Ended.");
		return status;
	}
	/*
	 * User listing Service
	 */
	public List<Customer> clist(){
		LOGGER.info("Method Execution Started.");
		List<Customer> list=customerDao.customerList();
		LOGGER.info("Method Execution Ended.");
		return list;
	}
	/*
	 * Sending Email Service
	 */
	public boolean sendEmail(String email , String name) {
		boolean status=false;
		String from=getEmail();
		String pass=getPass();
		Properties prop =mailServerConfig();
		Session session = Session.getDefaultInstance(prop,    
	               new javax.mail.Authenticator() { 
	               protected PasswordAuthentication getPasswordAuthentication() {    
	               return new PasswordAuthentication(from,pass);
	               }
		});
	               try {    
	                   MimeMessage message = new MimeMessage(session);    
	                   message.setFrom(new InternetAddress(from));
	                   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));    
	                   message.setSubject("Welcome to TAdigital");    
	                   message.setText("Dear "+ name +"\n\n Welcome ");    
	                   //send message  
	                   Transport.send(message);    
	                   status=true;   
	                  } catch (MessagingException e) {throw new RuntimeException(e);}
		return status;
	}
}
