<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie ie6 lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="ie ie7 lt-ie9 lt-ie8"        lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="ie ie8 lt-ie9"               lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="ie ie9"                      lang="en"> <![endif]-->
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
   <!--[if lt IE 9]><script src="js/html5shiv.js"></script><script src="js/respond.min.js"></script><![endif]-->
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
            </a>         </div>
         <!-- END navbar header-->
         <!-- START Nav wrapper-->
         <div class="nav-wrapper">
            <!-- START Left navbar-->
            <ul class="nav navbar-nav">
               <li>
                  <a href="#" data-toggle="aside">
                     <em class="fa fa-align-left"></em>                  </a>               </li>
            </ul>
            <!-- END Left navbar-->
            <!-- START Right Navbar-->
            <ul class="nav navbar-nav navbar-right">
               <li>
                  <a href="#" data-toggle="navbar-search">
                     <em class="fa fa-search"></em>                  </a>               </li>
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
                        <img src="app/img/user/02.jpg" alt="Avatar" width="60" height="60" class="img-thumbnail img-circle">
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
                     <li><a href="${basePath}/usercenter/updatepassword">密码修改 </a></li>
                     <li class="divider"></li>
                     <li><a href="/usercenter/out">退出</a>                     </li>
                  </ul>
                  <!-- END User links collapse-->
               </li>
               <!-- END user info-->
               <!-- START Menu-->
                <li>
                  <a href="${basePath}/usercenter/userinfo?action=show" title="Dashboard" data-toggle="" class="no-submenu">
                     <em class="fa fa-dashboard"></em>
                     <span class="item-text">个人信息</span>                  </a>
               </li>
               <li>
                  <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu">
                     <em class="fa fa-bar-chart-o"></em>
                     <span class="item-text">作为买方</span>                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                     <li style="background:gray;">
                        <a href="/page/order">
                           <span class="item-text">未完成订单</span>                        </a>                     </li>
                     <li>
                        <a href="/page/bhistory">
                           <span class="item-text">历史订单</span>                  </a>
                     </li>
                  </ul>
               </li>
               <li style="background:gray;">
                  <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu"
                  style="color:white; box-shadow: 0px 1px 10px rgba(0,0,0,.8);">
                     <em class="fa fa-bar-chart-o"></em>
                     <span class="item-text" style="font-size:17px;">作为卖方</span>                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                     <li>
                        <a href="/page/shistory">
                           <span class="item-text">已售出车辆信息</span>                        </a>                     </li>
                     <li>
                     <li>
                        <a href="/page/check_order">
                           <span class="item-text">订单确认</span>                        </a>                     </li>
                     <li style="background:gray;">
                        <a href="/page/check_car" style="color:white; box-shadow: 0px 1px 10px rgba(0,0,0,.8);">
                           <span class="item-text" style="font-size:17px;">我发布的车辆信息</span>                  </a>
                     </li>
                  </ul>
               </li>

               <li>
                  <a href="/page/collection" title="Standard" >
                     <em class="fa fa-table"></em>
                     <span class="item-text">收藏夹</span>                  </a>
               </li>
               <li>
                  <a href="${basePath}/page/index" title="Pages" data-toggle="" class="no-submenu">
                     <em class="fa fa-file-text"></em>
                     <div class="label label-primary pull-right">new</div>
                     <span class="item-text">返回首页</span>                  </a>
               </li>
               <!-- END Menu-->
               
               <!-- Sidebar footer    -->
               <li class="nav-footer">
                  <div class="nav-footer-divider"></div>
                  <!-- START button group-->
                  <div class="btn-group text-center">
                     <button type="button" data-toggle="tooltip" data-title="退出" class="btn btn-link">
                        <em class="fa fa-sign-out text-muted"></em>                     </button>
                  </div>
                  <!-- END button group-->
               </li>
            </ul>
         </nav>
         <!-- END Sidebar (left)-->
      </aside>
      <!-- End aside-->
      <!--XXX1-->
      <section>
         <!-- START Page content-->
         <section class="main-content">
            <h3>已发布汽车信息
               <br>
               <small>可查阅已发布的汽车信息</small>
            </h3>
            <!-- START panel-->
            <div class="panel panel-default">
               <div class="panel-heading">未完成订单
                  <a href="#" data-perform="panel-dismiss" data-toggle="tooltip" title="Close Panel" class="pull-right">
                     <em class="fa fa-times"></em>
                  </a>
                  <a href="#" data-perform="panel-collapse" data-toggle="tooltip" title="Collapse Panel" class="pull-right">
                     <em class="fa fa-minus"></em>
                  </a>
               </div>
               <!-- START table-responsive-->
               <div class="table-responsive">
                  <table id="table-id" class="table table-bordered table-hover">
                     <thead>
                     <tr class="table-th">
                        <th>汽车编号</th>
                        <th>名称</th>
                        <th>配置名</th>
                        <th>变速箱</th>
                        <th>发动机</th>
                        <th>车身结构</th>
                        <th>车龄</th>
                        <th>行驶里程</th>
                        <th>操作</th>
                     </tr>
                     <thead>
                     <tbody id= "table-tbody" class="table-tbody">
                     <c:forEach items="${itemsList}" var="item">
                        <tr>
                           <td>${item.carId}</td>
                           <td>${item.carName}</td>
                           <td><a href="/page/details?id=${item.carId}">${item.confName}</a></td>
                           <td>${item.gearbox}</td>
                           <td>${item.engine}</td>
                           <td>${item.bodyStructure}</td>
                           <td>${item.carAge}</td>
                           <td>${item.carMileage}</td>
                           <td><a href="javascript:void(0);"  id="cancel">撤销</a></td>
                        </tr>
                     </c:forEach>
                     </tbody>
                  </table>
               </div>
               <!-- END table-responsive-->
               <div class="panel-footer">
                  <div class="row">
                     <div class="col-lg-2">
                        <div class="input-group">

                        </div>
                     </div>
                     <div class="col-lg-8"></div>
                     <div class="col-lg-2">
                        <div class="input-group">
                           <p>客服电话：400-828-3499</p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- END panel-->
         </section>
         <!-- END Page content-->
      </section>
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

   <!-- END Scripts-->
</body>

</html>