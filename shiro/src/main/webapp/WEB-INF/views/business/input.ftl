<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>门店管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="business"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>门店编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="box-body" style="margin: 10px" class="form-horizontal" id="editForm" enctype="multipart/form-data" action="/business/saveOrUpdate" method="post" >
                    <input type="hidden" name="id" value="${business.id}">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>门店名称：</label>
                                <input type="text" class="form-control" name="name"  value="${business.name}"
                                       placeholder="请输入门店名称">
                            </div>
                            <div class="form-group">
                                <label >门店电话：</label>
                                <input type="text" class="form-control" name="tel" value="${business.tel}"
                                       placeholder="请输入门店电话">
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>门店地址：</label>
                                <input type="text" class="form-control" name="address" value="${business.address}"
                                       placeholder="请输入门店地址">
                            </div>
                            <div class="form-group">
                                <label>经营日期：</label>
                                <input type="text" class="form-control input-date" name="openDate" value="${(business.openDate?string("yyyy-MM-dd"))!}"  placeholder="请输入经营日期"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-10">
                            <label>门店介绍：</label>
                            <textarea class="form-control" rows="4" name="intro" placeholder="请输入门店介绍">${business.intro}</textarea>
                        </div>
                        <div class="form-group col-md-10">
                            <label>经营范围：</label>
                            <textarea class="form-control" rows="4" name="scope" placeholder="请输入门店经营范围">${business.scope}</textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>法人姓名：</label>
                                <input type="text" class="form-control" name="legalName" placeholder="请输入法人姓名" value="${business.legalName}">
                            </div>
                            <div class="form-group">
                                <label>法人电话：</label>
                                <input type="text" class="form-control" name="legalTel" placeholder="请输入法人电话" value="${business.legalTel}">
                            </div>
                            <div class="form-group">
                                <label>上传营业执照：</label>

                                <#if business.licenseImg??>
                                    <a class="btn" target="_blank" href="${business.licenseImg}">
                                        <i class="fa fa-user"></i> 查看附件
                                    </a>
                                </#if>
                                <#-- 隐藏的， 用于编辑时，把原本的图片地址提交到后台 -->
                                <input type="hidden"  name="licenseImg" value="${business.licenseImg}">
                                <#-- 给用户选择文件的，用于上传新的图片 -->
                                <input type="file" class="form-control" name="file" >
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>法人身份证：</label>
                                <input type="text" class="form-control" name="legalIdcard"  value="${business.legalIdcard}"
                                       placeholder="请输入法人身份证">
                            </div>
                            <div class="form-group">
                                <label>营业执照号码：</label>
                                <input type="text" class="form-control" name="licenseNumber" value="${business.licenseNumber}"
                                       placeholder="请输入营业执照号码">
                            </div>
                            <div class="form-group">
                                <label >门店性质：</label>
                                <select class="form-control" name="mainStore">
                                    <option value="0">分店</option>
                                    <option value="1">总店</option>
                                </select>
                                <script>
                                    $("select[name=mainStore]").val(${(business.mainStore?string("1","0"))!})
                                </script>
                            </div>
                        </div>

                    </div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-submit">保存</button>
                </form>

            </div>
        </section>
    </div>
    <#include "/common/footer.ftl">
</div>
</body>
</html>
