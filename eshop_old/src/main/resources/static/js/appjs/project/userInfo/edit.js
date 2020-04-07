$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/project/userInfo/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
					id : {
				required : true 
							},
					userName : {
				required : true 
								,maxlength:30 //限制字符长度。
							},
					userPwd : {
				required : true 
								,maxlength:30 //限制字符长度。
							},
					userStatus : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					userDelete : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					userPoint : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					userBirthday : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					userName : {
				required : icon + "请输入用户名"
								,maxlength:icon +"最大长度不能超过30" 
							},
					userPwd : {
				required : icon + "请输入主键"
								,maxlength:icon +"最大长度不能超过30" 
							},
					userStatus : {
				required : icon + "请输入用户状态，0表示正常，1表示禁用"
								,digits:   icon +"必须输入整数"
				 			},
					userDelete : {
				required : icon + "请输入1表示已经删除，0表示正常"
								,digits:   icon +"必须输入整数"
				 			},
					userPoint : {
				required : icon + "请输入用户积分"
								,digits:   icon +"必须输入整数"
				 			},
					userBirthday : {
				required : icon + "请输入用户积分"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}