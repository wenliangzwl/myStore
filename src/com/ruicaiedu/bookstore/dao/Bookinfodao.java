package com.ruicaiedu.bookstore.dao;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;

public interface Bookinfodao {
	/*----------徐炳艳开始----------*/
	//书籍默认显示（按时间倒序显示,查询所有）(可以根据实际情况，控制每页显示的条数)
	public List<Bookinfo>  seleBookinfo(int count);
	//查询书籍详情
	public Bookinfo selectBookinfodetails(Bookinfo bookinfo);
	//模糊查询书籍
	public List<Bookinfo> selectBookinfolikeslist(int pag,Bookinfo bookinfo);
	//模糊查询书籍页数
	public int selectBookinfolikespag(Bookinfo bookinfo);
	//模糊查询书籍是否存在
	public boolean selectbookinfolikes(Bookinfo bookinfo);
	//xby添加 假期-------------
	//更新书籍的收藏次数
	public void updatebooinfostore(Bookinfo bookinfo);
	//更新售卖的数量
	public void updatebooinfosell(Bookinfo bookinfo);
	
	//书籍分页查询 
	public List<Bookinfo> selectBookinfolist(Bookinfo bookinfo,int page,int count);
	//分页展示页数
	public int seleBookinfospage(Bookinfo bookinfo,int count);
	
	
	//后台添加书籍  
	public boolean addBookinfoassorter_right(Bookinfo bookinfo,Assorter_right assorter_right);
	//后台查询书籍
	public List<Bookinfo> selectBookinfoassorter_rightlist(Assorter_right assorter_right,int pag);
	//后台查询书籍页数
	public int selectBookinfoassorter_rightpag(Assorter_right assorter_right);
	//书籍综初中高宗查询查询  
	public List<Bookinfo> selectCombinationBookinfos(int pagesize1,int pagesize2,int page,int count);
	//依据折扣价依次排行
	public List<Bookinfo> selectbookinfobydiscount();
	
	//后台折扣分页
	public List<Bookinfo> selectbookinfobydiscountAssorter_rightlist(Assorter_right assorter_right,int page);
	//后台折扣分页页数
	public int selectbookinfobydiscountAssorter_rightpages(Assorter_right assorter_right);
	/*----------徐炳艳结束----------*/

	/*---------------周虎添加-----------*/
	//前台折扣商品分页页数
	public int selectbookinfobydiscountpage();
	 //积分换购书籍的查询  dxp 新添加	 查出 的有书籍的积分 图片 书籍名字等信息
   public List<Bookinfo> selectCanExchangeBooks(int pageindex,int pagesize);//分页查询可积分兑换商品 //pageindex表示当前页，pagesize表示每页显示的数量    dxp新添加
   public List<Bookinfo> selectCanExchangeBooks();//查询所有可积分兑换商品 dxp新添加
	//查询书籍	
	//public final static String  BOOKINFOIMPLSELECTBOOKINFBOOKINFOSSELL()
  public List<Bookinfo> selectbookinfBookinfossell();

}
