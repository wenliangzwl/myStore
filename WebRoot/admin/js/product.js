
 

var y0=false;
var y=false;
var y2=false;
var y3=false;
var y4=false;
var y5=false;
var y6=false;
var y7=true;
var y8=false;
var y9=false;
var y10=false;
var y11=false;
var y12=false;
var y13=false;
var y14=false;
var y15=false;
var y16=false;
function hk6(){
		var isbn =document.getElementById("cf6").value;
		
		var TF = false;
		var vaa = "";
		var test=0;
		var array = isbn.split("");
		if(isbn!=null&&isbn.length>0){
			for(var j=0;j<isbn.length;j++){
				if("-"==isbn[j]){
					test = parseFloat(test)+ parseFloat(1);
				}
			}
			if(test==0||test==3&&isbn.length==13||test==4&&isbn.length==17){
				var va = isbn.split("-");
			for(var i=0;i<va.length;i++){
				vaa = vaa.concat(va[i]);
			}
			var vb = vaa.split("");
			var shuzi = new Array("1","2","3","4","5","6","7","8","9","0","X");
			var abc = 0;
			for(var x =0;x<vaa.length;x++){
				for(var y=0;y<shuzi.length;y++){
					if(vb[x]==shuzi[y]){
						abc = abc+1;
					}
				}
			}			
			if(vb.length==abc){
				
				var total = 0;
				if(vaa.length==10){
					for(var x =0;x<(vb.length)-1;x++){
						total =  parseFloat(total)+ parseFloat((+(vb[x]))*(10-x));
					}
					if(vaa[9]=="X"){
						if((total+10)%11==0){
							 TF = true;
						}
					}else if((parseFloat(total)+parseFloat(vb[9]))%11==0){
								TF = true;
							}
					
				}else if(vb.length==13){
					for(var z=0;z<vaa.length-1;z++ ){
						if(z%2!=0){
							total = parseFloat(total)+parseFloat((+vb[z])*3);
						}else if(z%2==0){
							total = parseFloat(total) + parseFloat(+vb[z]);
						}
					}	
					
					var y = 10 -  total%10;
					if(y==vb[12]){
						TF = true;
					}else if(y==10&&vb[12]==0){
						TF = true;
					}
				
				
			}
			}
		}
		}	
			if(TF == true){
				document.getElementById("x6").innerHTML="正确!";
				document.getElementById("x6").style.color="#39F";		
			    y6=true;
		}else{
			if(isbn==null||isbn.length==0){
				document.getElementById("x6").innerHTML="不能为空!";
				document.getElementById("x6").style.color="red";
				 y6=false;
				
			}else{			
			document.getElementById("x6").innerHTML="请输入正确的ISBN!";
			document.getElementById("x6").style.color="red";
			 y6=false;}
			
		}
		}
	
	function hk7(){
 //document.write("错误！你没有填信息。");
		//var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var b1=document.getElementById("cf7").value;
 var b=(Math.round((b1/10)*100)/100);
 var price0=document.getElementById("cf0").value;
 var price=document.getElementById("cf").value;
 var price2=document.getElementById("cf2").value;
 var price3=document.getElementById("cf3").value;
 var price4=document.getElementById("cf4").value;
 if(price0==""&&price==""&&price2==""&&price3==""&&price4==""){
	 document.getElementById("x7").innerHTML="请先填写价格!";
	 document.getElementById("x7").style.color="red";
 }else{
 
if(b1.length!=0){
	if(patt2.test(b1)){
		if((price0!=""&&b>price0)||(price!=""&&b>price)||(price2!=""&&b>price2)||(price3!=""&&b>price3)||(price4!=""&&b>price4)){
			//alert("积分抵扣额不能大于商品价格！");
			document.getElementById("x7").innerHTML="积分抵扣额不能大于商品价格!";
			document.getElementById("x7").style.color="red";
			y7=false;
		}else{
    document.getElementById("x7").innerHTML="正确!";
    document.getElementById("x7").style.color="#39F";
    y7=true;	}
    		}else{
    document.getElementById("x7").innerHTML="格式不对!必须为不小于零的整数!";
    document.getElementById("x7").style.color="red";
    y7=false;	
    		}
	}else{
		document.getElementById("x7").innerHTML="*请填写购买此商品可以抵用的积分（10积分抵1元），不填表示不参与积分兑换";
	    document.getElementById("x7").style.color="gray";
	    y7=true;
	}
 }
}
	/*function hk8(){
 //document.write("错误！你没有填信息。");
		
 var b1=document.getElementById("cf8").value;
	if(b1.length==0){
	document.getElementById("x8").innerHTML="不能为空!";
	document.getElementById("x8").style.color="red";
	y8=false;
	}else{
	var fileName = document.form1.formfile.value;
		var type=(fileName.substr(fileName.lastIndexOf("."))).toLowerCase();		
		if(type!=""&&type!=".jpg"&&type!=".gif"&&type!=".jpeg"&& type!=".png"){
			alert("您上传图片的类型不符合(.jpg|.jpeg|.gif|.png)");
			document.getElementById("x8").innerHTML="★";
			document.getElementById("x8").style.color="red";
			y8=false;
		    }else{
		    	document.getElementById("x8").innerHTML="正确!";	
		    	document.getElementById("x8").style.color="#39F";
		y8=true
		}	
	}
}*/

	
	function hk9(){
		 //document.write("错误！你没有填信息。");
				//var patt=/^[0-9]+(.[0-9]{1,3})?$/;
				var patt2=/^[0-9]*$/;
		 var b1=document.getElementById("cf9").value;

			if(b1.length==0){
			document.getElementById("x9").innerHTML="不能为空!";
			document.getElementById("x9").style.color="red";
			y9=false;
			}else{
			if(patt2.test(b1)){
		    document.getElementById("x9").innerHTML="正确!";
		    document.getElementById("x9").style.color="#39F";
		    y9=true;	
		    		}else{
		    document.getElementById("x9").innerHTML="格式不对!必须为不小于零的整数!";
		    document.getElementById("x9").style.color="red";
		    y9=false;	
		    		}
			}
		}
	function hk10(){
		 //document.write("错误！你没有填信息。");
				var patt=/^[0-9]+(.[0-9]{1,3})?$/;
				var patt2=/^[0-9]*$/;
		 var b1=document.getElementById("cf10").value;

			if(b1.length==0){
			document.getElementById("x10").innerHTML="不能为空!";
			document.getElementById("x10").style.color="red";
			y10=false;
			}else{
			if(patt.test(b1)||patt2.test(b1)){
		    document.getElementById("x10").innerHTML="正确!";
		    document.getElementById("x10").style.color="#39F";
		    y10=true;	
		    		}else{
		    document.getElementById("x10").innerHTML="格式不对!必须为数字!";
		    document.getElementById("x10").style.color="red";
		    y10=false;	
		    		}
			}
		}
	function hk0(){
 //document.write("错误！你没有填信息。");
		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var c1=document.getElementById("cf0").value;
 

	if(c1.length==0){
	document.getElementById("x0").innerHTML="不能为空!";
	document.getElementById("x0").style.color="red";
	y0=false;
	}else{
	if(patt.test(c1)||patt2.test(c1)){
    document.getElementById("x0").innerHTML="正确!";
    document.getElementById("x0").style.color="#39F";
    y0=true;	
    		}else{
    document.getElementById("x0").innerHTML="格式不对!必须为数字!";
    document.getElementById("x0").style.color="red";
    y0=false;	
    		}
	}
}



	

	function hk(){
 //document.write("错误！你没有填信息。");
		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var c1=document.getElementById("cf").value;
 

	if(c1.length==0){
	document.getElementById("x").innerHTML="不能为空!";
	document.getElementById("x").style.color="red";
	y=false;
	}else{
	if(patt.test(c1)||patt2.test(c1)){
    document.getElementById("x").innerHTML="正确!";
    document.getElementById("x").style.color="#39F";
    y=true;
    		}else{
    document.getElementById("x").innerHTML="格式不对!必须为不小于零的数字!";
    document.getElementById("x").style.color="red";
    y=false;	
    		}
	}
}

	function hk2(){
 //document.write("错误！你没有填信息。");
		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var c1=document.getElementById("cf2").value;
 

	if(c1.length==0){
	document.getElementById("x2").innerHTML="不能为空!";
	document.getElementById("x2").style.color="red";
	y2=false;
	}else{
	if(patt.test(c1)||patt2.test(c1)){
    document.getElementById("x2").innerHTML="正确!";
    document.getElementById("x2").style.color="#39F";
    y2=true;
    		}else{
    document.getElementById("x2").innerHTML="格式不对!必须为不小于零的数字!";
    document.getElementById("x2").style.color="red";
    y2=false;	
    		}
	}
}
	function hk3(){
 //document.write("错误！你没有填信息。");
		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var c1=document.getElementById("cf3").value;
 

	if(c1.length==0){
	document.getElementById("x3").innerHTML="不能为空!";
	document.getElementById("x3").style.color="red";
	y3=false;
	}else{
	if(patt.test(c1)||patt2.test(c1)){
    document.getElementById("x3").innerHTML="正确!";
    document.getElementById("x3").style.color="#39F";
    y3=true;	
    		}else{
    document.getElementById("x3").innerHTML="格式不对!必须为不小于零的数字!";
    document.getElementById("x3").style.color="red";
    y3=false;	
    		}
	}
}
	function hk4(){
 //document.write("错误！你没有填信息。");
		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
 var c1=document.getElementById("cf4").value;
 

	if(c1.length==0){

	document.getElementById("x4").innerHTML="不能为空!";
	document.getElementById("x4").style.color="red";
	y4=false;
	}else{
	if(patt.test(c1)||patt2.test(c1)){
    document.getElementById("x4").innerHTML="正确!";
    document.getElementById("x4").style.color="#39F";
    y4=true;
    		}else{
    document.getElementById("x4").innerHTML="格式不对!必须为不小于零的数字!";
    document.getElementById("x4").style.color="red";
    y4=false;
    		}
	}
}
	function hk5(){
 //document.write("错误！你没有填信息。");
 var c1=document.getElementById("cf5").value;
	if(c1.length==0){
	document.getElementById("x5").innerHTML="不能为空!";
	document.getElementById("x5").style.color="red";
	y5=false;
	}else if(c1.length>50){
		document.getElementById("x5").innerHTML="不能多余50个字!";
		document.getElementById("x5").style.color="red";
		y5=false;
	}else{
    document.getElementById("x5").innerHTML="正确!";
    document.getElementById("x5").style.color="#39F";
    y5=true;	
    		
	}
}	
	
	
	function hk11(){
		 //document.write("错误！你没有填信息。");
		 var c1=document.getElementById("cf11").value;
			if(c1.length==0){
			document.getElementById("x11").innerHTML="不能为空!";
			document.getElementById("x11").style.color="red";
			y11=false;
			}else{
		    document.getElementById("x11").innerHTML="正确!";
		    document.getElementById("x11").style.color="#39F";
		    y11=true;	
		    		
			}
		}
	function hk12(){
		 //document.write("错误！你没有填信息。");
		 var c1=document.getElementById("cf12").value;
			if(c1.length==0){
			document.getElementById("x12").innerHTML="不能为空!";
			document.getElementById("x12").style.color="red";
			y12=false;
			}else{
		    document.getElementById("x12").innerHTML="正确!";
		    document.getElementById("x12").style.color="#39F";
		    y12=true;	
		    		
			}
		}
	var type=[["幼儿园/学前教育","学科教学","教师成长","课堂教学/课堂管理" ,"教育经典名著","班主任用书","学校管理","心理健康"],
	          ["课外阅读","新课标","文言文/古诗词"],["志愿填报","高考作文","美术/音乐/广播", "高考辅导","高校自主招生","高考模拟试题","对口升学"],
	          ["一般管理学","市场/营销 金融/投资","电子商务","会计","创业企业与企业家","生产与运作管理","管理信息系统","商务沟通"],
	          ["科普/百科","中国儿童文学","图画书","外国儿童文学","幼儿启蒙"],["外语考试","公务员考试","计算机考试","公务员考试","自学考试","成人高考","考研"],
	          ["中国当代小说","外国小说 社会","情感","世界名著","历史","科幻","作品集","青春文学"],["杂志/期刊"]];
	function btype(){
		var sheng=document.form1.btype1;
		var shi=document.form1.btype2;
		var shengindex=sheng.selectedIndex;
		//document.getElementById(shengindex);
		//alert("jiaobiao="+shengindex);
		shi.length=1;
		if(shengindex>0){	
		var shengshi=type[shengindex-1];
		for(var i=0;i<shengshi.length;i++){
			shi[i+1]=new Option(shengshi[i],i+1);
			shi[i+1].value=shengshi[i];
			
		}
	}
		y13=true;
		document.getElementById("x13").innerHTML="正确!";
	    document.getElementById("x13").style.color="#39F";
	}
	function hk14(){
		 //document.write("错误！你没有填信息。");
		 var c1=document.getElementById("cf14").value;
			if(c1.length==0){
			document.getElementById("x14").innerHTML="不能为空!";
			document.getElementById("x14").style.color="red";
			y14=false;
			}else{
		    document.getElementById("x14").innerHTML="正确!";
		    document.getElementById("x14").style.color="#39F";
		    y14=true;	
		    		
			}
		}
	function hk15(){
		 //document.write("错误！你没有填信息。");
		 var c1=document.getElementById("cf15").value;
			if(c1.length==0){
			document.getElementById("x15").innerHTML="不能为空!";
			document.getElementById("x15").style.color="red";
			y15=false;
			}else{
		    document.getElementById("x15").innerHTML="正确!";
		    document.getElementById("x15").style.color="#39F";
		    y15=true;	
		    		
			}
		}
