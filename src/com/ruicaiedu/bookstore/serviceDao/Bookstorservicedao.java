package com.ruicaiedu.bookstore.serviceDao;

import java.util.List;



import com.ruicaiedu.bookstore.dao.Ordersdao;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Orders;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Store_record;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface Bookstorservicedao {
	
	 public List<Bookinfo> selectbookinfBookinfossell();
	
	//添加商品换购
	 public boolean AddScore_exchange_record(Assorter_right assorter_right,Score_exchange score_exchange);
	 //前台积分商品分页页数
	 public int selectScore_exchangeinfopage();
	 //查询积分商品用作共享
	 public Score_exchange selectScore_exchangedetail(Score_exchange score_exchange);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*----------------丁小平区域开始-------------------------*/
		//查询后台用户是否存在
		public Assorter_right selectassorter_right(Assorter_right assorter_right);
		//查询后台用户信息做共享
		public boolean selectAssorter_right(Assorter_right assorter_right);
		//添加评论
		public boolean addComment(Userinfo userinfo,Bookinfo booksinfo,Comment comment);
		//评论分页展示
		public List<Comment> selectComment(Bookinfo booksinfo,int pag);
		//删除评论
		public boolean deleteComment(Userinfo userinfo,Comment comment);
		//分页显示我的评论 dxp新添加
		public List<Comment> selectComment(Userinfo userinfo, int pag);
		//得到我的评论显示的总页数 dxp新添加
		public int getTotalPage(List<Comment> comments,int pagesize);
		//显示我的所有评论/用于得到总页数 dxp新加
		public List<Comment> selectComment(Userinfo userinfo);
		//dxp 9月26新添加
		//后台分页查询评论 
		public List<Comment> selectComment(Assorter_right assorter_right,int page);
		//后台 查询全部评论 
		 public List<Comment> selectComment(Assorter_right assorter_right);
		
		 
		 /*----------------丁小平区域End-------------------------*/
		
		/*----------------徐炳艳区域开始-------------------------*/		
     	//默认显示书籍（根据实际情况改变显示条数：DXP新添加）
		public List<Bookinfo> getBookinfos(int page);
		//得到     查询书籍的总页数
		public int getPagedSize(List<Bookinfo> bookinfos,int count);
		
		//查询书籍详情
		public Bookinfo selectbookinfodetails(Bookinfo bookinfo);
		//模糊查询书籍
		public List<Bookinfo> selectBookinfolikeslist(int pag,Bookinfo bookinfo);
		//模糊查询书籍是否存在
		public boolean selectbookinfolikes(Bookinfo bookinfo);
		//模糊查询书籍页数
		public int selectBookinfolikespag(Bookinfo bookinfo);
		
		//书籍分页查询 
		public List<Bookinfo> selectBookinfolist(Bookinfo bookinfo,int page,int count);
		//分页展示页数
		public int seleBookinfospage(Bookinfo bookinfo,int count);

		//依据折扣价依次排行
		public List<Bookinfo> selectbookinfobydiscount();
		
		
		//后台添加书籍
		public boolean addBookinfoassorter_right(Bookinfo bookinfo,Assorter_right assorter_right);
		//后台查询书籍
		public List<Bookinfo> selectBookinfoassorter_rightlist(Assorter_right assorter_right,int pag);
		//后台查询书籍页数
		public int selectBookinfoassorter_rightpag(Assorter_right assorter_right);
		
		//后台折扣分页
		public List<Bookinfo> selectbookinfobydiscountAssorter_rightlist(Assorter_right assorter_right,int page);
		//后台折扣分页页数
		public int selectbookinfobydiscountAssorter_rightpages(Assorter_right assorter_right);
		
		//更新书籍的收藏次数  xby假期添加
		public void updatebooinfostore(Bookinfo bookinfo);
		//更新售卖的数量   xby假期添加
		public void updatebooinfosell(Bookinfo bookinfo);
		/*======================订单================*/
		//用户订单查询订单记录分页扎实
		public List<Orders> selectOrdersUserinfolist(int pag,Userinfo userinfo);
		//管理员订单分页展示
		public List<Orders> selectOrdersAssorter_rightlist(int pag,Assorter_right assorter_right);
		//用户订单添加
		public boolean addOrdersuserinfo(Userinfo userinfo,Orders orders);
		//管理员点单添加
		public boolean addOrdersassorter_right(Assorter_right assorter_right,Ordersdao orders);
		//管理员修改订单
		public boolean updateOrders(Orders orders,String states);
		//删除订单
		public boolean deleteOrdersAssorter_right(Orders orders);
			
		   //用户删除订单   dxp新添加
		public boolean deleteOrders(Orders orders);  //orders 只放主键
		//用户批量删除订单   dxp新添加
		public boolean deleteBatch(String  ordersids);
		//积分换购书籍的查询  dxp 新添加	
		public List<Bookinfo> selectCanExchangeBooks(int pageindex,int pagesize);//pageindex表示当前页，pagesize表示每页显示的数量
		//积分兑换中新添加接口   dxp
					public int getCanExchangeBooksTotalPage(int pagesize);//pagesize 页面显示的条数
		//前台分页页数
		public int selectOrdersuserinfopages(Userinfo userinfo);
		//后台分页查询也页数
		public int selectOrdersAssorter_rightpages(Assorter_right assorter_right);
		/*----------------徐炳艳区域End-------------------------*/

	
		
		
		/*----------------周虎区域开始-------------------------*/
		//用户查询自己的积分
		public int selectExchange_record(Userinfo userinfo);
		//删除积分消费记录
		public boolean deleteExchange_record(Userinfo userinfo,Exchange_record exchange_record);
		//添加积分消费记录
		public boolean addExchange_record(Userinfo userinfo,Exchange_record exchange_record);
		//分页展示积分消费记录
		public List<Exchange_record> selectExchange_records(Userinfo userinfo,int pag);
		//添加商品换购
		 public boolean AddScore_exchange_record(Userinfo userinfo,Score_exchange score_exchange);
		 //换购商品所化积分
		 public int selectScore_exchange(Score_exchange score_exchange);
		//查询积分换购商品
		 public List<Score_exchange> selectScore_exchangeinfo(int page);
		//用户进行商品兑换操作  dxp新添加
		 public boolean AddScore_exchange(Userinfo userinfo,Score_exchange score_exchange);
		//显示用户兑换商品的所有记录  dxp新添加 
		public List<Exchange_record> selectExchange_records(Userinfo userinfo);
	  //获得商品兑换记录分页显示的总页数
		public int getExchange_RecordTotalpage(Userinfo userinfo,int pagesize);
		 //dxp0928添加  根据换购商品的积分，减去用户积分  （修改用户积分）《买商品时，增加积分，也需调用该方法》
		 public  boolean updateUserScore(Score_exchange score_exchange);
		//dxp0928添加  判断用户的积分够不够商品兑换用
		 public boolean judgyUserScore(Score_exchange score_exchange);
		  //批量删除收藏夹   dxp9月28日添加
			public boolean deleteBatchOfStore(String bookids,Userinfo userinfo);
		/*----------------周虎区域End-------------------------*/
		

		/*----------------杨星星开始-------------------------*/  
		//查询是否收藏
		public boolean selectStore_record(Userinfo userinfo,Bookinfo bookinfo);
		//收藏夹分页展示
		public List<Store_record> selectBookinfos(Userinfo userinfo,int pag);
		//删除收藏夹书籍
		public boolean deleteBookinfo(Userinfo userinfo,Bookinfo bookinfo);
		//添加收藏夹
		public boolean addBookinfo_StoreRecord(Userinfo userinfo, Bookinfo bookinfo);
		//添加用户
		public boolean addUserinfo(Userinfo userinfo);
		//用户信息修改
		public boolean updateUserinfo(Userinfo userinfo);
		//登录验证
		public boolean loadingUseinfo(Userinfo userinfo);
		//用户共享数据
		public Userinfo selectUserinfo(Userinfo userinfo);
		//注册验证
		public boolean registerUseinfo(Userinfo userinfo);
		//收藏中新添加接口   得到收藏分页显示收藏书籍的总页数   dxp新添加
		public int getStore_RecordTotalpage(Userinfo userinfo,int pagesize); //pagesize为每页显示的数目
		public List<Store_record> seleStore_recordBookinfo(Userinfo userinfo); //查询收藏夹中所有的书籍信息 dxp新添加
	//0928 dxp修改	public List<Bookinfo> seleStore_recordBookinfo(Userinfo userinfo); //查询收藏夹中所有的书籍信息 dxp新添加
			
		
		
		/*----------------杨星星区域End-------------------------*/ 
		/*周虎添加*/
		public int selectbookinfobydiscountpage();
		/*周虎添加*/
		//后台会员管理
		public List<Userinfo> selectuserinfo(Assorter_right assorter_right);
//xby假期添加
		
		//销售的总和
		public double totalmoney(Assorter_right assorter_right);
		
		
		
		public boolean selectuserinfocondition(Userinfo userinfo,Bookinfo bookinfo);
		//===========		
		 //后台查询积分换购商品
		 public List<Score_exchange> selectScore_exchangeassorter_rightlist(Assorter_right assorter_right,int page);
		 //后台查询积分兑换商品的页数

		 public int selectScore_exchangeassorter_rightpages(Assorter_right assorter_right);
		 //更新兑换积分产品积分
		 public void updateScore_exchange(Score_exchange score_exchange);
		 //删除积分的兑换产品
		 public void deleteScore_exchange(Score_exchange score_exchange);
//xby假期
		//更新积分兑换记录的送货时间的
			public void updateExchange_records(Exchange_record exchange_record);
			//后台查询自己商品积分的兑换记录
			public List<Exchange_record> selectExchange_recordsAssorter_right(Assorter_right assorter_right,int page);
			//后台查询积分兑换分页的总页数
			public int selectExchange_recordspages(Assorter_right assorter_right);
//			更新用户积分
			public boolean updateuserscore(Userinfo userinfo, int score);						
			//添加收藏夹
			public boolean addBookinfo(Userinfo userinfo,Bookinfo bookinfo);

			//后台会员管理
			public List<Orders> selectVip(int pag,Assorter_right assorter_right);
			//后台会员页数
			public int selectVippges(Assorter_right assorter_right);
			//删除会员
			public void deleteVip(Userinfo userinfo);


}
