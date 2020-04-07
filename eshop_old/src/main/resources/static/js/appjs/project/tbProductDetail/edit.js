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
		url : "/project/tbProductDetail/update",
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
					detailHtml : {
				required : true 
								,maxlength:65535 //限制字符长度。
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
					detailHtml : {
				required : icon + "请输入详情内容，html代码"
								,maxlength:icon +"最大长度不能超过65535" 
							},
				}
	})
}