package com.ruicaiedu.bookstore.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_exchangeArea_ManageServlet")
public class User_exchangeArea_ManageServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Score_exchange score_exchange;
	private Exchange_record exchange_record;
	private Userinfo userinfo=null;
	public User_exchangeArea_ManageServlet() {
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
		bookstorservicedao=new Bookstorserviceimpl();
		score_exchange=new Score_exchange();
		exchange_record=new Exchange_record();
		boolean flag=false;
		int exchangeid=0;
		if(request.getParameter("exchangeid")!=null){
			exchangeid=Integer.parseInt(request.getParameter("exchangeid"));	
		}
		score_exchange.setExchangeid(exchangeid);
		score_exchange=bookstorservicedao.selectScore_exchangedetail(score_exchange);
		exchange_record.setExchangename(score_exchange.getExchangename());
		exchange_record.setScore(score_exchange.getScore());
		exchange_record.setExchangeimg(score_exchange.getExchangeimg());
        userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
		int userscore=userinfo.getScore();
		int exchangescore=bookstorservicedao.selectScore_exchange(score_exchange);
		int resultscore=userscore-exchangescore;
		if(exchangescore>userscore){
			response.sendRedirect("User_exchangeAreaServlet");
		}else{
			if(bookstorservicedao.updateuserscore(userinfo, resultscore)){
				if(bookstorservicedao.addExchange_record(userinfo, exchange_record)){
					flag=true;
					}					
			}
		}	
		if(flag){
			userinfo.setScore(userscore-exchangescore);
			System.out.println("积分兑换后自己的积分：测试"+userinfo.getScore());
			request.getSession().setAttribute("userinfo", userinfo);			
			response.sendRedirect("User_scoreExchageRecord_QueryServlet");
		}
		
		
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
