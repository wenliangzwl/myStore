package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/User_ExitServlet")
public class User_ExitServlet extends HttpServlet {

	
	public User_ExitServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy();
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		request.getSession().invalidate();
		response.sendRedirect("IndexServlet");//之后改为IndexServlet
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
		
	}

	public void init() throws ServletException {
		
	}

}
