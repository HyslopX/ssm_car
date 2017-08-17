<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Home</title>

    <link rel="stylesheet" href="css/sellcar.css" media="all">
    <!-- Google fonts -->
    <%--<link href='css/googlefonts.css' rel='stylesheet' type='text/css'>  X4 --%>

    <!-- font awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">

    <!-- bootstrap -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css"/>

    <!-- animate.css -->
    <link rel="stylesheet" href="assets/animate/animate.css"/>
    <%--<script href="js/jquery.form.js"></script>--%>
    <!-- gallery -->
    <%--<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">  X2 --%>

    <!-- favicon -->
    <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <link rel="icon" href="images/favicon.png" type="image/x-icon">


    <link rel="stylesheet" href="assets/style.css">

</head>
<!-- header -->

<body>
<style>
    .head_container{
        width:100%;
        height:60px;
        background: #303643;
        /*background: #EEEEEE;*/
        opacity: 0.9;
        font-size:18px;
        overflow:hidden;
    }

    .head_container .container{
        width:90%;
    }

    .head_container a{
        color:#fff;
    }

    .unionInfo .unionLogo{
        height:60px;
        width:170px;
    }

    .unionInfo .unionContent{
        padding:20px;

    }
    .userInfo .head_pic{
        padding:5px;
    }

    .userInfo .head_pic img{
        width:50px;
        height:50px;
        border-radius:25px;
        transition:0.5s;
    }
    .userInfo .head_pic img:hover{
        width:55px;
        height:55px;
        border-radius:50%;
    }


    .userInfo .userContent{
        padding:20px;
    }

    .head_container .list-inline li a:hover{
        text-decoration:none;
        /*color:#FE7300;*/
        color: #00A9C6;
        cursor: pointer;
        font-size:20px;
    }

</style>
<div class="head_container text-center">
    <div class="container">
        <div class="header">
            <div class="unionInfo col-md-7">
                <div class="col-sm-3 unionLogo center-block">
                    <img class="img-responsive" style="width: 50px;height: 50px;" src="images/logo.png" />
                </div>
                <div class="col-sm-8 unionContent text-center">
                    <ul class="list-inline">
                        <li class="col-sm-3"><a href="#">首页</a></li>
                        <li class="col-sm-3"><a href="${basePath}/route" target="_blank" style="z-inedx:999;">我要买车</a></li>
                        <li class="col-sm-3"><a href="#">我要卖车</a></li>
                        <li class="col-sm-3"><a href="#"></a></li>
                    </ul>
                </div>
            </div>

            <div class="userInfo col-md-5">
                <div class="col-sm-2 head_pic center-block">
                    <img class="img-responsive" src="images/head_pic.jpg" />
                </div>
                <div class="col-sm-8 userContent text-center">
                    <ul class="list-inline">
                        <li class="col-sm-3"><a src="#">消息</a></li>
                        <li class="col-sm-3"><a src="#">收藏</a></li>
                        <li class="col-sm-3"><a src="#">历史</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- slider -->
<div id="carousel-banner" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner" role="listbox">
        <div class="item active"><img src="images/banner1.jpg" class="img-responsive"></div>
        <div class="item"><img src="images/banner2.jpg" class="img-responsive"></div>
        <div class="item"><img src="images/banner3.jpg" class="img-responsive"></div>
    </div>

    <!-- caption -->
    <div class="caption">
        <div class="ab-wrap">
            <div class="ab-center">
                <div class="top-information">
                    <h1 class="logo">东通</h1>
                    <p> 东通二手车致力于为二手车交易提供可靠快捷的平台，线上预定，线下付款提车，避免中介赚差价<br>
                        基于Spring+SpringMVC+Mybatis框架构建一个B/S的二手车网上交易平台。用户可在该平台浏览他人发布的二手车信息并选择预约购买二手车，或是发布自己的二手车销售信息供他人购买。平台将提供可靠的汽车信息搜索、筛选服务以及买家用户的订单信息管理与卖家用户的二手车信息管理等功能。
                    </p>
                    <a href="/page/showCar" class="btn"><i class="fa fa-anchor"></i>我要买车</a>
                    <a class="btn" href="javascript:showDialog();"><i class="fa fa-anchor"></i>我要卖车</a>
                    <a href="${basePath}/page/user" class="btn"><i class="fa fa-leaf"></i>个人中心</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Controls -->
    <div class="next-prev">
        <a class="left" href="#carousel-banner" role="button" data-slide="prev"><i
                class="fa fa-3x fa-angle-left"></i></a>
        <a class="right" href="#carousel-banner" role="button" data-slide="next"><i class="fa fa-3x fa-angle-right"></i></a>
    </div>
