function userRegister(){
		$("#username_span").html("");
		$("#password_span").html("");
		$("#name_span").html("");
		$("#telephone_span").html("");
		
		var username=$("#username").val().trim();
		var password=$("#password").val().trim();
		var name=$("#name").val().trim();
		var telephone=$("#telephone").val().trim();
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
		if(name==""){
			$("#name_span").html("名字不能为空");
			$("#name").focus();
			ok=false;
		}
		if(telephone==""||!(/^1[34578]\d{9}$/.test(telephone))){
			$("#telephone_span").html("电话号码不能为空或者格式错误");
			$("#telephone").focus();
			ok=false;
		}
		if(ok){
			$.ajax({
				url:path+"/user/register",
				type:"post",
				data:{"username":username,"password":password,"name":name,"telephone":telephone},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						$("#username_span").html(result.msg);
					}else if(result.status==1){
						alert(result.msg);
						window.location.href = "toLogin";
					}
				},
				error:function(){alert("注册失败！")}
			});
		}
	}