package com.ruicaiedu.bookstore.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
/*
 * 
 * 注册界面
 * 
 * 
 * 
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	private Userinfo userinfo;
	public UserRegisterServlet() {
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
		bookstorservicedao=new Bookstorserviceimpl();
		String basePath=request.getServletContext().getContextPath();
		userinfo=new Userinfo();
		request.setCharacterEncoding("utf-8");
		userinfo.setNickname(request.getParameter("nickname"));
		userinfo.setPwd(request.getParameter("pwd"));
		userinfo.setEmail(request.getParameter("email"));
		String optt=null;//dxp1009
		if(bookstorservicedao.registerUseinfo(userinfo)){
			response.sendRedirect(basePath.concat("/customer/register.jsp"));
		}else {
			bookstorservicedao.addUserinfo(userinfo);
			System.out.println("----------------------");
			optt="haslogin";//dxp1009
			request.getSession().setAttribute("optt", optt);//dxp1009
			request.getSession().setAttribute("userinfo", bookstorservicedao.selectUserinfo(userinfo));
			response.sendRedirect(basePath.concat("/IndexServlet"));
		}
		;
		
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
