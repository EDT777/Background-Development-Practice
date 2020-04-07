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
		url : "/project/sysFile/update",
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
					type : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					url : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					createDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					type : {
				required : icon + "请输入文件类型"
								,digits:   icon +"必须输入整数"
				 			},
					url : {
				required : icon + "请输入URL地址"
								,maxlength:icon +"最大长度不能超过200" 
							},
					createDate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}