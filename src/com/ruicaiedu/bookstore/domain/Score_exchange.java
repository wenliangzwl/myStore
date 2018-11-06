package com.ruicaiedu.bookstore.domain;

public class Score_exchange implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Assorter_right assorter_right;
	private int exchangeid;//主键
	private int score;//换购些商品需要的积分
	private Userinfo userinfo;//换商品的用户名字
	private String exchangename;//商品名
	private String description;//商品描述
	private String exchangetype;//商品类型
	private  String exchangeimg;//商品的图片	//xby假期
	public int getExchangeid() {
		return exchangeid;
	}
	public void setExchangeid(int exchangeid) {
		this.exchangeid = exchangeid;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public String getExchangename() {
		return exchangename;
	}
	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExchangetype() {
		return exchangetype;
	}
	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getExchangeimg() {
		return exchangeimg;
	}
	public void setExchangeimg(String exchangeimg) {
		this.exchangeimg = exchangeimg;
	}
	public Assorter_right getAssorter_right() {
		return assorter_right;
	}
	public void setAssorter_right(Assorter_right assorter_right) {
		this.assorter_right = assorter_right;
	}
	
}
