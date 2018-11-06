package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_myorderServlet")
public class User_myorderServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Bookstorservicedao bookstorservicedao=null;
Userinfo userinfo=null;

	public User_myorderServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  bookstorservicedao=new Bookstorserviceimpl();
		  userinfo=(Userinfo)(request.getSession().getAttribute("userinfo"));
		  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		  String target=basePath.concat("index.jsp");
	       int pageIndex=1;
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }
	       
	       int totalpage=bookstorservicedao.selectOrdersuserinfopages(userinfo);
	       request.setAttribute("pageIndex", pageIndex);
	       request.setAttribute("totalpage", totalpage);
	       System.out.println("订单总页数"+totalpage);
	       System.out.println("当前页"+pageIndex);
    List<Orders>orderss=bookstorservicedao.selectOrdersUserinfolist(pageIndex, userinfo);     
    System.out.println("==++++++____+++++___++++++测试"+orderss.size());
    request.setAttribute("orderss", orderss);

//target=basePath.concat("customer/user_myorder.jsp");
request.getRequestDispatcher("customer/user_myorder.jsp").forward(request, response);
 
       
		
		
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
		
	}

	
	public void init() throws ServletException {
		
	}

}
