package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/User_myorder_ManageServlet")
public class User_myorder_ManageServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Bookstorservicedao bookstorservicedao =null;
Orders orders=null;
	public User_myorder_ManageServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		String target=basePath.concat("index.jsp");
	int opt=0;
	if(request.getParameter("opt")!=null){
		opt=Integer.parseInt(request.getParameter("opt"));		
	}
	String ordersid="";
			
	if(request.getParameter("ordersid")!=null){
		ordersid=request.getParameter("ordersid");
	}
    bookstorservicedao=new Bookstorserviceimpl();
    
    //查看  评价 单个删除 选择
    	
    	  switch(opt){
    	    case 1:
    	    	//转到订单详情页面（暂时没有该显示页面）	
    	    	//写一个订单详情的servlet，共享订单数据到订单详情页面
    	    	
    	    break;
    	    case 2:
    	    	//没有订单评价表，需重新建立，并实现底层方法！！暂时不做
    	    	response.sendRedirect("BookDetailServlet?bookid="+request.getParameter("bookid")+"&back=1");	
    	    	
    	        break;
    	    case 3:
    	    	System.out.println("===========我单个删除订单了吗===========");
    	    	 orders=new Orders();
    	    	orders.setOrdersid(request.getParameter("ordersid"));
    	    	
    	    	if(bookstorservicedao.deleteOrders(orders)){
System.out.println("我单个删除订单成功了");
//target=basePath.concat("User_myorderServlet");
request.getRequestDispatcher("User_myorderServlet").forward(request, response);
    	    		
    	    	}else{//target=basePath.concat("User_myorderServlet");
    	    		response.sendRedirect("User_myorderServlet");
    	    	 request.getRequestDispatcher("User_myorderServlet").forward(request, response);}
    	        break;
    	    case 4://批量删除
    	    	 ordersid=request.getParameter("ordersid");
    	    	 System.out.println("接受到的id字符串"+ordersid);
    	    	System.out.println("我开始批量删除了吗");
    	    	if(bookstorservicedao.deleteBatch(ordersid)){
    	    		System.out.println("批量删除成功");  	    		
    	    		//target=basePath.concat("User_myorderServlet");
    	    		response.sendRedirect("User_myorderServlet");
    	    		//request.getRequestDispatcher("User_myorderServlet").forward(request, response);
    	       	}
    	    	
    	    	break;
    	    default:
    	        break;
    	    
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