/*	function hk16(){
				//var patt=/^[0-9]+(.[0-9]{1,3})?$/;
				var patt2=/(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9] {1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578] |1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469] |11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1] [0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468] [048]|[13579][26])|((0[48]|[2468][048]| [3579][26])00))-02-29)/;
		 var c1=document.getElementById("cf16").value;
		 

			if(c1.length==0){

			document.getElementById("x16").innerHTML="不能为空!";
			document.getElementById("x16").style.color="red";
			y16=false;
			}else{
			if(patt2.test(c1)){
		    document.getElementById("x16").innerHTML="正确!";
		    document.getElementById("x16").style.color="#39F";
		    y16=true;
		    		}else{
		    document.getElementById("x16").innerHTML="格式不对!必须为YYYY-MM-DD,数字组成!";
		    document.getElementById("x16").style.color="red";
		    y16=false;
		    		}
			}
		}*/
	function oncheck() {
	//alert("11");
		

		if((y0&&y5&&y6&&y7&&y9&&y10&&y11&&y12&&y13&&y14&&y15)||((y||y2||y3||y4)&&y5&&y6&&y7&&y9&&y10&&y11&&y12&&y14&&y15)){
			
			return true;

		}else{	
			if(!y13){
				document.getElementById("x13").innerHTML="不能为空!";
				document.getElementById("x13").style.color="red";
			}
			document.getElementById("cf11").onblur();
			document.getElementById("cf12").onblur();
			document.getElementById("cf14").onblur();
			document.getElementById("cf15").onblur();
			document.getElementById("cf0").onblur();
			document.getElementById("cf").onblur();
			document.getElementById("cf2").onblur();
			document.getElementById("cf3").onblur();
			document.getElementById("cf4").onblur();
			document.getElementById("cf5").onblur();
			document.getElementById("cf6").onblur();
			document.getElementById("cf7").onblur();
			document.getElementById("cf9").onblur();
			document.getElementById("cf10").onblur();
			return false;
			 // document.getElementById("cf8").onblur();
			  
	
		
	  
	   
		}
		
	}
	/*function oncheck2() {

			if((y0&&y5&&y6&&y7&&y9&&y10&&y11&&y12&&y13&&y14&&y15)||((y||y2||y3||y4)&&y5&&y6&&y7&&y9&&y10&&y11&&y12&&y14&&y15)){
				return true;

			}else{	
				if(!y13){
					document.getElementById("x13").innerHTML="不能为空!";
					document.getElementById("x13").style.color="red";
				}
				document.getElementById("cf11").onblur();
				document.getElementById("cf12").onblur();
				document.getElementById("cf14").onblur();
				document.getElementById("cf15").onblur();
				document.getElementById("cf0").onblur();
				document.getElementById("cf").onblur();
				document.getElementById("cf2").onblur();
				document.getElementById("cf3").onblur();
				document.getElementById("cf4").onblur();
				document.getElementById("cf5").onblur();
				document.getElementById("cf6").onblur();
				document.getElementById("cf7").onblur();
				document.getElementById("cf9").onblur();
				document.getElementById("cf10").onblur();
				return false;
				 // document.getElementById("cf8").onblur();
				  
		
			
		  
		   
			}
			
		}
*/
	
	
	
	var ya2=true;
	var ya3=true;
	var ya4=true;
	var ya5=true;
	var ya7=false;
	var ya6=false;
	var ya8=true;
	var ya9=true;
	var ya10=true;


	function changeprice(){
		//alert("sssssssss");
		p=document.getElementById("jn").innerHTML;
		var a=document.getElementById("dis").value;
		//var b=document.getElementById("bp").value;
		var c=a*p;
		var d=Math.round(c*100)/100;
		document.getElementById("bp").value=d;
		document.getElementById("bp").onblur();
		}

		ya2=true;

		function ch(){
			//alert("dsdsds");
		p=document.getElementById("jn").innerHTML;
		var a=document.getElementById("bp").value;
		var b=document.getElementById("op").value;
		var c=a/p;
		var f=(Math.round(c*100)/100);
		var e=(Math.round(c*100)/100)*10;
		 var k=(c==1?b:(Math.round(e*100)/100+"折"));
		document.getElementById("op").value=f;
		l=document.getElementById("op").value;
		//document.write("糟糕！文档消失了。"+p+"元");
		document.getElementById("op").innerHTML=k;

		var patt=/^[0-9]+(.[0-9]{1,3})?$/;
		var patt2=/^[0-9]*$/;
			if(a.length==0){
			document.getElementById("m2").innerHTML="不能为空!";
			document.getElementById("m2").style.color="red";
			ya2=false;
			}else{
			if(patt.test(a)||patt2.test(a)){
			if(parseFloat(a)>parseFloat(p)){
		   document.getElementById("m2").innerHTML="新价不能大于原价！";
		   document.getElementById("m2").style.color="red";
		   ya2=false;
			}else{
		   document.getElementById("m2").innerHTML="正确!";
		   document.getElementById("m2").style.color="#39F";
		   ya2=true;}
		   		}else{
		   document.getElementById("m2").innerHTML="格式不对,必须为不小于零的数字！";
		   document.getElementById("m2").style.color="red";
		   ya2=false;
		   		}
			}

		}
		function currentprice(){
		var a=document.getElementById("cbp").value;
		var b=document.getElementById("op").value;
		document.getElementById("bp").value=a*b;
		}	
	
	
	
