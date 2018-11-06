package com.ruicaiedu.bookstore.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_exchangeAreaServlet")
public class User_exchangeAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bookstorservicedao bookstorservicedao=null;
	private List<Score_exchange> list;
	private Userinfo userinfo;
	Score_exchange score_exchange=null;
    public User_exchangeAreaServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 bookstorservicedao=new Bookstorserviceimpl();
	    
		 //待修改，应该查询积分兑换记录表！！！
		 String basePath=request.getServletContext().getContextPath();
		 
		 int pageIndex=1;
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }
	      int totalpage=bookstorservicedao.selectScore_exchangeinfopage();
	     list= bookstorservicedao.selectScore_exchangeinfo(pageIndex);		     	
	     	userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
	     	//userinfo.setScore(bookstorservicedao.selectUserinfo((Userinfo)request.getSession().getAttribute("userinfo")).getScore());
	     	//request.getSession().setAttribute("userinfo", userinfo);
	     	request.setAttribute("pageIndex", pageIndex);
	     	System.out.println("++==="+totalpage);
	     	request.setAttribute("totalpage", totalpage);
	     	request.setAttribute("list", list);
	     	request.getRequestDispatcher("customer/user_exchangeArea.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
