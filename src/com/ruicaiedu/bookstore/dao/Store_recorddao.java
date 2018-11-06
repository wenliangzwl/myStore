package com.ruicaiedu.bookstore.dao;

import java.util.List;

import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Store_record;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface  Store_recorddao {
	/*----------杨星星开始----------*/
	//查询是否收藏
	public boolean selectStore_record(Userinfo userinfo,Bookinfo bookinfo);
	//收藏夹分页展示
	public List<Store_record> selectBookinfos(Userinfo userinfo,int pag);
	//删除收藏夹书籍
	public boolean deleteBookinfo(Userinfo userinfo,Bookinfo bookinfo);
	//添加收藏夹
	public boolean addBookinfo_StoreRecord(Userinfo userinfo,Bookinfo bookinfo);

	//添加收藏夹  xby
		public boolean addBookinfo(Userinfo userinfo,Bookinfo bookinfo);
	/*----------杨星星结束----------*/
	
	public List<Store_record> seleStore_recordBookinfo(Userinfo userinfo); //查询收藏夹中所有的书籍信息 dxp新添加
}
