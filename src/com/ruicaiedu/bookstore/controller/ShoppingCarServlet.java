package com.ruicaiedu.bookstore.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Item;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
	private Bookinfo bookinfo;
	private Bookstorservicedao bookstorservicedao;
	static List<Item> items;
	private Item item;
	static{
		items=new ArrayList<Item>();
	}
	public ShoppingCarServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item=new Item();	
		int empty=0;
		String bookid="0";
		String bookidreduce="0";
		String bookidincrease="0";
		int  inputvalue=0;
		String inputbookid="0";
		String deletebookid="0";
		bookinfo=new Bookinfo();
		String back="0";
		boolean bq=false;
		bookstorservicedao=new Bookstorserviceimpl();
		if(request.getParameter("bookid")!=null){
			bookid=request.getParameter("bookid");
			bookinfo.setBookid(bookid);
			bookinfo=bookstorservicedao.selectbookinfodetails(bookinfo);
		}
		if(request.getParameter("bookidreduce")!=null){
			bookidreduce=request.getParameter("bookidreduce");
			
		}
		if(request.getParameter("bookidincrease")!=null){
			bookidincrease=request.getParameter("bookidincrease");
		}
		if(request.getParameter("inputvalue")!=null){
			inputbookid=request.getParameter("inputbookid");
			inputvalue=Integer.parseInt(request.getParameter("inputvalue"));
		}
		if(request.getParameter("deletebookid")!=null){
			deletebookid=request.getParameter("deletebookid");
		}
		if(request.getParameter("sele")!=null){
			bq=true;
			String spil[]=request.getParameter("sele").split(",");
			for (int i = 0; i < spil.length-1; i++) {
				for (int j = i+1; j < spil.length; j++) {
					if(spil[i].equals(spil[j])){
						spil[i]="0";
						spil[j]="0";
					}
				}
			}
			for (int i = 0; i < spil.length; i++) {
				for (int j = 0; j < items.size(); j++) {
					if(spil[i].equals(items.get(j).getBookinfo().getBookid())){
						items.remove(j);
					}
				}
			}		
		}
		if(request.getParameter("empty")!=null){
			for (int i = 0; i < items.size(); i++) {
				items.remove(i);
				bq=true;
			}
		}
		
		item=new Item();
	
		for (int i = 0; i < items.size(); i++) {
		if(bookid.equals(items.get(i).getBookinfo().getBookid())){
			items.get(i).setAccount(items.get(i).getAccount()+1);
			bq=true;			
			}else if(bookidreduce.equals(items.get(i).getBookinfo().getBookid())){
				items.get(i).setAccount(items.get(i).getAccount()-1);
				bq=true;			
			}else if(bookidincrease.equals(items.get(i).getBookinfo().getBookid())){
				items.get(i).setAccount(items.get(i).getAccount()+1);
				bq=true;			
			}else if(inputbookid.equals(items.get(i).getBookinfo().getBookid())){
				items.get(i).setAccount(inputvalue);
				bq=true;			
			}else if(deletebookid.equals(items.get(i).getBookinfo().getBookid())){
				items.remove(i);
				bq=true;			
			}
		}
		if(bq==false){
		item.setBookinfo(bookinfo);
		item.setAccount(1);
		items.add(item);
		}
		double totle=0;
		int size=0;
		for (int i = 0; i < items.size(); i++) {
		totle=totle+items.get(i).getAccount()*items.get(i).getBookinfo().getDiscountprice();
		size=size+items.get(i).getAccount();
	}	
	request.getSession().setAttribute("items", items);
	request.getSession().setAttribute("totle", totle);
	request.getSession().setAttribute("size", size);
	if(request.getParameter("empty")!=null){
		response.sendRedirect("IndexServlet");
	}else{
	if(request.getParameter("back")!=null){
		response.sendRedirect("/bookstore/customer/user_myShoppingcar.jsp");
	}else{
	response.sendRedirect("/bookstore/customer/buy.jsp");
	}}
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
