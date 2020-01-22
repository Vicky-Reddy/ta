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

public class LogInControllerprocessServlet extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getName());
	Customer customer = new Customer();
	/*
	 * User Login Servlet
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Execution Started.");
		customer.setEmail(req.getParameter("email"));
		customer.setPassword(req.getParameter("pwd"));
		boolean status=new CustomerService().login(customer);
		if(status) {
			req.setAttribute("cust", customer);
			RequestDispatcher rd= req.getRequestDispatcher("loginSuccess.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("loginFailure.jsp");
			rd.forward(req, resp);
		}
		LOGGER.info("Execution Ended.");
	}

}
