package com.ruicaiedu.bookstore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruicaiedu.bookstore.dao.*;
import com.ruicaiedu.bookstore.domain.Assorter_right;
import com.ruicaiedu.bookstore.domain.Bookinfo;
import com.ruicaiedu.bookstore.util.DBhelper;
import com.ruicaiedu.bookstore.util.Document;

public class Bookinfoimpl implements Bookinfodao {
	private Connection connection;
	private PreparedStatement pstm;
	private Bookinfo bookinfo;
	private Assorter_right assorter_right;
	private ResultSet rs;
	private List<Bookinfo> list;

	@Override
	//模糊查询书籍
	//public final static String BOOKINFOIMPL_SELECTBOOKINFOLIKES="select * from bookinfo where bookname like ? limit ?,12;";
	public List<Bookinfo> selectBookinfolikeslist(int pag, Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		list=new ArrayList<Bookinfo>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOLIKES);
			pstm.setString(1, "%"+bookinfo.getBookname()+"%");
			pstm.setInt(2, (pag-1)*12);
			rs=pstm.executeQuery();
			while(rs.next()){
				assorter_right=new Assorter_right();
				bookinfo=new Bookinfo();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				
				assorter_right.setAdminname(rs.getString("adminname"));
				
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	//模糊查询书籍页数
	//public final static String BOOKINFOIMPL_SELECTBOOKINFOLIKESPAG="select count(*) from bookinfo where bookname like ?";
	@Override
	public int selectBookinfolikespag(Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		int pages=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOLIKESPAG);
			pstm.setString(1, "%"+bookinfo.getBookname()+"%");
			rs=pstm.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)%12==0){
					pages=rs.getInt(1)/12;
				}else{
					pages=rs.getInt(1)/12+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	}
	@Override
	//模糊查询书籍是否存在
	public boolean selectbookinfolikes(Bookinfo bookinfo) {
		// TODO Auto-generated method stub
		if(selectBookinfolikespag(bookinfo)!=0){
			return true;
		}
		return false;
	}

	@Override
	//书籍分页查询 
	//public final static String BOOKINFOIMPL_SELECTBOOKINFOLIST="select * from bookinfo where  grade=? limit ?,?"; 
	public List<Bookinfo>  selectBookinfolist(Bookinfo bookinfo, int page, int count) {
		// TODO Auto-generated method stub
		list=new ArrayList<Bookinfo>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOLIST);
			pstm.setInt(1, bookinfo.getGrade());
			pstm.setInt(2, (page-1)*count);
			pstm.setInt(3, count);
			rs=pstm.executeQuery();
			while(rs.next()){
				bookinfo=new Bookinfo();
				assorter_right=new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				
				assorter_right.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list  ;
	}

	@Override
	//分页展示页数
	//	public final static String BOOKINFOIMPL_SELEBOOKINFOS="select count(*) from bookinfo where  grade=?";
	public int seleBookinfospage(Bookinfo bookinfo,int count) {
		int pages=0;
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELEBOOKINFOS);
			pstm.setInt(1, bookinfo.getGrade());
			rs=pstm.executeQuery();
			if(rs.next()){
			if(rs.getInt(1)%count==0){
				pages=rs.getInt(1)/count;
			}else{
				pages=rs.getInt(1)/count+1;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
		// TODO Auto-generated method stub
	}

	@Override
	//后台添加书籍  
	//public final static String BOOKINFOIMPL_ADDBOOKINFOASSORTER_RIGHT="insert into bookinfo(bookid,bookname,bookprice,discountprice,bookimg,bookdetails,discount,state,btype,deadline,major,grade,author,press,presstime,isbn,score,adminname,homeImage,exchange) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//"insert into bookinfo(bookid,bookname,bookprice,discountprice,bookimg,bookdetails,discount,state,btype,deadline,major,grade,author,press,presstime,isbn,score,adminname,homeImage,exchange) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public boolean addBookinfoassorter_right(Bookinfo bookinfo, Assorter_right assorter_right) {
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_ADDBOOKINFOASSORTER_RIGHT);
			pstm.setString(1, bookinfo.getBookid());
			pstm.setString(2, bookinfo.getBookname());
			pstm.setDouble(3, bookinfo.getBookprice());
			pstm.setDouble(4, bookinfo.getDiscountprice());
			pstm.setString(5, bookinfo.getBookimg());
			pstm.setString(6, bookinfo.getBookdetails());
			pstm.setDouble(7, 10*bookinfo.getDiscountprice()/bookinfo.getBookprice());
			pstm.setString(8, "已经审核");
			pstm.setString(9, bookinfo.getBtype());
			pstm.setString(10, bookinfo.getDeadline());
			pstm.setString(11, bookinfo.getMajor());
			pstm.setInt(12, bookinfo.getGrade());
			pstm.setString(13, bookinfo.getAuthor());
			pstm.setString(14, bookinfo.getPress());
			pstm.setString(15, bookinfo.getPresstime());
			pstm.setString(16, bookinfo.getIsbn());
			pstm.setInt(17, bookinfo.getScore());
			pstm.setString(18, assorter_right.getAdminname());//dxp1009凌晨一点
			pstm.setString(19, bookinfo.getHomeImage());
			pstm.setInt(20, 0);
			if(pstm.executeUpdate()>0){
				DBhelper.getConnection().close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				DBhelper.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	//后台查询书籍
	//public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTLIST="select * from bookinfo where adminname=? limit ?,4";
	public List<Bookinfo> selectBookinfoassorter_rightlist(Assorter_right assorter_right,int page){
		// TODO Auto-generated method stub
		list=new ArrayList<Bookinfo>();
		try {
			System.out.println("pageindex底层测试"+page);
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTLIST);
			pstm.setString(1, assorter_right.getAdminname());
			System.out.println("decccccc"+(page-1)*4);
			pstm.setInt(2, ((page-1)*4));
			rs=pstm.executeQuery();
			while(rs.next()){
				bookinfo=new Bookinfo();
				Assorter_right assorter_right2=new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				assorter_right2.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right2);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list  ;
	}
	//后台查询书籍页数    
    //dxp修改 9月24 20:33
    //  注释有误 dxp 修改	//public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTPAG="select count(*) from where adminname=?";
    // 原sql语句   public final static String BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTPAG="select count(*) from   where adminid=?";

     //不想改了……………………………… 
     //sql语句 问题  "select count(*) from   where adminid=?";  并且数据库bookinfo表中无adminid字段
//select count(*) from bookinfo where adminname=?            dxp 修改     0924  23:27    

@Override
	public int selectBookinfoassorter_rightpag(
			Assorter_right assorter_right) {
		int pages=0;
		// TODO Auto-generated method stub
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOASSORTER_RIGHTPAG);
			pstm.setString(1, assorter_right.getAdminname());  //dxp添加 9月24日 20:42 （原版本无）
			rs=pstm.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)%4==0){
					pages=rs.getInt(1)/4;
				}else{
					pages=rs.getInt(1)/4+1;	
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return 0; dxp0924 晚注释掉
		return pages;
	}
	
	
	
	
	@Override
	//查询书籍详情
	//public final static String BOOKINFOIMPL_SELECTBOOKINFODETAILS ="select * from bookinfo where bookid=?";

	public Bookinfo selectBookinfodetails(Bookinfo bookinfo) {
		connection = DBhelper.getConnection();
		try {
			pstm =connection.prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFODETAILS);
			pstm.setString(1, bookinfo.getBookid());
			rs = pstm.executeQuery();
			if(rs.next()){
				assorter_right = new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				assorter_right.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookinfo;
	}
	//默认查询数据
	//public final static String BOOKINFOIMPL_SELEBOOKINFO="select * from bookinfo order by uploadTime limit ?,12";
	@Override
	public List<Bookinfo> seleBookinfo(int page) {
		// TODO Auto-generated method stub
		list=new ArrayList<Bookinfo>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELEBOOKINFO);
			pstm.setInt(1, (page-1)*5);
			rs=pstm.executeQuery();
			while(rs.next()){
				bookinfo=new Bookinfo();
				assorter_right=new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				assorter_right.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list  ;
	}
	
	//综合查询
	//public final static String BOOKINFOIMPL_SELECTCOMBINATIONBOOKINFOS="select * from bookinfo where grade>=? and grade<=? limit ?,? ";
	@Override
	public List<Bookinfo> selectCombinationBookinfos(int page1
			,int page2,int page,int count) {
		// TODO Auto-generated method stub
		 list=new ArrayList<Bookinfo>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTCOMBINATIONBOOKINFOS);
			//System.err.println(pstm);
			pstm.setInt(1, page1);
			pstm.setInt(2, page2);
			pstm.setInt(3, (page-1)*count);
			pstm.setInt(4, count);
			rs=pstm.executeQuery();
			while(rs.next()){
				bookinfo=new Bookinfo();
				assorter_right=new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				assorter_right.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//依据书籍的的折扣排行
//	public final static String BOOKINFOIMPL_SELECTBOOKINFOBYDISCOUNT="select * from bookinfo order by discount limit 0,12";
	@Override
	public List<Bookinfo> selectbookinfobydiscount() {
		// TODO Auto-generated method stub
		list=new ArrayList<Bookinfo>();
		try {
			pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPL_SELECTBOOKINFOBYDISCOUNT);
			rs=pstm.executeQuery();
			while(rs.next()){
				bookinfo=new Bookinfo();
				assorter_right=new Assorter_right();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getDouble("bookprice"));
				bookinfo.setDiscountprice(rs.getDouble("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getDouble("discount"));
				bookinfo.setState(rs.getString("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setDeadline(rs.getString("deadline"));
				bookinfo.setMajor(rs.getString("major"));
				bookinfo.setGrade(rs.getInt("grade"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPress(rs.getString("press"));
				bookinfo.setPresstime(rs.getString("presstime"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setScore(rs.getInt("score"));
				assorter_right.setAdminname(rs.getString("adminname"));
				bookinfo.setAssorter_right(assorter_right);
				bookinfo.setUploadTime(rs.getString("uploadTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setExchange(rs.getInt("exchange"));
				bookinfo.setSell(rs.getInt("sell"));
				bookinfo.setStore(rs.getInt("store"));
				list.add(bookinfo);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list  ;
	}

	//促销商品分页页数
	@Override
	public int selectbookinfobydiscountpage() {
		String sql = "select count(*) from bookinfo";
		int pages = 0;
		try {
			pstm = DBhelper.getConnection().prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)%12==0){
					pages = rs.getInt(1)/12;
				}else{
					pages = rs.getInt(1)/12+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			DBhelper.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	}

	
	
	

	//SELECT * from bookinfo where exchange!=0 limit ?,?
	//积分换购书籍的查询  dxp 新添加	 注：查出 的有书籍的积分 图片 书籍名字等信息
			@Override
public List<Bookinfo> selectCanExchangeBooks(int pageindex, int pagesize) {//pageindex表示当前页，pagesize表示每页显示的数量
		connection=DBhelper.getConnection();
		try {
		 pstm=connection.prepareStatement(Document.BOOKINFOIMPL_SELECTCANEXCHANGEBOOKS);
         pstm.setInt(1, (pageindex-1)*pagesize);
         pstm.setInt(2, pagesize);
         rs=pstm.executeQuery();
         list=new ArrayList<Bookinfo>();
         while(rs.next()){
        	bookinfo=new Bookinfo();
        	assorter_right=new Assorter_right();
        	assorter_right.setAdminname(rs.getString("adminname"));
        	bookinfo.setAssorter_right(assorter_right);
        	bookinfo.setAuthor(rs.getString("author"));
        	bookinfo.setBookdetails(rs.getString("bookdetails"));
        	bookinfo.setBookid(rs.getString("bookid"));
        	bookinfo.setBookimg(rs.getString("bookimg"));
        	bookinfo.setBookname(rs.getString("bookname"));
        	bookinfo.setBookprice(rs.getDouble("bookprice"));
        	bookinfo.setBtype(rs.getString("btype"));
        	bookinfo.setDeadline(rs.getString("deadline"));
        	bookinfo.setDiscount(rs.getDouble("discount"));
        	bookinfo.setDiscountprice(rs.getDouble("discountprice"));
        	bookinfo.setExchange(rs.getInt("exchange"));
        	bookinfo.setGrade(rs.getInt("grade"));
        	bookinfo.setHomeImage(rs.getString("homeImage"));
        	bookinfo.setIsbn(rs.getString("isbn"));
        	bookinfo.setMajor(rs.getString("major"));
        	bookinfo.setPress(rs.getString("press"));
        	bookinfo.setPresstime(rs.getString("presstime"));
        	bookinfo.setScore(rs.getInt("score"));
        	bookinfo.setState(rs.getString("state"));
        	bookinfo.setUploadTime(rs.getString("uploadTime"));
        	list.add(bookinfo);          }			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
					return list;
			}
				
	//查询所有可积分兑换商品  dxp新添加     注： 查出 的有书籍的积分 图片 书籍名字等信息
			@Override
			public List<Bookinfo> selectCanExchangeBooks() {
				connection=DBhelper.getConnection();
				try {
					pstm=connection.prepareStatement(Document.BOOKINFOIMPL_SELECTCANEXCHANGEBOOKS_ALL);
		                rs=pstm.executeQuery();
		         list=new ArrayList<Bookinfo>();
		         while(rs.next()){
		        	 bookinfo=new Bookinfo();
		        	assorter_right=new Assorter_right();
		        	assorter_right.setAdminname(rs.getString("adminname"));
		        	bookinfo.setAssorter_right(assorter_right);
		        	bookinfo.setAuthor(rs.getString("author"));
		        	bookinfo.setBookdetails(rs.getString("bookdetails"));
		        	bookinfo.setBookid(rs.getString("bookid"));
		        	bookinfo.setBookimg(rs.getString("bookimg"));
		        	bookinfo.setBookname(rs.getString("bookname"));
		        	bookinfo.setBookprice(rs.getDouble("bookprice"));
		        	bookinfo.setBtype(rs.getString("btype"));
		        	bookinfo.setDeadline(rs.getString("deadline"));
		        	bookinfo.setDiscount(rs.getDouble("discount"));
		        	bookinfo.setDiscountprice(rs.getDouble("discountprice"));
		        	bookinfo.setExchange(rs.getInt("exchange"));
		        	bookinfo.setGrade(rs.getInt("grade"));
		        	bookinfo.setHomeImage(rs.getString("homeImage"));
		        	bookinfo.setIsbn(rs.getString("isbn"));
		        	bookinfo.setMajor(rs.getString("major"));
		        	bookinfo.setPress(rs.getString("press"));
		        	bookinfo.setPresstime(rs.getString("presstime"));
		        	bookinfo.setScore(rs.getInt("score"));
		        	bookinfo.setState(rs.getString("state"));
		        	bookinfo.setUploadTime(rs.getString("uploadTime"));
		        	list.add(bookinfo); 
		         }	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
							return list;
			}
			
			//后台折扣查询
			//public final static String  SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTLIST="select * from bookinfo where bookinfo.adminname=? order by bookinfo.discount limit ?,4";
			@Override
			public List<Bookinfo> selectbookinfobydiscountAssorter_rightlist(
					Assorter_right assorter_right,int page) {
				list=new ArrayList<Bookinfo>();
				try {
					pstm=DBhelper.getConnection().prepareStatement(Document.SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTLIST);
					pstm.setString(1, assorter_right.getAdminname());
					pstm.setInt(2, (page-1)*4);
					rs=pstm.executeQuery();
					while(rs.next()){
						bookinfo=new Bookinfo();
						Assorter_right assorter_right2=new Assorter_right();
						bookinfo.setBookid(rs.getString("bookid"));
						bookinfo.setBookname(rs.getString("bookname"));
						bookinfo.setBookprice(rs.getDouble("bookprice"));
						bookinfo.setDiscountprice(rs.getDouble("discountprice"));
						bookinfo.setBookimg(rs.getString("bookimg"));
						bookinfo.setBookdetails(rs.getString("bookdetails"));
						bookinfo.setDiscount(rs.getDouble("discount"));
						bookinfo.setState(rs.getString("state"));
						bookinfo.setBtype(rs.getString("btype"));
						bookinfo.setDeadline(rs.getString("deadline"));
						bookinfo.setMajor(rs.getString("major"));
						bookinfo.setGrade(rs.getInt("grade"));
						bookinfo.setAuthor(rs.getString("author"));
						bookinfo.setPress(rs.getString("press"));
						bookinfo.setPresstime(rs.getString("presstime"));
						bookinfo.setIsbn(rs.getString("isbn"));
						bookinfo.setScore(rs.getInt("score"));
						assorter_right2.setAdminname(rs.getString("adminname"));
						bookinfo.setAssorter_right(assorter_right2);
						bookinfo.setUploadTime(rs.getString("uploadTime"));
						bookinfo.setHomeImage(rs.getString("homeImage"));
						bookinfo.setExchange(rs.getInt("exchange"));
						list.add(bookinfo);
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return list  ;
			}
			//后台折扣页数
//			public final static String  SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTPAGES="select count(*) from bookinfo where bookinfo.adminname=?";
			@Override
			public int selectbookinfobydiscountAssorter_rightpages(
					Assorter_right assorter_right) {
					int pages=0;
					// TODO Auto-generated method stub
					try {
						pstm=DBhelper.getConnection().prepareStatement(Document.SELECTBOOKINFOBYDISCOUNTASSORTER_RIGHTPAGES);
						pstm.setString(1, assorter_right.getAdminname());  //dxp添加 9月24日 20:42 （原版本无）
						rs=pstm.executeQuery();
						while(rs.next()){
							if(rs.getInt(1)%4==0){
								pages=rs.getInt(1)/4;
							}else{
								pages=rs.getInt(1)/4+1;	
							}
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return pages;
				}
			
			//更新的书籍总共售卖的数量
			//	public final static String BOOKINFOIMPLUPDATEBOOINFOSELL="update bookinfo set sell=sell+? where bookid=?";
				
			public void updatebooinfosell(Bookinfo bookinfo){
				try {
					System.out.println("更新数量=============");
					pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPLUPDATEBOOINFOSELL);
					pstm.setInt(1, bookinfo.getSell());
					pstm.setString(2, bookinfo.getBookid());
					pstm.execute();
					DBhelper.getConnection().close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			//更新书籍的收藏次数
//		、	public final static String BOOKINFOIMPLUPDATEBOOINFOSTORE="update bookinfo set store=store+1 where bookid=?";
			public void updatebooinfostore(Bookinfo bookinfo){
				try {
					System.err.println("11111111111100000000000000000000000");
					pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPLUPDATEBOOINFOSTORE);
					pstm.setString(1, bookinfo.getBookid());
					pstm.execute();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}finally{
					try {
						DBhelper.getConnection().close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
			//查询书籍	
			//public final static String  BOOKINFOIMPLSELECTBOOKINFBOOKINFOSSELL()

			@Override
			public List<Bookinfo> selectbookinfBookinfossell() {
				list=new ArrayList<Bookinfo>();
				try {
					pstm=DBhelper.getConnection().prepareStatement(Document.BOOKINFOIMPLSELECTBOOKINFBOOKINFOSSELL);
					rs=pstm.executeQuery();
					while(rs.next()){
						bookinfo=new Bookinfo();
						assorter_right=new Assorter_right();
						bookinfo.setBookid(rs.getString("bookid"));
						bookinfo.setBookname(rs.getString("bookname"));
						bookinfo.setBookprice(rs.getDouble("bookprice"));
						bookinfo.setDiscountprice(rs.getDouble("discountprice"));
						bookinfo.setBookimg(rs.getString("bookimg"));
						bookinfo.setBookdetails(rs.getString("bookdetails"));
						bookinfo.setDiscount(rs.getDouble("discount"));
						bookinfo.setState(rs.getString("state"));
						bookinfo.setBtype(rs.getString("btype"));
						bookinfo.setDeadline(rs.getString("deadline"));
						bookinfo.setMajor(rs.getString("major"));
						bookinfo.setGrade(rs.getInt("grade"));
						bookinfo.setAuthor(rs.getString("author"));
						bookinfo.setPress(rs.getString("press"));
						bookinfo.setPresstime(rs.getString("presstime"));
						bookinfo.setIsbn(rs.getString("isbn"));
						bookinfo.setScore(rs.getInt("score"));
						assorter_right.setAdminname(rs.getString("adminname"));
						bookinfo.setAssorter_right(assorter_right);
						bookinfo.setUploadTime(rs.getString("uploadTime"));
						bookinfo.setHomeImage(rs.getString("homeImage"));
						bookinfo.setExchange(rs.getInt("exchange"));
						bookinfo.setSell(rs.getInt("sell"));
						bookinfo.setStore(rs.getInt("store"));
						list.add(bookinfo);
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return list  ;
			}
				
				
				

			
}
