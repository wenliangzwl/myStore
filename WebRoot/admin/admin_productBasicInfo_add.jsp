<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>慧慧网综合管理平台</title>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>admin/css/style.css">
<script type="text/javascript"
	src="<%=basePath%>admin/js/jquery.min.js"></script>
<script src="<%=basePath%>admin/js/admincomm.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>admin/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>admin/css/adminInnerComm.css">
<script type="text/javascript"
	src="<%=basePath%>admin/js/admininnerComm.js"></script>

<link href="<%=basePath%>admin/css/swfupload-default.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>admin/js/handlers.js"></script>
<script type="text/javascript"
	src="<%=basePath%>admin/js/jquery-latest.js"></script>
<script type="text/javascript" src="<%=basePath%>admin/js/swfupload.js"></script>

</head>

<script type="text/javascript">
	var contextPath = "/bookStores";
	function startLoad() {
		var url = contextPath + "Admin_ProductBasicInfo_AddServlet";
		var sizeLimit = "1 MB"; // 文件的大小  注意: 中间要有空格
		var types = "*.jpg;*.jpeg;*.gif;*.png"; //注意是 " ; " 分割 
		var typesdesc = "web iamge file"; //这里可以自定义
		var uploadLimit = 20; //上传文件的 个数
		initSwfupload(url, sizeLimit, types, typesdesc, uploadLimit);
	}

	function fg() {
		document.getElementById("yu").style.display = "";
		document.getElementById("yu2").style.display = "";
		document.getElementById("yu3").style.display = "";
		document.getElementById("yu4").style.display = "";
		document.getElementById("yu5").style.display = "";
		document.getElementById("yu6").style.display = "";
		document.getElementById("yu7").style.display = "";
		document.getElementById("yu8").style.display = "";
		document.getElementById("yu9").style.display = "";
		//document.getElementById("po3").style.display="";
		//document.getElementById("po2").style.display="none";
		document.getElementById("po1").style.display = "none";
		document.getElementById("po").style.display = "none";

	}
	function fg1() {
		document.getElementById("yu").style.display = "none";
		document.getElementById("yu2").style.display = "none";
		document.getElementById("yu3").style.display = "none";
		document.getElementById("yu4").style.display = "none";
		document.getElementById("yu5").style.display = "none";
		document.getElementById("yu6").style.display = "none";
		document.getElementById("yu7").style.display = "none";
		document.getElementById("yu8").style.display = "none";
		document.getElementById("yu9").style.display = "none";
		//document.getElementById("po2").style.display="";
		//document.getElementById("po3").style.display="none";
		document.getElementById("po1").style.display = "";
		document.getElementById("po").style.display = "";
	}
