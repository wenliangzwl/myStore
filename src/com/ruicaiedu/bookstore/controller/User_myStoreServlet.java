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
import com.ruicaiedu.bookstore.domain.Store_record;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;


@WebServlet("/User_myStoreServlet")
public class User_myStoreServlet extends HttpServlet {
	
	Bookstorservicedao bookstorservicedao=null;
	Bookinfo bookinfo=null;
	private Userinfo userinfo;
	public User_myStoreServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  bookstorservicedao=new Bookstorserviceimpl();
		  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		  String target=basePath.concat("index.jsp");
	       int pageIndex=1;
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }	   
	       userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
	 List<Store_record> store_records=bookstorservicedao.selectBookinfos(userinfo, pageIndex);	
	 request.setAttribute("pageIndex", pageIndex);
     request.setAttribute("totalpage",bookstorservicedao.getStore_RecordTotalpage(userinfo, 4));
	 request.setAttribute("store_records", store_records);	
	/* System.out.println("收藏记录"+store_records.size());
	 
	 for(Store_record store_record:store_records){
		 System.out.println("书名"+store_record.getBookinfo().getBookname());
		 System.out.println("书价格"+store_record.getBookinfo().getBookprice());
		 System.out.println("书籍图片"+store_record.getBookinfo().getBookimg());
	 }
*/

//target=basePath.concat("customer/user_myStore.jsp");
request.getRequestDispatcher("customer/user_myStore.jsp").forward(request, response);

	 	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
