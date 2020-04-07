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
		url : "/project/sysUser/update",
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
					userId : {
				required : true 
							},
					username : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					name : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					password : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					deptId : {
				required : true 
							},
					email : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					mobile : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					status : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					userIdCreate : {
				required : true 
							},
					gmtCreate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					gmtModified : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					sex : {
				required : true 
							},
					birth : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					picId : {
				required : true 
							},
					liveAddress : {
				required : true 
								,maxlength:500 //限制字符长度。
							},
					hobby : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					province : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					city : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					district : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
				},
		messages : {
					userId : {
				required : icon + "请输入"
							},
					username : {
				required : icon + "请输入用户名"
								,maxlength:icon +"最大长度不能超过50" 
							},
					name : {
				required : icon + "请输入"
								,maxlength:icon +"最大长度不能超过100" 
							},
					password : {
				required : icon + "请输入密码"
								,maxlength:icon +"最大长度不能超过50" 
							},
					deptId : {
				required : icon + "请输入"
							},
					email : {
				required : icon + "请输入邮箱"
								,maxlength:icon +"最大长度不能超过100" 
							},
					mobile : {
				required : icon + "请输入手机号"
								,maxlength:icon +"最大长度不能超过100" 
							},
					status : {
				required : icon + "请输入状态 0:禁用，1:正常"
								,digits:   icon +"必须输入整数"
				 			},
					userIdCreate : {
				required : icon + "请输入创建用户id"
							},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					gmtModified : {
				required : icon + "请输入修改时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					sex : {
				required : icon + "请输入性别"
							},
					birth : {
				required : icon + "请输入出身日期"
								,date:     icon +"必须输入正确格式的日期"
							},
					picId : {
				required : icon + "请输入"
							},
					liveAddress : {
				required : icon + "请输入现居住地"
								,maxlength:icon +"最大长度不能超过500" 
							},
					hobby : {
				required : icon + "请输入爱好"
								,maxlength:icon +"最大长度不能超过255" 
							},
					province : {
				required : icon + "请输入省份"
								,maxlength:icon +"最大长度不能超过255" 
							},
					city : {
				required : icon + "请输入所在城市"
								,maxlength:icon +"最大长度不能超过255" 
							},
					district : {
				required : icon + "请输入所在地区"
								,maxlength:icon +"最大长度不能超过255" 
							},
				}
	})
}