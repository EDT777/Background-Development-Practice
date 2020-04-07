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
		url : "/project/tbOrderLogistics/update",
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
					orderId : {
				required : true 
							},
					type : {
				required : true 
							},
					logisticsNo : {
				required : true 
								,maxlength:30 //限制字符长度。
							},
					submitDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					orderId : {
				required : icon + "请输入对应用户"
							},
					type : {
				required : icon + "请输入快递公司"
							},
					logisticsNo : {
				required : icon + "请输入物流单号"
								,maxlength:icon +"最大长度不能超过30" 
							},
					submitDate : {
				required : icon + "请输入提交物流单号时间"
								,date:     icon +"必须输入正确格式的日期"
							},
				}
	})
}