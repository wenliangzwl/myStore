package com.ruicaiedu.bookstore.util;

public  class Document {
	public final static String USERINFOIMPL_LOADINGUSERINFO ="select nickname,pwd from userinfo  where nickname= ? and pwd =?";
	public final static String USERINFOIMPL_ADDGUSERINFO = "insert into userinfo(nickname,pwd,email) values(?,?,?)";
	public final static String USERINFOIMPL_UPDATEUSERINFO = "update userinfo set nickname = ?,phone = ?,qq = ? ,username = ?,address= ?,city= ?,qu= ?,classname = ?,grade= ?,familyphone= ?,postcode= ?,province= ?,utype =?,school=?,picture=?,email=?,hobby=?,introduce=?,birthday=?,gender=? where userid= ?";
	public final static String USERINFOIMPL_SELECTUSERINFO = "select * from userinfo where nickname= ? and pwd =?";
	
	public final static String  BOOKINFOIMPLSELECTBOOKINFBOOKINFOSSELL="select * from bookinfo order by sell desc limit 0,7";
	
	
	
	
	//查询积分换购商品的页数
	public final static String SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEINFOPAGE="select count(*)  from score_exchange";	

	
	
	
	//查询用作登录验证
	public final static String ASSORTER_RIGHTIMPL_SELECTASSORTER_RIGHT ="select adminname,adminpwd from assorter_right  where adminname= ? and adminpwd =?";
	//查询用作共享
	public final static String ASSORTER_RIGHTIMPL_SELECTASSORTER_RIGHT_A ="select * from assorter_right  where adminname= ? and adminpwd =?";
	//用作注册验证
	public final static String USERINFOIMPLREGISTERUSEINFO="select * from userinfo where nickname=?";
	//添加商品换购
		public final static String SCORE_EXCHANGEIMPL_ADDSCORE_EXCHANGE_RECORD ="insert into score_exchange(score,name,exchangename,description,exchangetype,exchangeimg) values(?,?,?,?,?,?)";
	//换购商品所化积分
		//查询积分换购所有商品
		public final static String SCORE_EXCHANGEIMPL_SELECTSCORE_EXCHANGEINFO="select *  from score_exchange  limit ?,4";
		//换购商品所化积分
		public final static String SCORE_EXCHANGEIMPL_SELECTSCORE_EXCHANGE="select score from score_exchange where exchangeid=?";
		//查询是否收藏 yxx
		public final static String STORE_RECORDIMPL_SELECTSTORE_RECORD="select * from store_record where userid=? and bookid=?";

		////添加收藏夹
		public final static String STORE_RECORDIMPL_ADDBOOKINFO="insert into store_record(bookid,userid) values(?,?)";
		
		//书籍详情
	public final static String BOOKINFOIMPL_SELECTBOOKINFODETAILS ="select * from bookinfo where bookid=?";
	//模糊查询书籍
	//徐炳艳0927修改
	public final static String BOOKINFOIMPL_SELECTBOOKINFOLIKES="select * from bookinfo where bookname like ? limit ?,12;";
	//模糊查询书籍页数
	//徐炳艳0927修改
	public final static String BOOKINFOIMPL_SELECTBOOKINFOLIKESPAG="select count(*) from bookinfo where bookname like ?";
	//查询书籍分页查询
	public final static String BOOKINFOIMPL_SELECTBOOKINFOLIST="select * from bookinfo where  grade=? limit ?,?";
	//查询书籍分页页数
	public final static String BOOKINFOIMPL_SELEBOOKINFOS="select count(*) from bookinfo where  grade=?";
	//综合查询
	public final static String BOOKINFOIMPL_SELECTCOMBINATIONBOOKINFOS="select * from bookinfo where grade>=? and grade<=? limit ?,? ";
	//前台默认查询书籍
	public final static String BOOKINFOIMPL_SELEBOOKINFO="select * from bookinfo order by uploadTime desc limit ?,12";
	

	//后台查询书籍  //dxp 0924 晚修改	
	public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTLIST="select * from bookinfo where adminname=? limit ?,4";
	
