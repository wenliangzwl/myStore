package com.ruicaiedu.bookstore.domain;

public class Log implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int logid;//日志主键
	private String logtype;//日志类型
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	public String getLogtype() {
		return logtype;
	}
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}
	public String getLogdetails() {
		return logdetails;
	}
	public void setLogdetails(String logdetails) {
		this.logdetails = logdetails;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}
	private String logdetails;// 详细内容
	private int userid;//是对哪个用户的评论
	private String recordtime;//记录时间
}
