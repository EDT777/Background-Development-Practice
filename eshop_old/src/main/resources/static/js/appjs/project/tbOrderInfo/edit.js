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
		url : "/project/tbOrderInfo/update",
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
					actualPrice : {
				required : true 
							},
					orderState : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					payState : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					finishDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
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
					userId : {
				required : true 
							},
					userRemark : {
				required : true 
								,maxlength:300 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
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
					actualPrice : {
				required : icon + "请输入因付总价"
							},
					orderState : {
				required : icon + "请输入订单状态，0提交，1支付，2发货，3签收，4完成，-1取消，-2申请退款中，-3客服介入中"
								,digits:   icon +"必须输入整数"
				 			},
					payState : {
				required : icon + "请输入支付状态，0未支付，1已支付"
								,digits:   icon +"必须输入整数"
				 			},
					finishDate : {
				required : icon + "请输入完成日期"
								,date:     icon +"必须输入正确格式的日期"
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
					userId : {
				required : icon + "请输入订单用户"
							},
					userRemark : {
				required : icon + "请输入用户备注"
								,maxlength:icon +"最大长度不能超过300" 
							},
				}
	})
}