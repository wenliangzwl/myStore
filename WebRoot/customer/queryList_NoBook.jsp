<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script>
$(function(){
    $('.nav_left').mouseover(function(){

		$('.category_ho').show();
	}).mouseout(function(){
		$('.category_ho').hide();
	});  	
});
</script>
</head>

<body>
<!--top begin -->
<div class="header">

    <div class="header_1">
         <div class="warp">
              <div class="header_1_l">
                    	 <c:if test="${optt==null&&opttt==null}"><a href="<%=basePath %>customer/login.jsp">请登陆</a>
				 <a href="<%=basePath %>customer/register.jsp">免费注册</a> </c:if>
				
				 <c:if test="${optt.equals('haslogin')}">${sessionScope.userinfo.nickname }
				 <span id=""><a href="<%=basePath%>User_ExitServlet">用户退出</a></span>
				 </c:if> 
				
				 <c:if test="${opttt==null&&optt==null}"> <span id=""><a href="<%=basePath%>admin/adminLogin.jsp">管理员登陆</a></span>  </c:if> 
				  <c:if test="${opttt.equals('haslogin')}">&nbsp;${sessionScope.assorter_right.adminname} 
				   <a href="<%=basePath%>Admin_ExitServlet">管理员退出</a>       </c:if> 
              </div>
              <div class="header_1_r">
                   <ul>
                        <li><a href="<%=basePath %>User_myorderServlet">我的订单</a></li>
						<li><a href="<%=basePath %>customer/buy.jsp">购物车<span class="red">${size}</span>件
						</a></li>
						<li><a href="<%=basePath %>customer/helpCenter.jsp">帮助中心</a></li>
                   </ul>              
              </div> 
         </div>
    </div>
    <!--logo &s begin -->
    <div class="header_2">
         <div class="logo"></div>
         <div class="srarching">
               <div class="srarching_t">
                    <form action="<%=basePath %>LikeListServlet" method="post">
						<input name="search_txt" type="text" class="search_txt"
							value="输入你要搜索的书籍名称"
							onfocus="if(this.value=='输入你要搜索的书籍名称'){this.value='';}"
							onblur="if(this.value==''){this.value='输入你要搜索的书籍名称';}" /> <input
							name="search_bt" type="submit" class="search_bt" value="搜索" />
					</form>
				</div>
               <div class="srarching_b">
                   热门搜索：
                   <a href="<%=basePath %>QueryListServlet?grade=8">外语考试</a>
                   <a href="<%=basePath %>QueryListServlet?grade=9">中小学教辅</a>
                   <a href="<%=basePath %>QueryListServlet?grade=13">百科全书</a>  
                   <a href="<%=basePath %>QueryListServlet?grade=15">辞典</a>
                   <a href="<%=basePath %>QueryListServlet?grade=16">牛津系列</a> 
                   <a href="<%=basePath %>QueryListServlet?grade=10">汉语工具书</a>
                   <a href="<%=basePath %>QueryListServlet?grade=11">英语工具书</a>
               </div>
         </div>
         <div class="ewm"><img src="<%=basePath %>customer/images/ewm.jpg" width="92" height="92" /></div>
         
    </div>
    <!--logo &s end -->
    <!--nav begin -->
    <div class="nav">
         <div class="warp">
               <div class="nav_left">
               
                  全部分类
                  <div class="category_ho">
                    <dl>
                         <dt><a href="<%=basePath %>QueryListServlet?grade=21">小学</a></dt>
                         <dd>
                             <a href="<%=basePath %>QueryListServlet?grade=1">小学一年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=2">小学二年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=3">小学三年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=4">小学四年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=5">小学五年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=6">小学六年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="<%=basePath %>QueryListServlet?grade=22">初中</a></dt>
                         <dd>
                             <a href="<%=basePath %>QueryListServlet?grade=27">初中一年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=28">初中二年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=29">初中三年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="<%=basePath %>QueryListServlet?grade=23">高中</a></dt>
                         <dd>
                             <a href="<%=basePath %>QueryListServlet?grade=30">高中一年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=31">高中二年级</a>
                             <a href="<%=basePath %>QueryListServlet?grade=32">高中三年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="<%=basePath %>QueryListServlet?grade=24">教育</a></dt>
                         <dd>
                             <a href="<%=basePath %>QueryListServlet?grade=7">教材</a>
                             <a href="<%=basePath %>QueryListServlet?grade=8">外语考试</a>
                             <a href="<%=basePath %>QueryListServlet?grade=9">中小学教辅</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="<%=basePath %>QueryListServlet?grade=25">工具书</a></dt>
                         <dd>         
                             <a href="<%=basePath %>QueryListServlet?grade=10">汉语工具书</a>
                             <a href="<%=basePath %>QueryListServlet?grade=11">英语工具书</a>
                             <a href="<%=basePath %>QueryListServlet?grade=12">其他语种工具</a>
                             <a href="<%=basePath %>QueryListServlet?grade=13">百科全书</a>
                             <a href="<%=basePath %>QueryListServlet?grade=14">文学鉴赏</a>
                             <a href="<%=basePath %>QueryListServlet?grade=15">辞典</a>
                             <a href="<%=basePath %>QueryListServlet?grade=16">牛津系列</a>
                             <a href="<%=basePath %>QueryListServlet?grade=17">朗文系列种工具</a>
                             <a href="<%=basePath %>QueryListServlet?grade=18">民族语工具书</a>
                             <a href="<%=basePath %>QueryListServlet?grade=19">英文原版书</a>
                         </dd>
                    </dl>
                    <dl class="last">
                         <dt><a href="<%=basePath %>QueryListServlet?grade=26">期刊</a></dt>
                         <dd></dd>
                    </dl>
                 </div>
                    
               </div>
               <div class="nav_right">
                    <ul>                                                       
                           <li><a href="<%=basePath %>IndexServlet">首页</a></li>
						<li><a href="">促销优惠</a></li>
						<li><a href="<%=basePath %>customer/buy.jsp">购物车</a></li>
							<li><a href="<%=basePath %>User_myorderServlet">我的订单</a></li>
						<li><a href="<%=basePath%>customer/user_infoDetail.jsp">个人中心</a></li>
						<li><a href="<%=basePath %>customer/helpCenter.jsp">客户服务</a></li>                                                   
                       
                    </ul>
               </div>
         </div>
    </div>
    <!--nav end -->
    <div class="clearfloat"></div>
