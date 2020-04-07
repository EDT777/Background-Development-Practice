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
		url : "/project/tbProductImages/update",
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
					imageUrl : {
				required : true 
								,maxlength:200 //限制字符长度。
							},
					contentType : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					order : {
				required : true 
								,digits:true //必须输入整数。
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
					imageUrl : {
				required : icon + "请输入图片路径，以|分割"
								,maxlength:icon +"最大长度不能超过200" 
							},
					contentType : {
				required : icon + "请输入内容类型，用于传递正确的值给浏览器，上传时设定"
								,maxlength:icon +"最大长度不能超过20" 
							},
					order : {
				required : icon + "请输入图片顺序"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}