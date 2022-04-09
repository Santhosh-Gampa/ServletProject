package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		System.out.println("Inside Userservlet");
		String name = req.getParameter("uName");
		String age = req.getParameter("uAge");

		writer.write(name);
		writer.write(age);
		writer.close();
		

	}

}
