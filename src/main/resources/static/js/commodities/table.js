function openWindows(id){
	var url=path+"/accessory/list?fruitId="+id;
	window.open(url,"附属品","height=400,width=700,scrollbars=yes");
}

function editCommodities(id){
	$.ajax({
		url:path+"/commodities/editCommodities",
		type:"get",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			$("#editName").val(data["fruitName"]);
			$("#editPrice").val(data["price"]);
			$("#editLocality").val(data["locality"]);
			$("#fruitId").val(data["fruitId"]);
			//显示弹出框
			$(".mask").css("display","block");
			//引入分页信息至该form表单
			//$("#eStartPage").val()
		},
		error:function(){alert("编辑失败！")}
	});
}
function deleteCommodities(id,name){
	if (confirm("你确定要删除货物"+name+"吗？")) {  
		$.ajax({
			url:path+"/commodities/deleteCommodities",
			type:"get",
			data:{"id":id},
			dataType:"json",
			success:function(){
				alert("删除成功");
				findCommodities();
			},
			error:function(){alert("删除失败！")}
		});
	}
}