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
		url : "/project/tbAccount/update",
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
					accountNo : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					accountName : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					balance : {
				required : true 
							},
					remark : {
				required : true 
								,maxlength:300 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					accountNo : {
				required : icon + "请输入账号"
								,maxlength:icon +"最大长度不能超过20" 
							},
					accountName : {
				required : icon + "请输入姓名"
								,maxlength:icon +"最大长度不能超过20" 
							},
					balance : {
				required : icon + "请输入余额"
							},
					remark : {
				required : icon + "请输入"
								,maxlength:icon +"最大长度不能超过300" 
							},
				}
	})
}