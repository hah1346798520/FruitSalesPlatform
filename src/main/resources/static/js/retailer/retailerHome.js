function findRetailer(){
	var name=$("#name").val().trim();
	var telephone=$("#telephone").val().trim();
	var address=$("#address").val().trim();
	var status=$("#status").val();
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
		$.ajax({
			url:path+"/retailer/find",
			type:"post",
			data:{"name":name,"telephone":telephone,"address":address,"status":status,"startTime":startTime,"endTime":endTime},
			dataType:"html",
			success:function(list){
				$("#result").html(list);
			},
			error:function(){alert("搜索失败！")}
		});
}
function addRetailer(){
	$("#addName_span").html("");
	$("#addTelephone_span").html("");
	$("#addAddress_span").html("");
	
	var name=$("#addName").val().trim();
	var telephone=$("#addTelephone").val().trim();
	var address=$("#addAddress").val().trim();
	var ok=true;
	if(name==""){
		$("#addName_span").html("密码不能为空");
		$("#addName").focus();
		ok=false;
	}
	if(telephone==""||!(/^1[34578]\d{9}$/.test(telephone))){
		$("#addTelephone_span").html("电话号码不能为空或者格式错误");
		$("#addTelephone").focus();
		ok=false;
	}
	if(address==""){
		$("#addAddress_span").html("地址不能为空");
		$("#addAddress").focus();
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/retailer/addRetailer",
			type:"post",
			data:{"name":name,"telephone":telephone,"address":address},
			dataType:"json",
			success:function(){
				showAddMask(false);
				findAll();
			},
			error:function(){alert("注册失败！")}
		});
	}
}
function showAddMask(flag){
	if(flag=="true"){
		$(".addMask").css("display","block");
	}else{
		$(".addMask").css("display","none");
	}
}

function editFormSubmit(){
	var retailerId=$("#retailerId").val();
	var name=$("#editName").val().trim();
	var telephone=$("#editTelephone").val().trim();
	var address=$("#editAddress").val().trim();
	var status=$("#editStatus").val();
		$.ajax({
			url:path+"/retailer/edit",
			type:"post",
			data:{"retailerId":retailerId,"name":name,"telephone":telephone,"address":address,"status":status},
			dataType:"json",
			success:function(){
				alert("编辑成功");
				cancelEdit();
				findRetailer();
			},
			error:function(){alert("提交失败！")}
				
		});
}	

function findAll(){
	$.ajax({
		url:path+"/retailer/findAll",
		type:"get",
		data:{},
		dataType:"html",
		success:function(list){
			$("#result").html(list);
		},
		error:function(){alert("查询失败失败！")}
	});
}
function changeStatus(){
	var status1=$("#indexStatus").val();
	$("#status").val(status1);
}

function cancelEdit(){
	$(".mask").css("display","none");
}

function changeEditStatus(){
	var status=$("#eStatus").val();
	$("#editStatus").val(status);
}