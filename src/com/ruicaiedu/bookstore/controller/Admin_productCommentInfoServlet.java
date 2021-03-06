package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_productCommentInfoServlet")
public class Admin_productCommentInfoServlet extends HttpServlet {
Bookstorservicedao bookstorservicedao=null;
Comment comment=null;
Assorter_right assorter_right =null;
	public Admin_productCommentInfoServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 int pageIndex=1;
		 bookstorservicedao=new Bookstorserviceimpl();
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }
	       assorter_right=(Assorter_right)request.getSession().getAttribute("assorter_right");
	       System.err.println("大小"+bookstorservicedao.selectComment(assorter_right).size());
	      int totalpage=bookstorservicedao.getTotalPage(bookstorservicedao.selectComment(assorter_right), 5);
	      System.err.println("总共页数"+totalpage);
	     request.setAttribute("comments",bookstorservicedao.selectComment(assorter_right, pageIndex) );	       
        request.getRequestDispatcher("admin/admin_productCommentInfo.jsp").forward(request, response);
		
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	
	}

	public void init() throws ServletException {
	
	}

}
