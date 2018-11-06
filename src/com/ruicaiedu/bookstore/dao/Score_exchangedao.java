package com.ruicaiedu.bookstore.dao;



import java.util.List;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Score_exchange;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface Score_exchangedao {
	/*----------周虎开始----------*/
	//添加商品换购
	 public boolean AddScore_exchange_record(Assorter_right assorter_right,Score_exchange score_exchange);
	 //换购商品所化积分
	 public int selectScore_exchange(Score_exchange score_exchange);
	 
	 //前台查询积分换购商品
	 public List<Score_exchange> selectScore_exchangeinfo(int page);
	 //前台积分商品分页页数
	 public int selectScore_exchangeinfopage();
	 //用户进行商品兑换操作 dxp新添加
	 public boolean AddScore_exchange(Userinfo userinfo,Score_exchange score_exchange);//dxp新添加
	
	 
	 
	 //后台查询积分换购商品
	 public List<Score_exchange> selectScore_exchangeassorter_rightlist(Assorter_right assorter_right,int page);
	 //后台查询积分兑换商品的页数
	 public int selectScore_exchangeassorter_rightpages(Assorter_right assorter_right);

	 //前台更新用户的积分
	 public boolean updateuserscore(Userinfo userinfo,int score);
	 //查询积分商品用作共享
	 public Score_exchange selectScore_exchangedetail(Score_exchange score_exchange);
	
	 
	 //更新兑换积分产品积分
	 public void updateScore_exchange(Score_exchange score_exchange);
	 //删除积分的兑换产品
	 public void deleteScore_exchange(Score_exchange score_exchange);

	 
	 
}
