package com.ruicaiedu.bookstore.serviceDaoImpl;

import java.awt.print.Book;
import java.util.List;

import com.ruicaiedu.bookstore.dao.Bookinfodao;
import com.ruicaiedu.bookstore.dao.Ordersdao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Store_record;
import com.ruicaiedu.bookstore.domain.Userinfo;
import com.ruicaiedu.bookstore.factory.Boookstorfactory;
import com.ruicaiedu.bookstore.serviceDao.Bookstorservicedao;

public class Bookstorserviceimpl implements Bookstorservicedao {
	private Boookstorfactory boookstorfactory;
	private Orders orders=null;
	@Override
	public Assorter_right selectassorter_right(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		return boookstorfactory.getAssorter_rightdao().selectassorter_right(assorter_right);
	}

	public Bookstorserviceimpl(){
		boookstorfactory=new Boookstorfactory();
	}
	
	@Override
	public boolean selectAssorter_right(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		return boookstorfactory.getAssorter_rightdao().selectAssorter_right(assorter_right);
	}

	@Override
	public Bookinfo selectbookinfodetails(Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().selectBookinfodetails(bookinfo);
	}

	@Override
	public List<Bookinfo> selectBookinfolikeslist(int pag, Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		
		return boookstorfactory.getBookinfodao().selectBookinfolikeslist(pag, bookinfo);
	}

	@Override
	public boolean selectbookinfolikes(Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().selectbookinfolikes(bookinfo);
	}

	@Override
	public List<Bookinfo> selectBookinfolist(Bookinfo bookinfo, int page, int count) {
		// TODO Auto-generated method stub
		if(bookinfo.getGrade()==21){
			return boookstorfactory.getBookinfodao().selectCombinationBookinfos( 1, 6, page, count);
			}else if(bookinfo.getGrade()==22){
			return boookstorfactory.getBookinfodao().selectCombinationBookinfos( 27, 29, page, count);	
			}else if(bookinfo.getGrade()==23){
			return boookstorfactory.getBookinfodao().selectCombinationBookinfos(30, 32, page, count);
			}else if(bookinfo.getGrade()==24){
			return boookstorfactory.getBookinfodao().selectCombinationBookinfos( 7, 9, page, count);
			}else if(bookinfo.getGrade()==25){
			return boookstorfactory.getBookinfodao().selectCombinationBookinfos( 10, 13, page, count);
			}else if(bookinfo.getGrade()==26){
			return boookstorfactory.getBookinfodao().seleBookinfo(1);	
			}	
		return boookstorfactory.getBookinfodao().selectBookinfolist(bookinfo, page, count);
	}

	@Override
	public int seleBookinfospage(Bookinfo bookinfo,int count) {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().seleBookinfospage(bookinfo,count);
	}

	@Override
	public boolean addBookinfoassorter_right(Bookinfo bookinfo, Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().addBookinfoassorter_right(bookinfo, assorter_right);
	}

	@Override
	public boolean addComment(Userinfo userinfo, Bookinfo booksinfo,
			Comment comment) {
		// TODO Auto-generated method stub
		return boookstorfactory.getCommentdao().addComment(userinfo, booksinfo, comment);
	}

	@Override
	public List<Comment> selectComment(Bookinfo booksinfo, int pag) {
		// TODO Auto-generated method stub
		return boookstorfactory.getCommentdao().selectComment(booksinfo, pag);
	}

	@Override
	public boolean deleteComment(Userinfo userinfo, Comment comment) {
		// TODO Auto-generated method stub
		return boookstorfactory.getCommentdao().deleteComment(userinfo, comment);
	}

	@Override
	public int selectExchange_record(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getExchange_recorddao().selectExchange_record(userinfo);
	}

	@Override
	public boolean deleteExchange_record(Userinfo userinfo,
			Exchange_record exchange_record) {
		// TODO Auto-generated method stub
		return boookstorfactory.getExchange_recorddao().deleteExchange_record(userinfo, exchange_record);
	}

	@Override
	public boolean addExchange_record(Userinfo userinfo,
			Exchange_record exchange_record) {
		// TODO Auto-generated method stub
		return boookstorfactory.getExchange_recorddao().addExchange_record(userinfo, exchange_record);
	}

	@Override
	public List<Exchange_record> selectExchange_records(Userinfo userinfo, int pag) {
		// TODO Auto-generated method stub
		return boookstorfactory.getExchange_recorddao().selectExchange_records(userinfo, pag);
	}

	@Override
	public List<Orders> selectOrdersUserinfolist(int pag, Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().selectOrdersUserinfolist(pag, userinfo);
	}

	@Override
	public List<Orders> selectOrdersAssorter_rightlist(int pag, Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().selectOrdersAssorter_rightlist(pag, assorter_right);
	}

