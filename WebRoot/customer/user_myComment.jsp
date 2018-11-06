<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的评论</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script type="text/javascript">
		function number() {
		var res = "";
		for (var i = 0; i < ${totalpage}; i++) {
			res += "<a href='<%=basePath %>User_myCommentServlet?pageIndex="+ (i + 1) + "' class='active'>" + (i + 1) + " </a>";
		}
		document.getElementById("num").innerHTML = res;
	}
</script>

</head>

<body onload="number()">

    <div class="user_top">
       <div class="user_c">
         <div class="user_top_l">
             <a href="<%=basePath %>IndexServlet" target="_blank">回到首页</a>
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
                   <dd><a href="<%=basePath %>User_myorderServlet">我的订单</a></dd>
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
                   <dd class="active"><a href="<%=basePath %>User_myCommentServlet">我的评论</a></dd>
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
                    <div class="user_lmt1">我的评论</div>
                   
           </div>
           <div class="user_coment">
                 <div class="my_comments">
                  

                    
                     <ul>
                       <c:forEach var="comment" items="${comments}">
                         <li>
                             <div class="my_co_1">
                                  <div class="my_co_11"><a href="" target="_blank"><img src="${comment.bookinfo.bookimg}" width="47" height="60" /></a></div>
                                  <div class="my_co_12">${comment.bookname}</div>
                                  <div class="my_co_13">${comment.bookinfo.commenttime}</div>
                                  <div class="my_co_14"><a href="<%=basePath %>User_myComment_ManageServlet?commentid=${comment.commentid}">删除</a></div>
                             </div>
                             <div class="my_co_2"><span class="red">我的评论：</span>${comment.content}</div>
                             
                         </li>
                         	</c:forEach>
                         
                     </ul>
                        <!--分页开始 -->
                 <div style="clear:both;"></div>
                    <div class="fenyeys" >
                    	<c:if test="${pageIndex>1}">
						<a href="<%=basePath %>User_myCommentServlet?pageIndex=${pageIndex-1}">上一页</a>	
		            </c:if>
					<c:if test="${pageIndex<=1}">上一页</c:if>
					<span id="num"> </span>
					<c:if test="${pageIndex<totalpage}">
						<a href="<%=basePath %>User_myCommentServlet?pageIndex=${pageIndex+1}">下一页</a>
					</c:if>
					<c:if test="${pageIndex>=totalpage}">下一页</c:if>
                    </div>
                    <div style="clear:both;"></div>
                    <!--分页结束 -->
                 </div>
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