	//后台查询书籍页数 //dxp 0924 晚修改
	 //原sql语句  public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTPAG="select count(*) from where adminid=?";
	 public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTPAG="select count(*) from bookinfo where adminname=?";//dxp 0924 晚添加

	 
	 
	 
	 
	//后台添加书籍  
	public final static String BOOKINFOIMPL_ADDBOOKINFOASSORTER_RIGHT="insert into bookinfo(bookid,bookname,bookprice,discountprice,bookimg,bookdetails,discount,state,btype,deadline,major,grade,author,press,presstime,isbn,score,adminname,homeImage,exchange) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	//前台依据书籍的的折扣排行
	public final static String BOOKINFOIMPL_SELECTBOOKINFOBYDISCOUNT="select * from bookinfo order by discount limit 0,12";
	//后台折扣查询
	public final static String  SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTLIST="select * from bookinfo where bookinfo.adminname=? order by bookinfo.discount limit ?,4";
	//后台折扣排行页数
	public final static String  SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTPAGES="select count(*) from bookinfo where bookinfo.adminname=?";
	//添加评论
	public final static String COMMENTIMPLADDCOMMENT="insert into comment(userid,bookid,content,bookname) VALUES(?,?,?,?)";
	//查询评论
	public final static String COMMENTIMPLSELECTCOMMENT="select * from comment where bookid=? limit ?,8";
	//删除评论
	public final static String COMMENTIMPL_DELETECOMMENT="delete from comment where userid=? and commentid=?;";
//分页显示我的评论   dxp新添加 9月26日
	//public final static String COMMENTIMPL_SELECTCOMMENT_SHOWBYPAGES="select * from comment WHERE userid=? ORDER BY commenttime desc LIMIT ?,5";
	public final static String COMMENTIMPL_SELECTCOMMENT_SHOWBYPAGES="select * from comment c,userinfo u  WHERE c.userid=u.userid and c.userid=? ORDER BY commenttime desc LIMIT ?,5";
//显示我的所有评论  9月26日	
	public final static String COMMENTIMPL_SELECTCOMMENT_SHOWALL="select * from comment c,userinfo u  WHERE c.userid=u.userid and c.userid=? ORDER BY commenttime desc";	

//后台分页显示评论  dxp新添加 9月26日
//public final static String COMMENTIMPL_SELECTCOMMENT_ASSORTER_RIGHT_BYPAGE="SELECT  c.* from `comment` c,(SELECT bookid from assorter_right a,bookinfo b WHERE b.adminname=a.adminname and a.adminname=?)d where d.bookid=c.bookid limit ?,5";
public final static String COMMENTIMPL_SELECTCOMMENT_ASSORTER_RIGHT_BYPAGE="select u.username,c.* from userinfo u,comment c where u.userid=c.userid and u.userid in(select userid from comment where bookid in(select bookid from bookinfo where adminname=?)) limit ?,5";
//后台显示全部评论 dxp新添加 9月26日
public final static String COMMENTIMPL_SELECTCOMMENT_ASSORTER_RIGHT_ALL="SELECT  c.* from `comment` c,(SELECT bookid from assorter_right a,bookinfo b WHERE b.adminname=a.adminname and a.adminname=?)d where d.bookid=c.bookid";
//进行积分兑换操作	 dxp新添加 9月26日
public final static String SCORE_EXCHANGEIMPL_ADDSCORE_EXCHANGE="insert into score_exchange(score,name,exchangename,description,exchangetype)values(?,?,?,?,?)";
//积分换购书籍的分页查询       dxp 新添加9月26日
//徐炳艳修改
public final static String BOOKINFOIMPL_SELECTCANEXCHANGEBOOKS="SELECT * from bookinfo where exchange!=0 limit ?,?";
//积分换购书籍的查询所有       dxp 新添加 9月26日修改
public final static String BOOKINFOIMPL_SELECTCANEXCHANGEBOOKS_ALL="SELECT * from bookinfo where exchange!=0 ";
////显示用户兑换商品的所有记录  dxp新添加  9月26日
public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS_ALL="SELECT * from  exchange_record where userid=?";
///查询收藏夹中所有的书籍信息 dxp新添加
public final static String STORE_RECORDIMPL_SELESTORE_RECORDBOOKINFO="SELECT s.*,b.* from store_record s,bookinfo b WHERE s.bookid=b.bookid and s.bookid in (SELECT bookid from store_record s,userinfo u WHERE u.userid=s.userid and s.userid=?)";


