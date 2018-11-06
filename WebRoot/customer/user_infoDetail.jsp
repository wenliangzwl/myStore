<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人档案</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>customer/css/style.css" />
<script type="text/javascript" src="<%=basePath %>customer/js/jquery.min.js"></script>
<script src="<%=basePath %>customer/js/user_infoDetail.js" type="text/javascript" charset="utf-8"></script>
<script language="javascript">
function nowtime()
{//年月日三级联动
var da,ny,nm,nd;
da = new Date();
ny = da.getYear();
nm = da.getMonth();
nd = da.getDate();
document.form1.year2.value = ny;
document.form1.month2.value = nm+1;
document.form1.day2.value = nd;
}
</script>
<style type="text/css">
.err{
	color:red;
}
.ok{
	color:green;
}
</style>
</head>

<body>

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
                   <dd  class="active"><a href="<%=basePath %>customer/user_infoDetail.jsp">个人档案</a></dd>
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
                    <div class="user_lmt1">个人档案</div>
                   
           </div>
           
           <form style="" name="form1" action="<%=basePath%>User_infoDetail_UpdateServlet" method="post"
					enctype="multipart/form-data" onsubmit="return checkform()">
           <div class="user_coment">
               <div class="gr_wap">
                   <p class="gr_ts">亲爱的&nbsp;<b>${sessionScope.userinfo.nickname}</b>，请填写真实的资料</p>
                   <dl>
                       <dt>当前头像：</dt>
                       <dd>
                         <div class="pic_head"><img src="${sessionScope.userinfo.picture}" width="88" height="87" /></div>
                         <div class="pic_choice">
                               <p class="pic_choice1">
                                   请从您的电脑中上传图片作为头像：
                                   <span class="gray">(建议尺寸96*96像素，300k以内)</span>
                               </p>
                           <p class="browse_mypic">
                                   <input type="file" name="Myfile" id="uploadfile" size="36" maxlength="30" onchange="checkMyfile(this)" onclick="checkMyfile(this)" onkeydown="checkMyfile(this)" style="height:21px; width:290px; font-size:12px; padding-top:3px; float:left;" />
                             
                                 <input type="hidden" name="hid_opt" id="hid_opt" value="${sessionScope.userinfo.userid}"/>
                                  <input onclick="" name="btnUpload" type="button" id="btnUpload" class="browse_button" Height="20px" value="上传" disabled="disabled" />
                               </p>
                           
                           
                            </div>
                            
                     </dd>
                      <dd> <p><span id="oppend_uploadfile"> 	   </span></p>  </dd>
                   </dl>
                  
                   <dl>
                       <dt><span class="red">*</span>昵称：</dt>
                       <dd><input name="nicheng" type="text" class="nicheng" value="${sessionScope.userinfo.nickname}" onfocus="setblank(this)"onblur="checkNickname(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_nicheng" > 	    </span>
                       </dd>
                   </dl>
                   <dl>
                       <dt><span class="red">*</span>身份：</dt>
                       <dd>
                               <label>
                                 <input type="radio" name="RadioGroup1" value="在校学生" id="RadioGroup1_0" checked="checked"/>
                                 在校学生</label>
                          
                               <label>
                               <input type="radio" name="RadioGroup1" value="教师" id="RadioGroup1_1" />
                                 教师</label>
                         <label>  <input type="radio" name="RadioGroup1" value="上班族" id="RadioGroup1_2" /> 上班族</label>
                        <label>   <input type="radio" name="RadioGroup1" value="自由职业" id="RadioGroup1_3" /> 自由职业</label>
 
                       </dd>
                   </dl>
                   <dl>
                     <dt><span class="red">*</span>真实姓名：</dt>
                       <dd><input name="realname" type="text" class="realname" value="${sessionScope.userinfo.username}"onfocus=" setblank(this)"onblur="checkRealname(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_realname" > 	    </span>
                       </dd>
                   </dl>
                   <dl>
                       <dt>性别：</dt>
                       <dd>

                               <label>
                                 <input type="radio" name="RadioGroup2" value="男" id="RadioGroup2_0" checked="checked"/>男</label>
                      
                               <label>
                                 <input type="radio" name="RadioGroup2" value="女" id="RadioGroup2_1" />女</label>
                       </dd>
                   </dl>
                   <dl>
                     <dt>EMAIL：</dt>
                       <dd><input name="email" type="text" class="realname" value="${sessionScope.userinfo.email}"onfocus=" setblank(this)"onblur="checkEmail(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_email" > 	    </span>
                       </dd>
                   </dl>
                   <dl>
                       <dt><span class="red">*</span>电话：</dt>
                       <dd><input name="phone" type="text" class="realname"value="${sessionScope.userinfo.phone}"onfocus=" setblank(this)"onblur="checkPhone(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_phone" > 	    </span>
                       </dd>
                   </dl>
                   <dl>
                       <dt>QQ：</dt>
                       <dd><input name="qq" type="text" class="realname"value="${sessionScope.userinfo.qq}"onfocus=" setblank(this)"onblur="checkQQ(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_qq" > 	    </span>
                       </dd>
                          
                   </dl>
                   <dl>
                       <dt>学校：</dt>
                       <dd><input name="school" type="text" class="realname"value="${sessionScope.userinfo.school}"onfocus=" setblank(this)"onblur="checkSchool(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_school" > 	    </span>
                       </dd>
                      
                   </dl>
                   <dl>
                       <dt>班级：</dt>
                       <dd><input name="class" type="text" class="realname" value="${sessionScope.userinfo.classname}"onfocus=" setblank(this)"onblur="checkClassname(this)"/>
                       &nbsp;  &nbsp; &nbsp;<span id="oppend_class" > 	    </span>
                       </dd>
                    
                   </dl>
                   <dl>
                       <dt>生日：</dt>
                       <dd>
                            <select name="year2" >     
                                <option value="1990" selected="selected">1990</option>
                                <option value="1991">1991</option>
                                <option value="1992">1992</option>
                                <option value="1993">1993</option>
                                <option value="1994">1994</option>
                                <option value="1995">1995</option>
                                <option value="1996">1996</option>
                                <option value="1997">1997</option>
                                <option value="1998">1998</option>
                                <option value="1999">1999</option>
                                <option value="2000">2000</option>
                                <option value="2001">2001</option>
                                <option value="2002">2002</option>
                                <option value="2003">2003</option>
                                <option value="2004">2004</option>
                                <option value="2005">2005</option>
                                <option value="2006">2006</option>
                                <option value="2007">2007</option>
                                <option value="2008">2008</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                                <option value="2013">2013</option>
                                <option value="2014">2014</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                              </select>
               
                              <select name="month2">
                           
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8" selected="selected">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                              </select>
                        
                              <select name="day2">
                           
                                <option value="1">1</option>
                                <option value="2" >2</option>
                                <option value="3" >3</option>
                                <option value="4" >4</option>
                                <option value="5" >5</option>
                                <option value="6" >6</option>
                                <option value="7" >7</option>
                                <option value="8" >8</option>
                                <option value="9" >9</option>
                                <option value="10" selected="selected">10</option>
                                <option value="11" >11</option>
                                <option value="12" >12</option>
                                <option value="13" >13</option>
                                <option value="14" >14</option>
                                <option value="15" >15</option>
                                <option value="16" >16</option>
                                <option value="17" >17</option>
                                <option value="18" >18</option>
                                <option value="19" >19</option>
                                <option value="20" >20</option>
                                <option value="21" >21</option>
                                <option value="22" >22</option>
                                <option value="23" >23</option>
                                <option value="24" >24</option>
                                <option value="25" >25</option>
                                <option value="26" >26</option>
                                <option value="27" >27</option>
                                <option value="28" >28</option>
                                <option value="29" >29</option>
                                <option value="30" >30</option>
                                <option value="31" >31</option>
                                
                              </select>
                              <span class="gray">出生年份为保密</span>
                  <script language="Javascript">
                  if (this.form1.month2!="")
                  {nowtime()}
                  </script>
                       </dd>
                   </dl>
                   <dl>
                       <dt><span class="red">*</span>居住地：</dt>
                       <dd>
                            <div>
                                  <select id="s_province" name="s_province" class="selects" value="${sessionScope.userinfo.province}"></select>  
                                  <select id="s_city" name="s_city" class="selects" value="${sessionScope.userinfo.city}"></select>  
                                  <select id="s_county" name="s_county" class="selects" value="${sessionScope.userinfo.qu}"></select>
                                  <script class="resources library" src="js/area.js" type="text/javascript"></script>
                                  
                                  <script type="text/javascript">_init_area();</script>
                              </div>
                              <div id="show"></div>
                               <script type="text/javascript">
                                      var Gid  = document.getElementById ;
                                      var showArea = function(){
                                          Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
                                          Gid('s_city').value + " - 县/区" + 
                                          Gid('s_county').value + "</h3>"
                                                                  }
                                     // Gid('s_county').setAttribute('onchange','showArea()');
                              </script>
                       </dd>
                   </dl>
                   <dl>
                       <dt>兴趣爱好：</dt>
                       <dd><textarea name="aihao" cols="" rows="" class="aihao" placeholder="不同项目之间用空格分开，例如“旅行 阅读 瑜伽" onfocus=" setblank(this)"onblur="checkHobby(this)">${sessionScope.userinfo.hobby}</textarea></dd>
                   <dd >  <span id="oppend_aihao"> 	     </span></dd>
                   </dl>
                   <dl>
                       <dt>自我介绍：</dt>
                       <dd><textarea name="jieshao" cols="" rows="" class="jieshao" placeholder=""onfocus=" setblank(this)"onblur="checkIntroduction(this)">${sessionScope.userinfo.introduce}</textarea></dd>
                   <dd >  <span id="oppend_jieshao"> 	   </span></dd>
                   </dl>
                   <dl>
                       <dt></dt>
                       <dd><input name="save_xx" type="submit" class="save_xx" value="保存基本信息"/></dd>
                     
                   </dl>
               </div>
           </div>
           </form>
          <!-- ------------------------- --> 
           
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
