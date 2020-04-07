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
		url : "/project/sysDept/update",
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
					deptId : {
				required : true 
							},
					parentId : {
				required : true 
							},
					name : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					orderNum : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					delFlag : {
				required : true 
								,digits:true //必须输入整数。
				 			},
				},
		messages : {
					deptId : {
				required : icon + "请输入"
							},
					parentId : {
				required : icon + "请输入上级部门ID，一级部门为0"
							},
					name : {
				required : icon + "请输入部门名称"
								,maxlength:icon +"最大长度不能超过50" 
							},
					orderNum : {
				required : icon + "请输入排序"
								,digits:   icon +"必须输入整数"
				 			},
					delFlag : {
				required : icon + "请输入是否删除  -1：已删除  0：正常"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}