</div>

<!--sellcar_info-->
<div class="ui-dialog" id="dialogMove" onselectstart='return false;'>
    <div class="ui-dialog-content">
        <div class="panel panel-default">
            <div class="panel-body">

                <form method="post" action="${basePath}/home/sellcar" id="baseinfo" class="form-horizontal" enctype="multipart/form-data">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">上传车辆图片</label>
                            <img id="img" width="200px" style="margin-left:20px;">
                            <div class="col-sm-4">
                                <input type="file" name="file" id="fileInput" style="margin-left:20px;" data-classbutton="btn btn-default"
                                       data-classinput="form-control inline" class="filestyle form-control">
                            </div>
                        </div>
                    </fieldset>

                    <fieldset>
                        <legend>输入基本信息</legend>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">车辆品牌</label>
                            <div class="col-sm-10">
                                <select style="width: 260px; margin-left:20px;" class="form-control m-b" id="brand" name="brand">
                                    <optgroup label="热门车型">
                                        <option selected="selected">宝马</option>
                                        <option>奔驰</option>
                                        <option>奥迪</option>
                                        <option>大众</option>
                                        <option>福特</option>
                                        <option>丰田</option>
                                        <option>本田</option>
                                        <option>日产</option>
                                    </optgroup>
                                    <optgroup label="A">
                                        <option>奥迪</option>
                                        <option>安驰</option>
                                    </optgroup>
                                    <optgroup label="B">
                                        <option>别克</option>
                                        <option>比亚迪</option>
                                    </optgroup>
                                    <optgroup label="C">
                                        <option>长安</option>
                                        <option>川汽野马</option>
                                    </optgroup>
                                    <optgroup label="D">
                                        <option>东风</option>
                                        <option>东南</option>
                                    </optgroup>
                                    <optgroup label="F">
                                        <option>福特</option>
                                        <option>法拉利</option>
                                    </optgroup>
                                </select>
                                <select style="width: 260px; margin-left:20px;" name="car_name" id="car_name" class="form-control m-b">
                                    <option value="AK1" selected="selected">宝马1系</option>
                                    <option>宝马3系</option>
                                    <option>宝马5系</option>
                                    <option>宝马7系</option>
                                    <option>宝马X3</option>
                                    <option>宝马X5</option>
                                    <option>宝马X6</option>
                                    <option>宝马Z5</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">里程数</label>
                            <div class="col-sm-10">
                                <input type="text" style="width: 260px; margin-left:20px;" name="car_mileage" id="car_mileage" placeholder="单位（万公里）"
                                       class="form-control">
                                <span class="help-block m-b-none">车辆从购买之日起跑过的里程数，以里程表上数据为准，禁止造假.</span></div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label for=car_price class="col-sm-2 control-label">报价</label>
                            <div class="col-sm-10">
                                <input style="width: 260px; margin-left:20px;" name="price" id="car_price" placeholder="单位（万元）"
                                       type="text" class="form-control">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label for="car_age" class="col-sm-2 control-label">车龄</label>
                            <div class="col-sm-10">
                                <input style="width: 260px; margin-left:20px;" name="car_age" id="car_age" placeholder="单位（年）"
                                       type="text" class="form-control">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset class="last-child">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">受损程度</label>
                            <div class="col-sm-10">
                                <select style="width: 260px; margin-left:20px;" name="car_damage" id="car_damage" class="form-control m-b">
                                    <option>0%</option>
                                    <option>5%</option>
                                    <option>10%</option>
                                    <option>15%</option>
                                    <option>20%</option>
                                    <option>25%</option>
                                    <option>30%</option>
                                    <option>35%</option>
                                    <option>40%</option>
                                    <option>45%</option>
                                    <option>50%</option>
                                    <option>55%</option>
                                    <option>60%</option>
                                    <option>65%</option>
                                    <option>70%</option>
                                    <option>75%</option>
                                    <option>80%</option>
                                    <option>85%</option>
                                    <option>90%</option>
                                    <option>95%</option>
                                    <option>100%</option>
                                </select>
                                <br>
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">验车地址</label>
                            <div class="col-sm-10">
                                <input id="address" name="address" style="width: 260px; margin-left:20px;" placeholder="请填写详细地址"
                                       type="text" class="form-control">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label for="license_address" class="col-sm-2 control-label">牌照归属地</label>
                            <div class="col-sm-10">
                                <input id="license_address" name="license_address" style="width: 260px; margin-left:20px;" placeholder="如：四川成都"
                                       type="text" class="form-control">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <label for="iseager" class="col-sm-2 control-label">是否急于出售</label>
                            <div class="col-sm-10">
                                <select style="width: 260px; margin-left:20px;" id="iseager" name="iseager" class="form-control m-b">
                                    <option>是</option>
                                    <option>否</option>
                                </select>
                                <br>
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button type="button" onclick="javascript:hideDialog();">取消</button>
                                <button type="button" id="carinfo_submit">提交</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- slider -->

