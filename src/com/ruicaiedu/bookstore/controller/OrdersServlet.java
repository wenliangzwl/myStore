package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.daoImpl.Bookinfoimpl;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Item;
import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private Orders orders;
	private Bookinfo bookinfo;
	private Userinfo userinfo;
	private Bookstorservicedao bookstorservicedao;
	public OrdersServlet() {
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
		int score=0;
		List<Item> items=(List<Item>) request.getSession().getAttribute("items");
		for (int i = 0; i < items.size(); i++) {
			bookinfo=new Bookinfo();
			userinfo=new Userinfo();
			orders=new Orders();
			orders.setUserinfo((Userinfo)request.getSession().getAttribute("userinfo"));
			bookinfo.setBookid(items.get(i).getBookinfo().getBookid());
			items.get(i).getAccount();
			
			bookinfo.setBookname(items.get(i).getBookinfo().getBookname());
			System.out.println("----------=========-----------1009测试-----"+bookinfo.getBookname());
			bookinfo.setAuthor(items.get(i).getBookinfo().getAuthor());
			bookinfo.setIsbn(items.get(i).getBookinfo().getIsbn());
			orders.setBookinfo(bookinfo);
			orders.setJiage(items.get(i).getBookinfo().getDiscountprice()*items.get(i).getAccount());
			score=score+items.get(i).getBookinfo().getScore()*items.get(i).getAccount();
			orders.setAcount(items.get(i).getAccount());	
			bookinfo.setSell(items.get(i).getAccount());
			bookstorservicedao.addOrdersuserinfo((Userinfo)request.getSession().getAttribute("userinfo"), orders);
				bookstorservicedao.updatebooinfosell(bookinfo);			
		}	
		bookstorservicedao.updateuserscore((Userinfo)request.getSession().getAttribute("userinfo"), score);
		response.sendRedirect("ShoppingCarServlet?empty=1");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
