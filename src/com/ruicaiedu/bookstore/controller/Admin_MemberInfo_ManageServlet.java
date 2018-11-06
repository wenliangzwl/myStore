package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_MemberInfo_ManageServlet")
public class Admin_MemberInfo_ManageServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Userinfo userinfo;
	public Admin_MemberInfo_ManageServlet() {
		super();
	}
public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bookstorservicedao=new Bookstorserviceimpl();
		userinfo=new Userinfo();
		int userid=0;
		if(request.getParameter("userid")!=null){
			userid=Integer.parseInt(request.getParameter("userid"));
			userinfo.setUserid(userid);
		}
		bookstorservicedao.deleteVip(userinfo);
		response.sendRedirect("Admin_MemberInfoServlet");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