    //删除积分消费记录
	public final static String EXCHANGE_RECORDIMPL_DELETEEXCHANGE_RECORD="delete from exchange_record where userid=? and recordid=?";

	//查询积分总页数
	public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORD="select count(*) from exchange_record where userid=?";
	//前台用户查询订单
	public final static String ORDERSIMPL_SELECTORDERSUSERINFO="select orders.*,bookinfo.bookimg from bookinfo,orders where orders.bookid=bookinfo.bookid and userid=? limit ?,2";  //dxp 0928 改为2
	//前台分也查询订单页数
		public final static String ORDERSIMPL_SELECTORDERSUSERINFOPAGES="select count(*)  from orders where userid=?";
	//-------------------------------------

		//后台用户查询订单  xby修改0926晚 
		public final static String ORDERSIMPL_SELECTORDERSASSORTER_RIGHT="select orders.*,userinfo.address,bookinfo.discountprice,userinfo.phone,userinfo.email from userinfo,orders,bookinfo where orders.bookid=bookinfo.bookid and bookinfo.adminname=? and userinfo.userid=orders.userid limit ?,4";		//前台用户添加订单
		//dxp 0927修改1009修改
		public final static String ORDERSIMPL_ADDORDERSUSERINFO="insert into orders(ordersid,userid,bookid,jiage,acount,phone,username,bookname,author,isbn) values(?,?,?,?,?,?,?,?,?,?);";
		//后台修改订单
		public final static String ORDERSIMPL_UPDATEORDERS="update orders set state=? where ordersid=?;";	
		//删除订单(前后台 )dxp 0927修改
		public final static String ORDERSIMPL_DELETEORDERS="delete from   orders where ordersid=?";
		//后台页数
		public final static String ORDERSIMPL_SELECTORDERSASSORTER_RIGHTPAGES="select count(*)  from orders  where bookid in (select bookid from bookinfo where adminname=?)";
	//-----------------------------


//===========================================0928原sql=========================================
		//-928--//	//添加积分记录
		//-928--//		public final static String EXCHANGE_RECORDIMPL_ADDEXCHANGE_RECORD="insert into exchange_record(userid,score,exchangename,state,address,sendtime) values(?,?,?,?,?,?)";
		//-928--//	//分页查询积分消费记录
		//-928--//	public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS="select * from exchange_record where userid=? limit ?,4";
		//-928--//		//收藏夹分页展示yxx
				//-928--//		public final static String STORE_RECORDIMPL_SELECTBOOKINFOS="select * from store_record where userid=? limt=?,3";
				//-928--//		//删除收藏夹书籍
				//-928--//			public final static String STORE_RECORDIMPL_DELETEBOOKINFOS="delete from store_record where userid=? bookid=?";
		//============================================================================
		
	//  dxp0928添加  根据换购商品的积分，减去用户积分  （修改用户积分）《买商品时，增加积分，也需调用该方法》 
		public final static String SCORE_EXCHANGEIMPL_UPDATEUSERSCORE="update userinfo u set u.score=(u.score-?) WHERE u.username=?";
//			//dxp0928添加  判断用户的积分够不够商品兑换用
		public final static String SCORE_EXCHANGEIMPL_JUDGYUSERSCORE="SELECT userid from userinfo u WHERE u.score>=? and u.username=?";
		
