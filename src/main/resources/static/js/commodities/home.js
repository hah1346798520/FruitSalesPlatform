function findCommodities(){
	var fruitName=$("#fruitName").val().trim();
	var locality=$("#locality").val().trim();
	var minPrice=$("#minPrice").val();
	var maxPrice=$("#maxPrice").val();
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
		$.ajax({
			url:path+"/commodities/find",
			type:"post",
			data:{"fruitName":fruitName,"locality":locality,"minPrice":minPrice,"maxPrice":maxPrice,"startTime":startTime,"endTime":endTime},
			dataType:"html",
			success:function(list){
				$("#result").html(list);
			},
			error:function(){alert("搜索失败！")}
		});
}
function addCommodities(){
	$("#addFruitName_span").html("");
	$("#addPrice_span").html("");
	$("#addLocality_span").html("");
	
	var fruitName=$("#addFruitName").val().trim();
	var price=$("#addPrice").val().trim();
	var locality=$("#addLocality").val().trim();
	var ok=true;
	if(fruitName==""){
		$("#addFruitName_span").html("名称不能为空");
		$("#addFruitName").focus();
		ok=false;
	}
	if(price==""){
		$("#addPrice_span").html("价格不能为空");
		$("#addPrice").focus();
		ok=false;
	}
	if(locality==""){
		$("#addLocality_span").html("产地不能为空");
		$("#addLocality").focus();
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/commodities/addCommodities",
			type:"post",
			data:{"fruitName":fruitName,"price":price,"locality":locality},
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
	var fruitId=$("#fruitId").val();
	var fruitName=$("#fruitName").val().trim();
	var price=$("#editPrice").val();
	var locality=$("#editLocality").val().trim();
		$.ajax({
			url:path+"/commodities/edit",
			type:"post",
			data:{"fruitId":fruitId,"fruitName":fruitName,"price":price,"locality":locality},
			dataType:"json",
			success:function(){
				alert("编辑成功");
				cancelEdit();
				findCommodities();
			},
			error:function(){alert("提交失败！")}
				
		});
}	

function findAll(){
	$.ajax({
		url:path+"/commodities/findAll",
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