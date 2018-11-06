package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_myCommentServlet")
public class User_myCommentServlet extends HttpServlet {
Bookstorservicedao bookstorservicedao=null;
	Comment comment=null;
	Userinfo userinfo=null;
	public User_myCommentServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bookstorservicedao=new Bookstorserviceimpl();
		System.out.println("我来到评论了吗");
	       int pageIndex=1;
	       String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
	       String target=basePath.concat("index.jsp");
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }	   
	   userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
       request.setAttribute("comments",bookstorservicedao.selectComment(userinfo, pageIndex));
       System.out.println("评论测试"+bookstorservicedao.selectComment(userinfo, pageIndex).size());
       request.setAttribute("pageIndex", pageIndex);
       int totalpage=bookstorservicedao.getTotalPage(bookstorservicedao.selectComment(userinfo), 4);
       request.setAttribute("totalpage",totalpage);
       System.out.println("总页数"+totalpage);
       System.out.println("当前页"+pageIndex);
       // target=basePath.concat("customer/user_myComment.jsp");
       request.getRequestDispatcher("customer/user_myComment.jsp").forward(request, response);
       
       
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
