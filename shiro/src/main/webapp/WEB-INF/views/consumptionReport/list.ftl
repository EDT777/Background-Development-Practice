<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>门店收入报表</title>
    <#include "/common/link.ftl" >

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl" >

    <#assign currentMenu="consumptionReport"/>

    <#include "/common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>门店收入报表</h1>
        </section>
        <section class="content">
            <div class="box">
                <div style="margin: 10px;">
                    <!--高级查询--->
                    <form class="form-inline" id="searchForm" action="/consumptionReport/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label>门店查询</label>
                            <select class="form-control" name="businessId" id="businessId">
                                <option value="">请选择门店</option>
                                <#list businesses as b>
                                    <option value="${b.id}">${b.name}</option>
                                </#list>
                            </select>
                            <script>
                                $("#businessId").val(${qo.businessId})
                            </script>
                        </div>
                        <div class="form-group">
                            <label>时间段查询:</label>
                            <div class="input-daterange input-group" >
                                <input type="text" class="input-sm form-control" name="startDate"
                                       value="${(qo.startDate?string('yyyy-MM-dd'))!}"/>
                                <span class="input-group-addon">到</span>
                                <input type="text" class="input-sm form-control" name="endDate"
                                       value="${(qo.endDate?string('yyyy-MM-dd'))!}" />
                            </div>
                        </div><div class="form-group">
                            <label>结算单状态</label>
                            <select class="form-control" name="status" id="status">
                                <option value="">全部</option>
                                <#list statusEnums as e>
                                    <option value="${e.getValue()}">${e.getName()}</option>
                                </#list>
                            </select>
                            <script>
                                $("#status").val(${qo.status})
                            </script>
                        </div>

                        <div class="form-group">
                            <label>预约类型</label>
                            <select class="form-control" name="appointmentType" id="appointmentType">
                                <option value="">请选择预约类型</option>
                                <option value="1">预约</option>
                                <option value="0">非预约</option>
                            </select>
                        </div>
                        <script>
                            $("#appointmentType").val(${qo.appointmentType})
                        </script>

                        <br/>
                        <br/>

                        <div class="form-group">
                            <label for="status">分组类型:</label>
                            <select class="form-control" name="groupType" id="groupType">
                                <#list enums as e>
                                    <option value="${e.getValue()}">${e.getName()}</option>
                                </#list>
                            </select>
                            <script>
                                $("#groupType").val("${qo.groupType}")
                            </script>
                        </div>

                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>
                        <button type="button" class="btn btn-info btn-chart" >
                            <span class="glyphicon glyphicon-stats"></span> 柱状图
                        </button>
                    </form>
                </div>
                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>分组类型</th>
                                <th>总订单数</th>
                                <th>总消费金额</th>
                                <th>总实收金额</th>
                                <th>总优惠金额</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list pageInfo.list as m>
                                <tr>
                                    <td>${m.groupType}</td>
                                    <td>${m.number}</td>
                                    <td>${m.total}</td>
                                    <td>${m.pay}</td>
                                    <td>${m.discount}</td>
                                </tr>
                            </#list>
                        </tbody>

                    </table>
                    <#include "/common/page.ftl">
                </div>
            </div>
        </section>
    </div>
    <#include "/common/footer.ftl">
</div>

<!-- Modal模态框 -->
<div class="modal fade" id="chartModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content" style="padding: 20px">

        </div>
    </div>
</div>


<script>
    $(".btn-chart").click(function () {
         window.location.href = "/consumptionReport/listBar?"+$("#searchForm").serialize()
       /* $('#chartModal').modal({
            remote : "/consumptionReport/listBar" + "?" + $("#searchForm").serialize() //加上高级查询的条件
        })
        $('#chartModal').modal('show')*/
    })
</script>

</body>
</html>