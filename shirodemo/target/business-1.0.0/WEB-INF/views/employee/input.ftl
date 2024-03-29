<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="employee"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>员工编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="form-horizontal" action="/employee/saveOrUpdate" method="post" id="editForm" >
                    <input type="hidden" name="id" value="${employee.id}" >
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-2 control-label">用户名：</label>
                        <div class="col-sm-6">
                            <input type="text"
                                   <#if employee??>
                                         disabled
                                   </#if>
                                   class="form-control" name="username" value="${employee.username}"  placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-2 control-label">真实姓名：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="name" value="${employee.name}"  placeholder="请输入真实姓名">
                        </div>
                    </div>
                    <#-- 添加员工才显示， 编辑员工不需要显示-->
<#--                    <#if employee==null>-->
                    <#-- ?? 判断对象是否存在 -->
                    <#if !employee??>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="repassword" class="col-sm-2 control-label">验证密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="repassword" name="repassword" placeholder="再输入一遍密码">
                            </div>
                        </div>
                    </#if>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">电子邮箱：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"  name="email" value="${employee.email}" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">年龄：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="age" value="${employee.age}" placeholder="请输入年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dept" class="col-sm-2 control-label">部门：</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="dept" name="dept.id">
                                <option value="">全部</option>
                                <#list departments as d>
                                    <option value="${d.id}">${d.name}</option>
                                </#list>
                            </select>
                            <script>
                                $("#dept").val(${employee.dept.id})
                            </script>
                        </div>
                    </div>
                    <div class="form-group" id="adminDiv">
                        <label for="admin" class="col-sm-2 control-label">超级管理员：</label>
                        <div class="col-sm-6"style="margin-left: 15px;">
                            <input type="checkbox" id="admin" name="admin" class="checkbox">
<#--                                    ${employee.admin?string('checked','')}-->
                        </div>

                    </div>
                    <div class="form-group" id="roleDiv">
                        <label for="role" class="col-sm-2 control-label">分配角色：</label><br/>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-2 col-sm-offset-2">
                                <select multiple class="form-control allRoles" size="15">
                                    <#list roles as r>
                                        <option value="${r.id}">${r.name}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-sm-1" style="margin-top: 60px;" align="center">
                                <div>

                                    <a type="button" class="btn btn-primary  " style="margin-top: 10px" title="右移动"
                                       onclick="moveSelected('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-menu-right"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="左移动"
                                       onclick="moveSelected('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-menu-left"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全右移动"
                                       onclick="moveAll('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全左移动"
                                       onclick="moveAll('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a>
                                </div>
                            </div>

                            <div class="col-sm-2">
                                <select multiple class="form-control selfRoles" size="15" name="ids">
                                    <#list employee.roles as r>
                                        <option value="${r.id}">${r.name}</option>
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
    //找到表单，调用bootstrapValidator方法，配置验证规则
    $("#editForm").bootstrapValidator({
        feedbackIcons: { //图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields:{ //配置字段的规则
            username:{
                validators: { //具体有什么规则
                    notEmpty: { //不能为空
                         message: '用户名必填'
                    },
                    remote: { //远程验证
                         url: "/employee/checkUsername",
                         message: '用户名已存在,请重新输入',
                         delay: 1000, //1秒后再发送
                    },

                }
            },
          /*  password:{
                validators:{
                    notEmpty:{ //不能为空
                        message:"密码必填" //错误时的提示信息
                    },
                }
            },
            repassword:{
                validators:{
                    notEmpty:{ //不能为空
                        message:"密码必填" //错误时的提示信息
                    },
                    identical: {//两个字段的值必须相同
                        field: 'password',
                        message: '两次输入的密码必须相同'
                    },
                }
            },
            email: {
                validators: {
                    emailAddress: {} //邮箱格式
                }
            },
            age:{
                validators: {
                    between: { //数字的范围
                        min: 18,
                        max: 60
                    }
                }
            }*/
        }
    }).on('success.form.bv', function() { //表单所有数据验证通过后执行里面的代码
        console.log("验证通过")
        //提交表单（使用不会触发验证的方式提交即可）
        //$.post('/employee/saveOrUpdate',$("#editForm").serialize(),f)
        $("#editForm").ajaxSubmit(function(data){
            if(data.success){ //成功
                Swal.fire({
                    title: '操作成功',
                    text: "",
                    icon: 'success',
                    confirmButtonText: 'OK'
                }).then((result) => {
                    window.location.href = "/employee/list"
                })
            }else{
                Swal.fire(
                    '操作失败',
                    '请联系管理员',
                    'error'
                )
            }
        })

    });




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

    let roleDiv;
    $("#admin").click(function(){
        //得到当前复选框的状态
        let checked = $(this).prop('checked');
        if(checked){
            //删除角色相关区域
            roleDiv = $("#roleDiv").detach();
        }else{
            //恢复角色相关区域(追加到管理员后面)
            $("#adminDiv").after(roleDiv)
        }
    })
    //保存
    $(".btn-submit").click(function () {
        //让右边下拉框所有的option设为选中状态
        $(".selfRoles > option").prop('selected',true)
        //提交表单
        $("#editForm").submit();
    })
    //判断admin字段是否为true
    <#if employee.admin>
        $("#admin").prop('checked',true)
        //删除角色相关元素
        roleDiv = $("#roleDiv").detach();
    </#if>

    var ids = [];
    //角色去重功能
    //1.获取右边所有的option，取得里面value值（角色id）
    $(".selfRoles > option").each(function (i,ele) {
        //2.把获取到的value值存入到一个ids数组中 [2,4,5,6,7,87]
        ids.push($(ele).val())
    })
    //3.遍历左边所有的option,取得里面value值
    $(".allRoles > option").each(function (i,ele) {
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
