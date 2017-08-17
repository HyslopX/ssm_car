<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie ie6 lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="ie ie7 lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="ie ie8 lt-ie9" lang="en"> <![endif]-->
<!--[if IE 9]> <html class="ie ie9" lang="en"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-ie">
<!--<![endif]-->

<head>
    <base href="<%=basePath%>">
    <!-- Meta-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <title>个人中心</title>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script><![endif]-->
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="app/css/bootstrap.css">
    <!-- Vendor CSS-->
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendor/animo/animate+animo.css">
    <link rel="stylesheet" href="vendor/csspinner/csspinner.min.css">
    <!-- START Page Custom CSS-->
    <link rel="stylesheet" href="vendor/slider/css/slider.css">
    <link rel="stylesheet" href="vendor/chosen/chosen.min.css">
    <link rel="stylesheet" href="vendor/datetimepicker/css/bootstrap-datetimepicker.min.css">
    <!-- Codemirror -->
    <link rel="stylesheet" href="vendor/codemirror/lib/codemirror.css">
    <!-- Bootstrap tags-->
    <link rel="stylesheet" href="vendor/tagsinput/bootstrap-tagsinput.css">
    <!-- END Page Custom CSS-->
    <!-- App CSS-->
    <link rel="stylesheet" href="app/css/app.css">
    <!-- Modernizr JS Script-->
    <script src="vendor/modernizr/modernizr.js" type="application/javascript"></script>
    <!-- FastClick for mobiles-->
    <script src="vendor/fastclick/fastclick.js" type="application/javascript"></script>
</head>

