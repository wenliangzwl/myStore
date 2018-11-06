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
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.SuperSlide.2.1.1.js"></script>
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
            	  欢迎光临购书网！
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
                    <input name="search_txt" type="text"  class="search_txt" value="输入你要搜索的书籍名称" onfocus="if(this.value=='输入你要搜索的书籍名称'){this.value='';}"  onblur="if(this.value==''){this.value='输入你要搜索的书籍名称';}"/>
                    <input name="search_bt" type="button" class="search_bt"  value="搜索"/>
               </div>
               <div class="srarching_b">
                   热门搜索：
                   <a href="">外语考试</a>
                   <a href="">中小学教辅</a>
                   <a href="">百科全书</a>  
                   <a href="">辞典</a>
                   <a href="">牛津系列</a> 
                   <a href="">汉语工具书</a>
                   <a href="">英语工具书</a>
               </div>
         </div>
         <div class="ewm"><img src="images/ewm.jpg" width="92" height="92" /></div>
         
    </div>
    <!--logo &s end -->
    <!--nav begin -->
    <div class="nav">
         <div class="warp">
               <div class="nav_left">
               
                  全部分类
                  <div class="category_ho">
                    <dl>
                         <dt><a href="">小学</a></dt>
                         <dd>
                             <a href="">小学一年级</a>
                             <a href="">小学二年级</a>
                             <a href="">小学三年级</a>
                             <a href="">小学四年级</a>
                             <a href="">小学五年级</a>
                             <a href="">小学六年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="">初中</a></dt>
                         <dd>
                             <a href="">初中一年级</a>
                             <a href="">初中二年级</a>
                             <a href="">初中三年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="">高中</a></dt>
                         <dd>
                             <a href="">高中一年级</a>
                             <a href="">高中二年级</a>
                             <a href="">高中三年级</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="">教育</a></dt>
                         <dd>
                             <a href="">教材</a>
                             <a href="">外语考试</a>
                             <a href="">中小学教辅</a>
                         </dd>
                    </dl>
                    <dl>
                         <dt><a href="">工具书</a></dt>
                         <dd>         
                             <a href="">汉语工具书</a>
                             <a href="">英语工具书</a>
                             <a href="">其他语种工具</a>
                             <a href="">百科全书</a>
                             <a href="">文学鉴赏</a>
                             <a href="">辞典</a>
                             <a href="">牛津系列</a>
                             <a href="">朗文系列种工具</a>
                             <a href="">民族语工具书</a>
                             <a href="">英文原版书</a>
                         </dd>
                    </dl>
                    <dl class="last">
                         <dt><a href="">期刊</a></dt>
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
    <div class="list_banner"><a href="" target="_blank"><img src="images/list_banner.jpg" width="1100" height="92" /></a></div>
    <!--1begin -->
    <div class="buy_one">
    
         <div class="buy_one_t">
              <div class="buy_one_t1"></div>
              <div class="buy_one_t2">商品名称</div>
              <div class="buy_one_t3">单价</div>
              <div class="buy_one_t4">数量</div>
              <div class="buy_one_t5">小计</div>
              <div class="buy_one_t6">操作</div>
         </div>
         
         <div class="buy_one_c">
         
           <ul>
           	<c:forEach var="item" items="${items}">
               <li>
                    <div class="buy_one_c1"></div>
                    <div class="buy_one_c2">
                         <div class="buy_one_c2l"><a href=""><img src="${item.bookinfo.bookimg }" width="38" height="54" /></a></div>
                         <div class="buy_one_c2r">${item.bookinfo.bookname }</div>
                    </div>
                    <div class="buy_one_c3"><b class="pr1">${item.bookinfo.discountprice }</b></div>
                    <div class="buy_one_c4">${item.account }</div>
                    <div class="buy_one_c5"><b class="pr2">${item.bookinfo.discountprice*item.account }</b></div>
                    <div class="buy_one_c6">
                         <div class="buy_one_c62"><a href="">修改</a></div>
                        
                    </div>
               </li>
               </c:forEach>
           </ul>
         </div>
         <!--收货人信息beign -->
         <div class="address_xg">
              <div class="address_xg_t"><span class="edit"><a href="">修改</a></span>收货人信息</div>
              <div class="address_xg_b">
                   <dl>
                        <dt>收货人姓名：</dt>
                        <dd><input name="name" type="text" class="txta" disabled="disabled" value="${userinfo.username }"/></dd>
                   </dl>
                   <dl>
                        <dt>收货地区：</dt>
                        <dd><input name="name" type="text" class="txta" disabled="disabled" value="${userinfo.address }"/></dd>
                   </dl>
                   <dl>
                        <dt>邮编：</dt>
                        <dd><input name="name" type="text" class="txta" disabled="disabled" value="${userinfo.postcode}"/></dd>
                   </dl>
                   <dl>
                        <dt>手机：</dt>
                        <dd><input name="name" type="text" class="txta" disabled="disabled" value="${userinfo.phone }"/></dd>
                   </dl>
              </div>
         </div>
         <!--收货人信息end -->
         <!--配送方式 begin -->
        <div class="address_xg">
              <div class="address_xg_t">配送方式</div>
              <div class="address_xg_b">
                <form id="form1" name="form1" method="post" action="">
                      <p>
                        <label class="courier">
                          <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" />
                          自提</label>
                        <label class="courier">
                          <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" checked="checked"/>
                          申通快递</label>
                        <label class="courier">
                            <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
                          圆通快递</label>
                        <label class="courier">
                            <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
                          平邮</label>
                      </p>
                </form>
              </div>
        </div>
         <!--配送方式 end -->
    </div>
    <!--1end -->
    <!--zhifu begin -->
  <div class="pay_way">
    <div class="hd">
            选择支付方式
			<ul>
				<li>淘宝支付</li>
				<li>银联支付</li>
			</ul>
		</div>
		<div class="bd">
             <ul>
                  <li>
                        <label>
                          <input type="radio" name="RadioGroup2" value="" id="RadioGroup2_0" />
                          <img src="<%=basePath %>customer/images/kuaijie.jpg" width="161" height="42"  class="pcs"/>
                        </label>
                  </li>
                  <li>
                       <label>
                          <input type="radio" name="RadioGroup2" value="" id="RadioGroup2_1" />
                          <img src="<%=basePath %>customer/images/zfb.jpg" width="161" height="42" class="pcs"/>
                        </label>
                  </li>
             </ul>
             <ul>
                    <li>
                        <label>
                          <input type="radio" name="RadioGroup3" value="" id="RadioGroup3_0" />
                          <img src="<%=basePath %>customer/images/c1.jpg" width="161" height="42"  class="pcs"/>
                        </label>
                  </li>
                  <li>
                       <label>
                          <input type="radio" name="RadioGroup3" value="" id="RadioGroup3_1" />
                          <img src="<%=basePath %>customer/images/c1.jpg" width="161" height="42" class="pcs"/>
                        </label>
                  </li>
             </ul>
    </div>
  </div>
   <script type="text/javascript">jQuery(".pay_way").slide({delayTime:0 });</script>
    <!--zhifu end -->
  <div class="next_bt"><a href="<%=basePath %>OrdersServlet"></a></div> 
   
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
