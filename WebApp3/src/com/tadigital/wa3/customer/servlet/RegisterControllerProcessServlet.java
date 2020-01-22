package com.tadigital.wa3.customer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tadigital.wa3.customer.dao.CustomerDao;
import com.tadigital.wa3.customer.entity.Customer;
import com.tadigital.wa3.customer.service.CustomerService;

public class RegisterControllerProcessServlet extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
	CustomerService customerService= new CustomerService();
	/*
	 * User Registration Servlet
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Execution Started.");
		Customer customer = new Customer();
		String mail=req.getParameter("email");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		LOGGER.info("Values Recieved From Request :"+mail+" , "+fname+" , "+lname);
		customer.setUsername(req.getParameter("uname"));
		customer.setEmail(mail);
		customer.setPassword(req.getParameter("pwd"));
		customer.setFname(fname);
		customer.setLname(lname);
		boolean status=customerService.register(customer);
		LOGGER.info("Result of registration :"+status);
		if(status) {
			customerService.sendEmail(mail,fname+" "+lname);
			RequestDispatcher rd= req.getRequestDispatcher("registerSuccess.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("registerFailure.jsp");
			rd.forward(req, resp);
		}
		LOGGER.info("Execution Ended.");
	}

}

