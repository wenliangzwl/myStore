$(document).ready(function() {
	$("#seekButton").click(function() {
		$("form").submit();
	});
});

var list = new Array();
var qshref = " ";
var x = 0;

function addcheck(obj, span) {
	var inputs = $(".dd_book");
	if(obj.checked) {
		obj.checked = true;
		x = parseFloat(x) + parseFloat(1);
	} else {
		$("#allxz").attr("checked", false);
		$(obj).attr("checked", false);
		x = x - 1;
	}
	if(x == inputs.length) {
		document.getElementById("allxz").checked = true;
	}
}

function checkall(obj) {
	var inputs = $(".dd_book");
	for(var x = 0; x < inputs.length; x++) {
		inputs[x].checked = obj.checked;
	}
	if(obj.checked) {
		x = inputs.length;
	} else {
		x = 0;
	}
}

function addid(obj) {
	var inputs = $(".dd_book");
	if(inputs.length <= 0) {
		$("#tr").attr("style", "display:block");
		$("#div").text("暂无数据");
		$(obj).removeAttr("href");
	} else {
		for(var x = 0; x < inputs.length; x++) {
			if(inputs[x].checked == true) {
				var id = $(inputs[x]).parent(".td1").siblings(".td2").text();
				list.push(id);
			}
		}
		if(list.length <= 0) {
			$("#tr").attr("style", "display:block");
			$("#div").text("请选择想要删除的记录");
			$(obj).removeAttr("href");
		} else {
			obj.href = qshref + "&payno=" + list
		}
	}
}


	