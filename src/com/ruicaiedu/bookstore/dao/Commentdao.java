package com.ruicaiedu.bookstore.dao;

import java.util.List;

import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.domain.Comment;
import com.ruicaiedu.bookstore.domain.Userinfo;

public interface Commentdao {
	/*----------丁小平开始----------*/
	//添加评论
	public boolean addComment(Userinfo userinfo,Bookinfo booksinfo,Comment comment);
	//评论分页展示
	public List<Comment> selectComment(Bookinfo booksinfo,int pag);
	//删除评论
	public boolean deleteComment(Userinfo userinfo,Comment comment);

	//分页显示我的评论
		public List<Comment> selectComment(Userinfo userinfo,int pag);
		//显示我的所有评论/用于得到总页数
		public List<Comment> selectComment(Userinfo userinfo);
//后台分页查询评论 
public List<Comment> selectComment(Assorter_right assorter_right,int page);  //可以在业务层实现后台的书籍评论的分页查询*/
//后台 查询全部评论 
 public List<Comment> selectComment(Assorter_right assorter_right);
 //xby 添加
//判断是否存在===========徐炳艳
		public boolean selectuserinfocondition(Userinfo userinfo,Bookinfo bookinfo);
	/*----------丁小平结束----------*/
}