<body>
<!-- START Main wrapper-->
<section class="wrapper">
    <!-- START Top Navbar-->
    <nav role="navigation" class="navbar navbar-default navbar-top navbar-fixed-top">
        <!-- START navbar header-->
        <div class="navbar-header">
            <a href="/page/index" class="navbar-brand">
                <div class="brand-logo">东通二手车</div>
            </a></div>
        <!-- END navbar header-->
        <!-- START Nav wrapper-->
        <div class="nav-wrapper">
            <!-- START Left navbar-->
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" data-toggle="aside">
                        <em class="fa fa-align-left"></em> </a></li>
            </ul>
            <!-- END Left navbar-->
            <!-- START Right Navbar-->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" data-toggle="navbar-search">
                        <em class="fa fa-search"></em> </a></li>
            </ul>
            <!-- END Right Navbar-->
        </div>
        <!-- END Nav wrapper-->
    </nav>
    <!-- END Top Navbar-->

    <!-- START aside-->
    <aside class="aside">
        <!-- START Sidebar (left)-->
        <nav class="sidebar">
            <ul class="nav">
                <!-- START user info-->
                <li>
                    <div data-toggle="collapse-next" class="item user-block has-submenu">
                        <!-- User picture-->
                        <div class="user-block-picture">
                            <img src="app/img/user/02.jpg" alt="Avatar" width="60" height="60"
                                 class="img-thumbnail img-circle">
                            <!-- Status when collapsed-->
                            <div class="user-block-status">
                                <div class="point point-success point-lg"></div>
                            </div>
                        </div>
                        <!-- Name and Role-->
                        <div class="user-block-info">
                            <span class="user-block-name item-text">尊敬的用户，欢迎您！</span>
                            <span class="user-block-role">买主&卖主</span>
                        </div>
                    </div>

                    <!-- START User links collapse-->
                    <ul class="nav collapse">
                        <li><a href="/usercenter/updatepassword">密码修改 </a></li>
                        <li class="divider"></li>
                        <li><a href="/usercenter/out">退出</a></li>
                    </ul>
                    <!-- END User links collapse-->

                </li>
                <!-- END user info-->
                <!-- START Menu-->
                <li style="background:gray;">
                    <a href="/usercenter/userinfo?action=show" title="Dashboard"
                       style="color:white; box-shadow: 0px 1px 10px rgba(0,0,0,.8);">
                        <em class="fa fa-dashboard"></em>
                        <!-- 用于添加小图标 -->
                        <span class="item-text" style="font-size:17px;">个人信息</span> </a>
                </li>
                <li>
                    <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu">
                        <em class="fa fa-bar-chart-o"></em>
                        <span class="item-text">作为买方</span> </a>
                    <!-- START SubMenu item-->
                    <ul class="nav collapse ">
                        <li>
                            <a href="/page/order">
                                <span class="item-text">未完成订单</span> </a></li>
                        <li>
                            <a href="/page/bhistory">
                                <span class="item-text">历史订单</span> </a>
                        </li>
                    </ul>
                    <!-- END SubMenu item-->
                </li>

                <li>
                    <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu">
                        <em class="fa fa-bar-chart-o"></em>
                        <span class="item-text">作为卖方</span> </a>
                    <!-- START SubMenu item-->
                    <ul class="nav collapse ">
                        <li>
                            <a href="/page/shistory">
                                <span class="item-text">已售出车辆信息</span> </a></li>
                        <li>
                        <li>
                            <a href="/page/check_order">
                                <span class="item-text">未售出车辆信息</span> </a></li>
                        <li>
                            <a href="/page/check_car">
                                <span class="item-text">预售车辆信息发布</span> </a>
                        </li>
                    </ul>
                    <!-- END SubMenu item-->
                </li>

                <li>
                    <a href="/page/collection" title="Standard">
                        <em class="fa fa-table"></em>
                        <span class="item-text">收藏夹</span> </a>
                </li>
                <li>
                    <a href="/page/index" title="Pages">
                        <em class="fa fa-file-text"></em>
                        <div class="label label-primary pull-right">new</div>
                        <span class="item-text">返回首页</span> </a>
                </li>
                <!-- END Menu-->
                <!-- Sidebar footer    -->
                <li class="nav-footer">
                    <div class="nav-footer-divider"></div>
                    <!-- START button group-->
                    <div class="btn-group text-center">
                        <button type="button" data-toggle="tooltip" data-title="退出" class="btn btn-link">
                            <em class="fa fa-sign-out text-muted"></em></button>
                    </div>
                    <!-- END button group-->
                </li>
            </ul>
        </nav>
        <!-- END Sidebar (left)-->
    </aside>
    <!-- End aside-->

    <!-- START aside-->
    <aside class="offsidebar">
        <!-- START Off Sidebar (right)-->
        <nav>
            <ul class="nav">
                <!-- START user info-->
                <li>
                    <div class="item">
                        <div style="background-image: url('${basePath}/resources/app/img/offsidebar-bg.jpg')"
                             class="p-lg">
                            <div class="text-center">
                                <p>
                                    <img src="app/img/user/02.jpg" style="width: 64px; height: 64px" alt="Image"
                                         class="img-circle img-thumbnail"></p>
                                <p class="text-white">
                                    <strong>Alex</strong></p>
                            </div>
                        </div>
                    </div>
                </li>
                <!-- END user info-->
                <!-- START list title-->
                <li class="p">
                    <small class="text-muted">ONLINE</small>
                </li>
                <!-- END list title-->
                <li>
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-success point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/05.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Tommy Sam</strong>
                           <br>
                           <small class="text-muted">tommy39</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-success point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/06.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Beverley Pierce</strong>
                           <br>
                           <small class="text-muted">be40210</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-danger point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/07.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Victor Long</strong>
                           <br>
                           <small class="text-muted">longlong</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-warning point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/08.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Danielle Berry</strong>
                           <br>
                           <small class="text-muted">hunter49</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                </li>
                <!-- START list title-->
                <li class="p">
                    <small class="text-muted">OFFLINE</small>
                </li>
                <!-- END list title-->
                <li>
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/09.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Bertha Cooper</strong>
                           <br>
                           <small class="text-muted">ber123</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                    <!-- START User status-->
                    <a href="#" class="media p mt0">
                     <span class="pull-right">
                        <span class="point point-lg"></span>                     </span>
                        <span class="pull-left">
                        <!-- Contact avatar-->
                        <img src="app/img/user/10.jpg" style="width: 40px; height: 40px" alt="Image"
                             class="media-object img-circle">                     </span>
                        <!-- Contact info-->
                        <span class="media-body">
                        <span class="media-heading">
                           <strong class="text-white">Anne Curtis</strong>
                           <br>
                           <small class="text-muted">anni</small>                        </span>                     </span>
                    </a>
                    <!-- END User status-->
                </li>
                <li>
                    <!-- Optional link to list more users-->
                    <a href="#" title="See more contacts" class="p">
                        <strong>
                            <small class="text-muted">&hellip;</small>
                        </strong> </a></li>
            </ul>
        </nav>
        <!-- END Off Sidebar (right)-->
    </aside>
    <!-- END aside-->

    <!-- START Main section-->
    <section>
        <!-- START Page content-->
        <!--XXX1-->
        <section class="main-content">
            <h3>个人信息
                <br>
                <small>请完善您的个人信息，以获取更多特权</small>
            </h3>
            <!-- START panel-->
            <div class="panel panel-default">
                <div class="panel-heading">基本信息</div>
                <div class="panel-body">
                    <form method="get" class="form-horizontal">

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-4">
                                    ${username}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">真实姓名</label>
                                <div class="col-sm-4" id="name">
                                    ${name}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4" id="sex">
                                    ${sex}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">年龄</label>
                                <div class="col-sm-4" id="age">
                                    ${age}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户手机</label>
                                <div class="col-sm-4" id="phone">
                                    ${phone}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户邮箱</label>
                                <div class="col-sm-4">
                                    ${email}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">注册时间</label>
                                <div class="col-sm-4">
                                    ${registertime}
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button type="button" id="edit" style="display:block" class="btn btn-primary">编辑
                                    </button>
                                    <button type="button" id="cancel" style="display:none" class="btn btn-default">取消
                                    </button>
                                    <button type="button" id="save" style="display:none" class="btn btn-primary">保存修改
                                    </button>
                                </div>
                            </div>
                        </fieldset>

                    </form>
                </div>
            </div>
            <!-- END panel-->
        </section>
        <!-- END Page content-->
    </section>
    <!-- END Main section-->

