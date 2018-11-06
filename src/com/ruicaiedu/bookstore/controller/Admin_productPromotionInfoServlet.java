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

@WebServlet("/Admin_productPromotionInfoServlet")
public class Admin_productPromotionInfoServlet extends HttpServlet {
	Bookstorservicedao sBookstorservicedao = new Bookstorserviceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;//默认第一页
		if(request.getParameter("page")!=null){
			 page = Integer.parseInt(request.getParameter("page"));
			}
		
		//共享当前页数
		request.setAttribute("page", page);
		//共享总分页页数
		request.setAttribute("pages",sBookstorservicedao.selectBookinfoassorter_rightpag((Assorter_right)request.getSession().getAttribute("assorter_right")));
		//共享查询数据
		request.setAttribute("bookinfos", sBookstorservicedao.selectBookinfoassorter_rightlist((Assorter_right)request.getSession().getAttribute("assorter_right"), page));
		//转发页面
		request.getRequestDispatcher("admin/admin_productPromotionInfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public void init() throws ServletException {
	}
}
