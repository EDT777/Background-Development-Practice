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
		url : "/project/sysUserPlus/update",
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
					payment : {
				required : true 
								,number:true //必须输入合法的数字（负数，小数）。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					userId : {
				required : icon + "请输入"
							},
					payment : {
				required : icon + "请输入"
								,number:   icon +"必须输入合法的数字（负数，小数）"
							},
				}
	})
}