</div>
<!--top end -->
<!--container begin -->
<div class="container">
    <!--banner begin -->
    <div class="list_banner"><a href="" target="_blank"><img src="<%=basePath %>customer/images/list_banner.jpg" width="1100" height="92" /></a></div>
    <!--banner end -->
    <div class="list_dq"> <a href="" target="_blank">购书网</a> > <a href="" target="_blank">图书 </a>> <a href="" target="_blank">中小学教辅</a> >小学一年级 </div>
    <!--fenlei begin -->
    <div class="list_fl">
         <dl>
              <dt>科目：</dt>
              <dd>
                   <a href="" target="_blank" class="active">语文</a>
                   <a href="" target="_blank">数学</a>
                   <a href="" target="_blank">英语</a>
                   <a href="" target="_blank">其他科目</a>
              </dd>
         </dl>
         <dl>
              <dt>价格：</dt>
              <dd>           
                   <a href="" target="_blank" class="active">1-3元</a>
                   <a href="" target="_blank">3-9元 </a>
                   <a href="" target="_blank">9-10元</a>
                   <a href="" target="_blank">10元以上</a>
              </dd>
         </dl>
         <dl style="border-bottom:none;">
              <dt>折扣：</dt>
              <dd>            
                   <a href="" target="_blank" class="active">3折以下</a>
                   <a href="" target="_blank">3-5折</a>
                   <a href="" target="_blank">5-7折</a>
                   <a href="" target="_blank">7折以上</a>
              </dd>
         </dl>
    </div>
    <!--fenlei end -->
    <!--paixu begin -->
    <div class="paixu">
        <div class="number">共有<span class="red">122</span>个商品</div>
        <ul>
            <li class="li1">排序</li>
            <li class="active"><a href="">默认排序</a></li>
            <li><a href="">销量<b><img src="<%=basePath %>customer/images/list_jtx.jpg" width="7" height="8" /></b></a></li>
            <li><a href="">价格<b><img src="<%=basePath %>customer/images/list_jts.jpg" width="7" height="8" /></b></a></li>
            <li><a href="">出版时间<b><img src="<%=basePath %>customer/images/list_jtx.jpg" width="7" height="8" /></b></a></li>
        </ul>
    </div>
    <!--paixu end -->
    <div class="clearfloat"></div>
     <!--today begin -->
     <div class="today">
       
         <div class="today_b">
        <div style="text-align :center ; font-size: 18px; color: red;"><img src="<%=basePath %>customer/images/gthxx.jpg" width="100px" height="100px">暂无您想搜索的书籍!!!</div>
         </div>  
     </div>
     <!--today end -->
     <!--page begin -->
     <div style="clear:both;"></div>
      <div style="clear:both;"></div>
    <!--page begin -->
