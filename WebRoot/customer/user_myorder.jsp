<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
</head>


<script type="text/javascript">
function getordersids_delete(){
	var inputs = document.getElementsByTagName("input");
	var str = "";
	for (var i = 1; i < inputs.length; i++) {
		if (inputs[i].type == "checkbox" && inputs[i].checked) {
			str += inputs[i].value + "/";
		}

	}
	str = str.substring(0, str.lastIndexOf("/"));
	alert("str值"+str);
	window.location = "<%=basePath %>User_myorder_ManageServlet?ordersid=" + str+"&opt=4";


}


	function number() {
		var res = "";
		for (var i = 0; i < ${totalpage}; i++) {
			res += "<a href='<%=basePath %>User_myorderServlet?pageIndex=" + (i + 1) + "' class='active'>"
					+ (i + 1) + " </a>";
		}
		document.getElementById("num").innerHTML = res;
	}
</script>
 <script type="text/JavaScript">
 function check(){
 	var oInput=document.getElementsByName("myorder");
 	for (var i=0;i<oInput.length;i++)
 		oInput[i].checked=document.getElementById("allxz").checked;
 }
</script>
<body onload="number()">

    <div class="user_top">
       <div class="user_c">
         <div class="user_top_l">
             <a href="<%=basePath %>index.jsp" target="_blank">回到首页</a>
             欢迎您，${sessionScope.userinfo.nickname}  &nbsp;&nbsp;&nbsp;
             <a href="<%=basePath %>User_ExitServlet" target="_blank">退出</a>
         </div>
         <div class="user_top_r">
               <ul>
                   <li><a href="" target="_blank">帮助中心</a></li>
                   <li><a href="" target="_blank">关于我们</a></li>

               </ul>
         </div>
       </div>
    </div>
    
    <div class="user_nav">
         <div class="user_c">
               <div class="user_nav_l">用户中心</div>
               <div class="user_nav_r">
                     <input name="search2" type="text"  class="uesr_s"/>
                     <input name="search2" type="button"  class="uesr_b"/>
               </div>
         </div>
    </div>
    
    <div class="user_cont">
         <!--left begin -->
         <div class="user_cont_left">
                  <dl>
                   <dt>我的交易</dt>
                   <dd class="active"><a href="<%=basePath %>User_myorderServlet">我的订单</a></dd>
                   <dd><a href="<%=basePath %>User_myStoreServlet">我的收藏</a></dd>
                   <dd><a href="<%=basePath %>">我的账单</a></dd>
                   <dd><a href="<%=basePath %>User_myShoppingcarServlet">我的购物车</a></dd>
                   <dd><a href="<%=basePath %>">已经购买的商品</a></dd>
               </dl>
               <dl>
                   <dt>自助服务</dt>
                   <dd><a href="<%=basePath %>">申请查询退换货</a></dd>
                   <dd><a href="<%=basePath %>">查询退换货记录</a></dd>
                   <dd><a href="<%=basePath %>User_scoreExchageRecord_QueryServlet">查询积分兑换记录</a></dd>
               </dl>
               <dl>
                   <dt>我的账户</dt>
                   <dd><a href="<%=basePath %>User_myScoreServlet">我的积分</a></dd>
                   <dd><a href="<%=basePath %>">我的消息</a></dd>
                   <dd><a href="<%=basePath %>customer/user_myAdress.jsp">我的收获地址</a></dd>
                   <dd ><a href="<%=basePath %>customer/user_infoDetail.jsp">个人档案</a></dd>
               </dl>
               <dl>
                   <dt>社区中心</dt>
                   <dd><a href="<%=basePath %>User_myCommentServlet">我的评论</a></dd>
                   <dd><a href="<%=basePath %>User_exchangeAreaServlet">兑换专区</a></dd>
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
                    <div class="user_lmt1">我的订单</div>
                    <div class="user_lmt2">
                         <div class="user_lmt22"><a href=""><span style="margin-top:2px;" onclick="getordersids_delete()" >批量删除</span> </a></div>
                         <div class="user_lmt21"><input name="allx_all"id="allxz" type="checkbox" value="" class="allxz_c"onclick="check();"/>全选</div>
                    </div>
               </div>
               <div class="user_coment">
                 <table width="713" border="0" cellspacing="0" cellpadding="0"  class="my_dd">
                       <tr>
                            <th height="48" colspan="2">书籍</th>
                            <th width="110">订单日期</th>
                            <th width="93">订单数量</th>
                            <th width="98">订单状况</th>
                            <th width="117">实付款（元）</th>
                            <th width="115">交易操作</th>
                        </tr>
                        <c:forEach var="orders" items="${orderss}">
                        
                <tr>
                            <td width="32" height="195" style="border-right:none; vertical-align:text-top;">
                              <input type="checkbox" name="myorder" id="dd_boo_One" value="${orders.ordersid}"class="dd_book"/>
                            </td>
                            <td width="163">
                                 <div class="dd_img"><a href="" target="_blank"><img src="${orders.bookinfo.bookimg}" width="132" height="121" /></a></div>
                                 <div class="dd_bookname"><a href="" target="_blank">${orders.bookame}</a></div>
                            </td>
                            <td>${orders.createtime}</td>
                            <td>${orders.acount}</td>
                            <td>${orders.state}</td>
                            <td>${orders.jiage}</td>
                            <td>
                                 <div class="user_ck"><a href="<%=basePath %>User_myorder_ManageServlet?ordersid=${orders.ordersid}&opt=1" target="_blank">查看</a></div>
                                 <div class="user_pj"><a href="<%=basePath %>User_myorder_ManageServlet?ordersid=${orders.ordersid}&bookid=${orders.bookinfo.bookid}&opt=2" target="_blank">评价</a></div>
                                 <div class="user_sc"><a href="<%=basePath %>User_myorder_ManageServlet?ordersid=${orders.ordersid}&opt=3" target="_blank">删除</a></div>
                            </td>
                        </tr>        
                        
	</c:forEach>
                        
                      
                        
                        
                    </table>
                    <!--分页开始 -->
                    <div style="clear:both;"></div>
                    <div class="fenyeys" >
                    
                    
                      <c:if test="${pageIndex>1}">	<a href="<%=basePath %>User_myorderServlet?pageIndex=${pageIndex-1}">上一页</a>	
		</c:if>
		
			
		
		<c:if test="${pageIndex<=1}">上一页</c:if>		
		<span id="num">			</span>
		<c:if test="${pageIndex<totalpage}"><a 	href="<%=basePath %>User_myorderServlet?pageIndex=${pageIndex+1}">下一页</a></c:if>	
		    <c:if test="${pageIndex>=totalpage}">下一页</c:if>
                                     
                    </div>
                    <div style="clear:both;"></div>
                    <!--分页结束 -->
               </div>
         </div>
         <!--right end -->
    </div>
    
    <div class="footer_m mar38">
           <div class="footer_nav">
               <a href="" target="_blank">关于我们</a>|
               <a href="" target="_blank">联系我们</a>|
               <a href="" target="_blank">人才招聘</a>|
               <a href="" target="_blank">广告服务</a>|
               <a href="" target="_blank">友情链接</a>|
               <a href="" target="_blank">销售联盟</a>|
               <a href="" target="_blank">公司简介</a>
           </div>
           <div class="footer_copyright">
                网络文化经营许可证鄂网文[2015]0278-060号  Copyright © 2015-2018  版权所有
           </div>
     </div>
    
</body>
</html>
