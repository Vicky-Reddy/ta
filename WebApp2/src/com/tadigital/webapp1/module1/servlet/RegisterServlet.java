package com.tadigital.webapp1.module1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String fn = req.getParameter("f1");
		String ln = req.getParameter("f2");
		String em = req.getParameter("f3");
		String g = req.getParameter("f4");
		String[] qu = req.getParameterValues("f5");
		String c = req.getParameter("f6");
		String ad = req.getParameter("f7");
		String p = req.getParameter("f8");

		out.println("FirstName :"+fn);
		out.println("<br>lastName :"+ln);
		out.println("<br>email :"+em);
		out.println("<br>gender :"+g);
		for(String q:qu) {
		out.println("<br>Qualification :"+q);}
		out.println("<br>country :"+c);
		out.println("<br>address :"+ad);
		out.println("<br>password :"+p);

	}

}
