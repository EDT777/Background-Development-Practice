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
		url : "/project/sysDeptPost/update",
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
					deptId : {
				required : true 
							},
					postId : {
				required : true 
							},
					parentId : {
				required : true 
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					deptId : {
				required : icon + "请输入部门ID"
							},
					postId : {
				required : icon + "请输入岗位ID"
							},
					parentId : {
				required : icon + "请输入父ID"
							},
				}
	})
}