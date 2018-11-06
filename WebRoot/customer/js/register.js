/*function setblank(obj) {
	obj.value = "";
}
*/
function checkNickname(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v =="") {
		res = "<span class='err' >*请填写用户名 </span>";
	}else if(/[a-zA-Z0-9_\u4e00-\u9fa5]{2,8}/.test(v)!=true) {
		res = "<span class='err' >*必须2~8位汉字/字母/数字!</span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_nicheng").innerHTML = res;
	return flag;
}

function checkpwd(obj){
		var v = obj.value;
	var res = "";
	var flag = false;
	if(v =="") {
		res = "<span class='err' >*请填写密码 </span>";
	}else if(/[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}/.test(v)!=true) {
		res = "<span class='err' >*必须2~10位汉字/字母/数字!</span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_pwd").innerHTML = res;
	return flag;	
}
function checkpwd2(obj1,obj2){
		var v = obj1.value;
		var v2=obj2.value;
	var res = "";
	var flag = false;
	if(v =="") {
		res = "<span class='err' >*密码不能为空 </span>";
	}else if(!v.equals(v2)){
		res="<span class='err' >*两次输入的密码不一致 </span>";
	}else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_pwd2").innerHTML = res;
	return flag;	
}
function checkEmail(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写Email地址 </span>";
	}else if( /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(v)!=true) {
		res = "<span class='err' >*请正确填写Email地址！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}obj.value=v;
	document.getElementById("oppend_email").innerHTML = res;
	return flag;
	
}
function checkform(){
	var flag1=checkNickname(obj);
	var flag2=checkpwd(obj);
	var flag3=checkpwd2(obj);	
	var flag4=checkEmail(obj);	
	
if(flag1 &&flag2&&flag3&&flag4){		
    return true;
}else return false;	
	
}
