
package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ProductOrderStateInfo_ManageServlet")
public class Admin_ProductOrderStateInfo_ManageServlet extends HttpServlet {
	private Orders orders;
	private Bookstorservicedao bookstorservicedao;
	public Admin_ProductOrderStateInfo_ManageServlet() {

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
		bookstorservicedao.updateOrders(orders, request.getParameter("state"));
		response.sendRedirect("Admin_ProductOrderStateInfoServlet");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

