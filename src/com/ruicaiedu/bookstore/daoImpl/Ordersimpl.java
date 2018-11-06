package com.ruicaiedu.bookstore.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruicaiedu.bookstore.dao.Ordersdao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;
import com.ruicaiedu.bookstore.util.Tool;
public class Ordersimpl implements Ordersdao{
	private PreparedStatement pstm;
	private ResultSet rs;
	private Bookinfo bookinfo;
	private Orders orders;
	private Userinfo userinfo;
	private List<Orders> list;
	//销售总和
//	public final static String  ORDERSIMPLTOTALMONEY=

	@Override
	public double totalmoney(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		double totalmoney=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPLTOTALMONEY);
			pstm.setString(1, assorter_right.getAdminname());
			rs=pstm.executeQuery();
			if(rs.next()){
				totalmoney=rs.getFloat(1);
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
		
		return totalmoney;
	}
	//前台分页查询订单
	//public final static String ORDERSIMPL_SELECTORDERSUSERINFO="select * from orders where userid=? limit ?,4";
	@Override
	public List<Orders> selectOrdersUserinfolist(int pag, Userinfo userinfo) {
		// TODO Auto-generated method stub
		list=new ArrayList<Orders>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_SELECTORDERSUSERINFO);
			pstm.setInt(1, userinfo.getUserid());
			pstm.setInt(2, (pag-1)*2); //dxp0928 改为2
			rs=pstm.executeQuery();
			while(rs.next()){
				orders=new Orders();
				 bookinfo=new Bookinfo();
				orders.setOrdersid(rs.getString(1));
				userinfo.setUserid(rs.getInt(2));
				bookinfo.setBookid(rs.getString(3));
				//dname字段没有set方法     //dxp 1008 凌晨1点修改！
				orders.setCreatetime(rs.getTimestamp(4).toString());
				orders.setState(rs.getString(5));
				orders.setJiage(rs.getDouble(6));
				orders.setPaynumber(rs.getString(7));
				orders.setShipcharge(rs.getString(8));
				orders.setAcount(rs.getInt(9));
				orders.setPhone(rs.getString(10));
				userinfo.setUsername(rs.getString(12));
				bookinfo.setBookname(rs.getString(12));
				bookinfo.setAuthor(rs.getString(13));
				bookinfo.setIsbn(rs.getString(14)); 
				bookinfo.setBookimg(rs.getString(15)); 
				orders.setUserinfo(userinfo);
				orders.setBookinfo(bookinfo);
				list.add(orders);
				/*`dname` char(30) default NULL,-- 订单商品名字
				  `createtime` timestamp default current_timestamp,-- 创建时间
				  `state` char(30) default '已付款,未发货',-- 订单状态（下单没付款，下单已付款，付款未发货，付款已经发货等等）
				  `jiage` float default NULL,-- 此订单价格
				  `paynumber` char(30) default NULL,-- 支付号（没做支付功能，可以暂时去掉）
				  `shipcharge` char(30) default NULL,-- 支付运费（没做运费表，可以暂时去掉）
				  `acount` int(10) default NULL,-- 数量
				  `phone` char(30) default NULL,-- 电话
				  `username` char(30) default NULL,-- 下单用户名
				  `bookname` char(30) default NULL,-- 所购买书名
				  `author` char(30) default NULL,-- 作者
				  `isbn` char(30) default NULL,-- ISBN*/
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
		return list;
	}
	//前台分页查询订单页数、
	//	public final static String ORDERSIMPL_SELECTORDERSUSERINFOPAGES="select count(*)  from orders where userid=?";
	@Override
	public int selectOrdersuserinfopages(Userinfo userinfo) {
		// TODO Auto-generated method stub
		int page=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_SELECTORDERSUSERINFOPAGES);
		    pstm.setInt(1, userinfo.getUserid());
			rs=pstm.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)%2==0){
					page=rs.getInt(1)/2;
				}else{
					page=rs.getInt(1)/2+1;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return page;
	}
	
	
	
	
	//后台用户分页查询订单
