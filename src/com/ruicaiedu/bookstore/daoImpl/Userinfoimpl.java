package com.ruicaiedu.bookstore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruicaiedu.bookstore.dao.Userinfodao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;

public class Userinfoimpl implements Userinfodao {
	private Connection connection;
	private PreparedStatement pstm;
	private Userinfo userinfo;
	private Userinfo userinfo2;
	private ResultSet rs;
	private List<Userinfo> userinfos;

	@Override
	//添加用户
	public boolean addUserinfo(Userinfo userinfo) {
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.USERINFOIMPL_ADDGUSERINFO);
			pstm.setString(1,userinfo.getNickname());
			pstm.setString(2,userinfo.getPwd());
			pstm.setString(3,userinfo.getEmail());
			if(pstm.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	//用户登录注册验证
	public boolean loadingUseinfo(Userinfo userinfo) {
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.USERINFOIMPL_LOADINGUSERINFO);
			pstm.setString(1,userinfo.getNickname());
			pstm.setString(2,userinfo.getPwd());
			rs = pstm.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	//数据共享
	public Userinfo selectUserinfo(Userinfo userinfo) {
		connection = DBhelper.getConnection();
		System.out.println("底层接收到了吗"+userinfo.getNickname()+userinfo.getPwd());
		userinfo2 = new Userinfo();
		try {
			pstm = connection.prepareStatement(Document.USERINFOIMPL_SELECTUSERINFO);
			pstm.setString(1,userinfo.getNickname());
			pstm.setString(2,userinfo.getPwd());
			rs = pstm.executeQuery();
			if(rs.next()){				
				userinfo2.setScore(rs.getInt("score"));
				System.out.println("查询出来"+rs.getInt("score"));
				userinfo2.setUserid(rs.getInt("userid"));
				userinfo2.setNickname(rs.getString("nickname"));
				userinfo2.setPhone(rs.getString("phone"));
				userinfo2.setQq(rs.getString("qq"));
				userinfo2.setUsername(rs.getString("username"));
				userinfo2.setAddress(rs.getString("address"));
				userinfo2.setCity(rs.getString("city"));
				userinfo2.setQu(rs.getString("qu"));
				userinfo2.setClassname(rs.getString("classname"));
				userinfo2.setGrade(rs.getString("grade"));
				userinfo2.setFamilyphone(rs.getString("familyphone"));
				userinfo2.setPostcode(rs.getString("postcode"));
				userinfo2.setProvince(rs.getString("province"));
				userinfo2.setUtype(rs.getString("utype"));
				userinfo2.setSchool(rs.getString("school"));				
				userinfo2.setPicture(rs.getString("picture"));
				userinfo2.setEmail(rs.getString("email"));
				userinfo2.setHobby(rs.getString("hobby"));
				userinfo2.setIntroduce(rs.getString("introduce"));
				userinfo2.setBirthday(rs.getString("birthday"));
				userinfo2.setGender(rs.getString("gender"));
				userinfo2.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("底层测试"+userinfo2.getScore());
		return userinfo2 ;
	}

	@Override
	//用户修改信息   dxp0928 修改
	public boolean updateUserinfo(Userinfo userinfo) {
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.USERINFOIMPL_UPDATEUSERINFO);
			pstm.setString(1,userinfo.getNickname());//
			pstm.setString(2,userinfo.getPhone());//
			pstm.setString(3,userinfo.getQq());//
			pstm.setString(4, userinfo.getUsername());//
			pstm.setString(5,userinfo.getAddress());//
			pstm.setString(6,userinfo.getCity());//
			pstm.setString(7, userinfo.getQu());//
			pstm.setString(8, userinfo.getClassname());//
			pstm.setString(9, null);//==
			pstm.setString(10, null);//==
			pstm.setString(11, null);//==
			pstm.setString(12, userinfo.getProvince());//
			pstm.setString(13, userinfo.getUtype());//
			pstm.setString(14, userinfo.getSchool());//
			//pstm.setInt(15, 0);//== dxp删掉
			pstm.setString(15, userinfo.getPicture());//
			pstm.setString(16, userinfo.getEmail());//
			pstm.setString(17, userinfo.getHobby());//
			pstm.setString(18, userinfo.getIntroduce());//
			pstm.setString(19, userinfo.getBirthday());//
			pstm.setString(20, userinfo.getGender());//
			pstm.setInt(21, userinfo.getUserid());//0928丁小平添加
			if(pstm.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//注册验证
	//	public final static String USERINFOIMPLREGISTERUSEINFO="select * from userinfo where nickname=?";
	@Override
	public boolean registerUseinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.USERINFOIMPLREGISTERUSEINFO);
			pstm.setString(1, userinfo.getNickname());
			rs=pstm.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public List<Userinfo> selectUserinfo(Assorter_right assorter_right) {
		String sql = "select * from userinfo,orders,bookinfo WHERE userinfo.userid=orders.userid and orders.bookid =bookinfo.bookid and bookinfo.adminname=?";
		userinfos = new ArrayList<Userinfo>();
		try {
			connection = DBhelper.getConnection();
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, assorter_right.getAdminname());
			rs = pstm.executeQuery();
			while(rs.next()){
				userinfo = new Userinfo();
				userinfo.setNickname(rs.getString("nickname"));
				userinfo.setPhone(rs.getString("phone"));
				userinfo.setQq(rs.getString("qq"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setAddress(rs.getString("address"));
				userinfo.setCity(rs.getString("city"));
				userinfo.setQu(rs.getString("qu"));
				userinfo.setClassname(rs.getString("classname"));
				userinfo.setGrade(rs.getString("grade"));
				userinfo.setFamilyphone(rs.getString("familyphone"));
				userinfo.setPostcode(rs.getString("postcode"));
				userinfo.setProvince(rs.getString("province"));
				userinfo.setUtype(rs.getString("utype"));
				userinfo.setSchool(rs.getString("school"));
				userinfo.setScore(rs.getInt("score"));
				userinfo.setPicture(rs.getString("picture"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setHobby(rs.getString("hobby"));
				userinfo.setIntroduce(rs.getString("introduce"));
				userinfo.setBirthday(rs.getString("birthday"));
				userinfo.setGender(rs.getString("gender"));
				userinfos.add(userinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userinfos;
	}

}
