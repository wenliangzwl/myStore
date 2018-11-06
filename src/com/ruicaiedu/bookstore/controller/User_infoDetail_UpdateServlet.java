package com.ruicaiedu.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.omg.CORBA.UShortSeqHolder;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;
import com.ruicaiedu.bookstore.serviceDaoImpl.Bookstorserviceimpl;
import com.ruicaiedu.bookstore.util.Tool;

@WebServlet("/User_infoDetail_UpdateServlet")
public class User_infoDetail_UpdateServlet extends HttpServlet {
	Bookstorservicedao bookstorservicedao = null;
    Userinfo userinfo=null;
	private static final long serialVersionUID = 1L;

	public User_infoDetail_UpdateServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
request.setCharacterEncoding("utf-8");
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/";
String target=basePath.concat("index.jsp");	

		// ===============================================
		bookstorservicedao=new Bookstorserviceimpl();
		String[] form = new String[20];
	
		DiskFileItemFactory dff = new DiskFileItemFactory();
		dff.setSizeThreshold(4096);
		File temp = new File("d:/temp");
		if (!temp.exists()) {
			temp.mkdirs();
		}
		dff.setRepository(temp);
		ServletFileUpload upload = new ServletFileUpload(dff);		
		try {
			List<FileItem> items = upload.parseRequest(request);// 解析表单
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				if (item.isFormField()) {
					form[i] = new String(item.getString()
							.getBytes("iso-8859-1"), "utf-8");
				//	System.out.println("i值"+i+form[i]);
				} else {
					String str = item.getName();
				//	System.out.println("初始地址"+str);
					String filename = str.substring((str.lastIndexOf("\\")+1));
				//	System.out.println("图片名字"+filename);
					String uuidName = UUID.randomUUID().toString()+ filename;					
					int hash = uuidName.hashCode();
					String hashStr = Integer.toHexString(hash);
					char[] hss = hashStr.toCharArray();
					
					String filebox="";
					String path =request.getServletContext().getContextPath()+"/".concat("userimg"); 
					
					for (char c : hss) {
						filebox += "/" + c;
					}
					
					//new File(path).mkdirs();
				
					path+=filebox;
					String savepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path ;
				
					form[i] =savepath+"/"+uuidName;
				//	System.out.println("数据库存储图片i值"+i+form[i]);
					String uploadpath=this.getServletContext().getRealPath(
							"/userimg")+filebox;					
				//	System.out.println("上传存储图片"+uploadpath);
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
		userinfo=(Userinfo)request.getSession().getAttribute("userinfo");
		userinfo.setPicture(form[0]);
		//form[1]为隐藏域 ，不算！
		userinfo.setNickname(form[2]);
		userinfo.setUtype(form[3]);
		userinfo.setUsername(form[4]);
		userinfo.setGender(form[5]);
		userinfo.setEmail(form[6]);
		userinfo.setPhone(form[7]);
		userinfo.setQq(form[8]);
		userinfo.setSchool(form[9]);
		userinfo.setClassname(form[10]);
		String 	birthday=form[11].concat("-").concat(form[12]).concat("-").concat(form[13]);
		System.out.println("============="+birthday);
		userinfo.setBirthday(birthday);
		userinfo.setProvince(form[14]);
		userinfo.setCity(form[15]);
		userinfo.setQu(form[16]);
		userinfo.setHobby(form[17]);
		userinfo.setIntroduce(form[18]);	
		String address=form[14].concat(form[15]).concat(form[16]);
		userinfo.setAddress(address);
		userinfo.setUserid(userinfo.getUserid());
		System.out.println("userid"+userinfo.getUserid());
		String msg="";
		if(bookstorservicedao.updateUserinfo(userinfo)){
		      System.out.println("==============我运行了吗=============");
			request.setAttribute(msg, "您已经成功修改信息");			
			
          
			request.getSession().removeAttribute("userinfo");
			System.out.println("修改用户信息后用户的id"+userinfo.getUserid());
			System.out.println("修改用户信息后用户nicheng"+userinfo.getNickname()+"mima"+userinfo.getPwd());
			//System.out.println("用户信息转接到了吗"+userinfo2.getNickname()+"=="+userinfo2.getPwd());
			//System.out.println("修改用户信息后用户积分：："+bookstorservicedao.selectUserinfo(userinfo2).getScore());
			 Userinfo userinfo2=bookstorservicedao.selectUserinfo(userinfo);
			request.getSession().setAttribute("userinfo", userinfo2);	
			request.getRequestDispatcher("customer/user_infoDetail.jsp").forward(request, response);
		
		}else{

			request.setAttribute(msg, "没有成功修改,请重新提交！");
			target=basePath.concat("customer/user_infoDetail.jsp");
			request.getRequestDispatcher("customer/user_infoDetail.jsp").forward(request, response);			
			
		}

	
		
	}

	
	public void init() throws ServletException {
		
	}

}