		//dxp 9月28修改
				//public final static String STORE_RECORDIMPL_SELECTBOOKINFOS="select * from store_record where userid=? limit ?,3";
				public final static String STORE_RECORDIMPL_SELECTBOOKINFOS="SELECT s.*,b.* from store_record s,bookinfo b WHERE s.bookid=b.bookid and s.bookid in (SELECT s.bookid from store_record s,userinfo u WHERE u.userid=s.userid and s.userid=?) limit ?,3;";
				//删除收藏夹书籍
				//dxp略微修改 0928
				public final static String STORE_RECORDIMPL_DELETEBOOKINFOS="delete from store_record where userid=? and bookid=?";
				//添加积分记录
				//添加积分记录
				public final static String EXCHANGE_RECORDIMPL_ADDEXCHANGE_RECORD="insert into exchange_record(userid,score,exchangename,address,sendtime,exchangeimg) values(?,?,?,?,?,?)";
				//分页查询积分消费记录
				//public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS="select * from exchange_record where userid=? limit ?,4";
		//dxp 0928修改
			//	public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS="select e.*,b.* from exchange_record e,bookinfo b WHERE e.bookid=b.bookid and e.userid=?  limit ?,4";
		//分页查询积分消费记录  xby1009玩
				public final static String EXCHANGE_RECORDIMPL_SELECTEXCHANGE_RECORDS="select * from exchange_record where userid=? limit ?,4";

		//================================================================
		


//xby假期添加

				//书籍更新售卖
				public final static String BOOKINFOIMPLUPDATEBOOINFOSELL="update bookinfo set sell=sell+? where bookid=?";
				//新书籍收鞥新藏
				public final static String BOOKINFOIMPLUPDATEBOOINFOSTORE="update bookinfo set store=store+1 where bookid=?";
				//添加评论之前判断是否已经下过订单
				public final static String  COMMENTIMPLSELECTUSERINFOCONDITION="select  orders.* from orders where userid=? and bookid=?";

				//销售总和
				public final static String  ORDERSIMPLTOTALMONEY="select sum(jiage) from orders  where bookid in(select bookid from bookinfo where adminname=?)";

				//后台查询积分兑换商品
				public final static String  SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHT="select score_exchange.* from score_exchange where name=?  limit ?,4";
				//后台查询兑换商品页数
				public final static String  SCORE_EXCHANGEIMPLSELECTSCORE_EXCHANGEASSORTER_RIGHTPAGES="select count(*)  from  score_exchange where name=?";
				//更新产品的积分
				public final static String  SCORE_EXCHANGEIMPLUPDATESCORE_EXCHANGE="update score_exchange set score=? where exchangeid=?";

				//删除积分兑换的产品
				public final static String  SCORE_EXCHANGEIMPLDELETESCORE_EXCHANGE="delete from score_exchange where exchangeid=?";
//xby假期end-----------
				//更新积分兑换记录的送货时间
				public final static String  EXCHANGE_RECORDIMPLUPDATEEXCHANGE_RECORDS="update exchange_record set sendtime=? where recordid=? ";
				//后台查寻商品兑换的记录
				public final static String EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSASSORTER_RIGHT="select exchange_record.*,userinfo.username from userinfo ,exchange_record where exchangename in(select exchangename from score_exchange where name=?) and userinfo.userid=exchange_record.userid  limit ?,4";
				//后台查询积分兑换记录的页数
				public final static String EXCHANGE_RECORDIMPLSELECTEXCHANGE_RECORDSPAGES="select count(*) from exchange_record where exchangename in(select exchangename from score_exchange where name=?)";
				//更新用户的积分
				//dxp1009晚22点修改
				//public final static String SCORE_EXCHANGEDAOUPDATEUSERSCORE="update userinfo set score=score+?  where userid=? ";
				public final static String SCORE_EXCHANGEDAOUPDATEUSERSCORE="update userinfo set score=?  where userid=? ";
				//查询不积分商品用作共享
				public final static String SCORE_EXCHANGEDAOSELECTSCORE_EXCHANGEDETAIL="select * from Score_exchange where exchangeid=?";
				
				//后台会员分页
				public final static String  ORDERSIMPLSELECTVIP="select orders.*,userinfo.address,bookinfo.discountprice,userinfo.phone,userinfo.email from userinfo,orders,bookinfo where orders.bookid=bookinfo.bookid and bookinfo.adminname=? and userinfo.userid=orders.userid group by orders.userid limit ?,4";
				//后台会员页数
				public final static String  ORDERSIMPLSELECTVIPPGES="select count(*) from (select orders.userid from orders where bookid in(select bookid from bookinfo where adminname=?) group by userid) b";
				//删除会员
				public final static String  ORDERSIMPLDELETEVIP="delete from orders where userid=?";


}

