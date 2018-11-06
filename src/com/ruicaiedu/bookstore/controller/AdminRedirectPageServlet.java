package com.ruicaiedu.bookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminRedirectPageServlet")
public class AdminRedirectPageServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public AdminRedirectPageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		int pageno=Integer.parseInt(request.getParameter("pageno"));
		System.out.println("参数取值"+pageno);
		switch(pageno){
		case 1:			
			//request.getRequestDispatcher("/Admin_ProductBasicInfo_DisplayServlet").forward(request, response);
			response.sendRedirect("/bookstore/Admin_ProductBasicInfo_DisplayServlet");
			
			break;
		case 2:
			response.sendRedirect("/bookstore/Admin_productCommentInfoServlet");
			break;
		case 3:
			response.sendRedirect("/bookstore/Admin_productPromotionInfoServlet");
			break;
		case 4:
			response.sendRedirect("");
			break;
		case 5:
			response.sendRedirect("/bookstore/Admin_ProductOrderStateInfoServlet");
			break;
		case 6:
			response.sendRedirect("/bookstore/Admin_ProductOrderStateInfoServlet?back=1");
			break;
		case 7:
			response.sendRedirect("");
			break;
			
		case 8:
			response.sendRedirect("");
			break;
		case 9:
			response.sendRedirect("/bookstore/Admin_ManagePeopleServlet?back=2");
			break;
		case 10:
			response.sendRedirect("");
			break;
		case 11:
			response.sendRedirect("");
			break;
		case 12:
			response.sendRedirect("/bookstore/Admin_ScoreExchangeInfoServlet");
			break;
		case 13:
			response.sendRedirect("/bookstore/Admin_ScoreExchangeLogoServlet");
			break;
		case 14:
			response.sendRedirect("/bookstore/Admin_MemberInfoServlet");
			break;
		default:
			break;
		}
		

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
