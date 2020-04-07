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
		url : "/project/goodsType/update",
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
					typeName : {
				required : true 
								,maxlength:30 //限制字符长度。
							},
					parentId : {
				required : true 
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					typeName : {
				required : icon + "请输入类型名称"
								,maxlength:icon +"最大长度不能超过30" 
							},
					parentId : {
				required : icon + "请输入父ID，类型的层级关系"
							},
				}
	})
}