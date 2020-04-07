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
		url : "/project/goods/update",
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
					name : {
				required : true 
								,maxlength:60 //限制字符长度。
							},
					price : {
				required : true 
							},
					count : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					type : {
				required : true 
								,maxlength:30 //限制字符长度。
							},
					upTime : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					state : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					sourceChannel : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					inPrice : {
				required : true 
							},
					promtionPrice : {
				required : true 
							},
					typeId : {
				required : true 
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					name : {
				required : icon + "请输入名称"
								,maxlength:icon +"最大长度不能超过60" 
							},
					price : {
				required : icon + "请输入价格"
							},
					count : {
				required : icon + "请输入数量"
								,digits:   icon +"必须输入整数"
				 			},
					type : {
				required : icon + "请输入商品类型"
								,maxlength:icon +"最大长度不能超过30" 
							},
					upTime : {
				required : icon + "请输入上架时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					state : {
				required : icon + "请输入商品状态，0表示正常，1表示库存预警，-1表示无货，-2表示已下架"
								,digits:   icon +"必须输入整数"
				 			},
					sourceChannel : {
				required : icon + "请输入进货渠道"
								,maxlength:icon +"最大长度不能超过255" 
							},
					inPrice : {
				required : icon + "请输入进货价格"
							},
					promtionPrice : {
				required : icon + "请输入促销价格"
							},
					typeId : {
				required : icon + "请输入商品类型的引用上类型表的id"
							},
				}
	})
}