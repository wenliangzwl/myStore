package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_AddcommentServlet")
public class User_AddcommentServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Bookinfo bookinfo;
	private Comment comment;
	public User_AddcommentServlet() {
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
		System.out.println("我来到评论显示了吗");
		bookinfo=new Bookinfo();
		comment=new Comment();
		bookinfo.setBookid(request.getParameter("bookid"));
		comment.setContent(request.getParameter("contents"));
		bookstorservicedao=new Bookstorserviceimpl();	
		if(bookstorservicedao.addComment((Userinfo)request.getSession().getAttribute("userinfo"), bookstorservicedao.selectbookinfodetails(bookinfo), comment)){
			response.sendRedirect("BookDetailServlet?bookid="+bookinfo.getBookid()+"");
		}else{
			
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
