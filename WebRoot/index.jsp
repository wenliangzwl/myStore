<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>慧慧网</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">

</script>
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
					<form action="<%=basePath %>LikeListServlet"  method="post">
						<input name="search_txt" type="text" class="search_txt"
						value="输入你要搜索的书籍名称"
						onfocus="if(this.value=='输入你要搜索的书籍名称'){this.value='';}"
						onblur="if(this.value==''){this.value='输入你要搜索的书籍名称';}" /> <input
						name="search_bt" type="submit" class="search_bt" value="搜索" />
					</form>
				</div>
				<div class="srarching_b">
					热门搜索： <a href="<%=basePath %>QueryListServlet?grade=8">外语考试</a> <a href="<%=basePath %>QueryListServlet?grade=9">中小学教辅</a> <a href="<%=basePath %>QueryListServlet?grade=13">百科全书</a>
					<a href="<%=basePath %>QueryListServlet?grade=15">辞典</a> <a href="<%=basePath %>QueryListServlet?grade=16">牛津系列</a> <a href="<%=basePath %>QueryListServlet?grade=10">汉语工具书</a> <a
						href="<%=basePath %>QueryListServlet?grade=11">英语工具书</a>
				</div>
			</div>
			<div class="ewm">
				<img src="<%=basePath %>customer/images/ewm.jpg" width="92" height="92" />
			</div>

		</div>
		<!--logo &s end -->
		<!--nav begin -->
		<div class="nav">
			<div class="warp">
				<div class="nav_left">全部分类</div>
				<div class="nav_right">
					<ul>
						<li><a href="<%=basePath %>index.jsp">首页</a></li>
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
		<!--1 begin -->
		<div class="con_one">
			<!--left begin -->
			<div class="con_one_left">
				<!--fenlei begin -->
				<div class="category">
					<dl>
						<dt>
							 <a href="<%=basePath %>QueryListServlet?grade=20">小学</a>
						</dt>
						<dd>
							<a href="<%=basePath %>QueryListServlet?grade=1">小学一年级</a> <a href="<%=basePath %>QueryListServlet?grade=2">小学二年级</a> <a href="<%=basePath %>QueryListServlet?grade=3">小学三年级</a> <a
								href="<%=basePath %>QueryListServlet?grade=4">小学四年级</a> <a href="<%=basePath %>QueryListServlet?grade=5">小学五年级</a> <a href="<%=basePath %>QueryListServlet?grade=6">小学六年级</a>

						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=basePath %>QueryListServlet?grade=21">初中</a>
						</dt>
						<dd>
							<a href="<%=basePath %>QueryListServlet?grade=27">初中一年级</a>
							<a href="<%=basePath %>QueryListServlet?grade=28">初中二年级</a>
							<a href="<%=basePath %>QueryListServlet?grade=29">初中三年级</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=basePath %>QueryListServlet?grade=22">高中</a>
						</dt>
						<dd>
							<a href="<%=basePath %>QueryListServlet?grade=30">高中一年级</a>
							<a href="<%=basePath %>QueryListServlet?grade=31">高中二年级</a>
							<a href="<%=basePath %>QueryListServlet?grade=32">高中三年级</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=basePath %>QueryListServlet?grade=23">教育</a>
						</dt>
						<dd>
							<a href="<%=basePath %>QueryListServlet?grade=7">教材</a>
							<a href="<%=basePath %>QueryListServlet?grade=8">外语考试</a>
							<a href="<%=basePath %>QueryListServlet?grade=9">中小学教辅</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=basePath %>QueryListServlet?grade=24">工具书</a>
						</dt>
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
						<dt>
							<a href="<%=basePath %>QueryListServlet?grade=25">期刊</a>
						</dt>
						<dd></dd>
					</dl>
				</div>
				<!--fenlei end -->
				<!--hot begin -->
				<div class="hotsell">
					<div class="hotsell_t">热销排行榜</div>
					<div class="hotsell_b">
						<ul>
							<%int a=0;%>
							<c:forEach var="sell" items="${sell }">
							<li>
								<div class="dis_pi">
									<a href="<%=basePath %>BookDetailServlet?bookid=${sell.bookid}" target="_blank"><img src="${sell.bookimg } "
										width="70" height="82" alt="" title="" /></a> <span class="pic_r"><em>${sell.bookname }</em>
										<i>${sell.discountprice }</i> <del>${sell.bookprice } </del> </span>
									<%a++;%>
								</div>
								<p>
									<a href="" target="_blank">${sell.bookname }</a>
								</p>
								<div class="num lbg"><%out.print(a);%></div>
							</li>
							</c:forEach>						
						</ul>
					</div>
				</div>
				<script type="text/javascript">
					jQuery(".hotsell_b").slide({
						titCell : "li",
						triggerTime : 0
					});
				</script>

				<!--hot end -->
				<div class="clearfloat"></div>
				<!--ads1 begin -->
				<div class="ads1">
					<ul>
						<li><a href=""><img src="<%=basePath %>customer/images/ad1.jpg" width="235"
								height="115" /></a></li>
						<li><a href=""><img src="<%=basePath %>customer/images/ad2.jpg" width="235"
								height="115" /></a></li>
					</ul>
				</div>
				<!--ads1 end -->
			</div>
			<!--left end -->
			<!--right begin -->
			<div class="con_one_right">
				<!--banner begin -->
				<div class="banner">
					<ul class="pic">
						<li><a href="" target="_blank"><img
								src="<%=basePath %>customer/images/banner1.jpg" width="856" height="335" /></a></li>
						<li><a href="" target="_blank"><img
								src="<%=basePath %>customer/images/banner1.jpg" width="856" height="335" /></a></li>
						<li><a href="" target="_blank"><img
								src="<%=basePath %>customer/images/banner1.jpg" width="856" height="335" /></a></li>
					</ul>
					<ul class="hd">
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
				<script type="text/javascript">
					jQuery(".banner").slide({
						mainCell : ".pic",
						effect : "left",
						autoPlay : true,
						delayTime : 300
					});
				</script>
				<!--banner end -->
				<!--new book begin -->
				<div class="newbook">
					<div class="hd">
						<h2>新书上架</h2>
						<a class="next"></a> <a class="prev"></a>
						<ul>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					</div>
					<div class="bd">
						<ul>
						<c:forEach var="list" items="${list}">
							<li><a href="" target="_blank">
									<div class="imgs">
									
										<a href="<%=basePath %>BookDetailServlet?bookid=${list.bookid}"><img src="${list.bookimg}" width="135" height="157" alt=""
											title="" /></a>
									</div>
									<h3>${list.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${list.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${list.store }</b></span>
									</div>
									<div class="price">${list.discountprice}</div>
							</a></li>
							</c:forEach>
						</ul>
					</div>

				</div>
				<script type="text/javascript">
					jQuery(".newbook").slide({
						mainCell : ".bd ul",
						effect : "left",
						delayTime : 800,
						vis : 5,
						scroll : 1,
						pnLoop : false,
						trigger : "click",
						easing : "easeOutCubic"
					});
				</script>

				<!--new book end -->

				<!--hot tj begin -->
				<div class="hottj">
					<div class="hd">
						<h2>热门推荐</h2>
						<ul>
							<li>小学</li>
							<li>初中</li>
							<li>高中</li>
							<li>教育</li>
							<li>工具书</li>
							<li>期刊</li>
						</ul>
					</div>
					<div class="bd">
						<ul class="tjul">
						<c:forEach var="subjectprimary" items="${subjectprimary }">
							<li class="last">
									<div class="imgs">
									<a href="<%=basePath %>BookDetailServlet?bookid=${subjectprimary.bookid}" target="_blank"><img src="${subjectprimary.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${subjectprimary.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${subjectprimary.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${subjectprimary.store }</b></span>
									</div>
									<div class="price">${subjectprimary.discountprice }</div>
							</li>
							</c:forEach>
						</ul>
						
						<ul class="tjul">
						<c:forEach var="junior" items="${junior }">
							<li class="last">
									<div class="imgs">
										<a href="<%=basePath %>BookDetailServlet?bookid=${junior.bookid}" target="_blank"><img src="${junior.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${junior.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${junior.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${junior.store }</b></span>
									</div>
									<div class="price">${junior.discountprice }</div>
							</li>
							</c:forEach>
						</ul>
						
						
					<ul class="tjul">
						<c:forEach var="senior" items="${senior }">
							<li class="last">
									<div class="imgs">
										<a href="<%=basePath %>BookDetailServlet?bookid=${senior.bookid}" target="_blank"><img src="${senior.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${senior.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${senior.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${senior.store }</b></span>
									</div>
									<div class="price">${senior.discountprice }</div>
							</li>
							</c:forEach>
					</ul>


					<ul class="tjul">
						<c:forEach var="education" items="${education }">
							<li class="last">
									<div class="imgs">
										<a href="<%=basePath %>BookDetailServlet?bookid=${education.bookid}" target="_blank"><img src="${education.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${senior.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${senior.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${senior.store}</b></span>
									</div>
									<div class="price">${education.discountprice }</div>
							</li>
							</c:forEach>
					</ul>
				<ul class="tjul">
						<c:forEach var="tool" items="${tool }">
							<li class="last">
									<div class="imgs">
										<a href="<%=basePath %>BookDetailServlet?bookid=${tool.bookid}" target="_blank"><img src="${tool.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${tool.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${senior.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${senior.store }</b></span>
									</div>
									<div class="price">${tool.discountprice }</div>
							</li>
							</c:forEach>
					</ul>
					
					<ul class="tjul">
						<c:forEach var="periodical" items="${periodical }">
							<li class="last">
									<div class="imgs">
										<a href="<%=basePath %>BookDetailServlet?bookid=${periodical.bookid}" target="_blank"><img src="${periodical.bookimg }" width="132" height="180" alt=""
											title="" /></a>
									</div>
									<h3>${periodical.bookname }</h3>
									<div class="shou">
										<span class="shou_l">已售：<b class="red">${periodical.sell }</b></span> <span
											class="shou_r">收藏：<b class="red">${periodical.store }</b></span>
									</div>
									<div class="price">${periodical.discountprice }</div>
							</li>
							</c:forEach>
					</ul>
					</div>
				</div>
				<script type="text/javascript">
					jQuery(".hottj").slide({
						delayTime : 0
					});
				</script>
				<!--hot tj end -->
			</div>
			<!--right end -->
		</div>
		<!--1 end -->
		<!--ads2 beign -->
		<div class="ads2">
			<ul>
				<li><a href=""><img src="<%=basePath %>customer/images/b1.jpg" width="360"
						height="125" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/b2.jpg" width="360"
						height="125" /></a></li>
				<li class="last"><a href=""><img src="<%=basePath %>customer/images/b3.jpg"
						width="360" height="125" /></a></li>
			</ul>
		</div>
		<!--ads2 end -->

		<!--today begin -->
		<div class="today">
			<div class="today_t">今日特价</div>
			<div class="today_b">
				<ul>
				<c:forEach var="discountlist" items="${discountlist }">
					<li>
							<div class="pics">
								<a href="<%=basePath %>BookDetailServlet?bookid=${discountlist.bookid}"><img src="${discountlist.bookimg }" width="178" height="168" alt=""
									title="" /></a>
							</div>
							<div class="tt" style="color:red;font-size:18px">${discountlist.bookname }</div>
							<div class="no_price">
								<span class="xj">￥${discountlist.discountprice }</span><span class="cj"><del>${discountlist.bookprice }</del></span>
							</div>
					</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!--today end -->
	</div>
	<!--container end -->
	<!--footer begin -->
	<div class="footer">
		<div class="footer_t">
			<ul>
				<li><a href=""><img src="<%=basePath %>customer/images/f1.jpg" width="130"
						height="52" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/f2.jpg" width="130"
						height="52" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/f3.jpg" width="130"
						height="52" /></a></li>
				<li class="last"><a href=""><img src="images/f4.jpg"
						width="130" height="52" /></a></li>
			</ul>
		</div>
		<div class="footer_b">
			<div class="footer_b1 tb1">
				<span class="f_title">购物指南</span>
				<ul>
					<li><a href="" target="_blank">购物流程</a></li>
					<li><a href="" target="_blank">发票制度</a></li>
					<li><a href="" target="_blank">账户管理</a></li>
					<li><a href="" target="_blank">会员优惠</a></li>
				</ul>
			</div>
			<div class="footer_b1 tb2">
				<span class="f_title">支付方式</span>
				<ul>
					<li><a href="" target="_blank">货到付款</a></li>
					<li><a href="" target="_blank">网上支付</a></li>
					<li><a href="" target="_blank">银行转账</a></li>
					<li><a href="" target="_blank">账户余额</a></li>
				</ul>
			</div>
			<div class="footer_b1 tb3">
				<span class="f_title">支付方式</span>
				<ul>
					<li><a href="" target="_blank">订单状态说明</a></li>
					<li><a href="" target="_blank">订单取消操作</a></li>
					<li><a href="" target="_blank">订单配送说明</a></li>
				</ul>
			</div>
			<div class="footer_b1 tb4">
				<span class="f_title">配送方式</span>
				<ul>
					<li><a href="" target="_blank">配送时间及运费</a></li>
					<li><a href="" target="_blank">验货与签收</a></li>
					<li><a href="" target="_blank">订单配送查询</a></li>
				</ul>
			</div>
			<div class="footer_b1 tb5">
				<span class="f_title">退换货</span>
				<ul>
					<li><a href="" target="_blank">退换货政策</a></li>
					<li><a href="" target="_blank">退换货流程</a></li>
					<li><a href="" target="_blank">退换货申请</a></li>
					<li><a href="" target="_blank">退款说明</a></li>
				</ul>
			</div>
			<div class="footer_b1 tb6">
				<span class="f_title">商家服务</span>
				<ul>
					<li><a href="" target="_blank">常见问题</a></li>
					<li><a href="" target="_blank">找回密码</a></li>
					<li><a href="" target="_blank">汇款单招领</a></li>
					<li><a href="" target="_blank">联系客服</a></li>
				</ul>
			</div>
		</div>
		<div class="footer_m">
			<div class="footer_nav">
				<a href="" target="_blank">关于我们</a>| <a href="" target="_blank">联系我们</a>|
				<a href="" target="_blank">人才招聘</a>| <a href="" target="_blank">广告服务</a>|
				<a href="" target="_blank">友情链接</a>| <a href="" target="_blank">销售联盟</a>|
				<a href="" target="_blank">公司简介</a>
			</div>
			<div class="footer_copyright">网络文化经营许可证鄂网文[2015]0278-060号
				Copyright © 2015-2018 版权所有</div>
		</div>

	</div>
	<!--footer end -->

</body>
</html>


