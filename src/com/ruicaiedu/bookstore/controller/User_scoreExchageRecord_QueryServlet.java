package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;


@WebServlet("/User_scoreExchageRecord_QueryServlet")
public class User_scoreExchageRecord_QueryServlet extends HttpServlet {
	Bookstorservicedao bookstorservicedao=null;
	Score_exchange score_exchange=null;
	Bookinfo bookinfo=null;
	Userinfo userinfo2 =null;
	Exchange_record exchange_record=null;
	 Userinfo userinfo=null;
	 private static final long serialVersionUID = 1L;		
		private List<Exchange_record> list;

	public User_scoreExchageRecord_QueryServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		 	throws ServletException, IOException {
		System.out.println("------我来到了积分记录查询吗------");		
		bookstorservicedao=new Bookstorserviceimpl();
		 int pageIndex=1;
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }
	      userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
	      int totalpage=bookstorservicedao.selectExchange_record(userinfo);
	      list= bookstorservicedao.selectExchange_records(userinfo,pageIndex);	  
	     request.setAttribute("pageIndex", pageIndex);
	     request.setAttribute("totalpage", totalpage);
	     request.setAttribute("exchange_Records", list);
	     request.getRequestDispatcher("customer/user_exchangeArea_exchangeRecord.jsp").forward(request, response);	
		
	
		
		/*dxp
 * bookstorservicedao=new Bookstorserviceimpl();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
String target=basePath.concat("index.jsp");
String bookid="";
userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
int pageIndex=1;
if(request.getParameter("pageIndex")!=null){
	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
}	  
request.setAttribute("pageIndex", pageIndex);
	request.setAttribute("exchange_Records", bookstorservicedao.selectExchange_records(userinfo, pageIndex));
System.out.println("servlet大小"+bookstorservicedao.selectExchange_records(userinfo, pageIndex).size());
 request.setAttribute("totalpage",bookstorservicedao.getExchange_RecordTotalpage(userinfo, 5));
 request.getRequestDispatcher("customer/user_exchangeArea_exchangeRecord.jsp").forward(request, response);	*/
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