<!-- product list -->
<div class="row-fluid gallery clearfix" id="portfolio">
    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp">
        <img src="images/photos/1.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/1.jpg" title="Shoes" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp">
        <img src="images/photos/2.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/2.jpg" title="Formal" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp">
        <img src="images/photos/3.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/3.jpg" title="Red" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp ">
        <img src="images/photos/4.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/4.jpg" title="Brown" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp ">
        <img src="images/photos/5.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/5.jpg" title="Leather" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp ">
        <img src="images/photos/6.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/6.jpg" title="Blue" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp ">
        <img src="images/photos/7.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/7.jpg" title="Sports" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->

    <!-- product -->
    <div class="col-sm-3 product wowload fadeInUp ">
        <img src="images/photos/8.jpg" class="img-responsive">
        <div class="overlay">
            <div class="ab-wrap">
                <div class="ab-center text-center">
                    <h3>大众汽车</h3>
                    <p>$ 20.00</p>
                    <a href="images/photos/8.jpg" title="Converse" class="btn btn-default gallery-image"
                       data-gallery="">详细信息</a>
                </div>
            </div>
        </div>
    </div>
    <!-- product -->
</div>
<!-- product list -->


<!-- about -->

<!---<div id="map"></div>--->
<!-- contact -->


<!-- footer -->
<div class="footer text-center">
    <div class="social">
        <a href="#"><i class="fa fa-facebook fa-2x"></i></a>
        <a href="#"><i class="fa fa-instagram fa-2x"></i></a>
        <a href="#"><i class="fa fa-twitter fa-2x"></i></a>
        <a href="#"><i class="fa fa-pinterest fa-2x"></i></a>
    </div>
    Copyright &copy; 2017.Company name All rights reserved.
</div>
<!-- footer -->

<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title">Title</h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <!-- The modal dialog, which will be used to wrap the lightbox content -->
</div>

<a href="#home" class="gototop scroll"><i class="fa fa-angle-up  fa-3x"></i></a>

<!-- jquery -->
<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>

<!-- boostrap -->
<%--<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>--%>

<!-- jquery mobile -->
<%--<script src="assets/mobile/touchSwipe.min.js"></script> ??X8   --%>
<script src="assets/respond/respond.js"></script>
<%--<script src="font/fontawesome-webfont.woff"></script>--%>
<%--<script src="fontawesome-webfont.ttf"></script>--%>
<!-- gallery -->
<%--<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>  X3 --%>

