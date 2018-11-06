package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.dao.Bookinfodao;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/SelectBookinfoServlet")
public class SelectBookinfoServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Bookinfo bookinfo;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bookstorservicedao = new Bookstorserviceimpl();
		bookinfo = new Bookinfo();
		
		String bookid = request.getParameter("1");
		bookinfo.setBookid(bookid);
		if(bookstorservicedao.selectbookinfodetails(bookinfo)!=null){
			request.setAttribute("bookinfo", bookinfo);
			response.sendRedirect("bookDetail.jsp");
		}else{
			response.sendRedirect("index.jsp");
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
