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
		url : "/project/sysLog/update",
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
					userId : {
				required : true 
							},
					username : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					operation : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					time : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					method : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					params : {
				required : true 
								,maxlength:5000 //限制字符长度。
							},
					ip : {
				required : true 
								,maxlength:64 //限制字符长度。
							},
					gmtCreate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					type : {
				required : true 
								,digits:true //必须输入整数。
				 			},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					userId : {
				required : icon + "请输入用户id"
							},
					username : {
				required : icon + "请输入用户名"
								,maxlength:icon +"最大长度不能超过50" 
							},
					operation : {
				required : icon + "请输入用户操作"
								,maxlength:icon +"最大长度不能超过50" 
							},
					time : {
				required : icon + "请输入响应时间"
								,digits:   icon +"必须输入整数"
				 			},
					method : {
				required : icon + "请输入请求方法"
								,maxlength:icon +"最大长度不能超过200" 
							},
					params : {
				required : icon + "请输入请求参数"
								,maxlength:icon +"最大长度不能超过5000" 
							},
					ip : {
				required : icon + "请输入IP地址"
								,maxlength:icon +"最大长度不能超过64" 
							},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					type : {
				required : icon + "请输入0:异常 1:正常"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}