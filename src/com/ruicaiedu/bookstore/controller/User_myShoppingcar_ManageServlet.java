package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Item;
import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;


@WebServlet("/User_myShoppingcar_ManageServlet")
public class User_myShoppingcar_ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Bookstorservicedao bookstorservicedao=null;
	Bookinfo bookinfo=null;    
	
    public User_myShoppingcar_ManageServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstorservicedao=new Bookstorserviceimpl();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
		String target=basePath.concat("index.jsp");
		String bookid="";
		int opt=0;
		boolean flag=false;
		if(request.getParameter("opt")!=null){
			
			opt=Integer.parseInt(request.getParameter("opt"));
		}
		   List<Item> items = 	(List)request.getSession().getAttribute("items");
		   if(items==null){items=new ArrayList<Item>();}
		switch(opt){
		case 1://查看 （书籍详情）
			break;
		case 2://付款
			break;
		case 3://删除
		 bookid=request.getParameter("bookid");		
		  flag=false;
		 for(int i=0;i<items.size();i++){
			 if(items.get(i).getBookinfo().getBookid().equals(bookid)){
				 items.remove(i);		
				 flag=true;					
			      break;
			      }			 
		 }
		 if(flag){ response.sendRedirect("User_myShoppingcarServlet");}
		 else { response.sendRedirect("User_myShoppingcarServlet");}
				break;
		case 4://移入收藏夹
			break;
		case 5://批量删除(接的是bookids(拼起来的字符串))
			String bookids=request.getParameter("bookids");
			String[] bookidss=bookids.split("/");
			 flag=true;
			for(int i=0;i<bookidss.length;i++){				
				for(int j=0;j<items.size();j++){
					 if(items.get(j).getBookinfo().getBookid().equals(bookidss[i])){
						 items.remove(j);  
					 }else{ 
						 flag=false;						
					 }					 
				 }
			}	
			if(flag){response.sendRedirect("User_myShoppingcarServlet");}else{
				response.sendRedirect("User_myShoppingcarServlet");
			}
			break;
		case 6://批量购买
			break;
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
