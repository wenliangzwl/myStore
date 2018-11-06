package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ProductOrderDeleteServlet")
public class Admin_ProductOrderDeleteServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Orders orders;
	public Admin_ProductOrderDeleteServlet() {
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
		orders=new Orders();
		bookstorservicedao=new Bookstorserviceimpl();
		orders.setOrdersid(request.getParameter("ordersid"));
		bookstorservicedao.deleteOrdersAssorter_right(orders);
		response.sendRedirect("Admin_ProductOrderStateInfoServlet");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
