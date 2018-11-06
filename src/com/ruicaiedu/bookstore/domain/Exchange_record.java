package com.ruicaiedu.bookstore.domain;

public class Exchange_record implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Bookinfo bookinfo; //dxp0928添加
	private int recordid;//主键
	private Userinfo userinfo;//用户名(买家用户主键)
	private  int score;//兑换所花积分
	private String exchangename;//兑换商品名字
	private String exchangetime;//兑换时间
	private String state;//商品兑换状态，能不能兑换
	private String address;//送货地址
	private String sendtime;//送货时间
	private String exchangeimg;
	public int getRecordid() {
		return recordid;
	}
	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}
	
	
	public Userinfo   getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getExchangename() {
		return exchangename;
	}
	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}
	public String getExchangetime() {
		return exchangetime;
	}
	public void setExchangetime(String exchangetime) {
		this.exchangetime = exchangetime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public Bookinfo getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}
	public String getExchangeimg() {
		return exchangeimg;
	}
	public void setExchangeimg(String exchangeimg) {
		this.exchangeimg = exchangeimg;
	}
	
	


}
