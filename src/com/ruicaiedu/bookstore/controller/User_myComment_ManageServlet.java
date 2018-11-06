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

@WebServlet("/User_myComment_ManageServlet")
public class User_myComment_ManageServlet extends HttpServlet {
Bookstorservicedao bookstorservicedao=null;
Comment comment=null;
Userinfo userinfo=null;
	private static final long serialVersionUID = 1L;

	
	public User_myComment_ManageServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		String target=basePath.concat("index.jsp");
		userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
		bookstorservicedao=new Bookstorserviceimpl();
	    comment=new Comment();
	    comment.setCommentid(Integer.parseInt(request.getParameter("commentid")));
	    System.out.println("评论id"+comment.getCommentid());
	    if(bookstorservicedao.deleteComment(userinfo, comment)){
	    	//target=basePath.concat("User_myCommentServlet");
	    	System.out.println("评论我删除成功了");
	    	response.sendRedirect("User_myCommentServlet");
	    	
	    }else{
	    	System.out.println("评论我没有删除成功");
	    	//target=basePath.concat("User_myCommentServlet");
	    	response.sendRedirect("User_myCommentServlet");
	    	
	    }
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