//	public final static String ORDERSIMPL_SELECTORDERSASSORTER_RIGHT="select orders.*,userinfo.address from userinfo,orders,bookinfo where orders.bookid=bookinfo.bookid and bookinfo.adminname=? and userinfo.userid=orders.userid limit ?,4";
	@Override
	public List<Orders> selectOrdersAssorter_rightlist(int pag, Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		list=new ArrayList<Orders>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_SELECTORDERSASSORTER_RIGHT);
			pstm.setString(1, assorter_right.getAdminname());
			pstm.setInt(2, (pag-1)*4);
			rs=pstm.executeQuery();
			while(rs.next()){
				userinfo=new Userinfo();
				orders=new Orders();
				bookinfo=new Bookinfo();
				orders.setOrdersid(rs.getString(1));
				userinfo.setUserid(rs.getInt(2));
				bookinfo.setBookid(rs.getString(3));
				orders.setCreatetime(rs.getTimestamp(4).toString());
				orders.setState(rs.getString(5));
				orders.setJiage(rs.getDouble(6));
				orders.setPaynumber(rs.getString(7));
				orders.setShipcharge(rs.getString(8));
				orders.setAcount(rs.getInt(9));
				orders.setPhone(rs.getString(10));
				userinfo.setUsername(rs.getString(11));
				bookinfo.setBookname(rs.getString(12));
				bookinfo.setAuthor(rs.getString(13));
				bookinfo.setIsbn(rs.getString(14)); 
				userinfo.setAddress(rs.getString(15));
				bookinfo.setDiscountprice(rs.getDouble(16));				
				userinfo.setEmail(rs.getString(17));
				orders.setUserinfo(userinfo);
				orders.setBookinfo(bookinfo);
				list.add(orders);
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
		return list;
	}
	//后台页数
	//public final static String ORDERSIMPL_SELECTORDERSASSORTER_RIGHTPAGES="select count(*)  from orders  where bookid in (select bookid from bookinfo where adminname=?)";
	@Override
	public int selectOrdersAssorter_rightpages(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		int page=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_SELECTORDERSASSORTER_RIGHTPAGES);
			pstm.setString(1,assorter_right.getAdminname());
			rs=pstm.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)%4==0){
				page=rs.getInt(1)/4;
				}else{
				page=rs.getInt(1)/4+1;	
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	//前台用户添加订单
	//public final static String ORDERSIMPL_ADDORDERSUSERINFO="insert into orders(ordersid,userid,bookid,jiage,acount,phone,username,bookame,author,isbn) values(?,?,?,?,?,?,?,?,?,?);";
	//-----insert into orders(ordersid,userid,bookid,jiage,acount,phone,username,bookame,author,isbn) values(?,?,?,?,?,?,?,?,?,?);";
	@Override
	public boolean addOrdersuserinfo(Userinfo userinfo, Orders orders) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_ADDORDERSUSERINFO);
			pstm.setString(1, Tool.getRandomId());
			pstm.setInt(2, userinfo.getUserid());
			pstm.setString(3, orders.getBookinfo().getBookid());
			pstm.setDouble(4, orders.getJiage());
			pstm.setDouble(5, orders.getAcount());
			pstm.setString(6, orders.getUserinfo().getPhone());
			pstm.setString(7, orders.getUserinfo().getUsername());
			pstm.setString(8, orders.getBookinfo().getBookname());
			pstm.setString(9, orders.getBookinfo().getAuthor());
			pstm.setString(10, orders.getBookinfo().getIsbn());	
			if(pstm.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//不用
	@Override
	public boolean addOrdersassorter_right(Assorter_right assorter_right, Ordersdao orders) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//后台修改订单
	//public final static String ORDERSIMPL_UPDATEORDERS="update orders set state=? where ordersid=?;";	
	@Override
	public boolean updateOrders(Orders orders,String state) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_UPDATEORDERS);
			pstm.setString(1, state);
			pstm.setString(2, orders.getOrdersid());
			if(pstm.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//后台删除订单
	//public final static String ORDERSIMPL_DELETEORDERSASSORTER_RIGHT="delete from   orders where ordersid=?";
	@Override
	public boolean deleteOrdersAssorter_right( Orders orders) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_DELETEORDERS);
			pstm.setString(1, orders.getOrdersid());
			if(pstm.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//千台删除订单
	//public final static String ORDERSIMPL_DELETEORDERSASSORTER_RIGHT="delete from   orders where ordersid=?";
	@Override
	public int deleteOrdersUserinfo(Orders orders) {
		// TODO Auto-generated method stub
		System.out.println("数据访问层"+orders.getOrdersid());
		int times=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPL_DELETEORDERS);
			pstm.setString(1, orders.getOrdersid());
			times=pstm.executeUpdate();
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
		
		return times;
	}
//	public final static String  ORDERSIMPLSELECTVIP

	@Override
	public List<Orders> selectVip(int pag, Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		list=new ArrayList<Orders>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPLSELECTVIP);
			pstm.setString(1, assorter_right.getAdminname());
			pstm.setInt(2, (pag-1)*4);
			rs=pstm.executeQuery();
			while(rs.next()){
				userinfo=new Userinfo();
				orders=new Orders();
				bookinfo=new Bookinfo();
				orders.setOrdersid(rs.getString(1));
				userinfo.setUserid(rs.getInt(2));
				bookinfo.setBookid(rs.getString(3));
				orders.setCreatetime(rs.getTimestamp(4).toString());
				orders.setState(rs.getString(5));
				orders.setJiage(rs.getDouble(6));
				orders.setPaynumber(rs.getString(7));
				orders.setShipcharge(rs.getString(8));
				orders.setAcount(rs.getInt(9));
				orders.setPhone(rs.getString(10));
				userinfo.setUsername(rs.getString(11));
				bookinfo.setBookname(rs.getString(12));
				bookinfo.setAuthor(rs.getString(13));
				bookinfo.setIsbn(rs.getString(14)); 
				userinfo.setAddress(rs.getString(15));
				bookinfo.setDiscountprice(rs.getDouble(16));
				userinfo.setPhone(rs.getString(17));
				userinfo.setEmail(rs.getString(18));
				orders.setUserinfo(userinfo);
				orders.setBookinfo(bookinfo);
				list.add(orders);
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
		return list;
	}
	//后台会员页数
//	public final static String  ORDERSIMPLSELECTVIPPGES="select count(*) from (select orders.userid from orders where bookid in(select bookid from bookinfo where adminname=?) group by userid) b";
	public int selectVippges(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		int pages=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPLSELECTVIPPGES);
			pstm.setString(1, assorter_right.getAdminname());
			rs=pstm.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)%4==0){
					pages=rs.getInt(1)/4;
				}else{
					pages=rs.getInt(1)/4+1;
				}
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
		
		return pages;
	}
	//删除会员信息
//	public final static String  ORDERSIMPLDELETEVIP

	@Override
	public void deleteVip(Userinfo userinfo) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.ORDERSIMPLDELETEVIP);
			pstm.setInt(1, userinfo.getUserid());
			pstm.execute();
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
	
	}
	


}
