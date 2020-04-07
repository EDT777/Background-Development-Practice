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
		url : "/project/sysUserDateInfo/update",
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
								,maxlength:20 //限制字符长度。
							},
					enroleDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					leaveDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					status : {
				required : true 
								,digits:true //必须输入整数。
				 			},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					userId : {
				required : icon + "请输入用户"
								,maxlength:icon +"最大长度不能超过20" 
							},
					enroleDate : {
				required : icon + "请输入入职日期"
								,date:     icon +"必须输入正确格式的日期"
							},
					leaveDate : {
				required : icon + "请输入离职日期"
								,date:     icon +"必须输入正确格式的日期"
							},
					status : {
				required : icon + "请输入状态，0表示在职，1表示离职"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}