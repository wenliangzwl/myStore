package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/Admin_ProductOrderStateInfoServlet")
public class Admin_ProductOrderStateInfoServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	public Admin_ProductOrderStateInfoServlet() {
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
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		bookstorservicedao=new Bookstorserviceimpl();
		request.setAttribute("ordersassorter_rightlist", bookstorservicedao.selectOrdersAssorter_rightlist(page, (Assorter_right)request.getSession().getAttribute("assorter_right")));
		request.setAttribute("pages", bookstorservicedao.selectOrdersAssorter_rightpages((Assorter_right)request.getSession().getAttribute("assorter_right")));
		request.setAttribute("page", page);
		request.setAttribute("totalmoney",bookstorservicedao.totalmoney((Assorter_right)request.getSession().getAttribute("assorter_right")));	
		if(request.getParameter("back")!=null){
			request.getRequestDispatcher("/admin/admin_productOrderSaleInfo.jsp").forward(request, response);	
		}else{
		request.getRequestDispatcher("/admin/admin_ProductOrderStateInfo.jsp").forward(request, response);
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
