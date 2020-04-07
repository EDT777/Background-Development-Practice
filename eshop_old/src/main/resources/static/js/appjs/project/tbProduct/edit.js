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
		url : "/project/tbProduct/update",
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
								,maxlength:200 //限制字符长度。
							},
					typeId : {
				required : true 
							},
					typeName : {
				required : true 
								,maxlength:50 //限制字符长度。
							},
					onSale : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					quantity : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					lowStockThreshold : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					unity : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					supplierReference : {
				required : true 
							},
					createBy : {
				required : true 
							},
					gmtCreate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					updateBy : {
				required : true 
							},
					gmtUpdate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					delFlag : {
				required : true 
								,digits:true //必须输入整数。
				 			},
					upc : {
				required : true 
								,maxlength:20 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					name : {
				required : icon + "请输入商品标题"
								,maxlength:icon +"最大长度不能超过200" 
							},
					typeId : {
				required : icon + "请输入分类信息"
							},
					typeName : {
				required : icon + "请输入分类名称"
								,maxlength:icon +"最大长度不能超过50" 
							},
					onSale : {
				required : icon + "请输入是否上架，默认为不上架"
								,digits:   icon +"必须输入整数"
				 			},
					quantity : {
				required : icon + "请输入数量"
								,digits:   icon +"必须输入整数"
				 			},
					lowStockThreshold : {
				required : icon + "请输入库存预警阈值"
								,digits:   icon +"必须输入整数"
				 			},
					unity : {
				required : icon + "请输入计价单位，参考数据字典ProductUnit"
								,maxlength:icon +"最大长度不能超过255" 
							},
					supplierReference : {
				required : icon + "请输入供应商预留"
							},
					createBy : {
				required : icon + "请输入创建人"
							},
					gmtCreate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					updateBy : {
				required : icon + "请输入更新人"
							},
					gmtUpdate : {
				required : icon + "请输入更新时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					delFlag : {
				required : icon + "请输入是否删除，0表示正常，1表示已删除"
								,digits:   icon +"必须输入整数"
				 			},
					upc : {
				required : icon + "请输入单品编码，预留"
								,maxlength:icon +"最大长度不能超过20" 
							},
				}
	})
}