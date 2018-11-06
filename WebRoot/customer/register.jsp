


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<META charset="UTF-8"><TITLE>慧慧购书网-用户注册页面</TITLE>
<META name="keywords" content="用户注册">
<META name="content" content="用户注册">
<META content="IE=edge, chrome=1" http-equiv="X-UA-Compatible">
<LINK rel="stylesheet"type="text/css" href="<%=basePath %>customer/css/login.css">
    <style type="text/css">
.err{
	color:red;
}
.ok{
	color:green;
}
</style>
<script src="<%=basePath %>js/register.js" type="text/javascript" charset="utf-8"></script>
<SCRIPT>
    	function a(){
			if(f.nickname.value =="用户账号"){
				f.nickname.value ="";}
				}
		function b(){
			if(f.email.value =="邮箱"){
				f.email.value ="";}
				}
		function c(){
			if(f.pwd.value =="密码"){
				f.pwd.value ="";}
				}
		function d(){
			if(f.repwd.value =="重复密码"){
				f.repwd.value ="";}
				}		
    </SCRIPT>

<META name="GENERATOR" content="MSHTML 9.00.8112.16684"></HEAD>
<BODY class="login_bj">
<DIV class="zhuce_body">
<DIV class="logo"><A href="<%=basePath %>index.jsp">
<P style="font-size: 22px;" width="180" height="54">慧慧购书网</P></A></DIV>
<DIV class="zhuce_kong">
<DIV class="zc">
<DIV class="bj_bai">
<H3>欢迎注册</H3>
<FORM id="f" method="post" action="<%=basePath %>UserRegisterServlet" onsubmit="return checkform()">
	<INPUT class="kuang_txt phone" onfocus="a()" name="nickname" value="用户账号" type="text"onblur="checkNickname(this)">
	<span id="oppend_nicheng" > 	    </span>
	<INPUT class="kuang_txt email" onfocus="b()" name="email" value="邮箱" type="text"onblur="checkEmail(this)">
	<span id="oppend_email" > 	    </span>
	<INPUT class="kuang_txt possword" onfocus="c()" name="pwd" value="密码" type="text"onblur="checkpwd(this)">
	<span id="oppend_pwd" > 	    </span>
	<INPUT class="kuang_txt possword" onfocus="d()" name="repwd" value="重复密码" type="text"onblur="checkpwd2(this,pwd)">
<span id="oppend_pwd2" > 	    </span>
<DIV><INPUT value="" type="checkbox"><SPAN>已阅读并同意<A href="<%=basePath %>index.jsp" 
target="_blank"><SPAN class="lan">《慧慧购书网用户注册协议》</SPAN></A></SPAN></DIV>
<INPUT class="btn_zhuce" name="注册" value="注册" type="submit">
</FORM></DIV>
<DIV class="bj_right">
<P>使用以下账号直接登录</P><A class="zhuce_qq" href="<%=basePath %>customer/register.jsp">QQ注册</A><A 
class="zhuce_wb" href="<%=basePath %>customer/register.jsp">微博注册</A><A 
class="zhuce_wx" href="<%=basePath %>customer/register.jsp">微信注册</A>
<P>已有账号？<A href="<%=basePath %>customer/login.jsp">立即登录</A></P></DIV></DIV></DIV>
<DIV style="text-align: center;"></DIV></DIV></BODY></HTML>