	@Override
	public boolean addOrdersuserinfo(Userinfo userinfo, Orders orders) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().addOrdersuserinfo(userinfo, orders);
	}

	@Override
	public boolean addOrdersassorter_right(Assorter_right assorter_right, Ordersdao orders) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().addOrdersassorter_right(assorter_right, orders);
	}

	@Override
	public boolean updateOrders(Orders orders,String states) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().updateOrders(orders,states);
	}

	@Override
	public boolean deleteOrdersAssorter_right( Orders orders) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().deleteOrdersAssorter_right( orders);
	}

	


	@Override
	public boolean selectStore_record(Userinfo userinfo, Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getStore_recorddao().selectStore_record(userinfo, bookinfo);
	}

	@Override
	public List<Store_record> selectBookinfos(Userinfo userinfo, int pag) {
		// TODO Auto-generated method stub
		return boookstorfactory.getStore_recorddao().selectBookinfos(userinfo, pag);
	}

	@Override
	public boolean deleteBookinfo(Userinfo userinfo, Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getStore_recorddao().deleteBookinfo(userinfo, bookinfo);
	}

	@Override
	public boolean addBookinfo_StoreRecord(Userinfo userinfo, Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getStore_recorddao().addBookinfo_StoreRecord( userinfo, bookinfo);
	}

	@Override
	public boolean addUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getUserinfodao().addUserinfo(userinfo);
	}

	@Override
	public boolean updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getUserinfodao().updateUserinfo(userinfo);
	}

	@Override
	public boolean loadingUseinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getUserinfodao().loadingUseinfo(userinfo);
	}

	@Override
	public Userinfo selectUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getUserinfodao().selectUserinfo(userinfo);
	}
	@Override
	public List<Bookinfo> selectBookinfoassorter_rightlist(Assorter_right assorter_right,int pag){
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().selectBookinfoassorter_rightlist(assorter_right,pag);
	}
	@Override
	public boolean AddScore_exchange_record(Userinfo userinfo,
			Score_exchange score_exchange) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int selectScore_exchange(Score_exchange score_exchange) {
		// TODO Auto-generated method stub
		return boookstorfactory.getScore_exchangedao().selectScore_exchange(score_exchange); 
	}
	//积分换购商品
	@Override
	public List<Score_exchange> selectScore_exchangeinfo(int page) {
		// TODO Auto-generated method stub
		return boookstorfactory.getScore_exchangedao().selectScore_exchangeinfo(page);
	}
	
	@Override
	public int selectBookinfoassorter_rightpag(
			Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		
		return boookstorfactory.getBookinfodao().selectBookinfoassorter_rightpag(assorter_right);
	}
	@Override
	public int selectBookinfolikespag(Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().selectBookinfolikespag(bookinfo);
	}
	@Override
	public boolean registerUseinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getUserinfodao().registerUseinfo(userinfo);
	}
	
	
	@Override
	public List<Bookinfo> selectbookinfobydiscount() {
		// TODO Auto-generated method stub
		return boookstorfactory.getBookinfodao().selectbookinfobydiscount();
	}

	@Override
	public int selectOrdersuserinfopages(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return boookstorfactory.getOrdersdao().selectOrdersuserinfopages(userinfo);
	}
	@Override
	public int selectOrdersAssorter_rightpages(Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		
		return boookstorfactory.getOrdersdao().selectOrdersAssorter_rightpages(assorter_right);
	}
	
	
	
	
	
