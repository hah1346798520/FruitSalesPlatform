function showAddAccessory(flag){
	if(flag=="true"){
		$(".addAccessoryMask").css("display","block");
	}else{
		$(".addAccessoryMask").css("display","none");
	}
}
function addAccessory(){
	$("#addAccessoryName_span").html("");
	$("#addPrice_span").html("");
	
	var name=$("#addAccessoryName").val().trim();
	var price=$("#addPrice").val().trim();
	var fruitId=$("#aFruitId").val();
	var ok=true;
	if(name==""){
		$("#addAccessoryName_span").html("名称不能为空");
		$("#addAccessoryName").focus();
		ok=false;
	}
	if(price==""){
		$("#addPrice_span").html("价格不能为空");
		$("#addPrice").focus();
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/accessory/addAccessory",
			type:"post",
			data:{"name":name,"price":price,"fruitId":fruitId},
			dataType:"json",
			success:function(){
				//showAddAccessory(false);
				location.reload();
			},
			error:function(){alert("添加失败！")}
		});
	}
}
function checkAll(obj){
	var ischeck=obj.checked;
	var checkList=$("[name='arrays']");
	for(var i=0;i<checkList.length;i++){
		checkList[i].checked=ischeck;
	}
}

function deleteAccessory(){
	var myArray=new Array();
	var len=0;
	//var fruitId=$("#aFruitId").val();
	var arrays=$("[name='arrays']");
	for(var i=0;i<arrays.length;i++){
		if(arrays[i].checked){
			myArray[len++]=arrays[i].value;
		}
	}
	$.ajax({
		url:path+"/accessory/deleteList",
		type:"post",
		data:{"arrays":myArray/*,"fruitId":fruitId*/},
		dataType:"json",
		traditional:true,
		success:function(date){
			alert("删除成功!");
			location.reload();
		},
		error:function(){alert("删除失败！")}
	});
}