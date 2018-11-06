package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Item;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;


@WebServlet("/User_myShoppingcarServlet")
public class User_myShoppingcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Bookstorservicedao bookstorservicedao=null;
	Bookinfo bookinfo=null;
  
    public User_myShoppingcarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 bookstorservicedao=new Bookstorserviceimpl();
		 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		 String target=basePath.concat("index.jsp");
	      
	       List<Item> items = 	(List)session.getAttribute("items");
	       if(items==null){items=new ArrayList<Item>();}
	      
	       //---------开始实现分页 dxp---------------
	       List<Item>smallitems=new ArrayList<Item>();
	       int pageIndex=1;int pagesize=2;
	       int sizeAll=items.size();
	       if(request.getParameter("pageIndex")!=null){
	    	   pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
	       }	  
	       int beginIndex=(pageIndex-1)*pagesize;
	        int endIndex =sizeAll;//默认为最后一页即pageIndex*pagesize>sizeAll
	       if(pageIndex*pagesize<=sizeAll){
	    	   endIndex=pageIndex*pagesize;
	       }
	       for(int i=beginIndex;i<endIndex;i++){
	    	   smallitems.add(items.get(i));    	   	
	       }	       
	       int totalpage=1;
	       if(sizeAll%pagesize==0){
	    	   totalpage=sizeAll/pagesize;
	       }else{
	    	   totalpage=sizeAll/pagesize+1;
	       }	
	     
	       request.setAttribute("smallitems", smallitems);
	       request.setAttribute("pageIndex", pageIndex);
	       request.setAttribute("totalpage",totalpage);
	       //--------分页显示session数据 结束	dxp----    ----------------   	 
	      
	       request.getRequestDispatcher("customer/user_myShoppingcar.jsp").forward(request, response);
	  	   
		
		
		
	}

}
