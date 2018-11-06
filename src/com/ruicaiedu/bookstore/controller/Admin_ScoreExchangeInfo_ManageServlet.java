package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ScoreExchangeInfo_ManageServlet")
public class Admin_ScoreExchangeInfo_ManageServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Score_exchange score_exchange;
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public Admin_ScoreExchangeInfo_ManageServlet() {
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
		int exchangeiddelete=0;
		int score=0;
		int exchangeidupdate=0;
		if(request.getParameter("exchangeiddelete")!=null){
			exchangeiddelete=Integer.parseInt(request.getParameter("exchangeiddelete"));
			score_exchange.setExchangeid(exchangeiddelete);
			bookstorservicedao.deleteScore_exchange(score_exchange);
		}	
		if(request.getParameter("exchangeidupdate")!=null){
			exchangeidupdate=Integer.parseInt(request.getParameter("exchangeidupdate"));
			score=Integer.parseInt(request.getParameter("score"));
			score_exchange.setExchangeid(exchangeidupdate);
			score_exchange.setScore(score);
			bookstorservicedao.updateScore_exchange(score_exchange);
		}
		response.sendRedirect("Admin_ScoreExchangeInfoServlet");	
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
