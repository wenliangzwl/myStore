package com.ruicaiedu.bookstore.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
public class Admin_productPromotionInfo_ManageServlet extends HttpServlet {
	private Bookstorservicedao sBookstorservicedao = new Bookstorserviceimpl();
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//接受页面传过来的数据
				String bookid = request.getParameter("bookid");
				Bookinfo bookinfo = new Bookinfo();
				bookinfo.setBookid(bookid);
				//共享书籍详情
				request.setAttribute("bookinfo",sBookstorservicedao.selectbookinfodetails(bookinfo) );
				//页面展示
				request.getRequestDispatcher("admin/admin_productBasicInfo_detail.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
	public void init() throws ServletException {
	}

}
