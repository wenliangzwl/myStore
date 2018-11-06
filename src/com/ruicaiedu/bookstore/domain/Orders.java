package com.ruicaiedu.bookstore.domain;

public class Orders implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ordersid;//主键
	private Userinfo userinfo;//用户名
	private Bookinfo bookinfo;//订单商品名字
	private String createtime;//创建时间
	private String state;//订单状态
	private double jiage;//此订单价格
	private String paynumber;//支付号
	private String shipcharge;//支付运费
	private int acount;//数量
	private String phone;//电话
	private String bookame;//所购买书名
	private String author;//作者
	private String isbn;//ISBN
	public String getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}
	public Bookinfo getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getJiage() {
		return jiage;
	}
	public void setJiage(double jiage) {
		this.jiage = jiage;
	}
	public String getPaynumber() {
		return paynumber;
	}
	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}
	public String getShipcharge() {
		return shipcharge;
	}
	public void setShipcharge(String shipcharge) {
		this.shipcharge = shipcharge;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public String getBookame() {
		return bookame;
	}
	public void setBookame(String bookame) {
		this.bookame = bookame;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
}
