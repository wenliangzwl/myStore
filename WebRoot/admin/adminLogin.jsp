<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/adminLogin.css" />
		<style type="text/css">
		a:hover{
			text-decoration: underline;
			background-color: cornflowerblue;
		}
		a{text-decoration: none;}
	</style>
	</head>

	<body>

		<div id="body">

			<div id="head">
			
				慧慧网综合管理平台
			</div>

			<div id="adminlogin">

				<form name="myform" action="<%=basePath %>AdminLoginServlet" method="post" onsubmit=" ">

					<table id="fm" align="center" border="0" cellspacing="" cellpadding="0px">
						<tr>
							<td class="formhead" colspan="2">
								<div id="thead">用户登录
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="td1">
									用户名
								</div>
							</td>
							<td>
								<div class="td2">
									<input type="text" name="username" id=""class="text" value="" onfocus=" " onblur=" " />
								</div>
							</td>

						</tr>
						<tr>
							<td>
								<div class="td1">
									密码
								</div>
							</td>
							<td>
								<div class="td2">
									<input type="password" name="password" value="" onblur="checkPwd_01()" class="text"/>
								</div>
							</td>

						</tr>
						<tr>
							<td colspan="0">
								<div class="loginbutton">
									<input type="image" src="<%=basePath %>admin/img/loginbuttons.png"  class="buttonimg"/></div></td>
						<td><div class="td1" ><a href="<%=basePath %>IndexServlet">返回首页</a></div>			</td>
								

							

						</tr>
						<tr>
							
								
								
								
							
							
							</tr>
							

					</table>

				</form>
			</div>

		</div>

	</body>

</html>