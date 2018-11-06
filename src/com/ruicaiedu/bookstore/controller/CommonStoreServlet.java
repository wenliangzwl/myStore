package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Store_record;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/CommonStoreServlet")
public class CommonStoreServlet extends HttpServlet {
Bookstorservicedao bookstorservicedao=null;
Userinfo userinfo=null;
Bookinfo bookinfo=null;	
Store_record store_record=null;
	public CommonStoreServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        bookstorservicedao=new Bookstorserviceimpl();
        userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
        String bookid=request.getParameter("bookid");
		boolean flag=false;
		bookinfo=new Bookinfo();
		bookinfo.setBookid(bookid);		
		if(bookstorservicedao.addBookinfo_StoreRecord(userinfo, bookinfo)){
		flag=true;	
		}
				
		int opt=Integer.parseInt(request.getParameter("opt"));
		switch(opt){
		case 1:
			if(flag){response.sendRedirect("BookDetailServlet");}
			
			break;
		case 2:
			if(flag){
				response.sendRedirect("User_myShoppingcarServlet");
				}			
			break;
		default:
			
			break;
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	
	public void init() throws ServletException {
	
	}

}