//=========================================================================
	//dxp新添加
			@Override
			public List<Bookinfo> getBookinfos(int pageindex) {
				// TODO Auto-generated method stub
				return boookstorfactory.getBookinfodao().seleBookinfo(pageindex);
			}
			//dxp新添加
			@Override
			public int getPagedSize(List<Bookinfo> bookinfos,int count) {
				
				int total = bookinfos.size();
				
				if(total % count == 0){
					return total / count;
				}else{
					return total / count + 1;
				}
				
				
				
			}

	//用户删除订单   dxp新添加
		@Override
		public boolean deleteOrders(Orders orders) {
			if(boookstorfactory.getOrdersdao().deleteOrdersUserinfo(orders)>0){
				return true;
			}
			return false;
		}
		
		
		
		//用户批量删除订单   dxp新添加
		@Override
		public boolean deleteBatch(String ordersids) {
			// TODO Auto-generated method stub
			System.out.println("传过来的id字符串"+ordersids);
			String[] ordersides=ordersids.split("/");
			orders=new Orders();
			
			boolean flag=true;
		    for(int i=0;i<ordersides.length;i++){
		    	System.out.println(ordersides[i]);
		        orders.setOrdersid(ordersides[i]);
		    	if(boookstorfactory.getOrdersdao().deleteOrdersUserinfo(orders)<=0){
		    		flag=false;
	    			
		    	}
		    }
			return flag;
		}

		
		
		//dxp 收藏新添加   dxp 9月28日修改
		@Override
		public int getStore_RecordTotalpage(Userinfo userinfo,int pagesize) {
			
			
			int total =seleStore_recordBookinfo(userinfo).size();
				
				if(total % pagesize == 0){
					return total / pagesize;
				}else{
					return total / pagesize + 1;
				}
		}
		 //积分换购书籍的查询  dxp 新添加	
		@Override
		public List<Bookinfo> selectCanExchangeBooks(int pageindex, int pagesize) {//pageindex表示当前页，pagesize表示每页显示的数量
			// TODO Auto-generated method stub
			return boookstorfactory.getBookinfodao().selectCanExchangeBooks(pageindex, pagesize);
		}
		//查询书籍中可兑换商品时，分页显示的总页数    新添加接口   dxp
		@Override
		public int  getCanExchangeBooksTotalPage(int pagesize) {
	    return getPagedSize(boookstorfactory.getBookinfodao().selectCanExchangeBooks(), pagesize);

			
		}
		//dxp新添加，分页显示我的评论
		@Override
		public List<Comment> selectComment(Userinfo userinfo, int pag) {
			// TODO Auto-generated method stub
			return boookstorfactory.getCommentdao().selectComment(userinfo, pag);
		}
		//得到我的评论显示的总页数 dxp新添加
		@Override
		public int getTotalPage(List<Comment> comments, int pagesize) {
	      int total =comments.size();
			
			if(total % pagesize == 0){
				return total / pagesize;
			}else{
				return total / pagesize + 1;
			}
		}
		//显示我的所有评论/用于得到总页数
		@Override
		public List<Comment> selectComment(Userinfo userinfo) {
		
			
			return boookstorfactory.getCommentdao().selectComment(userinfo);
		}
		
		//用户进行商品兑换操作  dxp新添加
		@Override
		public boolean AddScore_exchange(Userinfo userinfo,Score_exchange score_exchange) {
			
			return boookstorfactory.getScore_exchangedao().AddScore_exchange(userinfo, score_exchange);
		}
		//	//显示用户兑换商品的所有记录  dxp新添加 
		@Override
		public List<Exchange_record> selectExchange_records(Userinfo userinfo) {
			
			return boookstorfactory.getExchange_recorddao().selectExchange_records(userinfo);
		}
		  //获得商品兑换记录分页显示的总页数   dxp新添加 
		@Override
		public int getExchange_RecordTotalpage(Userinfo userinfo,int pagesize) {
			
			  int total =selectExchange_records(userinfo).size();
				
				if(total % pagesize == 0){
					return total / pagesize;
				}else{
					return total / pagesize + 1;
				}
		}
		
		//	//dxp 收藏新添加        dxp修改09 28日
		@Override
		public List<Store_record> seleStore_recordBookinfo(Userinfo userinfo) {
			// TODO Auto-generated method stub
			return  boookstorfactory.getStore_recorddao().seleStore_recordBookinfo(userinfo);
		}
		
		
		//0928dxp 新添加
				@Override
				public boolean deleteBatchOfStore(String bookids,Userinfo userinfo) {
					String[] bookides=bookids.split("/");
					Bookinfo bookinfo=new Bookinfo();			
					boolean flag=true;
				    for(int i=0;i< bookides.length;i++){
				    	System.out.println(i+"::拆分循环中的：：："+bookides[i]);
				       bookinfo.setBookid(bookides[i]);
				    	if(!boookstorfactory.getStore_recorddao().deleteBookinfo(userinfo, bookinfo)){
				    		flag=false;
				    		System.out.println(i+"：：数据访问层我成功删除了吗");
				    		
				    
				    	}
				    }
					return flag;
				}

				@Override
				public boolean updateUserScore(Score_exchange score_exchange) {
					// TODO Auto-generated method stub
					return true ;
				}
				@Override
				public boolean judgyUserScore(Score_exchange score_exchange) {
					// TODO Auto-generated method stub
					return true;
				}
