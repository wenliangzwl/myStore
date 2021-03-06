package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ScoreExchangeLogoServlet")
public class Admin_ScoreExchangeLogoServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private List<Exchange_record>  list;
	public Admin_ScoreExchangeLogoServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		bookstorservicedao=new Bookstorserviceimpl();
		list=bookstorservicedao.selectExchange_recordsAssorter_right((Assorter_right)request.getSession().getAttribute("assorter_right"), page);
     	int pages=bookstorservicedao.selectExchange_recordspages((Assorter_right)request.getSession().getAttribute("assorter_right"));
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("admin/admin_ScoreExchangeLogo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
