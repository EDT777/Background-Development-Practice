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
		url : "/project/tbCartItem/update",
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
					productId : {
				required : true 
							},
					count : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					price : {
				required : true 
							},
					joinDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					userId : {
				required : icon + "请输入对应用户"
							},
					productId : {
				required : icon + "请输入产品，引用tb_product_upc"
							},
					count : {
				required : icon + "请输入数量"
								,digits:   icon +"必须输入整数"
				 			},
					price : {
				required : icon + "请输入加入购物车时价格"
							},
					joinDate : {
				required : icon + "请输入加入购物车时间"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}