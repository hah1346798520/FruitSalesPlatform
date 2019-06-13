function editRetailer(id){
	$.ajax({
		url:path+"/retailer/editRetailer",
		type:"get",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			$("#editName").val(data["name"]);
			$("#editTelephone").val(data["telephone"]);
			$("#editAddress").val(data["address"]);
			$("#retailerId").val(data["retailerId"]);
			$("#editStatus").val(data["status"]);
			$("#eStatus").val(data["status"]);
			//显示弹出框
			$(".mask").css("display","block");
			//引入分页信息至该form表单
			//$("#eStartPage").val()
		},
		error:function(){alert("编辑失败！")}
	});
}
function deleteRetailer(id,name){
	if (confirm("你确定要删除用户"+name+"吗？")) {  
		$.ajax({
			url:path+"/retailer/deleteRetailer",
			type:"get",
			data:{"id":id},
			dataType:"json",
			success:function(){
				alert("删除成功");
				findRetailer();
			},
			error:function(){alert("删除失败！")}
		});
	}
}