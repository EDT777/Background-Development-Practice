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
		url : "/project/sysTask/update",
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
					cronExpression : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					methodName : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					isConcurrent : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					description : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					updateBy : {
				required : true 
								,maxlength:64 //限制字符长度。
							},
					beanClass : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					createDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					jobStatus : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					jobGroup : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					updateDate : {
				required : true 
								,date:true //必须输入正确格式的日期。
							},
					createBy : {
				required : true 
								,maxlength:64 //限制字符长度。
							},
					springBean : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
					jobName : {
				required : true 
								,maxlength:255 //限制字符长度。
							},
				},
		messages : {
					id : {
				required : icon + "请输入"
							},
					cronExpression : {
				required : icon + "请输入cron表达式"
								,maxlength:icon +"最大长度不能超过255" 
							},
					methodName : {
				required : icon + "请输入任务调用的方法名"
								,maxlength:icon +"最大长度不能超过255" 
							},
					isConcurrent : {
				required : icon + "请输入任务是否有状态"
								,maxlength:icon +"最大长度不能超过255" 
							},
					description : {
				required : icon + "请输入任务描述"
								,maxlength:icon +"最大长度不能超过255" 
							},
					updateBy : {
				required : icon + "请输入更新者"
								,maxlength:icon +"最大长度不能超过64" 
							},
					beanClass : {
				required : icon + "请输入任务执行时调用哪个类的方法 包名+类名"
								,maxlength:icon +"最大长度不能超过255" 
							},
					createDate : {
				required : icon + "请输入创建时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					jobStatus : {
				required : icon + "请输入任务状态"
								,maxlength:icon +"最大长度不能超过255" 
							},
					jobGroup : {
				required : icon + "请输入任务分组"
								,maxlength:icon +"最大长度不能超过255" 
							},
					updateDate : {
				required : icon + "请输入更新时间"
								,date:     icon +"必须输入正确格式的日期"
							},
					createBy : {
				required : icon + "请输入创建者"
								,maxlength:icon +"最大长度不能超过64" 
							},
					springBean : {
				required : icon + "请输入Spring bean"
								,maxlength:icon +"最大长度不能超过255" 
							},
					jobName : {
				required : icon + "请输入任务名"
								,maxlength:icon +"最大长度不能超过255" 
							},
				}
	})
}