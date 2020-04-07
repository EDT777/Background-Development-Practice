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
		url : "/project/tbProductType/update",
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
					typeName : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					parentId : {
				required : true 
							},
					iconClass : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					createBy : {
				required : true 
							},
					gmtCreate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					updateBy : {
				required : true 
							},
					gmtUpdate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					typeName : {
				required : icon + "请输入实际存放地址"
								,maxlength:icon +"最大长度不能超过200" 
							},
					parentId : {
				required : icon + "请输入父类型"
							},
					iconClass : {
				required : icon + "请输入分类的图标"
								,maxlength:icon +"最大长度不能超过50" 
							},
					createBy : {
				required : icon + "请输入创建人"
							},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					updateBy : {
				required : icon + "请输入更新人"
							},
					gmtUpdate : {
				required : icon + "请输入更新时间"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}