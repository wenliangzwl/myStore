package com.ruicaiedu.bookstore.domain;

public class Store_record implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int storeid; //收藏主键
	private Bookinfo bookinfo;//收藏的书ID
	private String bookid;
	private String storetime;//收藏时间
	private Userinfo userinfo;//哪个用户收藏的
	public int getStoreid() {
		return storeid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	
	
	public Bookinfo getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}
	public String getStoretime() {
		return storetime;
	}
	public void setStoretime(String storetime) {
		this.storetime = storetime;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
