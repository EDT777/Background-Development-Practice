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
		url : "/project/sysDict/update",
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
					name : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					value : {
				required : true 
								,maxlength:2000 //限制字符长度。
							},
					type : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					description : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					sort : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					amend : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					parentId : {
				required : true 
							},
					createBy : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					createDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					updateBy : {
				required : true 
							},
					updateDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					remarks : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					delFlag : {
				required : true 
								,maxlength:1 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入编号"
							},
					name : {
				required : icon + "请输入标签名"
								,maxlength:icon +"最大长度不能超过100" 
							},
					value : {
				required : icon + "请输入数据值"
								,maxlength:icon +"最大长度不能超过2000" 
							},
					type : {
				required : icon + "请输入类型"
								,maxlength:icon +"最大长度不能超过100" 
							},
					description : {
				required : icon + "请输入描述"
								,maxlength:icon +"最大长度不能超过100" 
							},
					sort : {
				required : icon + "请输入排序（升序）"
								,digits:   icon +"必须输入整数"
				 			},
					amend : {
				required : icon + "请输入是否可以修改：0不可以，1可以修改"
								,digits:   icon +"必须输入整数"
				 			},
					parentId : {
				required : icon + "请输入父级编号"
							},
					createBy : {
				required : icon + "请输入创建者"
								,digits:   icon +"必须输入整数"
				 			},
					createDate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					updateBy : {
				required : icon + "请输入更新者"
							},
					updateDate : {
				required : icon + "请输入更新时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					remarks : {
				required : icon + "请输入备注信息"
								,maxlength:icon +"最大长度不能超过255" 
							},
					delFlag : {
				required : icon + "请输入删除标记"
								,maxlength:icon +"最大长度不能超过1" 
							},
				}
	})
}