<!-- custom script -->
<%--<script src="assets/script.js"></script>          X5 --%>
<%--<script src="js/ajaxFileupload.js"></script>--%>

<script src="js/jquery.form.js"></script>
<script src="js/browser.js"></script>

<!--sellcar_info script-->
<script type="text/javascript">

    var dialogInstace, onMoveStartId, mousePos = {x: 0, y: 0};	//	用于记录当前可拖拽的对象

    // var zIndex = 9000;

    //	获取元素对象
    function g(id) {
        return document.getElementById(id);
    }

    //	自动居中元素（el = Element）
    function autoCenter(el) {
        var bodyW = document.documentElement.clientWidth;
        var bodyH = document.documentElement.clientHeight;

        var elW = el.offsetWidth;
        var elH = el.offsetHeight;

        el.style.left = (bodyW - elW) / 2 + 'px';
        el.style.top = (bodyH - elH) / 2 + 'px';
    }
    //	Dialog实例化的方法
    function Dialog(dragId, moveId) {

        var instace = {};

        instace.dragElement = g(dragId);	//	允许执行 拖拽操作 的元素
        instace.moveElement = g(moveId);	//	拖拽操作时，移动的元素

        instace.mouseOffsetLeft = 0;			//	拖拽操作时，移动元素的起始 X 点
        instace.mouseOffsetTop = 0;			//	拖拽操作时，移动元素的起始 Y 点

        instace.dragElement.addEventListener('mousedown', function (e) {

            var e = e || window.event;

            dialogInstace = instace;
            instace.mouseOffsetLeft = e.pageX - instace.moveElement.offsetLeft;
            instace.mouseOffsetTop = e.pageY - instace.moveElement.offsetTop;

            onMoveStartId = setInterval(onMoveStart, 10);
            return false;
            // instace.moveElement.style.zIndex = zIndex ++;
        });

        return instace;
    }
    //	重新调整对话框的位置和遮罩，并且展现
    function showDialog() {
        var user = "${user}";  //若session无user值 判为游客登录 返回登录界面
        if(user=="" || user==null) {
            alert("请先登录");
            window.location.href="/login/login"
        }
        g('dialogMove').style.display = 'block';
        autoCenter(g('dialogMove'));
    }
    //	关闭对话框
    function hideDialog() {
        g('dialogMove').style.display = 'none';
    }
    //Dialog('dialogDrag', 'dialogMove');
</script>

<script type="text/javascript">
    $("#carinfo_submit").click(function () {
        var fileInput = $.trim($("#fileInput").val());
        var brand = $.trim($("#brand").find("option:selected").text());
        var car_name = $.trim($("#car_name").find("option:selected").text());
        var car_mileage = $.trim($("#car_mileage").val());
        var price = $.trim($("#car_price").val());
        var car_age = $.trim($("#car_age").val());
        var car_damage = $.trim($("#car_damage").find("option:selected").text());
        var address = $.trim($("#address").val());
        var license_address = $.trim($("#license_address").val());
        var iseager = $.trim($("#iseager").find("option:selected").text());

        if (fileInput == "") {
            alert("请至少上传一张图片！");
            return false;
        } else if (car_mileage == "") {
            alert("行驶里程不能为空！");
            return false;
        }
        else if (price == "") {
            alert("汽车售价不能为空！");
            return false;
        } else if (car_age == "") {
            alert("车龄不能为空！");
            return false;
        }
        else if (address == "") {
            alert("验车地址不能为空！");
            return false;
        }
        else if (license_address == "") {
            alert("汽车牌照归属地不能为空！");
            return false;
        }

        //ajax去服务器端校验

        var options = {
                 success: function(data) {
                 alert(data);
                 $(this).resetForm();
                 javascript:hideDialog();
             }
         };

        $('#baseinfo').ajaxSubmit(options);
    });

</script>
</body>
</html>