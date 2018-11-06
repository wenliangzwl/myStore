package com.ruicaiedu.bookstore.util;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tool {
	private static SimpleDateFormat format=null;
	
	public static String transDate(Date date){		
	     format=new SimpleDateFormat();		
		return format.format(date);	
	}

	public static String getRandomId(){
		char[] c={'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m',};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String strDate = sdf.format(new Date());
		return String.valueOf(c[new Random().nextInt(26)])+strDate + (Math.round(Math.random()*899999)+ 10000000);
	}
	
		public static String getBookGradeInfor(int opt){
			String res="";
			if(opt>0&&opt<33){
				switch(opt){
				case 1:	res=  "一年级";
				break;
				case 2:res=  "二年级";
				break;
				case 3:res=  "三年级";
				break;
				case 4:res=  "四年级";
				break;
				case 5:res=  "五年级";
				break;
				case 6:res=  "六年级";
				break;
				case 7:res= "教材";
				break;
				case 8:res= "外语考试";
				break;
				case 9:res= "中小学教辅";
				break;
				case 10:res= "汉语工具书";
				break;
				case 11:res= "英语工具书";
				break;
				case 12:res= "其它语种工具";
				break;
				case 13:res= "百科全书";
				break;
				case 14:res= "文学鉴赏";
				break;
				case 15:res= "辞典";
				break;
				case 16:res= "牛津系列";
				break;
				case 17:res= "朗文系列种工具";
				break;
				case 18:res= "民族语工具书";
				break;
				case 19:res= "英文原版书";
				break;
				case 20:res= "小学";
				break;
				case 21:res= "初中";
				break;
				case 22:res= "高中";
				break;
				case 23:res= "教育";
				break;
				case 24:res= "工具书";
				break;
				case 25:res= "期刊";
				break;
				case 26:res= "期刊";
				break;
				case 27:res= "初中一年级";
				break;
				case 28:res= "初中二年级";
				break;
				case 29:res= "初中三年级";
				break;
				case 30:res= "高中一年级";
				break;
				case 31:res= "高中二年级";
				break;
				case 32:res= "高中三年级";
				break;
				default :
					break;
				}}else{
					res= "不限";
				}
				return res;
				
				
			}
			
		}
		
		
	

