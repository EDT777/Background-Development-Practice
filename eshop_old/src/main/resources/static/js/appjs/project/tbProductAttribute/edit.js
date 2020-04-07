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
		url : "/project/tbProductAttribute/update",
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
					productId : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					attributeName : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					attributeValue : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					productId : {
				required : icon + "请输入对应商品"
								,maxlength:icon +"最大长度不能超过200" 
							},
					attributeName : {
				required : icon + "请输入属性名称"
								,maxlength:icon +"最大长度不能超过50" 
							},
					attributeValue : {
				required : icon + "请输入属性值"
								,maxlength:icon +"最大长度不能超过50" 
							},
				}
	})
}