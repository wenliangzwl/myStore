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
	}else if(/[a-zA-Z0-9_\u4e00-\u9fa5]{2,18}/.test(v)!=true) {
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
function checkAll(){
	var flag1=checkNickname(obj);
	var flag2=checkpwd(obj);	
if(flag1 &&flag2){		
    return true;
}else return false;	
	
}
