package com.ruicaiedu.bookstore.factory;
import com.ruicaiedu.bookstore.dao.Assorter_rightdao;
import com.ruicaiedu.bookstore.dao.Bookinfodao;
import com.ruicaiedu.bookstore.dao.Commentdao;
import com.ruicaiedu.bookstore.dao.Exchange_recorddao;
import com.ruicaiedu.bookstore.dao.Ordersdao;
import com.ruicaiedu.bookstore.dao.Score_exchangedao;
import com.ruicaiedu.bookstore.dao.Store_recorddao;
import com.ruicaiedu.bookstore.dao.Userinfodao;
import com.ruicaiedu.bookstore.daoImpl.Assorter_rightimpl;
import com.ruicaiedu.bookstore.daoImpl.Bookinfoimpl;
import com.ruicaiedu.bookstore.daoImpl.Commentimpl;
import com.ruicaiedu.bookstore.daoImpl.Exchange_recordimpl;
import com.ruicaiedu.bookstore.daoImpl.Ordersimpl;
import com.ruicaiedu.bookstore.daoImpl.Score_exchangeimpl;
import com.ruicaiedu.bookstore.daoImpl.Store_recordimpl;
import com.ruicaiedu.bookstore.daoImpl.Userinfoimpl;


public class Boookstorfactory {
	private Assorter_rightdao assorter_rightdao;
	private Bookinfodao bookinfodao;
	private Commentdao commentdao;
	private Exchange_recorddao exchange_recorddao;
	private  Ordersdao ordersdao;
	private Score_exchangedao score_exchangedao;
	private Store_recorddao store_recorddao;
	private Userinfodao userinfodao;
	//获得进后台用户实现类
	public Assorter_rightdao getAssorter_rightdao() {
		if(assorter_rightdao==null){
		assorter_rightdao=new Assorter_rightimpl();
		}
		return assorter_rightdao;
	}
	//获得书籍实现类
	public Bookinfodao getBookinfodao(){
		if(bookinfodao==null){
			bookinfodao=new Bookinfoimpl();
			}
			return bookinfodao;
	}
	//获得评论实现类
	public Commentdao getCommentdao(){
		if(commentdao==null){
			commentdao=new Commentimpl();
			}
			return commentdao;
	}
	//获得积分兑换实现类
	public Exchange_recorddao getExchange_recorddao(){
		if(exchange_recorddao==null){
			exchange_recorddao=new Exchange_recordimpl();
			}
			return exchange_recorddao;
	}
	//获得订单实现类
	public Ordersdao getOrdersdao(){
		if(ordersdao==null){
			ordersdao=new Ordersimpl();
			}
			return ordersdao;
	}
	//获得用户积分类
	public Score_exchangedao getScore_exchangedao(){
		if(score_exchangedao==null){
			score_exchangedao=new Score_exchangeimpl();
			}
			return score_exchangedao;
	}
	//获得收藏实现类
	public Store_recorddao getStore_recorddao(){
		if(store_recorddao==null){
			store_recorddao=new Store_recordimpl();
			}
			return store_recorddao;
	}
	//获得用户实现类
	public Userinfodao getUserinfodao(){
		if(userinfodao==null){
			userinfodao=new Userinfoimpl();
			}
			return userinfodao;
	}
}
