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

<link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/admin_productOrderSaleInfo.css"/>
<script type="text/javascript">
	

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
}

</script>
<script type="text/javascript">
function showDiv(){
document.getElementById('popDiv').style.display='block';
document.getElementById('bg').style.display='block';
}

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
}
function promptinfo()
{
	var address = document.getElementById('address');
	var s1 = document.getElementById('s1');
	var s2 = document.getElementById('s2');
	var s3 = document.getElementById('s3');
	//address.value = s1.value + s2.value + s3.value;
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
                    <div class="user_lmt1">当前位置》<a href="">首页</a>》商品订单管理》   商品销售额查询管理</div>
                 
               </div>
               <div class="user_coment" style="height: 550px">
<!------------------------------------------------------------------->

<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%" id="testPace">

			<tbody>
				<tr>
				<td valign="top" height="25">
					<!--项目列表 查询提交表单-->
					<form name="form1" action=" " method="post">
						<table align="center" cellpadding="0" cellspacing="2" width="100%">
							<!--提示信息-->
							<tbody><tr bgcolor="#1196EE">
								<td colspan="8" style="font-size: 14px; font-weight: bold; padding-left: 10px" height="30">
									商品销售额查询
								</td>
							</tr>
							<tr style="font-size: 13px" bgcolor="#E4E4E4">
							
								<td align="center">
									书名
								</td>
								<td>
									<input name="book" value="">
								</td>
								<td align="center">
									支付时间 
								</td>
								<td>
									从<input name="skdate" class="tcal tcalInput" size="10" value="" type="text">
								</td>
								<td align="center">
									到
								</td>
								<td>
									<input name="skdate1" class="tcal tcalInput" size="10" value="" type="text">
								</td>

							</tr>
							
							<tr bgcolor="#E4E4E4" height="50px">

								<td colspan="8" style="padding-right: 20px;" align="right">
									<input name="Submit" value="查询 " type="submit">
									
										
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
						<tbody>
						<tr style="font-size: 14px; font-weight: bold;" bgcolor="#1196EE" height="30">
							<td align="center">
								订单编号
							</td>
							
							<td align="center">
								书籍名称
							</td>
							<td align="center">
								书籍数量
							</td>
							<td align="center">
								订单价格
							</td>
							<td align="center">
								支付时间
							</td>
						</tr>	
					<c:forEach var="list" items="${ordersassorter_rightlist }">
					<tr style="font-size: 14px; font-weight: bold;" bgcolor="#1196EE" height="30">
							<td align="center">
								${list.ordersid }
							</td>
							
							<td align="center">
								${list.bookinfo.bookname }
							</td>
							<td align="center">
								${list.acount}
							</td>
							<td align="center">
								${list.jiage }
							</td>
							<td align="center">
								${list.createtime }
							</td>
						</tr>
						</c:forEach>

						
						<tr bgcolor="#E4E4E4" height="50">
		
		
				<td style="font-size: 13px;padding-right: 20px;" colspan="16" align="right">
				<c:if test="${page>1 }">
				<a href="<%=basePath %>Admin_ProductOrderStateInfoServlet?page=${page-1 }&back=1">上一页</a>	
				</c:if>
				<c:if test="${page<=1 }">
				上一页
				</c:if>
				<c:if test="${page<pages }">
				<a href="<%=basePath %>Admin_ProductOrderStateInfoServlet?page=${page+1}&back=1">
				下一页</a>	  
				</c:if>
				<c:if test="${page>=pages }">
						下一页			
				</c:if>
					当前第${page }页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总共${pages }页
					总共销售金额：${totalmoney }
							
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
		</tbody></table>



<!------------------------------------------------------------------------->
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