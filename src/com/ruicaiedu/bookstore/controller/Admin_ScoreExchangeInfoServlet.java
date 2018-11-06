package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ScoreExchangeInfoServlet")
public class Admin_ScoreExchangeInfoServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private List<Score_exchange> list;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pages=1;
		int page=1;
		if(request.getParameter("page")!=null){//说明有值传过来
			page=Integer.parseInt(request.getParameter("page"));
		}
		bookstorservicedao=new Bookstorserviceimpl();
		list=bookstorservicedao.selectScore_exchangeassorter_rightlist((Assorter_right)request.getSession().getAttribute("assorter_right"), page);
		pages=bookstorservicedao.selectScore_exchangeassorter_rightpages((Assorter_right)request.getSession().getAttribute("assorter_right"));
		request.setAttribute("page", page);
		request.setAttribute("pages", pages);
		request.setAttribute("lists", list);
		request.getRequestDispatcher("admin/admin_ScoreExchangeInfo.jsp").forward(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
