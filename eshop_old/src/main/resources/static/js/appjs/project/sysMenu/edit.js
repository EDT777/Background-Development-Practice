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
		url : "/project/sysMenu/update",
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
					menuId : {
				required : true 
							},
					parentId : {
				required : true 
							},
					name : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					url : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					perms : {
				required : true 
								,maxlength:500 //限制字符长度。
							},
					type : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					icon : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					orderNum : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					gmtCreate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					gmtModified : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					conditionSql : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
				},
		messages : {
					menuId : {
				required : icon + "请输入"
							},
					parentId : {
				required : icon + "请输入父菜单ID，一级菜单为0"
							},
					name : {
				required : icon + "请输入菜单名称"
								,maxlength:icon +"最大长度不能超过50" 
							},
					url : {
				required : icon + "请输入菜单URL"
								,maxlength:icon +"最大长度不能超过200" 
							},
					perms : {
				required : icon + "请输入授权(多个用逗号分隔，如：user:list,user:create)"
								,maxlength:icon +"最大长度不能超过500" 
							},
					type : {
				required : icon + "请输入类型   0：目录   1：菜单   2：按钮  3:数据权限"
								,digits:   icon +"必须输入整数"
				 			},
					icon : {
				required : icon + "请输入菜单图标"
								,maxlength:icon +"最大长度不能超过50" 
							},
					orderNum : {
				required : icon + "请输入排序"
								,digits:   icon +"必须输入整数"
				 			},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					gmtModified : {
				required : icon + "请输入修改时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					conditionSql : {
				required : icon + "请输入条件sql"
								,maxlength:icon +"最大长度不能超过200" 
							},
				}
	})
}