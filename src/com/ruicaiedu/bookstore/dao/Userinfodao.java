package com.ruicaiedu.bookstore.dao;

import java.util.List;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface Userinfodao {
	/*----------杨星星开始----------*/
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
	/*----------杨星星结束---------*/
	public List<Userinfo> selectUserinfo(Assorter_right assorter_right);
}
