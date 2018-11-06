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
<link type="text/css" rel="stylesheet" href="<%=basePath %>admin/css/style.css">
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.min.js"></script>
<script src="<%=basePath %>admin/js/admincomm.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/admin_productPromotionInfo.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/adminInnerComm.css"/>
<script src="<%=basePath %>admin/js/product.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath %>admin/js/admininnerComm.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
function showDiv(){
document.getElementById('popDiv').style.display='block';
document.getElementById('bg').style.display='block';
}

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
}

</script>		
		
		
		
		
		<script type="text/javascript" language="javascript">
function checkExcel(){
	var filename = document.excelImportForm.file.value;
	if(filename.indexOf('.xls')>0){
		return true;
	}
	alert("请选择正确的文件格式");
	return false;
}



</script>
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
                   <dd class="active"><a href="AdminRedirectPageServlet?pageno=1">商品基本信息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=2">商品评论信息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=3">促销商品信息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=4">商品审核管理</a></dd>
               </dl>
                 <dl>
                   <dt>合同管理</dt>                                                       
               </dl>
               <dl>
                   <dt>商品订单管理</dt>
                   <dd><a href="AdminRedirectPageServlet?pageno=5">商品订单状态查询管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=6">商品销售额查询管理</a></dd>
               </dl>
               <dl>
                   <dt>系统管理</dt>
                   <dd><a href="AdminRedirectPageServlet?pageno=7">系统日志信息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=8">短信信息消息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=9">供应商管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=10">密码管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=11">广告管理</a></dd>
               </dl>
               <dl>
                   <dt>积分兑换商品管理</dt>
                   <dd><a href="AdminRedirectPageServlet?pageno=12">积分兑换商品信息管理</a></dd>
                   <dd><a href="AdminRedirectPageServlet?pageno=13">积分兑换记录信息管理</a></dd>                 
               </dl>
               <dl style="">
                   <dt>会员管理</dt>
                   <dd><a href="AdminRedirectPageServlet?pageno=14">会员信息管理</a></dd>                                    
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
                    <div class="user_lmt1">当前位置》<a href="">首页</a>》促销商品信息管理</div>
                    
               </div>
               <div class="user_coment" style="height: 550px">
