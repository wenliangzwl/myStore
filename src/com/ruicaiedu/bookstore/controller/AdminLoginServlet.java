package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
private Bookstorservicedao bookstorservicedao=null;
	
	public AdminLoginServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");	
		Assorter_right assorter_right =new Assorter_right();
		assorter_right.setAdminname(request.getParameter("username"));
		assorter_right.setAdminpwd(request.getParameter("password"));
		bookstorservicedao=new Bookstorserviceimpl();	
		System.out.println(assorter_right.getAdminname());
		String opttt=null;
		if(bookstorservicedao.selectAssorter_right(assorter_right)){
			request.getSession().setAttribute("assorter_right",bookstorservicedao.selectassorter_right(assorter_right) );
			opttt="haslogin";
			request.getSession().setAttribute("opttt", opttt);
			request.getRequestDispatcher("/admin/adminManage.jsp").forward(request, response);
		}else{
			response.sendRedirect("/admin/adminLogin.jsp");
		}
		
		
		
		
		
		

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
