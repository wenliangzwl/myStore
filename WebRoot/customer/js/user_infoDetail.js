
/*==================================================*/


/*function setblank(obj) {
	obj.value = "";
}*/

/*==================================================*/

function checkMyfile(obj){
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v =="") {
		res = "<span class='err' >*请上传图片 </span>";
		//^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))(.jpg|.JPG|.gif|.GIF)$
	}else if(/^(([a-zA-Z]:)|(\\{2}\w+)\$?)((\\(([\一-\w]|\w[\w]).*))|(\\(\w[\w].*)))|([a-zA-Z]\w+)+(.jpg|。bmp|.JPG|.gif|.Gif|.png|。jpeg)$/.test(v)!=true) {
		res = "<span class='err' >*jpg/bmp/JPG/gif/Gif/png/jpeg类型图片!</span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_uploadfile").innerHTML = res;	
}
function checkNickname(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v =="") {
		res = "<span class='err' >*请填写昵称 </span>";
	}else if(/[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}/.test(v)!=true) {
		res = "<span class='err' >*必须2~10位汉字/字母/数字!</span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_nicheng").innerHTML = res;
	return flag;
}

function checkRealname(obj) {
	
var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写真实姓名 </span>";
	}else if(/^[\u4e00-\u9fa5]{2,7}/.test(v)!=true) {
		res = "<span class='err' >*昵称 必须2~7位汉字！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}	document.getElementById("oppend_realname").innerHTML = res;
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

function checkPhone(obj) {
	
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写电话号码或手机号码 </span>";
	}else if(/^(\d{3,4}-)?(\d{7,8})$|(1[0-9]{10})/.test(v)!=true) {
		res = "<span class='err' >*请正确填写号码！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_phone").innerHTML = res;
	return flag;
}

function checkQQ(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写QQ号码 </span>";
	}else if(/^\d{5,11}$/.test(v)!=true) {
		res = "<span class='err' >*请正确填写qq号码！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_qq").innerHTML = res;
	return flag;
	
	
}

function checkSchool(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写学校名称 </span>";
	}else if(/[\u4E00-\u9FA5]{2,15}/g.test(v)!=true) {
		res = "<span class='err' >*学校名称至少2位，最多15位！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
	
}
	document.getElementById("oppend_school").innerHTML = res;

	return flag;
	
	
}

function checkClassname(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写班级名称 </span>";
	}else if(/[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}/.test(v)!=true) {
		res = "<span class='err' >*班级名称至少2位，最多10位！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_class").innerHTML = res;
	return flag;
	
}

function checkHobby(obj) {
	var v = obj.value;
	var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写兴趣 </span>";
	}else if(/[\u4E00-\u9FA5]{2,15}/g.test(v)!=true) {
		res = "<span class='err' >*兴趣 填写最少至少2位，最多15位！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_aihao").innerHTML = res;
	return flag;
	
	
	
}

function checkIntroduction(obj) {
	var v = obj.value;
		var res = "";
	var flag = false;
	if(v == "") {
		res = "<span class='err' >*请填写自我介绍 </span>";
	}else if(/[\u4E00-\u9FA5]{2,15}/g.test(v)!=true) {
		res = "<span class='err' >*自我介绍  填写最少至少2位，最多15位！ </span>";
	} else {res = "<span class='ok'>正确！</span>";
	flag = true;
}
	document.getElementById("oppend_jieshao").innerHTML = res;
	return flag;
	
}


function checkform(){
	var flag1=checkNickname(obj);
	var flag2=checkRealname(obj);
	var flag3=checkEmail(obj);
		var flag4=checkPhone(obj);
	var flag5=checkQQ(obj);
	var flag6=checkSchool(obj);
		var flag7=checkClassname(obj);
	var flag8=checkHobby(obj);
	var flag9=checkIntroduction(obj);
	var flag10=checkMyfile(obj);
if(flag1 &&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9&&flag10){		
    return true;
}else return false;	
	
}
