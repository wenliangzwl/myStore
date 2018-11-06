package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.dao.Exchange_recorddao;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ScoreExchangeLogo_ManageServlet")
public class Admin_ScoreExchangeLogo_ManageServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Exchange_record exchange_record;
	public Admin_ScoreExchangeLogo_ManageServlet() {
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
		exchange_record=new Exchange_record();
		int recordid=0;
		String sendtime="0";
		if(request.getParameter("recordid")!=null){
			recordid=Integer.parseInt(request.getParameter("recordid"));
			sendtime=request.getParameter("sendtime");
		}
		exchange_record.setSendtime(sendtime);
		exchange_record.setRecordid(recordid);
		bookstorservicedao.updateExchange_records(exchange_record);
		response.sendRedirect("Admin_ScoreExchangeLogoServlet");
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
