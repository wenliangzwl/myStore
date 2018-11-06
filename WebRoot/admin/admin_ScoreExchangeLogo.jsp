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

<link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/admin_ScoreExchangeLogo.css"/>

<script type="text/javascript">

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
}

function fun(obj){
	window.location="<%=basePath %>Admin_ScoreExchangeLogo_ManageServlet?recordid="+obj.id+"&sendtime="+obj.value+"";
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
                    <div class="user_lmt1">当前位置》 <a href="">首页</a>》积分兑换商品管理》积分兑换记录信息管理 </div>
                    
          
           </div>
               <div class="user_coment" style="height: 550px">
<!------------------------------------------------------------------------>
<!--工作区-->
		<!--新建Bug成功的提示信息-->
			

		<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%" id="testpace">

			<tbody><tr>
				<td valign="top" height="25">
					<!--项目列表 查询提交表单-->
					<form name="form1" action="http://localhost:8087/edubooksystem/jilu/jiluinfo.jsp" method="post">
						<table align="center" cellpadding="0" cellspacing="2" width="100%">
							<!--提示信息-->
							<tbody><tr bgcolor="#1196EE">
								<td colspan="8" style="font-size: 14px; font-weight: bold; padding-left: 10px" height="30">
									积分兑换信息查询
								</td>
							</tr>
							<tr style="font-size: 13px" bgcolor="#E4E4E4">
								<td align="center">
									换购积分
								</td>
								<td>
									<select name="jifen">
										<option value="">
                                            	&nbsp;&nbsp;--请选择--                                                            
										</option>
										<option value="1">
											&nbsp;&nbsp;0&nbsp;&nbsp;-&nbsp;99积分
										</option>
										<option value="2">
											100-199积分
										</option>
										<option value="3">
											200-299积分
										</option>
										<option value="4">
											300-399积分
										</option>
										<option value="5">
											400-499积分
										</option>
										<option value="6">
											500-599积分
										</option>
										<option value="7">
											600-699积分
										</option>
										<option value="8">
											700-799积分
										</option>
									</select>
								</td>

								<td align="center">
									小商品名称
								</td>
								<td>
									<input name="mingcheng" value="">
								</td>
								<td align="center" bgcolor="#e4e4e4">
									记录时间
								</td>
								<td>
									
									<input name="date" class="tcal tcalInput" value="" type="text">
						
								</td>
								<td align="center" bgcolor="#e4e4e4">
									发货状态
								</td>
								<td>
									<select name="state">
										<option value="">-选择状态-</option>
										<option value="未发货">未发货</option>
										<option value="已发货">已发货</option>
									</select>
								</td>
							
								
							</tr>
							<tr bgcolor="#E4E4E4" height="50px">

								<td colspan="8" style="padding-right: 20px;" align="right">
									<input name="Submit" value="查询 " type="submit">
									<input value="导出 " onclick="location.href='http://localhost:8087/edubooksystem/daochu1.do?importType=jiluInfo&amp;total=0'" type="button">
								 
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
						<tbody><tr style="font-size: 14px; font-weight: bold;" bgcolor="#1196EE" height="30">
							<td align="center">
								编号
							</td>
							<td align="center">
								会员姓名
							</td>
							
							<td align="center">
								换购积分
							</td>
							<td align="center">
								小商品名字
							</td>
							<td align="center">
								记录时间
							</td>
							<td align="center">
								发货时间
							</td>
							<td align="center">
								送货地址
							</td>
							<td align="center">
								操作
							</td>
						</tr>


					<c:forEach  var="list" items="${list }">
						<tr style="font-size: 14px; font-weight: bold;" bgcolor="#1196EE" height="30">
							<td align="center" >
							${list.recordid }
							</td>
							<td align="center">
							${list.userinfo.username }
							</td>							
							<td align="center">
							${list.score }
							</td>
							<td align="center">
							${list.exchangename }							
							<td align="center">
							${list.exchangetime }
							</td>
							<td align="center">
                              	<input type="text" id="${list.recordid }"  value="${list.sendtime }" onchange="fun(this)"/> 
							</td>						
							<td align="center">
								${list.userinfo.address }
							</td>
							<td align="center">
								操作
							</td>
						</tr>
				</c:forEach>					
				<tr bgcolor="#E4E4E4" height="50">
				<td style="font-size: 13px;padding-right: 20px;" colspan="21" align="right">
				<c:if test="${page>1 }">
				<a href="Admin_ScoreExchangeLogoServlet?page=${page-1 }">上一页</a>	
				</c:if>
				<c:if test="${page<=1 }">
				上一页
				</c:if>
				<c:if test="${page<pages }">
				<a href="Admin_ScoreExchangeLogoServlet?page=${page+1}">
				下一页</a>	  
				</c:if>
				<c:if test="${page>=pages }">
						下一页			
				</c:if>
				共${pages }页 当前第${page }页
				</tr>
					</tbody></table>
				</td>
			</tr>
		</tbody></table>

<div id="bg" class="bg" style="display:none;"></div>

	
<!---------------------------------------------------------------------->
               </div>
               <div>

			          	 <div style="clear:both;"></div><div class="fenyeys">当前第0页 共0页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div style="clear:both;"></div>
				</div>
                    <!--分页结束 -->

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