

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>角色管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="role"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>角色编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="form-horizontal" action="/role/saveOrUpdate" method="post" id="editForm">

                    <input type="hidden"  name="id" value="${role.id}">
                    <div class="form-group"  style="margin-top: 10px;">
                        <label  class="col-sm-2 control-label">角色名称：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"  value="${role.name}" name="name"  placeholder="请输入角色名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">角色编号：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" value="${role.sn}" name="sn"  placeholder="请输入角色编号">
                        </div>
                    </div>
                    <div class="form-group " id="role">
                        <label for="role" class="col-sm-2 control-label">分配权限：</label><br/>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-2 col-sm-offset-2">
                                <select multiple class="form-control allPermissions" size="15">
                                    <#list permissions as p>
                                        <option value="${p.id}">${p.name}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-sm-1" style="margin-top: 60px;" align="center">
                                <div>

                                    <a type="button" class="btn btn-primary" style="margin-top: 10px" title="右移动"
                                       onclick="moveSelected('allPermissions', 'selfPermissions')">
                                        <span class="glyphicon glyphicon-menu-right"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="左移动"
                                       onclick="moveSelected('selfPermissions', 'allPermissions')">
                                        <span class="glyphicon glyphicon-menu-left"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全右移动"
                                       onclick="moveAll('allPermissions', 'selfPermissions')">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全左移动"
                                       onclick="moveAll('selfPermissions', 'allPermissions')">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <select multiple class="form-control selfPermissions" size="15" name="ids">
                                    <#list role.permissions as p>
                                        <option value="${p.id}">${p.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button type="button" class="btn btn-primary btn-submit">保存</button>
                            <a href="javascript:window.history.back()" class="btn btn-danger">取消</a>
                        </div>
                    </div>

                </form>
            </div>
        </section>
    </div>
    <#include "/common/footer.ftl">
</div>
<script>
    function moveSelected(src,target){
        //得到左边下拉框中选中的数据，移动到右边的下拉框
        let options = $("."+src+" > option:selected");
        $("."+target).append(options);
    }
    function moveAll(src,target){
        //得到左边下拉框全部的数据，移动到右边的下拉框
        let options = $("."+src+" > option");
        $("."+target).append(options);
    }
    //保存
    $(".btn-submit").click(function () {
        //让右边下拉框所有的option设为选中状态
        $(".selfPermissions > option").prop('selected',true)
        //提交表单
        $("#editForm").submit();
    })

    var ids = [];
    //权限去重功能
    //1.获取右边所有的option，取得里面value值（角色id）
    $(".selfPermissions > option").each(function (i,ele) {
        //2.把获取到的value值存入到一个ids数组中 [2,4,5,6,7,87]
        ids.push($(ele).val())
    })
    //3.遍历左边所有的option,取得里面value值
    $(".allPermissions > option").each(function (i,ele) {
        //4.判断value值是否已经存在ids数组
        let id = $(ele).val();
        if($.inArray(id,ids)>-1){
            //5.如果已经存在就把当前的所在的option元素删掉
            $(ele).remove();
        }
    })

</script>
</body>
</html>
