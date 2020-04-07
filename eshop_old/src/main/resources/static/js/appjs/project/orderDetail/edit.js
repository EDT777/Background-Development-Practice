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
		url : "/project/orderDetail/update",
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
					orderid : {
				required : true 
							},
					productid : {
				required : true 
							},
					count : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					price : {
				required : true 
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					orderid : {
				required : icon + "请输入对应订单"
							},
					productid : {
				required : icon + "请输入产品"
							},
					count : {
				required : icon + "请输入数量"
								,digits:   icon +"必须输入整数"
				 			},
					price : {
				required : icon + "请输入每件单价"
							},
				}
	})
}