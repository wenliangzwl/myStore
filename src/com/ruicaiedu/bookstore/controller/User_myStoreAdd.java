package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_myStoreAdd")
public class User_myStoreAdd extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Bookinfo bookinfo;
	
public User_myStoreAdd() {
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
		bookinfo=new Bookinfo();
		bookstorservicedao=new Bookstorserviceimpl();
		if(request.getParameter("back")!=null){
				bookinfo.setBookid(request.getParameter("bookid"));;
				bookstorservicedao.addBookinfo((Userinfo)request.getSession().getAttribute("userinfo"), bookinfo);
				System.err.println("--------------------");
				bookstorservicedao.updatebooinfostore(bookinfo);
				System.err.println("--------------------");
				
				request.getSession().setAttribute("bq", 1);
				response.sendRedirect("BookDetailServlet?bookid="+request.getParameter("bookid")+"");
			}else{
				bookinfo.setBookid(request.getParameter("bookid"));
				bookstorservicedao.addBookinfo((Userinfo)request.getSession().getAttribute("userinfo"), bookinfo);
				bookstorservicedao.updatebooinfostore(bookinfo);
				request.getSession().setAttribute("bq", 1);
				response.sendRedirect("customer/buy.jsp");
			}
		
	}
public void init() throws ServletException {
		// Put your code here
	}

}
