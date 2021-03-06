package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/LikeListServlet")
public class LikeListServlet extends HttpServlet {
	private String bookname;
	private Bookinfo bookinfo;
	private Bookstorservicedao bookstorservicedao = new Bookstorserviceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search_txt = request.getParameter("search_txt");
		bookname = "%"+search_txt+"%";
		bookinfo = new Bookinfo();
		bookinfo.setBookname(bookname);
		int pag = 1;
		if(request.getParameter("page")!=null){//不是第一页
			pag= Integer.parseInt(request.getParameter("page"));
		}
		//共享模糊查询到的数据;
		request.setAttribute("bookinfos", bookstorservicedao.selectBookinfolikeslist(pag, bookinfo));
		//共享当前页数
		request.setAttribute("page",pag);
		//共享查询条件
		//request.setAttribute("bookname",bookname );
		System.err.println("搜索的字符是"+bookname);
		//共享模糊查询总页数
		request.setAttribute("pages", bookstorservicedao.selectBookinfolikespag(bookinfo));
		//跳转页面
		if(bookstorservicedao.selectbookinfolikes(bookinfo)){
			request.getRequestDispatcher("customer/queryList.jsp").forward(request, response);
		}else{
			response.sendRedirect("customer/queryList_NoBook.jsp");
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
