function userLogin(){
	$("#username_span").html("");
	$("#password_span").html("");
	var username=$("#username").val().trim();
	var password=$("#password").val().trim();
	var ok=true;
	if(username==""){
		$("#username_span").html("用户名不能为空");
		$("#username").focus();
		ok=false;
	}
	if(password==""){
		$("#password_span").html("密码不能为空");
		$("#password").focus();
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/user/login",
			type:"post",
			data:{"username":username,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					$("#username_span").html(result.msg);
				}else if(result.status==1){
					$("#password_span").html(result.msg);
				}else if(result.status==2){
					window.location.href = "/tohome";
				}
			},
			error:function(){alert("登陆失败！")}
				
		});
	}
}