function cancelRetailerMask(){
	$(".retailerMask").css("display","none");
}

function cancelCommoditiesMask(){
	$(".commoditiesMask").css("display","none");
}

function addContractForm(){
	$("#message").val("");
	var type=$("#type").val();
	var retailerId=$("#retailerId").val();
	var commoditiesIdArrays=$("[name='commoditiesIdArrays']");
	var priceArrays=$("[name='priceArrays']");
	var ok=true;
	if(retailerId==null||retailerId==""){
		ok=false;
		alert("请关联供应商！");
		return;
	}
	var mycommoditiesIdArrays=new Array();
	for(var i=0;i<commoditiesIdArrays.length;i++){
		mycommoditiesIdArrays[i]=commoditiesIdArrays[i].value;
	}
	var mypriceArrays=new Array();
	for(var i=0;i<priceArrays.length;i++){
		mypriceArrays[i]=priceArrays[i].value;
	}
	/* for(var i=0;i<arrays.length;i++){
		if(arrays[i].checked){
			myArray[len++]=arrays[i].value;
		}
	} */
	if(ok){
		$.ajax({
			url:path+"/contract/add",
			type:"post",
			data:JSON.stringify({"type":type,"retailerId":retailerId,"commoditiesIdArrays":mycommoditiesIdArrays,"priceArrays":mypriceArrays}),
			dataType:"json",
			contentType: "application/json",
			traditional:true,
			success:function(result){
				alert(result.msg);
				$("#message").html(result.msg);
			},
			error:function(){alert("通讯异常!")}
		});
	}	
}
function checkAddContract(){}
function changeType(){
	var type=$("#indexType").val();
	$("#type").val(type);
}
function searchRetailer(){
	addRetailer($("#retailerName").val());
}

function addRetailer(name){
	$("#retailerList").html("");//将原来信息清空
	$.ajax({
		url:path+"/contract/getAllRetailer",
		type:"post",
		data:{"name":name},
		dataType:"html",
		success:function(list){
			$(".retailerMask").css("display","block"); 
			$("#retailerList").html(list);
		},
		error:function(){alert("通讯异常！")}
	});
}

function selectRetailer(retailerId,name,telephone,address){
	$("#retailerId").val(retailerId);
	$("#retailer_name").html("姓名:"+name);
	$("#retailer_telephone").html("联系电话:"+telephone);
	$("#retailer_address").html("送货地址:"+address);
	$(".retailerMask").css("display","none");
	$("#retailer_info").css("display","block");
}
function searchCommodities(){
	addFruit($("#commoditiesName").val());
}
function addFruit(name){
	$("#commoditiesList").html("");//将原来信息清空
	$.ajax({
		url:path+"/contract/getAllCommodities",
		type:"post",
		data:{"name":name},
		dataType:"html",
		success:function(list){
			$(".commoditiesMask").css("display","block"); 
			$("#commoditiesList").html(list);
		},
		error:function(){alert("通讯异常！")}
	});
}
function selectCommodities(){
	$("#commodities_info").html("");//将原来信息清空
	var myArray=new Array();
	var len=0;
	var arrays=$("[name='arrays']");
	for(var i=0;i<arrays.length;i++){
		if(arrays[i].checked){
			myArray[len++]=arrays[i].value;
		}
	}
	$.ajax({
		url:path+"/contract/getCommoditiesAndAccessory",
		type:"post",
		data:{"arrays":myArray/*,"fruitId":fruitId*/},
		dataType:"html",
		traditional:true,
		success:function(list){
			$(".commoditiesMask").css("display","none"); 
			$("#commodities_info").css("display","block"); 
			$("#commodities_info").html(list);
		},
		error:function(){alert("通讯异常！")}
	});
}