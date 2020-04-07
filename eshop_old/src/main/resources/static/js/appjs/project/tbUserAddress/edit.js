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
		url : "/project/tbUserAddress/update",
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
					mobile : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					country : {
				required : true 
								,maxlength:40 //限制字符长度。
							},
					province : {
				required : true 
								,maxlength:40 //限制字符长度。
							},
					city : {
				required : true 
								,maxlength:40 //限制字符长度。
							},
					area : {
				required : true 
								,maxlength:40 //限制字符长度。
							},
					address : {
				required : true 
								,maxlength:100 //限制字符长度。
							},
					contactName : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
					isDefault : {
				required : true 
								,digits:true //必须输入整数。
				 			},
				},
		messages : {
					id : {
				required : icon + "请输入主键"
							},
					userId : {
				required : icon + "请输入对应用户"
							},
					mobile : {
				required : icon + "请输入收件电话"
								,maxlength:icon +"最大长度不能超过20" 
							},
					country : {
				required : icon + "请输入国家"
								,maxlength:icon +"最大长度不能超过40" 
							},
					province : {
				required : icon + "请输入省份"
								,maxlength:icon +"最大长度不能超过40" 
							},
					city : {
				required : icon + "请输入城市"
								,maxlength:icon +"最大长度不能超过40" 
							},
					area : {
				required : icon + "请输入区"
								,maxlength:icon +"最大长度不能超过40" 
							},
					address : {
				required : icon + "请输入收件地址"
								,maxlength:icon +"最大长度不能超过100" 
							},
					contactName : {
				required : icon + "请输入收件人"
								,maxlength:icon +"最大长度不能超过20" 
							},
					isDefault : {
				required : icon + "请输入是否为默认地址"
								,digits:   icon +"必须输入整数"
				 			},
				}
	})
}