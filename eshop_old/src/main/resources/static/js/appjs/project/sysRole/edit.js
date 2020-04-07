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
		url : "/project/sysRole/update",
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
					roleId : {
				required : true 
							},
					roleName : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					roleSign : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					remark : {
				required : true 
								,maxlength:100 //限制字符长度。
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
				},
		messages : {
					roleId : {
				required : icon + "请输入"
							},
					roleName : {
				required : icon + "请输入角色名称"
								,maxlength:icon +"最大长度不能超过100" 
							},
					roleSign : {
				required : icon + "请输入角色标识"
								,maxlength:icon +"最大长度不能超过100" 
							},
					remark : {
				required : icon + "请输入备注"
								,maxlength:icon +"最大长度不能超过100" 
							},
					userIdCreate : {
				required : icon + "请输入创建用户id"
							},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					gmtModified : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}