//==================================================================		

		//
		//后台分页查询评论 
		@Override
		public List<Comment> selectComment(Assorter_right assorter_right,
				int page) {
              
			
			
			return boookstorfactory.getCommentdao().selectComment(assorter_right, page);
		}
		//后台 查询全部评论 
		@Override
		public List<Comment> selectComment(Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getCommentdao().selectComment(assorter_right);
		}

		@Override
		public int selectbookinfobydiscountpage() {
			return boookstorfactory.getBookinfodao().selectbookinfobydiscountpage();
		}
		@Override
		public List<Userinfo> selectuserinfo(Assorter_right assorter_right) {
			return boookstorfactory.getUserinfodao().selectUserinfo(assorter_right);
		}

		@Override
		public List<Bookinfo> selectbookinfobydiscountAssorter_rightlist(
				Assorter_right assorter_right, int page) {
			// TODO Auto-generated method stub
			return boookstorfactory.getBookinfodao().selectbookinfobydiscountAssorter_rightlist(assorter_right,page);
		}

		@Override
		public int selectbookinfobydiscountAssorter_rightpages(
				Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getBookinfodao().selectbookinfobydiscountAssorter_rightpages(assorter_right);
		}
	
//xby 假期添加
		@Override
		public void updatebooinfostore(Bookinfo bookinfo) {
			// TODO 自动生成的方法存根
			boookstorfactory.getBookinfodao().updatebooinfostore(bookinfo);
		}

		@Override
		public void updatebooinfosell(Bookinfo bookinfo) {
			// TODO 自动生成的方法存根
			boookstorfactory.getBookinfodao().updatebooinfosell(bookinfo);
			
		}
		@Override
		public double totalmoney(Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getOrdersdao().totalmoney(assorter_right);
		}
		@Override
		public boolean selectuserinfocondition(Userinfo userinfo,
				Bookinfo bookinfo) {
			// TODO Auto-generated method stub
			return boookstorfactory.getCommentdao().selectuserinfocondition(userinfo, bookinfo);
		}

		@Override
		public List<Score_exchange> selectScore_exchangeassorter_rightlist(
				Assorter_right assorter_right, int page) {
			// TODO Auto-generated method stub
			return boookstorfactory.getScore_exchangedao().selectScore_exchangeassorter_rightlist(assorter_right, page);
		}

		@Override
		public int selectScore_exchangeassorter_rightpages(
				Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getScore_exchangedao().selectScore_exchangeassorter_rightpages(assorter_right);
		}
		@Override
		public void updateScore_exchange(Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			boookstorfactory.getScore_exchangedao().updateScore_exchange(score_exchange);
		}

		@Override
		public void deleteScore_exchange(Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			boookstorfactory.getScore_exchangedao().deleteScore_exchange(score_exchange);
		}
		@Override
		public void updateExchange_records(Exchange_record exchange_record) {
			// TODO Auto-generated method stub
			boookstorfactory.getExchange_recorddao().updateExchange_records(exchange_record);
		}
		@Override
		public List<Exchange_record> selectExchange_recordsAssorter_right(
				Assorter_right assorter_right, int page) {
			// TODO 自动生成的方法存根
			return boookstorfactory.getExchange_recorddao().selectExchange_recordsAssorter_right(assorter_right, page);
		}

		@Override
		public int selectExchange_recordspages(Assorter_right assorter_right) {
			// TODO 自动生成的方法存根
			return boookstorfactory.getExchange_recorddao().selectExchange_recordspages(assorter_right);
		}
		@Override
		public boolean updateuserscore(Userinfo userinfo, int score) {
			// TODO 自动生成的方法存根
			return boookstorfactory.getScore_exchangedao().updateuserscore(userinfo, score);
		}
		@Override
		public boolean addBookinfo(Userinfo userinfo, Bookinfo bookinfo) {
			// TODO Auto-generated method stub
			return boookstorfactory.getStore_recorddao().addBookinfo(userinfo, bookinfo);
		}

		@Override
		public boolean AddScore_exchange_record(Assorter_right assorter_right,
				Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			return boookstorfactory.getScore_exchangedao().AddScore_exchange_record(assorter_right, score_exchange);
		}

		@Override
		public int selectScore_exchangeinfopage() {
			// TODO Auto-generated method stub
			return boookstorfactory.getScore_exchangedao().selectScore_exchangeinfopage();
		}

		@Override
		public Score_exchange selectScore_exchangedetail(
				Score_exchange score_exchange) {
			// TODO Auto-generated method stub
			return boookstorfactory.getScore_exchangedao().selectScore_exchangedetail(score_exchange);
		}
		@Override
		public List<Orders> selectVip(int pag, Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getOrdersdao().selectVip(pag, assorter_right);
		}

		@Override
		public int selectVippges(Assorter_right assorter_right) {
			// TODO Auto-generated method stub
			return boookstorfactory.getOrdersdao().selectVippges(assorter_right);
		}

		@Override
		public void deleteVip(Userinfo userinfo) {
			// TODO Auto-generated method stub
			boookstorfactory.getOrdersdao().deleteVip(userinfo);
		}

		@Override
		public List<Bookinfo> selectbookinfBookinfossell() {
			// TODO Auto-generated method stub
			return boookstorfactory.getBookinfodao().selectbookinfBookinfossell();
		}

}






