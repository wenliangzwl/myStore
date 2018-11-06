package com.ruicaiedu.bookstore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruicaiedu.bookstore.dao.Assorter_rightdao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;

public class Assorter_rightimpl implements Assorter_rightdao {
	private Connection connection;
	private PreparedStatement pstm;
	private Userinfo userinfo;
	private ResultSet rs;
	
	@Override
	//查询后台用户信息做共享
	public Assorter_right selectassorter_right(Assorter_right assorter_right) {
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.ASSORTER_RIGHTIMPL_SELECTASSORTER_RIGHT_A);
			pstm.setString(1,assorter_right.getAdminname());
			pstm.setString(2,assorter_right.getAdminpwd());
			rs = pstm.executeQuery();
			if(rs.next()){
				assorter_right = new Assorter_right();
				assorter_right.setAdminid(rs.getInt("adminid"));
				assorter_right.setAddress(rs.getString("address"));
				assorter_right.setAdminname(rs.getString("adminname"));
				assorter_right.setAdminpwd(rs.getString("adminpwd"));
				assorter_right.setDepartment(rs.getString("department"));
				assorter_right.setEmail(rs.getString("email"));
				assorter_right.setName(rs.getString("name"));
				assorter_right.setOrgname(rs.getString("orgname"));
				assorter_right.setQq(rs.getString("qq"));
				assorter_right.setPhone(rs.getString("phone"));
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
		return assorter_right;
	}

	@Override
	//查询后台用户是否存在
	public boolean selectAssorter_right(Assorter_right assorter_right) {
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.ASSORTER_RIGHTIMPL_SELECTASSORTER_RIGHT);
			pstm.setString(1,assorter_right.getAdminname());
			pstm.setString(2,assorter_right.getAdminpwd());
			rs = pstm.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return false;
	}

}
