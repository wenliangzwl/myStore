package com.ruicaiedu.bookstore.controller;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bookstorservicedao bookstorservicedao;
	private Bookinfo bookinfo;
	Comment comment=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bookstorservicedao = new Bookstorserviceimpl();
		bookinfo = new Bookinfo();
		comment=new Comment();
		String back="0";
		int page=1;
		int bq=0;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page")) ;
		}
		if(request.getParameter("bookid")!=null){
			bookinfo.setBookid(request.getParameter("bookid"));
		}
		
		request.setAttribute("bookinfo", (Bookinfo)bookstorservicedao.selectbookinfodetails(bookinfo));
		request.setAttribute("comments", bookstorservicedao.selectComment(bookinfo, page));
		if((Userinfo)request.getSession().getAttribute("userinfo")!=null){
			if(bookstorservicedao.selectStore_record((Userinfo)request.getSession().getAttribute("userinfo"), bookinfo)){
				bq=1;
				}
				request.getSession().setAttribute("bq",bq);
				if(request.getParameter("back")!=null){
				request.getRequestDispatcher("/customer/addcomment.jsp").forward(request, response);	
				}else{
				request.getRequestDispatcher("/customer/bookDetail.jsp").forward(request, response);
				}				
		}
			/*
			if(bookstorservicedao.selectStore_record((Userinfo)request.getSession().getAttribute("userinfo"), bookinfo)){
			bq=1;
			}
			request.getSession().setAttribute("bq",bq);
			if(request.getParameter("back")!=null){
			request.getRequestDispatcher("/customer/addcomment.jsp").forward(request, response);	
			}else{
			request.getRequestDispatcher("/customer/bookDetail.jsp").forward(request, response);
			}
		}else{
			response.sendRedirect("index.jsp");
		}*/
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
