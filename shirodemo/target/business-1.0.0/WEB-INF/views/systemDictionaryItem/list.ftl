<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>字典明细管理</title>
    <#-- 使用相对当前模板文件的路径 再去找另一个模板文件 -->
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--定义一个变量  菜单回显-->
    <#assign currentMenu="systemDictionaryItem"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>字典明细管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <div class="row" style="margin:20px">
                    <div class="col-xs-2">
                        <div class="panel panel-default">
                            <div class="panel-heading">字典目录</div>
                            <div class="panel-body">
                                <div class="list-group" id="dic">
                                    <#list dics as d>
                                        <a data-id="${d.id}" href="/systemDictionaryItem/list?typeId=${d.id}" class="list-group-item">${d.title}</a>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-10">
                        <!--高级查询--->
                        <form class="form-inline" id="searchForm" action="/systemDictionaryItem/list" method="post">
                            <input type="hidden" name="currentPage" id="currentPage" value="1">
                            <input type="hidden" name="typeId" value="${qo.typeId}">
                            <input type="hidden" name="parentId" value="${qo.parentId}">
                            <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                                <span class="glyphicon glyphicon-plus"></span> 添加
                            </a>
                        </form>
                        <!--编写内容-->
                        <div class="box-body table-responsive no-padding ">
                            <table class="table table-hover table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>字典明细标题</th>
                                        <th>字典明细序号</th>
                                        <th>上级明细</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                <#list pageInfo.list as item>
                                    <tr>
                                        <td>${item_index+1}</td>
                                        <td>
                                            <a href="/systemDictionaryItem/list?parentId=${item.id}">${item.title}</a>
                                        </td>
                                        <td>${item.sequence}</td>
                                        <td>${item.parent.title!"无"}</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-xs btn-input"  data-json='${item.json}' >
                                                <span class="glyphicon glyphicon-pencil"></span> 编辑
                                            </a>
                                        </td>
                                    </tr>
                                </#list>

                                </tbody>

                            </table>
                            <#include "/common/page.ftl" >
                        </div>
                    </div>
                </div>

            </div>
        </section>
    </div>
    <#include "/common/footer.ftl" >
</div>




<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
            </div>
            <form class="form-horizontal" action="/systemDictionaryItem/saveOrUpdate" method="post" id="editForm">
                <div class="modal-body">
                        <input type="hidden" name="id">
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="name" class="col-sm-3 control-label">字典目录：</label>
                            <div class="col-sm-6">
                                <select class="form-control"  name="type.id" >
                                    <#list dics as d>
                                        <option value="${d.id}">${d.title}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label  class="col-sm-3 control-label">上级明细：</label>
                            <div class="col-sm-6">
                                <select class="form-control"  name="parent.id" >
                                    <option value="">无</option>
                                    <#list items as i>
                                        <option value="${i.id}">${i.title}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label  class="col-sm-3 control-label">明细标题：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="title"
                                       placeholder="请输入字典明细编码">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label class="col-sm-3 control-label">明细序号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="sequence"
                                       placeholder="请输入字典明细序号">
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-submit">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    //字典目录下拉框值改变事件
    $("#editForm select[name='type.id']").change(function () {
        let val = $(this).val();
        //把选中的目录id传到后台查询字典明细
        $.get('/systemDictionaryItem/selectByTypeId',{typeId:val},function (data) {
            let options = '<option value="">无</option>';
            $.each(data,function(index,ele){
                options += '<option value="'+ele.id+'">'+ele.title+'</option>';
            })
            $("#editForm select[name='parent.id']").html(options)
        })
    })

    $("#editForm").ajaxForm(function (data) {
        if(data.success){ //成功
            Swal.fire({
                title: '操作成功',
                text: "",
                icon: 'success',
                confirmButtonText: 'OK'
            }).then((result) => {
                window.location.reload();
            })
        }else{
            Swal.fire(
                '操作失败',
                '请联系管理员',
                'error'
            )
        }
    })

    $(".btn-input").click(function () {
        $("#editForm input,#editForm select").val('')
        let json = $(this).data('json');
        if(json){
            $("#editForm input[name=id]").val(json.id)
            //有特殊符号要加引号
            $("#editForm select[name='type.id']").val(json.typeId)
            $("#editForm select[name='parent.id']").val(json.parentId)
            $("#editForm input[name=title]").val(json.title)
            $("#editForm input[name=sequence]").val(json.sequence)
        }
        $("#editModal").modal('show')
    })


    <#if qo.typeId??>
        $("a[data-id=${qo.typeId}]").addClass('active'); //设置高亮的代码
    </#if>

</script>

</body>
</html>
