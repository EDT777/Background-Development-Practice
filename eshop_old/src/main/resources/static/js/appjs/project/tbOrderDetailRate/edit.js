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
		url : "/project/tbOrderDetailRate/update",
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
					orderDetailId : {
				required : true 
							},
					logisticsRate : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					serviceRate : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					productRate : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					message : {
				required : true 
								,maxlength:300 //限制字符长度。
							},
					rateTime : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					state : {
				required : true 
								,digits:true //必须输入整数。
				 			},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					orderDetailId : {
				required : icon + "请输入对应订单详情"
							},
					logisticsRate : {
				required : icon + "请输入物流评价，0-5代表星级"
								,digits:   icon +"必须输入整数"
				 			},
					serviceRate : {
				required : icon + "请输入服务评价，0-5代表星级"
								,digits:   icon +"必须输入整数"
				 			},
					productRate : {
				required : icon + "请输入产品评价，0-5代表星级"
								,digits:   icon +"必须输入整数"
				 			},
					message : {
				required : icon + "请输入评价内容"
								,maxlength:icon +"最大长度不能超过300" 
							},
					rateTime : {
				required : icon + "请输入评价时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					state : {
				required : icon + "请输入状态，0表示评价，1表示已生效，2表示已取消"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}