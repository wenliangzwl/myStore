package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;

@WebServlet("/User_myStore_ManageServlet")
public class User_myStore_ManageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Bookstorservicedao bookstorservicedao=null;
	Bookinfo bookinfo=null;
	private Userinfo userinfo=null;
	public User_myStore_ManageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy();		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		
		throws ServletException, IOException {
		bookstorservicedao=new Bookstorserviceimpl();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		String target=basePath.concat("index.jsp");
		String bookid="";
		String bookids="";
		userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
		int opt=0;
		if(request.getParameter("opt")!=null){
			
			opt=Integer.parseInt(request.getParameter("opt"));
		}
		switch(opt){
		case 1://查看
			break;
		case 2://付款
			break;
		case 3://删除收藏
		 bookid=request.getParameter("bookid");
		 System.out.println("我来删除了吗");
		 System.out.println("bookid"+bookid);
		 System.out.println("bookid"+bookid);
		 bookinfo=new Bookinfo();
		 bookinfo.setBookid(bookid);
			if(bookstorservicedao.deleteBookinfo(userinfo,bookinfo)){
				System.out.println("我运行了吗===1");
				target=basePath.concat("User_myStoreServlet");
				response.sendRedirect(target);
								
			}else{
				System.out.println("我运行了吗===2");
				target=basePath.concat("User_myStoreServlet");
				response.sendRedirect(target);
			}
			break;
		case 4://批量删除
			
			System.out.println("我来批量删除了吗");
			bookids=request.getParameter("bookids");
			System.out.println("bookids集合"+bookids);
			if(bookstorservicedao.deleteBatchOfStore(bookids, userinfo)){
				System.out.println("我成功删除了吗");
			//	target=basePath.concat("User_myStoreServlet");
				response.sendRedirect("User_myStoreServlet");
				
			}
						
			break;
		case 5://批量购买
			break;
		case 6://结算
			break;
		
		}
			

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doGet(request, response);
	}

	public void init() throws ServletException {
	
	}

}
