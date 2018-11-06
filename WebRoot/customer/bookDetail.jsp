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
<title>书籍详情</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.jqzoom.js"></script>
<script type="text/javascript" src="<%=basePath %>customer/js/base.js"></script>
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
    <div class="list_banner"><a href="" target="_blank"><img src="${bookinfo.bookimg}" width="1100" height="92" /></a></div>
    <!--banner end -->
    <!--left begin -->
    <div class="xq_left">
         <div class="xq_left_dq"><a href="" target=""> 购书网</a> > <a href="" target=""> 图书</a> ><a href="" target="">  中小学教辅</a> > 小学一年级 </div>
         <!--book begin -->
         <div class="xq_book">
              <div class="books">
                 <div id="preview" class="spec-preview"> <span class="jqzoom"><img  src="${bookinfo.bookimg}" /></span> </div>
                  <!--缩图开始-->
                  <div class="spec-scroll"> <a class="prev"></a> <a class="next"></a>
                    <div class="items">
                      <ul>
                        <li><img alt=""  src="${bookinfo.bookimg}" onmousemove="preview(this);"></li>
                        <li><img alt=""  src="${bookinfo.bookimg}" onmousemove="preview(this);"></li>
                        <li><img alt=""  src="${bookinfo.bookimg}" onmousemove="preview(this);"></li>
                      </ul>
                    </div>
                  </div>
              </div>
              <!-- xinxi begin -->
              <div class="books_info">
                   <h1>${bookinfo.bookdetails }</h1>
                    <div class="info">
                             <dl>
                                  <dt>优&nbsp;&nbsp;惠&nbsp;&nbsp;价</dt>
                                  <dd><b class="price_s">${bookinfo.discountprice }</b><span class="red">${bookinfo.discount }</span></dd>
                             </dl>
                             <dl>
                                  <dt>定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价</dt>
                                  <dd><del>${bookinfo.discountprice }</del></dd>
                             </dl>
                             <dl>
                                  <dt>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;段</dt>
                                  <dd>
                                     <form id="form1" name="form1" method="post" action="">
                             
                                               <label>
                                                 <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" />
                                                 单期</label>
                                               <label>
                                                 <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
                                                 半年</label>
                                                 <label>
                                                 <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
                                                 全年</label>
                                    
                                     </form>
                                   </dd>
                             </dl>
                             <dl>
                                     <dt>购买数量</dt>
                                     <dd>
                                          <div class="wrap-input">
                                              <a onclick="" href="" class="btn-reduce">减少数量</a>
                                              <a onclick="" href="" class="btn-add">增加数量</a>
                                              <input onkeyup="" value="1" id="buy-num" class="text">
                                          </div>
                                     </dd>
                             </dl>
                             <dl>
                                  <dt>库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</dt>
                                  <dd><span class="red">1234</span>件</dd>
                             </dl>
                             <dl>
                                  <dt>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费</dt>
                                  <dd>￥10.00 <a href="" target="_blank" class="red">&nbsp;&nbsp;配送说明</a></dd>
                             </dl>
                       </div>
                       <!--dapei begin -->
                       <div class="dapei">
                            <div class="dapei_l">搭配可选</div>
                            <div class="dapei_r">
                                 <ul>
                                      <li>
                                           <div class="dapei_rli1"><a href="" target="_blank" ><img src="${bookinfo.bookimg}" width="72" height="86" /></a></div>
                                           <div class="dapei_rli2"><a href="" target="_blank" >${bookinfo.bookname}</a></div>
                                           <div class="dapei_rli3"><input name="checkbox1" type="checkbox" value="" class="check1"/>${bookinfo.bookprice}</div>
                                      </li>
                                       <li>
                                           <div class="dapei_rli1"><a href="" target="_blank" ><img src="${bookinfo.bookimg}" width="72" height="86" /></a></div>
                                           <div class="dapei_rli2"><a href="" target="_blank" >${bookinfo.bookname}</a></div>
                                           <div class="dapei_rli3"><input name="checkbox1" type="checkbox" value="" class="check1"/>${bookinfo.bookprice}</div>
                                      </li>
                                       <li>
                                           <div class="dapei_rli1"><a href="" target="_blank" ><img src="${bookinfo.bookimg}" width="72" height="86" /></a></div>
                                           <div class="dapei_rli2"><a href="" target="_blank" >${bookinfo.bookname}</a></div>
                                           <div class="dapei_rli3"><input name="checkbox1" type="checkbox" value="" class="check1"/>${bookinfo.bookprice}</div>
                                      </li>
                                    
                                 </ul>
                            </div>
                       </div>
                       <!--dapei end -->
                       <div class="book_but">
                            <div class="book_but1">
                            <c:if test="${bq!=1 }">
                            <a href="<%=basePath%>User_myStoreAdd?bookid=${bookinfo.bookid }&back=1">加入收藏夹</a>
                            </c:if>
                            <c:if test="${bq==1 }">
                            <a href="">已收藏</a>
                            </c:if>
                            </div>
                            <div class="book_but2"><a href="<%=basePath%>ShoppingCarServlet?bookid=${bookinfo.bookid}">加入购物车</a></div>
                       </div>
              </div>
              <!-- xinxi end -->
              
         </div>
        <!--book end -->
         <div class="book_xq">
              <div class="book_xq_t">商品详情</div>
              <div class="book_xq_b">${bookinfo.bookdetails}
              </div>
         </div>
         <!--book 详情 end -->
         <!--pinglun begin -->
          <div class="evaluate">
               
                <div class="evaluate_2">
                       <span class="more"><a href="">查看全部评论>></a></span>
                       <ul class="tabbtn_3" id="normaltab_3">
                            <li class="current"><a href="">全部(${comments.size() })</a></li>
                            <li><a href="">好评(${comments.size() })</a></li>
                            <li><a href="">中评(0)</a></li>
                            <li><a href="">差评(0)</a></li>
                            <li><a href="">追评(0)</a></li>
                        
                        </ul><!--tabbtn end-->
                   
                            </div><!--tabcon end-->
                         <!-- ----------------------------------------- -->  
                         <!-- -------------------好评开始---------------------- -->  
                            <div class="sublist_3">
                                
                                       <ul style="padding-bottom:20px;">
                                       <c:forEach var="comment" items="${comments}">
                                      <li>
                                           <div class="people_pic">
                                               <img src="">
                                               <p>${comment.userinfo.userid}</p>
                                           </div>
                                           <div class="pl_txt">
                                                <div class="pl_txt_1"><img src="<%=basePath %>customer/images/star5.jpg" width="68" height="13" /></div>
                                                <div class="pl_txt_2">
                                                     <p>心得：<b>${comment.content }</b></p>
                                                     <p style="text-indent:3em;">${comment.commenttime }</p>
                                                     <p style="text-indent:3em;"></p>
                                                    
                                                </div>
                                                
                                           </div>
                                      </li>
                                    </c:forEach>
                                  </ul>

                            </div><!--tabcon end-->
                            <!-- -------------------好评结束---------------------- --> 
                            <!-- -------------------差评结束---------------------- -->
                            <!-- -------------------追评开始---------------------- -->

                            <!-- -------------------追评结束---------------------- -->
                        </div><!--tabbox end-->
                   </div> 
                   <script type="text/javascript" src="js/jquery.tabso_yeso.js"></script>    
                        <script type="text/javascript">
                      $(document).ready(function($){
                          //默认选项卡切换
                          $("#normaltab_3").tabso({
                              cntSelect:"#normalcon_3",
                              tabEvent:"mouseover",
                              tabStyle:"normal"
                          });
                          
                      });
                      </script>             
           </div>           
         <!--pinglun end --> 
    </div>
    <!--left end -->
    
    <!--right begin -->
    <div class="xq_right">
         <!--hot begin -->
         <div class="hot_books">
             <div class="hot_books_t">热销排行</div>
             <div class="hot_books_b">
                  <ul>
                      <li>
                           <div class="p-img"><a href="" title="" target="_blank"><img src="images/xq_pic.jpg" width="100" height="100" /></a></div>
                           <div class="p-name"><a href="" title="" target="_blank">普鲁士勒绘本典藏（套装共6册）</a></div>
                           <div class="p-price">
                                <strong>￥25.6</strong>
                                <span class="zhe">[7.5折]</span>
                           </div>
                       </li>
                       
                  </ul>
             </div>
         </div>
         <!--hot end -->
          <!--other begin -->
         <div class="hot_books">
             <div class="hot_books_t">购买本书的还买了</div>
             <div class="hot_books_b">
                  <ul>
                      <li>
                           <div class="p-img"><a href="" title="" target="_blank"><img src="images/xq_pic.jpg" width="100" height="100" /></a></div>
                           <div class="p-name"><a href="" title="" target="_blank">普鲁士勒绘本典藏（套装共6册）</a></div>
                           <div class="p-price">
                                <strong>￥25.6</strong>
                                <span class="zhe">[7.5折]</span>
                           </div>
                       </li>
                       
                       
                  </ul>
             </div>
         </div>
         <!--other end -->
    </div>
    <!--right end -->
</div>
<!--container end -->
<!--footer begin -->
<div class="footer">
     <div class="footer_t">
          <ul>
        	<li>
				<a href=""><img src="<%=basePath %>customer/images/f1.jpg" width="130"
						height="52" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/f2.jpg" width="130"
						height="52" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/f3.jpg" width="130"
						height="52" /></a></li>
				<li><a href=""><img src="<%=basePath %>customer/images/f4.jpg" width="130"
						height="52" /></a>
				</li>
						
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
