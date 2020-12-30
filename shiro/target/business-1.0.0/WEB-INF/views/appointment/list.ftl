<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>预约单管理</title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="appointment"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>预约单管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 20px 0px 0px 10px">
                    <form class="form-inline" id="searchForm" action="/appointment/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label>预约单流水号</label>
                            <input type="text" class="form-control"  placeholder="请输入预约单流水号">
                        </div>
                                <div class="form-group">
                                    <label>预约业务大类</label>
                                    <select class="form-control"  id="categoryId">
                                        <option value="">请选择业务大类</option>
                                        <option value="1">售卖</option>
                                        <option value="2">保养</option>
                                        <option value="3">修理</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>预约单状态</label>
                                    <select class="form-control" id="status">
                                        <option value="">全部</option>
                                        <#list enums as e>
                                            <option value="${e.getValue()}">${e.getName()}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>门店查询</label>
                                    <select class="form-control"  id="businessId">
                                        <option value="">请选择门店</option>
                                        <option value="1">狼途汽车服务-深圳福田店</option>
                                        <option value="2">狼途汽车服务-广州黄埔店</option>
                                        <option value="3">狼途汽车服务-广州天河店</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <input type="text" class="form-control"  placeholder="请输入客户名称">
                                </div>



                                <br/>
                                <br/>
                        <div class="form-group">
                            <label>客户手机号</label>
                            <input type="text" class="form-control"  placeholder="请输入客户手机号">
                        </div>
                        <div class="form-group">
                            <label>预约时间查询：</label>
                            <input placeholder="请输入开始时间" type="text"  class="form-control "   /> -
                            <input placeholder="请输入结束时间" type="text"  class="form-control "   />
                        </div>

                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>

                        <a href="#" class="btn btn-success btn-input">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                    </form>

                </div>
                <div class="box-body table-responsive ">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>流水号</th>
                        <th>业务大类</th>
                        <th>预约说明</th>
                        <th>预约时间</th>
                        <th>客户名称</th>
                        <th>联系方式</th>
                        <th>预约门店</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageInfo.list as appointment>
                    <tr>
                        <td>${appointment_index+1}</td>
                        <td>${appointment.ano}</td>
                        <td>${appointment.category.title}</td>
                        <td>${appointment.info}</td>
                        <td>${(appointment.appointmentTime?string("yyyy-MM-dd HH:mm"))!}</td>
                        <td>${appointment.contactName}</td>
                        <td>${appointment.contactTel}</td>
                        <td>${appointment.business.name}</td>
                        <td>${appointment.statusName}</td>
                        <td>
                            <a href="#" class="btn btn-info btn-xs btn-input" >
                                <span class="glyphicon glyphicon-pencil"></span> 编辑
                            </a>
                            <a class="btn btn-xs btn-primary btn-status" data-status="1" data-id="${appointment.id}" >
                                <span class="glyphicon glyphicon-phone-alt"></span> 确认预约</a>
                            <a class="btn btn-xs btn-danger btn-status" data-status="4" data-id="${appointment.id}">
                                <span class="glyphicon glyphicon-remove"></span> 取消预约</a>
                         <#--   <#if appointment.status==1 >-->
                                 <a href="#" class="btn btn-success btn-xs btn-consume" data-ano="${appointment.ano}"  data-id="${appointment.id}" >
                                    <span class="glyphicon glyphicon-shopping-cart"></span> 确认到店
                                </a>
                           <#-- </#if>-->

                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                    <!--分页-->
                    <#include "/common/page.ftl">
                </div>

            </div>
        </section>
    </div>
    <#include "/common/footer.ftl">
</div>


<#-- 文件上传模态框 -->
<!--模态框-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form id="editForm" action="/appointment/saveOrUpdate" method="post" >
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">预约门店：</label>
                        <div class="col-sm-7">
                            <select class="form-control" name="business.id">
                                <option value="">请选择预约门店</option>
                                <#list businesses as b>
                                    <option value="${b.id}">${b.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">预约时间：</label>
                        <div class="col-sm-7">
                            <input type="text"  class="form-control input-date-hm" name="appointmentTime" placeholder="请输入预约时间"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">业务大类：</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="category" name="category.id">
                                <option value="">请选择业务大类</option>
                            </select>
                        </div>
                        <script>
                            $.get('/systemDictionaryItem/selectByTypeSn',{sn:'business'},function (data) {
                                let options = '';
                                $.each(data,function(index,ele){
                                    options+='<option value="'+ele.id+'">'+ele.title+'</option>';
                                })
                                $("#category").append(options)
                            })
                        </script>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">联系人：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="contactName"
                                   placeholder="请输入联系人">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">联系电话：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"  name="contactTel"
                                   placeholder="请输入联系电话">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">预约说明：</label>
                        <div class="col-sm-7">
                            <textarea type="text" class="form-control"  name="info"
                                      placeholder="请输入预约说明"></textarea>
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
    //确认/取消
    $(".btn-status").click(function () {
        //判断是否为确认按钮
        let text =  "是否确认预约信息无误?"
        let status = $(this).data('status');
        let id = $(this).data('id');
        if(status==4){ //取消
            text =  "是否确认取消预约?"
        }
        Swal.fire({
            title: '警告',
            text: text,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: '确认',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.value) { //确认按钮
                updateStatus(id,status);
            }
        })

        //更新当前预约单的状态

    })

    function updateStatus(id,status){
        $.post('/appointment/updateStatus',{id:id,status:status},function (data) {
            if(data.success){ //成功
                Swal.fire({
                    title: '修改成功',
                    text: "",
                    icon: 'success',
                    confirmButtonText: 'OK'
                }).then((result) => {
                    window.location.reload();
                })
            }else{
                Swal.fire(
                    '修改状态失败',
                    data.msg,
                    'error'
                )
            }
        })
    }





    $(".btn-input").click(function () {
        $("#editModal").modal('show')
    })

    //确认到店按钮
    $(".btn-consume").click(function () {
        let id = $(this).data('id');
        let ano = $(this).data('ano');
        Swal.fire({
            title: '温馨提示',
            text: '是否确认客户已经到店？',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: '是',
            cancelButtonText: '否'
        }).then((result) => {
            if(result.value){ //是
                Swal.fire({
                    title: '温馨提示',
                    text: '客户是否进行消费？',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: '有消费',
                    cancelButtonText: '无消费'
                }).then((result) => {
                    if(result.value){ //有消费
                        //创建新的消费单，关联预约单的处理方法
                        $.post('/consumption/saveByAppointmentAno',{ano:ano},function (data) {
                            if(data.success){ //成功
                                Swal.fire({
                                    title: '操作成功',
                                    text:  '已经生成结算单',
                                    icon: 'success',
                                    confirmButtonText: 'OK'
                                }).then((result) => {
                                    window.location.href = "/consumption/input?id="+ data.data; //把结算单的id传到input方法
                                })
                            }else{
                                Swal.fire(
                                    '操作失败',
                                    data.msg,
                                    'error'
                                )
                            }
                        })
                    }else{ //无消费 => 归档
                        updateStatus(id,3)
                    }
                })
            }
        })
    })

</script>


</body>
</html>
