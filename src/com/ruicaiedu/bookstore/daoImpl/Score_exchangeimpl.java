package com.ruicaiedu.bookstore.daoImpl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.omg.CORBA.PRIVATE_MEMBER;

import com.ruicaiedu.bookstore.dao.Score_exchangedao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;

public class Score_exchangeimpl implements Score_exchangedao {
	private PreparedStatement pstm;
	private Score_exchange score_exchange; 
	private ResultSet rs;
	private Connection connection=null; 
	private Userinfo userinfo;
	private List<Score_exchange> list;
	private Bookinfo bookinfo;
	private List<Bookinfo> list1;
	private Assorter_right assorter_right;
	//添加商品换购
	@Override
	public boolean AddScore_exchange_record(Assorter_right assorter_right,
			Score_exchange score_exchange) {
		//String sql = "insert into score_exchange(score,name,exchangename,description,exchangetype) values(?,?,?,?,?)";
		//score,name,exchangename,description,exchangetype,exchangeimg
		/* `score` int default NULL,-- 换购些商品需要的积分
		  `name` char(30) default NULL,-- 换商品的用户名字
		  `exchangename` char(40) default NULL,-- 商品名
		  `description` char(30) default NULL,-- 商品描述
		  `exchangetype` int default NULL,-- 商品类型  //dxp修改109
			 exchangeimg char(100) default null,-- 商品的图片*/
		connection=DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.SCORE_EXCHANGEIMPL_ADDSCORE_EXCHANGE_RECORD);
			pstm.setInt(1,score_exchange.getScore());
			pstm.setString(2,score_exchange.getAssorter_right().getAdminname());
			pstm.setString(3, score_exchange.getExchangename());
			pstm.setString(4,score_exchange.getDescription());
			pstm.setString(5,score_exchange.getExchangetype());
			pstm.setString(6, score_exchange.getExchangeimg());
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
	//换购商品所花积分
	@Override
	public int selectScore_exchange(Score_exchange score_exchange) {
		//String sql = "select score from score_exchange where exchangeid=?";
		connection = DBhelper.getConnection();
		try {
			pstm = connection.prepareStatement(Document.SCORE_EXCHANGEIMPL_SELECTSCORE_EXCHANGE);
			pstm.setInt(1, score_exchange.getExchangeid());
			rs = pstm.executeQuery();
			if(rs.next()){
				return rs.getInt("score");
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
		return 0;
	}

	@Override
	//前台查询能用积分换购所有商品
//	public final static String SCORE_EXCHANGEIMPL_SELECTSCORE_EXCHANGEINFO="select *  from score_exchange  limit ?,4";
	public List<Score_exchange> selectScore_exchangeinfo(int page) {
		list=new ArrayList<Score_exchange>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEIMPL_SELECTSCORE_EXCHANGEINFO);
			pstm.setInt(1, (page-1)*4);
			rs=pstm.executeQuery();
			while(rs.next()){
				assorter_right=new Assorter_right();
				bookinfo = new Bookinfo();
				score_exchange= new Score_exchange();
				score_exchange.setExchangeid(rs.getInt("exchangeid"));
				score_exchange.setDescription(rs.getString("description"));
				score_exchange.setExchangename(rs.getString("exchangename"));
				score_exchange.setExchangetype(rs.getString("exchangetype"));
				score_exchange.setScore(rs.getInt("score"));
				assorter_right.setAdminname(rs.getString("name"));
				score_exchange.setAssorter_right(assorter_right);
				score_exchange.setExchangeimg(rs.getString("exchangeimg"));
				list.add(score_exchange);							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//后台查询积分兑换商品
	//public final static String  SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHT="select score_exchange.* from score_exchange  where name=?  limit ?,4";
	 public List<Score_exchange> selectScore_exchangeassorter_rightlist(Assorter_right assorter_right,int page){
		 list=new ArrayList<Score_exchange>();
		 
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHT);
				pstm.setString(1, assorter_right.getAdminname());
				pstm.setInt(2, (page-1)*4);
			
				rs=pstm.executeQuery();
				while(rs.next()){
					System.out.println("2222");
					assorter_right=new Assorter_right();
					score_exchange= new Score_exchange();
					bookinfo=new Bookinfo();
					score_exchange.setExchangeid(rs.getInt("exchangeid"));
					score_exchange.setDescription(rs.getString("description"));
					score_exchange.setExchangename(rs.getString("exchangename"));
					score_exchange.setExchangetype(rs.getString("exchangetype"));
					score_exchange.setScore(rs.getInt("score"));
					assorter_right.setAdminname(rs.getString("name"));
					score_exchange.setAssorter_right(assorter_right);
					score_exchange.setExchangeimg(rs.getString("exchangename"));
					list.add(score_exchange);							
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;	 
	 }
		//后台查询兑换商品页数
//		public final static String  SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHTPAGES="select count(*)  from  score_exchange where name=?";
		@Override
		public int selectScore_exchangeassorter_rightpages(
				Assorter_right assorter_right) {
			int pages=0;
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHTPAGES);
				pstm.setString(1,assorter_right.getAdminname() );
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
		@Override
		public boolean AddScore_exchange(Userinfo userinfo,
				Score_exchange score_exchange) {
			// TODO 自动生成的方法存根
			return false;
		}
		//更新用户的积分
//		public final static String SCORE_EXCHANGEDAOUPDATEUSERSCORE="update userinfo set count=count+?  where userid=? ";

		@Override
		public boolean updateuserscore(Userinfo userinfo, int score) {
			// TODO 自动生成的方法存根
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEDAOUPDATEUSERSCORE);
				pstm.setInt(1,score);
				pstm.setInt(2, userinfo.getUserid());
				if(pstm.executeUpdate()>0){				
				return true;
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
			return false;
		}
		
//		public final static String SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEINFOPAGE="'";

		@Override
		//积分商品页数
		public int selectScore_exchangeinfopage() {
			// TODO 自动生成的方法存根
			int pages=0;
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEINFOPAGE);
				rs=pstm.executeQuery();
				
				if(rs.next()){
					if(rs.getInt(1)%4==0){
						pages=rs.getInt(1)/4;
					}else{
						pages=rs.getInt(1)/4+1;
					}
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
			return pages;
		}
		//查询不积分商品用作共享
//		public final static String SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEDETAIL="select * from Scoer_exchange where exchangeid=?";
		
		@Override
		//查询不积分商品用作共享
		public Score_exchange selectScore_exchangedetail(
				Score_exchange score_exchange) {
			// TODO 自动生成的方法存根
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEDETAIL);
				pstm.setInt(1, score_exchange.getExchangeid());
				rs=pstm.executeQuery();
				while(rs.next()){
					assorter_right=new Assorter_right();
					score_exchange.setExchangeid(rs.getInt("exchangeid"));
					score_exchange.setDescription(rs.getString("description"));
					score_exchange.setExchangename(rs.getString("exchangename"));
					score_exchange.setExchangetype(rs.getString("exchangetype"));
					score_exchange.setScore(rs.getInt("score"));
					assorter_right.setAdminname(rs.getString("name"));
					score_exchange.setAssorter_right(assorter_right);
					score_exchange.setExchangeimg(rs.getString("exchangeimg"));			
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
			return score_exchange;
		}
		//更新产品的积分
		//public final static String  SCORE_EXCHANGEIMPLUPDATESCORE_EXCHANGE="";
		@Override
		public void updateScore_exchange(Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEIMPLUPDATESCORE_EXCHANGE);
				pstm.setInt(1, score_exchange.getScore());
				pstm.setInt(2, score_exchange.getExchangeid());
				pstm.execute();
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		//删除积分兑换的产品
		//public final static String  SCORE_EXCHANGEIMPLDELETESCORE_EXCHANGE
		@Override
		public void deleteScore_exchange(Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			try {
				pstm=DBhelper.getConnection().prepareStatement(Document.SCORE_EXCHANGEIMPLDELETESCORE_EXCHANGE);
				pstm.setInt(1, score_exchange.getExchangeid());
				pstm.execute();
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


	
}
