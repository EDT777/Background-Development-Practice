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
		url : "/project/orderInfo/update",
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
					mobile : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					address : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					contactName : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					makeDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					payDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					totalPrice : {
				required : true 
							},
					userId : {
				required : true 
							},
					state : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					remark : {
				required : true 
								,maxlength:300 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					mobile : {
				required : icon + "请输入收件电话"
								,maxlength:icon +"最大长度不能超过20" 
							},
					address : {
				required : icon + "请输入收件地址"
								,maxlength:icon +"最大长度不能超过100" 
							},
					contactName : {
				required : icon + "请输入收件人"
								,maxlength:icon +"最大长度不能超过20" 
							},
					makeDate : {
				required : icon + "请输入订单下单日期"
								,date:     icon +"必须输入正确格式的日期"
							},
					payDate : {
				required : icon + "请输入订单付款日期"
								,date:     icon +"必须输入正确格式的日期"
							},
					totalPrice : {
				required : icon + "请输入订单总价"
							},
					userId : {
				required : icon + "请输入订单用户"
							},
					state : {
				required : icon + "请输入订单状态，0表示下单，1表示已付款，2表示申请退款中，3表示已经退款"
								,digits:   icon +"必须输入整数"
				 			},
					remark : {
				required : icon + "请输入备注"
								,maxlength:icon +"最大长度不能超过300" 
							},
				}
	})
}