package com.ruicaiedu.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

@WebFilter(filterName="a_SecurityFilter",urlPatterns="/*")   // 项目完后取消注释，开始使用此过滤器
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
		FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)res;
        String path  = request.getRequestURI();		
        String basePath=request.getServletContext().getContextPath();
        System.out.println("path"+path);
		String filename=path.substring(path.lastIndexOf("/")+1);
        System.out.println("fielname"+filename);
	if(request.getSession().getAttribute("userinfo")!=null&&!path.contains("Admin")&&!path.contains("admin")||request.getSession().getAttribute("assorter_right")!=null&&(path.contains("Admin")||path.contains("admin"))){
		System.out.println("---------1---------");	
		chain.doFilter(request, response);
			return;
		
		}	
	if(path.contains("admin")||path.contains("Admin")){
		System.out.println("---------1---------");		
		if((filename.contains("admin_")||filename.contains("Admin_"))||filename.equals("AdminRedirectPageServlet")||filename.equals("adminManage.jsp")){
			System.out.println("---------2---------");	
			response.sendRedirect(basePath.concat("/admin/adminLogin.jsp"));		
		}else{
			System.out.println("---------3---------");	
			chain.doFilter(request, response);
		}		
	}else if(filename.contains("user_")||filename.equals("order.jsp")||filename.equals("buy.jsp")||filename.equals("buyPay.jsp")||filename.equals("addcomment.jsp")||filename.contains("User_")||filename.equals("ShoppingCarServlet")||filename.equals("CommonStoreServlet")||filename.equals("OrdersServlet")||filename.equals("SelectBookinfoServlet")){
		System.out.println("wolailima");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++filename.contains(buy)+"+filename.contains("buy.jsp"));
		System.out.println("---------4---------");	
		response.sendRedirect(basePath.concat("/customer/login.jsp"));
	}else{
		System.out.println("---------5---------");	
		chain.doFilter(request, response);
	}
	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
