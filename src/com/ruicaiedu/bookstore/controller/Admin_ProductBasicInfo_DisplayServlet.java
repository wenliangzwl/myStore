package com.ruicaiedu.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;

@WebServlet("/Admin_ProductBasicInfo_DisplayServlet")
public class Admin_ProductBasicInfo_DisplayServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bookstorservicedao bookstorservicedao = null;
	Assorter_right assorter_right = null;

	public Admin_ProductBasicInfo_DisplayServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bookstorservicedao = new Bookstorserviceimpl();
		int pageIndex= 1;
		if (request.getParameter("pageIndex") != null) {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		}
		assorter_right = (Assorter_right) request.getSession().getAttribute(
				"assorter_right");
		//System.out.println("管理员名字：" + assorter_right.getAdminname());
		int totalpage = bookstorservicedao
				.selectBookinfoassorter_rightpag(assorter_right);

		//System.out.println("总页数" + totalpage);
		/*int lastrowSize = bookstorservicedao.selectBookinfoassorter_rightlist(
				assorter_right, totalpage).size();*/
		//System.out.println("最后一页的行数" + lastrowSize);
	/*	int rows = (totalpage - 1) * 5 + lastrowSize;*/
		//System.out.println("总行数" + rows);
		System.out.println("接收到的pageindex"+pageIndex);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("totalpage", totalpage);
		//request.setAttribute("rows", rows);
		request.setAttribute("bookinfors", bookstorservicedao
				.selectBookinfoassorter_rightlist(assorter_right, pageIndex));

		request.getRequestDispatcher("/admin/admin_ProductBasicInfo.jsp")
				.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	public void init() throws ServletException {
		// Put your code here
	}

}
