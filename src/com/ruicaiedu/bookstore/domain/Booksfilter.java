package com.ruicaiedu.bookstore.domain;

import com.ruicaiedu.bookstore.domain.Bookinfo;

public class Booksfilter {
 private Bookinfo bookinfo;
 private int count;
 public Booksfilter(){
	 bookinfo=new Bookinfo();
 }
public Bookinfo getBookinfo() {
	return bookinfo;
}
public void setBookinfo(Bookinfo bookinfo) {
	this.bookinfo = bookinfo;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}
