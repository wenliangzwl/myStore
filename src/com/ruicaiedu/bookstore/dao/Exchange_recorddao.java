package com.ruicaiedu.bookstore.dao;

import java.util.List;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Exchange_record;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface Exchange_recorddao {
	/*----------周虎开始----------*/
	//用户查询自己的积分
	public int selectExchange_record(Userinfo userinfo);
	//删除积分消费记录
	public boolean deleteExchange_record(Userinfo userinfo,Exchange_record exchange_record);
	//添加积分消费记录
	public boolean addExchange_record(Userinfo userinfo,Exchange_record exchange_record);
	//分页展示积分消费记录
	public List<Exchange_record> selectExchange_records(Userinfo userinfo,int pag);
	//显示用户兑换商品的所有记录  dxp新添加
	public List<Exchange_record> selectExchange_records(Userinfo userinfo);

	
	
	//更新积分兑换记录的送货时间的
	public void updateExchange_records(Exchange_record exchange_record);	
	//后台查询自己商品积分的兑换记录
	public List<Exchange_record> selectExchange_recordsAssorter_right(Assorter_right assorter_right,int page);
	//后台查询积分兑换分页的总页数
	public int selectExchange_recordspages(Assorter_right assorter_right);
	
	
	/*----------周虎结束----------*/
} 