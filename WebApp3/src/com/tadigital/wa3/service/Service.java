package com.tadigital.wa3.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Service {
	public static final Properties properties = new Properties();
	static 
		{
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mail.properties");
			
			try {
				properties.load(inputStream);
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	/*
	 * To get properties
	 */
	 public Properties mailServerConfig(){  
		 
         return properties;
	 }
	 /*
	 * To get Email
	 */
	 protected String getEmail() {
		 String user=properties.getProperty("mail.username");
		 return user;
	 }
	 /*
	 * To get password
	 */
	 protected String getPass() {
		 String pass=properties.getProperty("mail.password");
		 return pass;
	 }
}
