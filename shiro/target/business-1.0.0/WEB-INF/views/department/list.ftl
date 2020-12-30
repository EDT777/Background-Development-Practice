<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门管理</title>
    <#-- 使用相对当前模板文件的路径 再去找另一个模板文件 -->
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--定义一个变量  用于菜单回显-->
    <#assign currentMenu="department"/>

    <#include "/common/menu.ftl">

    <div class="content-wrapper">
        <section class="content-header">
            <h1>部门管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/department/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->
                <div class="box-body table-responsive ">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>部门名称</th>
                            <th>部门编号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
<#--                        <c:forEach items="${pageResult.data}" var="department">-->
                        <#list pageInfo.list as department>
                            <tr>
                                <td>${department_index+1}</td>
                                <td>${department.name}</td>
                                <td>${department.sn}</td>
                                <td>
                                    <a href="#" data-json='${department.json}'  class="btn btn-info btn-xs btn-input">
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a href="#"  data-url="/department/delete?id=${department.id}" class="btn btn-danger btn-xs btn-delete">
                                        <span class="glyphicon glyphicon-trash"></span> 删除
                                    </a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <!--分页-->
                    <#include "/common/page.ftl" >
                </div>
            </div>
        </section>
    </div>
    <#include "/common/footer.ftl" >
</div>

<!-- 模态框 -->
<div class="modal fade" id="inputModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
            </div>

            <form class="form-horizontal" id="editForm" action="/department/saveOrUpdate" method="post">
                <div class="modal-body">
                        <input type="hidden" name="id" >
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">部门名称</label>
                            <div class="col-sm-6">
                                <input type="text" name="name" class="form-control"  placeholder="名称" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-3 control-label">部门缩写</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="sn" placeholder="缩写" >
                            </div>
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    //添加/编辑绑定点击事件
    $(".btn-input").click(function () {
        //清除模态框中数据
        //$("#editForm").resetForm();
        $("#editForm input").val('')
        //从当前按钮上获取数据
        let json = $(this).data('json');
        //再回显到模态框中（dom操作）
        if(json){ //如果json不为空，才进行回显
            $("input[name=id]").val(json.id)
            $("input[name=name]").val(json.name)
            $("input[name=sn]").val(json.sn)
        }
        //弹出模态框
        $('#inputModal').modal('show')
    })


</script>

</body>
</html>
