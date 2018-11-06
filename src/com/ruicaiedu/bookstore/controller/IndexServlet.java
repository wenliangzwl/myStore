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
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private Bookstorservicedao bookstorservicedao;
	public IndexServlet() {
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
		List<Bookinfo> list=bookstorservicedao.getBookinfos(1);
		List<Bookinfo> discountlist=bookstorservicedao.selectbookinfobydiscount();
		
		Bookinfo bookinfosubjectprimary=new Bookinfo();
		bookinfosubjectprimary.setGrade(21);
		
		Bookinfo bookinfojunior=new Bookinfo();
		bookinfojunior.setGrade(22);
		
		Bookinfo bookinfosenior=new Bookinfo();
		bookinfosenior.setGrade(23);
		
		Bookinfo bookinfoeducation=new Bookinfo();
		bookinfoeducation.setGrade(24);
		
		Bookinfo bookinfotool=new Bookinfo();
		bookinfotool.setGrade(25);
		
		Bookinfo bookinfoperiodical=new Bookinfo();
		bookinfoperiodical.setGrade(26);
		
		request.setAttribute("subjectprimary", bookstorservicedao.selectBookinfolist(bookinfosubjectprimary, 1, 9));
		request.setAttribute("junior", bookstorservicedao.selectBookinfolist(bookinfojunior, 1, 9));
		request.setAttribute("senior", bookstorservicedao.selectBookinfolist(bookinfosenior, 1, 9));
		request.setAttribute("education", bookstorservicedao.selectBookinfolist(bookinfoeducation, 1, 9));
		request.setAttribute("tool", bookstorservicedao.selectBookinfolist(bookinfotool, 1, 9));
		request.setAttribute("periodical", bookstorservicedao.selectBookinfolist(bookinfoperiodical, 1, 9));
		request.setAttribute("sell",  bookstorservicedao.selectbookinfBookinfossell());

		
		request.getSession().setAttribute("list", list);
		request.setAttribute("discountlist", discountlist);
		System.out.println(discountlist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
