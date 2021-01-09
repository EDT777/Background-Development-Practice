$(function () {
    //删除按钮点击事件
    $(".btn-delete").click(function () {
        let url = $(this).data('url');
        Swal.fire({
            title: '警告',
            text: "是否确认删除该数据?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: '确认',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.value) { //确认按钮
                //进行删除
                window.location.href=url;
            }
            /*else{ //取消按钮

            }*/
        })
    })

    //设置input使用日期插件
    $(".input-date").datetimepicker({
        format:'yyyy-mm-dd',
        autoclose:true,
        minView:2,
        language:'zh-CN'
    })
    $(".input-date-hm").datetimepicker({
        format:'yyyy-mm-dd hh:ii',
        autoclose:true,
        minView:0,
        language:'zh-CN'
    })
})