</section>
<!-- END Main wrapper-->
<!-- START Scripts-->
<!-- Main vendor Scripts-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Plugins-->
<script src="vendor/chosen/chosen.jquery.min.js"></script>
<script src="vendor/slider/js/bootstrap-slider.js"></script>
<script src="vendor/filestyle/bootstrap-filestyle.min.js"></script>
<!-- Animo-->
<script src="vendor/animo/animo.min.js"></script>
<!-- Sparklines-->
<script src="vendor/sparklines/jquery.sparkline.min.js"></script>
<!-- Slimscroll-->
<script src="vendor/slimscroll/jquery.slimscroll.min.js"></script>
<!-- START Page Custom Script-->
<!-- Markdown Area Codemirror and dependencies -->
<script src="vendor/codemirror/lib/codemirror.js"></script>
<script src="vendor/codemirror/addon/mode/overlay.js"></script>
<script src="vendor/codemirror/mode/markdown/markdown.js"></script>
<script src="vendor/codemirror/mode/xml/xml.js"></script>
<script src="vendor/codemirror/mode/gfm/gfm.js"></script>
<script src="vendor/marked/marked.js"></script>
<!-- MomentJs and Datepicker-->
<script src="vendor/moment/min/moment-with-langs.min.js"></script>
<script src="vendor/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!-- Tags input-->
<script src="vendor/tagsinput/bootstrap-tagsinput.min.js"></script>
<!-- Input Mask-->
<script src="vendor/inputmask/jquery.inputmask.bundle.min.js"></script>
<!-- END Page Custom Script-->
<!-- App Main-->
<script src="app/js/app.js"></script>
<!--XXX2-->
<script>
    var status = 0;
    var init_name;
    var init_sex;
    var init_age;
    var init_phone;

    $("#edit").click(function () {
        if (status == 0) {
            $("#edit").attr("style", "display:none");
            $("#save").attr("style", "display:block");
            $("#cancel").attr("style", "display:block");

            init_name = $("#name").html();
            init_sex = $("#sex").html();
            init_age = $("#age").html();
            init_phone = $("#phone").html();

            $("#name").html("<input type=\"text\" id=\"nameInput\" class=\"form-control\" value=" + init_name + ">");
            $("#sex").html("<input type=\"text\" id=\"sexInput\" class=\"form-control\" value=" + init_sex + ">");
            $("#age").html("<input type=\"text\" id=\"ageInput\" class=\"form-control\" value=" + init_age + ">");
            $("#phone").html("<input type=\"text\" id=\"phoneInput\" class=\"form-control\" value=" + init_phone + ">");
            status = 1;
        }
        return false;
    });

    $("#save").click(function () {
        if (status == 1) {
            $("#edit").attr("style", "display:block");
            $("#save").attr("style", "display:none");
            $("#cancel").attr("style", "display:none");

            var name = $("#nameInput").val();
            var sex = $("#sexInput").val();
            var age = $("#ageInput").val();
            var phone = $("#phoneInput").val();

            $("#name").html(name);
            $("#sex").html(sex);
            $("#age").html(age);
            $("#phone").html(phone);

            status = 0

            $.ajax({
                type: "POST",
                url: "../usercenter/userinfo?action=save",
                data: {name: name, sex: sex, age: age, phone: phone}
            });
        }
    });

    $("#cancel").click(function () {
        if (status == 1) {
            $("#edit").attr("style", "display:block");
            $("#save").attr("style", "display:none");
            $("#cancel").attr("style", "display:none");

            $("#name").html(init_name);
            $("#sex").html(init_sex);
            $("#age").html(init_age);
            $("#phone").html(init_phone);
            status = 0
        }
        return false;
    });

</script>
<!-- END Scripts-->
</body>

</html>