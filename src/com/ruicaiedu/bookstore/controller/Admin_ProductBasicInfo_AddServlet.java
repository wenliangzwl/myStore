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
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
import com.ruicaiedu.bookstore.util.Tool;

@WebServlet("/Admin_ProductBasicInfo_AddServlet")
public class Admin_ProductBasicInfo_AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bookstorservicedao bookstorservicedao = null;
	Bookinfo bookinfo = null;
	Assorter_right assorter_right = null;

	public Admin_ProductBasicInfo_AddServlet() {
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
		String[] form = new String[16];
	
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
					String path =request.getServletContext().getContextPath()+"/".concat("bookimg"); 
					
					for (char c : hss) {
						filebox += "/" + c;
					}					
					//new File(path).mkdirs();				
					path+=filebox;
					String savepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path ;
				
					form[i] =savepath+"/"+uuidName;
					System.out.println("数据库存储图片i值"+i+form[i]);
					String uploadpath=this.getServletContext().getRealPath(
							"/bookimg")+filebox;					
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

	

		
		
		
		
		
	

		bookinfo = new Bookinfo();
		// 108 23点58分注释掉  assorter_right = new Assorter_right();
		assorter_right =(Assorter_right)request.getSession().getAttribute("assorter_right");
		System.out.println("上传书籍yonghumingz"+assorter_right.getAdminname());
		bookinfo.setBookid(Tool.getRandomId());

		// 108 23点58分注释掉  assorter_right.setAdminname(form[0]);
		bookinfo.setAssorter_right(assorter_right);

		bookinfo.setBookprice(Double.parseDouble(form[1]));
		bookinfo.setDiscountprice(Double.parseDouble(form[2]));
		bookinfo.setBookname(form[3]);
		bookinfo.setBookimg(form[4]);
		bookinfo.setBtype(form[5]);
		bookinfo.setGrade(Integer.parseInt(form[6]));
		bookinfo.setAuthor(form[7]);
		bookinfo.setPress(form[8]);
		bookinfo.setPresstime(form[9]);
		bookinfo.setIsbn(form[10]);	
		bookinfo.setScore(Integer.parseInt(form[11]));//绉垎鏁版嵁搴撻粯璁ゅ�鏀逛负0,涓嶅～琛ㄧず涓嶅弬涓庣Н鍒嗗厬鎹紒锛�
		bookinfo.setBookdetails(form[12]);		

		
		if (bookstorservicedao.addBookinfoassorter_right(bookinfo,assorter_right)) {
		
			request.getRequestDispatcher(
					"/Admin_ProductBasicInfo_DisplayServlet").forward(request,
					response);

		} else {
			request.getRequestDispatcher(
					"/Admin_ProductBasicInfo_DisplayServlet").forward(request,
					response);

		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