</div>
<!--container end -->
<!--footer begin -->
<div class="footer">
     <div class="footer_t">
          <ul>
               <li><a href=""><img src="<%=basePath %>customer/images/f1.jpg" width="130" height="52" /></a></li>
               <li><a href=""><img src="<%=basePath %>customer/images/f2.jpg" width="130" height="52" /></a></li>
               <li><a href=""><img src="<%=basePath %>customer/images/f3.jpg" width="130" height="52" /></a></li>
               <li class="last"><a href=""><img src="<%=basePath %>customer/images/f4.jpg" width="130" height="52" /></a></li>
          </ul>
     </div>
     <div class="footer_b">
           <div class="footer_b1 tb1">
                <span class="f_title">购物指南</span>
                <ul>
                    <li><a href="" target="_blank">购物流程</a></li>
                    <li><a href="" target="_blank">发票制度</a></li>
                    <li><a href="" target="_blank" >账户管理</a></li>
                    <li><a  href="" target="_blank">会员优惠</a></li>
                </ul>
           </div>
           <div class="footer_b1 tb2">
                <span class="f_title">支付方式</span>
                <ul>
                    <li><a href="" target="_blank">货到付款</a></li>
                    <li><a href="" target="_blank" >网上支付</a></li>
                    <li><a href="" target="_blank" >银行转账</a></li>
                    <li><a  href="" target="_blank">账户余额</a></li>
                </ul>
           </div>
            <div class="footer_b1 tb3">
                <span class="f_title">支付方式</span>
                <ul>
                    <li><a href="" target="_blank">订单状态说明</a></li>
                    <li><a href="" target="_blank" >订单取消操作</a></li>
                    <li><a href="" target="_blank" >订单配送说明</a></li>
                </ul>
           </div>
           <div class="footer_b1 tb4">
                <span class="f_title">配送方式</span>
                <ul>
                    <li><a href="" target="_blank">配送时间及运费</a></li>
                    <li><a href="" target="_blank" >验货与签收</a></li>
                    <li><a href="" target="_blank" >订单配送查询</a></li>
                </ul>
           </div>
            <div class="footer_b1 tb5">
                <span class="f_title">退换货</span>
                <ul>
                    <li><a href="" target="_blank">退换货政策</a></li>
                    <li><a href="" target="_blank" >退换货流程</a></li>
                    <li><a href="" target="_blank" >退换货申请</a></li>
                    <li><a href="" target="_blank" >退款说明</a></li>   
                </ul>
           </div>
            <div class="footer_b1 tb6">
                <span class="f_title">商家服务</span>
                <ul>
                    <li><a href="" target="_blank">常见问题</a></li>
                    <li><a href="" target="_blank" >找回密码</a></li>
                    <li><a href="" target="_blank" >汇款单招领</a></li>
                    <li><a href="" target="_blank" >联系客服</a></li>   
                </ul>
           </div>
     </div>
     <div class="footer_m">
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
     
</div>
<!--footer end -->

</body>
</html>
