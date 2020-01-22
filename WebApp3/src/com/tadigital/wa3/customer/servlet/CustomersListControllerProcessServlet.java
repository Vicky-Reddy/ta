package com.tadigital.wa3.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tadigital.wa3.customer.entity.Customer;
import com.tadigital.wa3.customer.service.CustomerService;

public class CustomersListControllerProcessServlet extends HttpServlet{
	
	/*
	 * User Listing Servlet
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Customer> x=null;
		x=new CustomerService().clist();
		req.setAttribute("CustomerList", x);
		RequestDispatcher rd= req.getRequestDispatcher("customersList.jsp");
		rd.forward(req, resp);
	}

}