<!--促销商品信息-->
<!------------------------------------------------------------------------------->

	<!--工作区-->
		<!--新建Bug成功的提示信息-->
			

		<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">

			<tbody><tr>
				<td valign="top" height="25">
					<!--项目列表 查询提交表单-->
					<form name="form1" action=" " method="post">
						<table align="center" cellpadding="0" cellspacing="2" width="100%" id="productpromotionQuery">
							<!--提示信息-->
							<tbody><tr bgcolor="#1196EE">
								<td colspan="8" style="font-size: 18px; font-weight: bold; padding-left: 10px" height="30">
									商品基本信息查询
								</td>
							</tr>
							<tr style="font-size: 10px" bgcolor="#E4E4E4">
								

								<td align="center">
									商品名称
								</td>
								<td style="width: 80px; ">
									<div style="margin-left: 15px;">
										<input name="bookname" value="">
									</div>
									
								</td>
								
								<td align="center" ">
									<div style="margin-left: -200px;">
									商品价格
								</div>
									
								</td>
								<td>
									<div style="margin-left: -80px;">
										<input name="bookprice" value="">
									</div>
									
								</td>
								<td align="center">
								<div style="margin-left: 0px;">
									适合学科
								</div>	
								</td>
								<td>
									<select name="shihezhuanye">
									<option value="">
									--请选择--
									</option>
										
										<option value="语文">
											语文
										</option>
										
										<option value="数学">
											数学
										</option>
										
										<option value="英语">
											英语
										</option>
										
										<option value="历史">
											历史
										</option>
										
										<option value="其他">
											其他
										</option>
										
										<option value="自然">
											自然
										</option>
										
										<option value="思想品德">
											思想品德
										</option>
										
										<option value="美术">
											美术
										</option>
										
										<option value="地理">
											地理
										</option>
										
										<option value="音乐">
											音乐
										</option>
										
									</select>
								</td>
								<td align="center">
								<div style="margin-left: -16px;">
									适合年级
								</div>		
								</td>
								<td>
									<select name="grade">
									   <option value="">
											--请选择--
										</option>
										<option value="1">
											一年级
										</option>
										<option value="2">
											二年级
										</option>
										<option value="3">
											三年级
										</option>
										<option value="4">
											四年级
										</option>
										<option value="5"> 
											五年级
										</option>
										<option value="6">
											六年级
										</option>
										<option value="7">
											初一
										</option>
										<option value="8">
											初二
										</option>
										<option value="9">
											初三
										</option>
										<option value="10">
											高一
										</option>
										<option value="11">
											高二
										</option>
										<option value="12">
											高三
										</option>
										<option value="13">
											小学
										</option>
										<option value="14">
											初中
										</option>
										<option value="15">
											高中
										</option>
										<option value="16">
											不限
										</option>      
                                     </select>
								</td>							
							</tr>
							<tr style="font-size: 13px" bgcolor="#E4E4E4" >
								
								<td align="center">
									<div style="margin-right:15px ;">
									作者
								</div>
								</td>
								<td>
									<div style="margin-left: 14px;">
										<input name="auth" value="">
									</div>
									
								</td>

								<td align="center">
								<div style="margin-left:-200px;">
									出版社
								</div>	
								</td>
								<td>
									<div style="margin-left:-80px;">
								<input name="chubanshe" value="">
								</div>	
									
								</td>
								<td align="center">
									条形码
								</td>
								<td>
									<input name="isbn" value="">
								</td>
								<td align="center" bgcolor="#e4e4e4">
									出版时间
								</td>
								<td bgcolor="#e4e4e4">
									<input name="date" class="tcal tcalInput" value="" type="text">				
								</td> 
							</tr>
							<tr style="font-size: 13px" bgcolor="#E4E4E4">
								<td align="center" bgcolor="#e4e4e4">
									商品类型
								</td>
								<td style="width: 325px;">
								<select name="btype1" onchange="btype()">
								 
   							 		 <option>选择大类</option>
   							 		
   									 <option>教育理论/教师用书</option>
    								 <option>中小学阅读</option>
   									 <option>高考</option>
   									 <option>管理</option>
   									 <option>童书</option>
   									 <option>考试</option>
   									 <option>小说</option>
   									 <option>杂志/期刊</option>
   								 </select>
   								 <select name="btype2">   								 
   									  
   							 		 <option>选择小类</option>
   							 		   								 
   								 </select>
								</td>	
								<td align="center">
								</td>
								<td>
								</td>
								<td align="center">
								</td>
								<td>
								</td>
								<td align="center">
								</td>
								<td>
								</td>
							
							
							</tr>
							<tr bgcolor="#E4E4E4" height="50px">

								<td colspan="8" style="padding-right: 20px;" align="right">
									<input name="Submit" value="查询 " type="submit">
									<!-- <input type="button" value="添加"
										onclick="location.href='bookadd.jsp'" /> -->
									<input value="导入 " onclick="showDiv();" type="button">	
									<input value="导出 " onclick="location.href=' '" type="button">
								 
								</td>
						</tr></tbody></table>
					</form>
			</td></tr>


			<tr>
				<td valign="top">
					<!--显示项目列表-->
					<!--   <form name="form2" action="rightxiuAction.do" method="post">-->
					<table align="center" border="0" bordercolor="#666666" cellpadding="0" cellspacing="2" width="100%">
						<!--标题-->
						<tbody><tr style="font-size: 11px; font-weight: bold;" bgcolor="#1196EE" height="30">
							
							<td align="center">
								商品编号
							</td>
							
							<td align="center">
								商品名称
							</td>
							<td align="center">
								订阅期限
							</td>
							<td align="center">
								商品价格
							</td>
							
							<td align="center">
								商品折扣
							</td>
							<td align="center">
								审核状态
							</td>
							<td align="center">
								商品类型
							</td>
							<td align="center">
								适合学科
							</td>
							<td align="center">
								适合年级
							</td>
							<td align="center">
								作者
							</td>
							<td align="center">
								出版社
							</td>
							<td align="center">
								出版时间
							</td>
							<td align="center">
								条形码
							</td>
							<td align="center">
								积分抵用数
							</td>
							<td align="center">
								操作
							</td>
							
						</tr>

						<c:forEach var = "bookinfo"  
						items="${bookinfos}">
						<tr id="productPromotionTable" style="font-size: 12px; " bgcolor="#E4E4E4">
							
							<td align="center">
								${bookinfo.bookid }
							</td>
							<td align="center">
								
									${bookinfo.bookname}
								
							</td>
							<td align="center">
								非订阅期刊
							</td>
							<td align="center">
								${bookinfo.bookprice }
							</td>
							
							<td align="center">
								${bookinfo.discount }
							</td>
							<td align="center">
								已审核
							</td>
							<td align="center">
								${bookinfo.btype }
							</td>
							<td align="center">
								${bookinfo.major }
							</td>
							<td align="center">
								${bookinfo.grade }
							</td>
							<td align="center">
								${bookinfo.author }
							</td>
							<td align="center">
								${bookinfo.press }
							</td>
							<td align="center">
								${bookinfo.presstime }
							</td>
							<td align="center">
								${bookinfo.isbn }
							</td>
							<td align="center">
								${bookinfo.score }
							</td>
							<td align="center" bgcolor="#E4E4E4" nowrap="">
								<a href=" Admin_productPromotionInfo_ManageServlet?bookid=${bookinfo.bookid }"> 查看</a>
							</td>
						</tr>
				</c:forEach>
						
						

						
						<tr bgcolor="#E4E4E4" height="50">
							<td style="font-size: 13px;padding-right: 20px;" colspan="21" align="right">

							共${total}行  共${pages }页 第${page}页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${page>1 }">
								<a 	href="<%=basePath %>Admin_productPromotionInfoServlet?=${page-1}">上一页</a>
							</c:if>
							<c:if test="${page<=1 }">
							上一页
							</c:if>
							<c:if test="${page<pages}">
							<a 	href="<%=basePath %>Admin_productPromotionInfoServlet?=${page+1}">下一页</a>
							</c:if>&nbsp;&nbsp;&nbsp;
							<c:if test="${page>=pages }">
							下一页
							</c:if>
							<a href="<%=basePath %>Admin_productPromotionInfoServlet?page=${pages}">尾页</a>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
		</tbody></table>




<div id="popDiv" class="mydiv" style="display:none;">
<form name="excelImportForm" action=" " method="post" enctype="multipart/form-data">
	<table align="center" border="0" cellpadding="0" cellspacing="0">
		<tbody><tr>
			<td align="center">
				Excel批量导入
				<input name="file" type="file">
				<input value="导入 " onclick="return checkExcel()" type="submit">
			</td>		
		</tr>
		<tr><td><a href="book/style.jsp">参考样式</a></td></tr>
	</tbody></table>
</form><br>
<button onclick="closeDiv();">关闭窗口</button>					
</div>
<div id="bg" class="bg" style="display:none;"></div>

	
	
	
	
<!---------------------------------------------------------------------------------------->
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