/*		function ck2(){
	 //document.write("错误！你没有填信息。");
			var patt=/^[0-9]+(.[0-9]{1,3})?$/;
			var patt2=/^[0-9]*$/;
	 var b1=document.getElementById("t2").value;
		if(b1.length==0){
		document.getElementById("s2").innerHTML="不能为空!";
		document.getElementById("s2").style.color="red";
		ya2=false;
		}else{
		
		if(patt.test(b1)||patt2.test(b1)){
	    document.getElementById("s2").innerHTML="正确!";
	    document.getElementById("s2").style.color="#39F";
	    ya2=true;
	    		}else{
	    document.getElementById("s2").innerHTML="格式不对!必须为不小于零的数字!";
	    document.getElementById("s2").style.color="red";
	    ya2=false;	
	    		}
		}
	}*/
		
		
		
		function ck3(){
			 //document.write("错误！你没有填信息。");
					
			 var b1=document.getElementById("t3").value;
				if(b1.length==0){
				document.getElementById("s3").innerHTML="不能为空!";
				document.getElementById("s3").style.color="red";
				ya3=false;
				}else{
				document.getElementById("s3").innerHTML="正确!";
				 document.getElementById("s3").style.color="#39F";
				ya3=true;
				}
			}
		function ck9(){
			 //document.write("错误！你没有填信息。");
					
			 var b1=document.getElementById("t9").value;
				if(b1.length==0){
				document.getElementById("s9").innerHTML="不能为空!";
				document.getElementById("s9").style.color="red";
				ya9=false;
				}else{
				document.getElementById("s9").innerHTML="正确!";
				 document.getElementById("s9").style.color="#39F";
				ya9=true;
				}
			}
		function ck10(){
			 //document.write("错误！你没有填信息。");
					
			 var b1=document.getElementById("t10").value;
				if(b1.length==0){
				document.getElementById("s10").innerHTML="不能为空!";
				document.getElementById("s10").style.color="red";
				ya10=false;
				}else{
				document.getElementById("s10").innerHTML="正确!";
				 document.getElementById("s10").style.color="#39F";
				ya10=true;
				}
			}

		function ck4(){
			var isbn =document.getElementById("t4").value;
			var TF = false;
			var vaa = "";
			var test=0;
			var array = isbn.split("");
			if(isbn!=null&&isbn.length>0){
				for(var j=0;j<isbn.length;j++){
					if("-"==isbn[j]){
						test = parseFloat(test)+ parseFloat(1);
					}
				}
				if(test==0||test==3&&isbn.length==13||test==4&&isbn.length==17){
					var va = isbn.split("-");
				for(var i=0;i<va.length;i++){
					vaa = vaa.concat(va[i]);
				}
				var vb = vaa.split("");
				var shuzi = new Array("1","2","3","4","5","6","7","8","9","0","X");
				var abc = 0;
				for(var x =0;x<vaa.length;x++){
					for(var y=0;y<shuzi.length;y++){
						if(vb[x]==shuzi[y]){
							abc = abc+1;
						}
					}
				}			
				if(vb.length==abc){
					
					var total = 0;
					if(vaa.length==10){
						for(var x =0;x<(vb.length)-1;x++){
							total =  parseFloat(total)+ parseFloat((+(vb[x]))*(10-x));
						}
						if(vaa[9]=="X"){
							if((total+10)%11==0){
								 TF = true;
							}
						}else if((parseFloat(total)+parseFloat(vb[9]))%11==0){
									TF = true;
								}
						
					}else if(vb.length==13){
						for(var z=0;z<vaa.length-1;z++ ){
							if(z%2!=0){
								total = parseFloat(total)+parseFloat((+vb[z])*3);
							}else if(z%2==0){
								total = parseFloat(total) + parseFloat(+vb[z]);
							}
						}	
						
						var y = 10 -  total%10;
						if(y==vb[12]){
							TF = true;
						}else if(y==10&&vb[12]==0){
							TF = true;
						}
					
					
				}
				}
			}
			}	
				
				if(TF == true){
					document.getElementById("s4").innerHTML="正确!";
					document.getElementById("s4").style.color="#39F";
			
					ya4=true;
			}else{
				if(isbn==null||isbn.length==0){
					document.getElementById("s4").innerHTML="不能为空!";
					document.getElementById("s4").style.color="red";
					 ya4=false;
					 
				}else{
				document.getElementById("s4").innerHTML="请输入正确的ISBN!";
				document.getElementById("s4").style.color="red";
				 ya4=false;		}		
			}
			}
		
		function ck5(){
			 //document.write("错误！你没有填信息。");
					var patt=/^[0-9]+(.[0-9]{1,3})?$/;
					var patt2=/^[0-9]*$/;
			 var b1=document.getElementById("t5").value;

				if(b1.length==0){
				document.getElementById("s5").innerHTML="不能为空!";
				document.getElementById("s5").style.color="red";
				ya5=false;
				}else{
				if(patt.test(b1)||patt2.test(b1)){
			    document.getElementById("s5").innerHTML="正确!";
			    document.getElementById("s5").style.color="#39F";
			    ya5=true;	
			    		}else{
			    document.getElementById("s5").innerHTML="格式不对!必须为不小于零的数字!";
			    document.getElementById("s5").style.color="red";
			    ya5=false;	
			    		}
				}
			}
		function ck6(){
	 //document.write("错误！你没有填信息。");
			var patt=/^[0-9]+(.[0-9]{1,3})?$/;
			var patt2=/^[0-9]*$/;
	 var c1=document.getElementById("t6").value;
		if(c1.length==0){
		document.getElementById("s6").innerHTML="不能为空!";
		document.getElementById("s6").style.color="red";
		ya6=false;
		}else{
		if(patt.test(c1)||patt2.test(c1)){
	    document.getElementById("s6").innerHTML="正确!";
	    document.getElementById("s6").style.color="#39F";
	    ya6=true;	
	    		}else{
	    document.getElementById("s6").innerHTML="格式不对!必须为不小于零的数字!";
	    document.getElementById("s6").style.color="red";
	    ya6=false;	
	    		}
		}
	}
		function ck7(){
	 //document.write("错误！你没有填信息。");
			var patt=/^[0-9]+(.[0-9]{1,3})?$/;
			var patt2=/^[0-9]*$/;
	 var c1=document.getElementById("t7").value;
	 

		if(c1.length==0){
		document.getElementById("s7").innerHTML="不能为空!";
		document.getElementById("s7").style.color="red";
		ya7=false;
		}else{
		if(patt.test(c1)||patt2.test(c1)){
	    document.getElementById("s7").innerHTML="正确!";
	    document.getElementById("s7").style.color="#39F";
	    ya7=true;
	    		}else{
	    document.getElementById("s7").innerHTML="格式不对!必须为不小于零的数字!";
	    document.getElementById("s7").style.color="red";
	    ya7=false;	
	    		}
		}
	}
	function ck8(){
	 //document.write("错误！你没有填信息。");
			var patt=/^[0-9]+(.[0-9]{1,3})?$/;
			var patt2=/^[0-9]*$/;
	 var c1=document.getElementById("t8").value;
	 

		if(c1.length==0){
		document.getElementById("s8").innerHTML="不能为空!";
		document.getElementById("s8").style.color="red";
		ya8=false;
		}else{	
		   var fileName = document.form1.formfile.value;
			var type=(fileName.substr(fileName.lastIndexOf("."))).toLowerCase();
			
			if(type!=""&&type!=".jpg"&&type!=".gif"&&type!=".jpeg"&& type!=".png"){
				alert("您上传图片的类型不符合(.jpg|.jpeg|.gif|.png)");
				document.getElementById("s8").innerHTML="★";
				document.getElementById("s8").style.color="red";
				//document.getElementById("s8").innerHTML="您上传图片的类型不符合(.jpg|.jpeg|.gif|.png)";
				ya8=false;
			}else{	
				document.getElementById("s8").innerHTML="正确!";
				document.getElementById("s8").style.color="#39F";
	         ya8=true;
	         }	
		}
	}

		function checkfc() {
			document.getElementById("t6").onblur();
			document.getElementById("t7").onblur();

			if(ya2&&ya3&&ya4&&ya5&&ya6&&ya7&&ya8&&ya9&&ya10){
				return true;
			}else{		
		      return false;
		      
			}
			
		}
				


