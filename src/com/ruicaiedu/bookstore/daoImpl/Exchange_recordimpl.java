package com.ruicaiedu.bookstore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ruicaiedu.bookstore.dao.Exchange_recorddao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;

public class Exchange_recordimpl implements Exchange_recorddao{
	private PreparedStatement pstm;
	private Exchange_record exchange_record;
	private ResultSet rs;
	private List<Exchange_record> list;
	//删除积分消费记录
	//public final static String EXCHANGE_RECORDIMPL_DELETEEXCHANGE_RECORD="delete from exchange_record where userid=? and recordid=?";
	public boolean deleteExchange_record(Userinfo userinfo,
			Exchange_record exchange_record) {
		// TODO Auto-generated method stub
		try {
			pstm = DBhelper.getConnection().prepareStatement(
					Document.EXCHANGE_RECORDIMPL_DELETEEXCHANGE_RECORD);
			pstm.setInt(1, userinfo.getUserid());
			pstm.setInt(2, exchange_record.getRecordid());
			if (pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	//添加积分记录
	//public final static String EXCHANGE_RECORDIMPL_ADDEXCHANGE_RECORD="insert into exchange_record(userid,score,exchangename,address,sendtime) values(?,?,?,?,?)";
	@Override
	public boolean addExchange_record(Userinfo userinfo,
			Exchange_record exchange_record) {
		// TODO Auto-generated method stub
		try {
			pstm = DBhelper.getConnection().prepareStatement(
					Document.EXCHANGE_RECORDIMPL_ADDEXCHANGE_RECORD);
			pstm.setInt(1, userinfo.getUserid());
			pstm.setInt(2, exchange_record.getScore());
			pstm.setString(3, exchange_record.getExchangename());
			pstm.setString(4, userinfo.getAddress());
			pstm.setString(5, "一天后");
			pstm.setString(6, exchange_record.getExchangeimg());
			if (pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}
	//分页查询积分消费记录
	//public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS="select * from exchange_record where userid=? limit ?,4";
	@Override
	public List<Exchange_record> selectExchange_records(Userinfo userinfo,
			int pag) {
		list = new ArrayList<Exchange_record>();
		try {
			pstm = DBhelper.getConnection().prepareStatement(
					Document.EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS);
			pstm.setInt(1, userinfo.getUserid());
			pstm.setInt(2, (pag - 1) * 4);
			rs = pstm.executeQuery();
			while (rs.next()) {
				exchange_record = new Exchange_record();
				exchange_record.setRecordid(rs.getInt(1));
				userinfo.setUserid(rs.getInt(2));
				exchange_record.setUserinfo(userinfo);
				exchange_record.setScore(rs.getInt(3));
				exchange_record.setExchangename(rs.getString(4));
				exchange_record.setExchangetime(rs.getTimestamp(5).toString());
				exchange_record.setState(rs.getString(6));
				exchange_record.setAddress(rs.getString(7));
				exchange_record.setSendtime(rs.getString(8));
				exchange_record.setExchangeimg(rs.getString("exchangeimg"));
				list.add(exchange_record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//查询积分总页数
	//public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORD="select count(*) from exchange_record where userid=?";
	public int selectExchange_record(Userinfo userinfo) {
		// TODO Auto-generated method stub
		int pages = 0;
		try {
			pstm = DBhelper.getConnection().prepareStatement(
					Document.EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORD);
			pstm.setInt(1, userinfo.getUserid());
			rs = pstm.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) % 4 == 0) {
					pages = rs.getInt(1) / 4;
				} else {
					pages = rs.getInt(1) / 4 + 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pages;
	}
	//SELECT * from  exchange_record where userid=?
	//显示用户兑换商品的所有记录  dxp新添加
		@Override
	public List<Exchange_record> selectExchange_records(Userinfo userinfo) {

		try {
			pstm = DBhelper.getConnection().prepareStatement(
					Document.EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS_ALL);
			pstm.setInt(1, userinfo.getUserid());
			rs = pstm.executeQuery();
			while (rs.next()) {
				exchange_record = new Exchange_record();
				exchange_record.setRecordid(rs.getInt(1));
				userinfo.setUserid(rs.getInt(2));
				exchange_record.setUserinfo(userinfo);
				exchange_record.setScore(rs.getInt(3));
				exchange_record.setExchangename(rs.getString(4));
				exchange_record.setExchangetime(rs.getTimestamp(5).toString());
				exchange_record.setState(rs.getString(6));
				exchange_record.setAddress(rs.getString(7));
				exchange_record.setSendtime(rs.getString(8));
				exchange_record.setExchangeimg(rs.getString("exchangeimg"));
				list.add(exchange_record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//后台查询兑换记录
	//public final static String EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSASSORTER_RIGHT="select exchange_record.*,userinfo.username from userinfo ,exchange_record where exchangename in(select exchangename from score_exchange where name='admin') and userinfo.userid=exchange_record.userid"
		@Override
		public List<Exchange_record> selectExchange_recordsAssorter_right(
				Assorter_right assorter_right,int page) {
			// TODO 自动生成的方法存根
			list=new ArrayList<Exchange_record>();
			
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSASSORTER_RIGHT);
				pstm.setString(1, assorter_right.getAdminname());
				pstm.setInt(2, (page-1)*4);
				rs=pstm.executeQuery();
				while(rs.next()){
					exchange_record=new Exchange_record();
					Userinfo userinfo=new Userinfo();
					exchange_record.setRecordid(rs.getInt(1));
					userinfo.setUserid(rs.getInt(2));
					exchange_record.setScore(rs.getInt(3));
					exchange_record.setExchangename(rs.getString(4));
					exchange_record.setExchangetime(rs.getString(5).toString());
					exchange_record.setState(rs.getString(6));
					userinfo.setAddress(rs.getString(7));
					exchange_record.setSendtime(rs.getString(8));
					userinfo.setUsername(rs.getString(10));
					exchange_record.setUserinfo(userinfo);
					exchange_record.setExchangeimg(rs.getString("exchangeimg"));
					list.add(exchange_record);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					DBhelper.getConnection().close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			return list;
		}
		//后台查询积分兑换记录的页数
		public final static String EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSPAGES="select count(*) from exchange_record where exchangename in(select exchangename from score_exchange where name=?)";
		@Override
		public int selectExchange_recordspages(Assorter_right assorter_right) {
			// TODO 自动生成的方法存根
			int pages = 0;
			try {
				pstm = DBhelper.getConnection().prepareStatement(
						Document.EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSPAGES);
				pstm.setString(1, assorter_right.getAdminname());
				rs = pstm.executeQuery();
				while (rs.next()) {
					if (rs.getInt(1) % 4 == 0) {
						pages = rs.getInt(1) / 4;
					} else {
						pages = rs.getInt(1) / 4 + 1;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBhelper.getConnection().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return pages;
		}
		//更新积分兑换记录的送货时间
//		public final static String  EXCHANGE_RECORDIMPLUPDATEEXCHANGE_RECORDS="update exchange_record set sendtime=? where recordid=? ";
		@Override
		public void updateExchange_records(Exchange_record exchange_record) {
			// TODO Auto-generated method stub
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.EXCHANGE_RECORDIMPLUPDATEEXCHANGE_RECORDS);
				pstm.setString(1, exchange_record.getSendtime());
				pstm.setInt(2, exchange_record.getRecordid());
				pstm.execute();
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
