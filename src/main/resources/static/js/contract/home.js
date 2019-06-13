function changeType(){
	var type1=$("#indexType").val();
	$("#type").val(type1);
}
function addContract(){
	var url=path+"/contract/addContract";
	window.open(url,"创建合同","height=700,width=700,scrollbars=yes");
}
function findContract(){
	var barCode=$("#barCode").val().trim();
	var retailerName=$("#retailerName").val().trim();
	var type=$("#type").val();
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
		$.ajax({
			url:path+"/contract/home",
			type:"post",
			data:{"barCode":barCode,"retailerName":retailerName,"type":type,"startTime":startTime,"endTime":endTime},
			dataType:"html",
			success:function(list){
				$("#result").html(list);
			},
			error:function(){alert("搜索失败！")}
		});
}