</script>
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
			<div class="user_nav_r"></div>
		</div>
	</div>
	<div class="user_top_l">
		欢迎您，${sessionScope.assorter_right.adminname}&nbsp;&nbsp;&nbsp;
		<a href="<%=basePath%>Admin_ExitServlet">退出系统</a> 
		
	</div>

	<!-------------------------------------头部End-------------------------------------------------------->
	<div class="user_cont">
		<!--left begin -->
		<div class="user_cont_left" style="height: 630px;clear: left;">
			 <dl>
                   <dt>供应商商品信息管理</dt>
                   <dd class="active"><a href="<%=basePath %>AdminRedirectPageServlet?pageno=1">商品基本信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=2">商品评论信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=3">促销商品信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=4">商品审核管理</a></dd>
               </dl>
                 <dl>
                   <dt>合同管理</dt>                                                       
               </dl>
               <dl>
                   <dt>商品订单管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=5">商品订单状态查询管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=6">商品销售额查询管理</a></dd>
               </dl>
               <dl>
                   <dt>系统管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=7">系统日志信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=8">短信信息消息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=9">供应商管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=10">密码管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=11">广告管理</a></dd>
               </dl>
               <dl>
                   <dt>积分兑换商品管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=12">积分兑换商品信息管理</a></dd>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=13">积分兑换记录信息管理</a></dd>                 
               </dl>
               <dl style="">
                   <dt>会员管理</dt>
                   <dd><a href="<%=basePath %>AdminRedirectPageServlet?pageno=14">会员信息管理</a></dd>                                    
               </dl>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".user_cont_left dl dt").click(function() {
					$(this).siblings().slideToggle("slow");
					$(this).toggleClass("jia");
					return false;
				});

			});
		</script>
		<!--left end -->
		<!--right begin -->
		<div class="user_cont_right">
			<div class="user_lmt">
				<div class="user_lmt1">
					当前位置》<a href="">首页</a>》<a href=""> </a>》商品基本信息管理》商品添加
				</div>

			</div>
			<div class="user_coment" style="height: 550px">
				<!--添加商品-->
				<!----------------------------------------------------------------------------------->

				<!--新建Bug-->
				<form style="" name="form1" action="<%=basePath%>Admin_ProductBasicInfo_AddServlet" method="post"
					enctype="multipart/form-data">
					<table style="" align="center" border="0" cellpadding="0"
						cellspacing="0" width="100%">
						<tbody style="">
							<tr style="">
								<td style="" valign="top">
									<!--Bug表单-->
									<table style="font-size: 13px;" align="center" border="0"
										cellpadding="2" cellspacing="2" width="100%">
										<!--提示信息-->
										<tbody style="">
											<tr bgcolor="#1196EE">
												<td colspan="2"
													style="font-size: 14px; font-weight: bold; padding-left: 10px"
													height="30">添加商品 &nbsp;&nbsp;&nbsp;</td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">操作人</td>
												<td bgcolor="#e4e4e4"><input type="text" name="adminname" id=""value="${sessionScope.assorter_right.adminname}" /></td>
											</tr>
											<tr id="po">
												<td id="po" align="center" bgcolor="#e4e4e4">商品价格</td>
												<td id="po" bgcolor="#e4e4e4"><input name="bookprice"
													onblur="hk0()" id="cf0" type="text">&nbsp; <font
													id="x0" style="position: absolute" color="gray" size="2">*填写商品的售价</font>
												</td>
											</tr>
											<tr id="po">
												<td id="po" align="center" bgcolor="#e4e4e4">商品折扣价</td>
												<td id="po" bgcolor="#e4e4e4"><input name="bookprice"
													onblur="hk0()" id="cf0" type="text">&nbsp; <font
													id="x0" style="position: absolute" color="gray" size="2">*填写商品的折扣价</font>
												</td>
											</tr>

											<tr>
												<td align="center" bgcolor="#e4e4e4">商品名称</td>
												<td bgcolor="#e4e4e4"><textarea rows="3" cols="30"
														name="bookname" onblur="hk5()" id="cf5"></textarea> &nbsp;<font
													id="x5" style="position: absolute" color="gray" size="2">*请填写此商品的名称</font>
												</td>
											</tr>
											<tr>

												<td align="center" bgcolor="#e4e4e4">上传商品图片</td>
												<td bgcolor="#e4e4e4" width="60%" height="25">
													<input type="file" name="myfile" id="" value="选择图片上传" />
												</td>
											</tr>




											<tr id="po1">

												<td align="center" bgcolor="#e4e4e4">商品类型</td>
												<td bgcolor="#e4e4e4"><select name="btype1"
													onchange="btype()">														
														<option value="23">教育</option>
														<option value="24">工具书</option>
														<option  value="25">期刊</option>														
														<option value="7">教材</option>
														<option value="8">外语考试</option>
														<option value="9">中小学教辅</option>
														<option value="10">汉语工具书</option>
														<option value="11">英语工具书</option>
														<option value="12">其他语种工具</option>
														<option value="13">百科全书</option>
														<option value="14">文学鉴赏</option>
														<option value="15">辞典</option>
														<option value="16">牛津系列</option>
														<option value="17">朗文系列种工具</option>
														<option value="18">民族语工具书</option>
														<option value="19">英文原版书</option>
														 <option value="26">期刊</option>
														
													
												</select> 


														<font id="x13" style="position: absolute" color="gray" size="2">*请选择商品所属的类型</font>
								</td>
											</tr>


											
											<tr>
												<td align="center" bgcolor="#e4e4e4">商品适合的年级</td>
												<td bgcolor="#e4e4e4"><select name="grade"
													onblur="hk11()" id="cf11">
														<option value="">-请选择-</option>
														<option value="1">一年级</option>
														<option value="2">二年级</option>
														<option value="3">三年级</option>
														<option value="4">四年级</option>
														<option value="5">五年级</option>
														<option value="6">六年级</option>
														<option value="20">小学</option>
														<option value="21">初中</option>
														<option value="22">高中</option>
													    <option value="27">初中一年级</option>
														<option value="28">初中二年级</option>
														<option value="29">初中三年级</option>
														<option value="30">高中一年级</option>
														<option value="31">高中二年级</option>
														<option value="32">高中三年级</option>
														

												</select>&nbsp; <font id="x11" style="position: absolute"
													color="gray" size="2">*请选择商品适用的年级</font></td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">作者</td>
												<td bgcolor="#e4e4e4"><input name="auth"
													onblur="hk14()" id="cf14" type="text">&nbsp; <font
													id="x14" style="position: absolute" color="gray" size="2">*请填写此商品的作者</font>
												</td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">出版社</td>
												<td bgcolor="#e4e4e4"><input name="chubanshe"
													onblur="hk15()" id="cf15" type="text">&nbsp; <font
													id="x15" style="position: absolute" color="gray" size="2">*请填写出版此商品的出版时间</font>
												</td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">出版时间</td>
												<td bgcolor="#e4e4e4"><input name="date"
													class="tcal tcalInput" value="" onblur="hk16()" id="cf16"
													style="background-color: white" type="text">&nbsp;
													<font id="x16" style="position: absolute" color="gray"
													size="2">*请填写此商品的出版时间</font></td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">条形码</td>
												<td bgcolor="#e4e4e4"><input name="isbn" onblur="hk6()"
													id="cf6" type="text">&nbsp; <font id="x6"
													style="position: absolute" color="gray" size="2">*请填写此商品的条形码</font>
												</td>
											</tr>
											<tr>
												<td align="center" bgcolor="#e4e4e4">积分抵用数</td>
												<td bgcolor="#e4e4e4"><input name="duihuan"
													onblur="hk7()" id="cf7" type="text">&nbsp; <font
													id="x7" style="position: absolute" color="gray" size="2">*请填写购买此商品可以抵用的积分（10积分抵1元），不填表示不参与积分兑换</font>
												</td>
											</tr>



											<td style="" colspan="2" bgcolor="#e4e4e4"><textarea
													name="bookdetails" style="width: 100%; height: 75px; "> 
			  请在此处描述此书的详细信息
					    </textarea></td>

											</tr>
											<tr>
												<td colspan="2" align="center" bgcolor="#e4e4e4"><input
													name="tijiao" value="保存 " onclick="return oncheck()"
													type="submit"> &nbsp;&nbsp; <input name="tijiao"
													value=" 返回 " onclick="history.back();" type="button">
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</form>



				<!----------------------------------------------------------------------------------->


			</div>


		</div>


		<!--right end -->
	</div>

	<div class="footer_m mar38" style="margin-top：40px;margin-bottom: 10px">
		<div class="footer_nav"></div>
		<div class="footer_copyright" style="margin-top: 80px;">
			<a href="" target="_blank">关于慧慧网</a>&nbsp;| &nbsp;<a href=""
				target="_blank">联系我们</a>&nbsp;| &nbsp;<a href="" target="_blank">人才招聘</a>&nbsp;|
			&nbsp;<a href="" target="_blank">广告服务</a>&nbsp;| &nbsp;<a href=""
				target="_blank">友情链接</a>&nbsp;| &nbsp;<a href="" target="_blank">销售联盟</a>&nbsp;|
			&nbsp;<a href="" target="_blank">慧慧网简介</a><br>
			<br> 网络文化经营许可证鄂网文[2015]0278-060号 Copyright © 2015-2018 版权所有
		</div>
	</div>



</body>