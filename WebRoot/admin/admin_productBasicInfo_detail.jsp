<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>慧慧网综合管理平台</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>/admin/css/style.css">
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.min.js"></script>
<script src="<%=basePath %>admin/js/admincomm.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.min.js"></script>
</head>

<body>

    <div class="user_top">
       <div class="user_c">
         
         <div class="user_top_r">
               <!--一张背景图片-->
         </div>
       </div>
    </div>
    
    <div class="user_nav">
         <div class="user_c">
               <div class="user_nav_l">
               <span style="margin-left: 350px;font-size: 30px;">慧慧网综合管理平台</span>
               </div>
               <div class="user_nav_r">
               
               </div>
         </div>
    </div>
    	<div class="user_top_l">
       欢迎您，${sessionScope.assorter_right.adminname} &nbsp;&nbsp;&nbsp;
      <a href="<%=basePath%>Admin_ExitServlet">退出系统</a>      
         </div>
    	
    <!-------------------------------------头部End-------------------------------------------------------->
    <div class="user_cont">
         <!--left begin -->
         <div class="user_cont_left" style="height: 630px;clear: left;">
               <dl>
                   <dt>供应商商品信息管理</dt>
                   <dd class="active"><a href="<%=basePath %>AdminRedirectPageServlet?pageno=1">商品基本信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=2">商品评论信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=3">促销商品信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=4">商品审核管理</a></dd>
               </dl>
                 <dl>
                   <dt>合同管理</dt>                                                       
               </dl>
               <dl>
                   <dt>商品订单管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=5">商品订单状态查询管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=6">商品销售额查询管理</a></dd>
               </dl>
               <dl>
                   <dt>系统管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=7">系统日志信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=8">短信信息消息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=9">供应商管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=10">密码管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=11">广告管理</a></dd>
               </dl>
               <dl>
                   <dt>积分兑换商品管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=12">积分兑换商品信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=13">积分兑换记录信息管理</a></dd>                 
               </dl>
               <dl style="">
                   <dt>会员管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=14">会员信息管理</a></dd>                                    
               </dl>
         </div>
         <script type="text/javascript">
$(document).ready(function(){
		$(".user_cont_left dl dt").click(function(){
		$(this).siblings().slideToggle("slow");
		$(this).toggleClass("jia"); return false;
	});
	
});
</script>
         <!--left end -->
         <!--right begin -->
         <div class="user_cont_right">
           <div class="user_lmt">
                    <div class="user_lmt1">	当前位置》<a href="">首页</a>》<a href=""> 供应商基本信息管理</a>》商品基本信息管理》商品详情</div>
                    
               </div>
               <div class="user_coment" style="height: 550px">
	 <!--书籍详情-->
	 <!------------------------------------------------------------------------------------------>
	 
	 <!--新建Bug-->
		<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody><tr>
				<td valign="top">
					<!--Bug表单-->
						<input name="ID" value="20160906171647524256" type="hidden">
						
						<table style="font-size: 15px;" align="center" border="0" cellpadding="2" cellspacing="2" width="100%">
							<!--提示信息-->
							<tbody><tr bgcolor="#999999">
								<td colspan="8" style="font-size: 18px; padding-left: 10px" height="50">
									查&nbsp;看&nbsp;商&nbsp;品
								</td>
							</tr>
							<!--Bug信息-->
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品编号
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.bookid }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品名称
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.bookname }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品价格
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.bookprice }
								</td>
							</tr>
<!--							<tr>-->
<!--								<td bgcolor="#e4e4e4" align="center">-->
<!--									商品描述-->
<!--								</td>-->
<!--								<td bgcolor="#e4e4e4">-->
<!--									<p> 
			&nbsp;请在此处描述此书的详细信息 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;AWERTJGFSAawryjukl</p>-->
<!--								</td>-->
<!--							</tr>-->
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品折扣
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.discount }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									审核状态
								</td>
								<td bgcolor="#e4e4e4">
									已审核
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品类型
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.btype }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									期限
								</td>
								<td bgcolor="#e4e4e4">
							无
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									适合学科
									
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.major }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									适合年级
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.grade }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									作者
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.author }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									出版社
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.press }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									出版时间
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.presstime }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									条形码
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.isbn }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									积分抵用数
								</td>
								<td bgcolor="#e4e4e4">
									${bookinfo.score }
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#e4e4e4">
									商品图片
								</td>
								<td bgcolor="#e4e4e4" width="60%" height="25">
									<img src="images/${bookinfo.bookimg }" width="100px" height="100px">
								</td>
							</tr>
								<tr>
								<td colspan="2" bgcolor="#e4e4e4">
					             <p> 
			&nbsp;此书的详细信息 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;AWERTJGFSAawryjukl</p>
								</td>
								
			
							</tr>
							<tr>
								<td colspan="2" align="center" bgcolor="#e4e4e4">
									<input name="tijiao" value=" 返回 " onclick="history.back();" type="button">
								</td>
							</tr>


						</tbody></table>
				</td>
			</tr>

		</tbody></table>

	

	 
	 <!------------------------------------------------------------------------------------------>
               </div>
               

         </div>
         <!--right end -->
    </div>
    
    <div class="footer_m mar38" style="margin-top：20px;margin-bottom: 10px">
           <div class="footer_nav">
             
           </div>
           <div class="footer_copyright">
             <a href="" target="_blank">关于慧慧网</a>&nbsp;|
               &nbsp;<a href="" target="_blank">联系我们</a>&nbsp;|
               &nbsp;<a href="" target="_blank">人才招聘</a>&nbsp;|
               &nbsp;<a href="" target="_blank">广告服务</a>&nbsp;|
               &nbsp;<a href="" target="_blank">友情链接</a>&nbsp;|
               &nbsp;<a href="" target="_blank">销售联盟</a>&nbsp;|
               &nbsp;<a href="" target="_blank">慧慧网简介</a><br><br>
                网络文化经营许可证鄂网文[2015]0278-060号  Copyright © 2015-2018  版权所有
           </div>
     </div>
    


</body>