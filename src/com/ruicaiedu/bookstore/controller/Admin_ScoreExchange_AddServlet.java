package com.ruicaiedu.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
import com.ruicaiedu.bookstore.util.Tool;

@WebServlet("/Admin_ScoreExchange_AddServlet")
public class Admin_ScoreExchange_AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bookstorservicedao bookstorservicedao = null;
Score_exchange score_exchange=null;
	Assorter_right assorter_right = null;

	public Admin_ScoreExchange_AddServlet() {
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
		request.setCharacterEncoding("utf-8");
		

		// ===============================================
		bookstorservicedao=new Bookstorserviceimpl();
		String[] form = new String[15];
	
		DiskFileItemFactory dff = new DiskFileItemFactory();
		dff.setSizeThreshold(4096);
		File temp = new File("d:/temp");
		if (!temp.exists()) {
			temp.mkdirs();
		}
		dff.setRepository(temp);
		ServletFileUpload upload = new ServletFileUpload(dff);
		System.out.println("-----2222---------");
		try {
			List<FileItem> items = upload.parseRequest(request);// 瑙ｆ瀽琛ㄥ崟
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				if (item.isFormField()) {
					form[i] = new String(item.getString()
							.getBytes("iso-8859-1"), "utf-8");
					System.out.println("i值"+i+form[i]);
				} else {
					String str = item.getName();
					System.out.println("初始地址"+str);
					String filename = str.substring((str.lastIndexOf("\\")+1));
					System.out.println("图片名字"+filename);
					String uuidName = UUID.randomUUID().toString()+ filename;					
					int hash = uuidName.hashCode();
					String hashStr = Integer.toHexString(hash);
					char[] hss = hashStr.toCharArray();
					
					String filebox="";
					String path =request.getServletContext().getContextPath()+"/".concat("Exchangeimg"); 
					
					for (char c : hss) {
						filebox += "/" + c;
					}					
					//new File(path).mkdirs();				
					path+=filebox;
					String savepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path ;
				
					form[i] =savepath+"/"+uuidName;
					System.out.println("++++++++++++"+form[i]);
					System.out.println("数据库存储图片i值"+i+form[i]);
					String uploadpath=this.getServletContext().getRealPath(
							"/Exchangeimg")+filebox;					
					System.out.println("上传存储图片"+uploadpath);
					new File(uploadpath).mkdirs();
					File fileupload = new File(uploadpath, uuidName);
					item.write(fileupload);
					temp.delete(); // --删除临时文件
						}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----333---------");
		score_exchange=new Score_exchange();
		assorter_right =(Assorter_right)request.getSession().getAttribute("assorter_right");
		score_exchange.setAssorter_right(assorter_right);
		score_exchange.setScore(Integer.parseInt(form[1]));
		score_exchange.setExchangename(form[2]);		
		score_exchange.setExchangeimg(form[3]);	
		score_exchange.setExchangetype(form[4]);
		score_exchange.setDescription(form[5]);
		System.out.println("添加前：：：：：：：：："+score_exchange.getExchangeimg());
		if(bookstorservicedao.AddScore_exchange_record(assorter_right, score_exchange)){
			response.sendRedirect("Admin_ScoreExchangeInfoServlet");
			}
		else {			
			response.sendRedirect("Admin_ScoreExchangeInfoServlet");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
