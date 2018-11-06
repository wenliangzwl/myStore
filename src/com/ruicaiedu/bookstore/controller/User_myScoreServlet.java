package com.ruicaiedu.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;

@WebServlet("/User_myScoreServlet")
public class User_myScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bookstorservicedao bookstorservicedao=null;
	private Userinfo userinfo=null;
	Score_exchange score_exchange=null;
    public User_myScoreServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 bookstorservicedao=new Bookstorserviceimpl();
	    
		 //待修改，应该查询积分兑换记录表！！！
		 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		 String target=basePath.concat("index.jsp");
		 int pageIndex=1;
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }
	       userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
	      //int totalpage=bookstorservicedao.getStore_RecordTotalpage(userinfo,2);
	       int totalpage=bookstorservicedao.getCanExchangeBooksTotalPage(4);
	      request.setAttribute("bookinfors", bookstorservicedao.selectCanExchangeBooks(pageIndex, 2));
	    System.out.println("====我的积分测试==="+bookstorservicedao.selectCanExchangeBooks(pageIndex, 2));
	      request.setAttribute("totalpage",totalpage);
	      //target=basePath.concat("customer/user_myScore.jsp");
	      request.getRequestDispatcher("/customer/user_myScore.jsp").forward(request, response);
	      
	
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
