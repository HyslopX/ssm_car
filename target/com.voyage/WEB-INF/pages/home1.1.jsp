<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"+"resources/";
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
    <!-- font awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">

    <!-- bootstrap -->
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css"/>

    <!-- animate.css -->
    <link rel="stylesheet" href="assets/animate/animate.css"/>

    <!-- gallery -->
    <link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

    <!-- favicon -->
    <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <link rel="icon" href="images/favicon.png" type="image/x-icon">


    <link rel="stylesheet" href="assets/style.css">

<%--<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>--%>
<script type="text/javascript">
$(document).ready(function(){
	$(".app").click(function(){
		$(".erweima").slideToggle();
	});
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$(".shoufang").click(function(){
		$(".lianxiway").slideToggle();
	});
	$(".contact_us").click(function(){
		$(".lianxiway").slideDown();
	});
});
</script>
</head>
<body>
<style type="text/css">
    .shoubu{border-radius:25px;background-color:#f0f0f0;margin-top:0px;margin-bottom:10px;border-bottom:1px solid #6e6e6e;box-shadow:2px 4px 6px #000;}
    .shoubu p{display:inline-block;padding:20px 20px 5px 20px;}
    .shoubu_p{padding:20px 20px 35px 20px;}
    .shoubu p a:hover{text-decoration:none;box-shadow:1px 2px 1px #000;}
    .backtable{border-radius:5px;display:inline-block;height:40px;padding:0px 45px 5px 45px;}
    .top-information{background-color:white;margin-left:50px !important;border:1px solid #6e6e6e;border-radius:45px;width:400px !important;margin-top:70px;padding:5px 3px 120px 3px;}
    .top-information h1{padding-top:20px;padding-bottom:20px;}
    .top-information p{line-height:2em !important;}
    .ab-center{vertical-align:middle;}
    .footer_bg1{background-color:#222;position:relative;bottom:0;right:0;left:0;text-align:center;}
    #toTop{position:fixed;right:10px;bottom:15px;background: url(images/top_move.png) no-repeat right top;}
    .qr-sanjiao{position:absolute;top:598px;left:210px;width:0;height:0;border-style:solid;border-width:10px 7px 4px;border-color:#99ebef transparent transparent}
</style>
<div class="shoubu"style="text-align:center;font-size:30px;">
	<div class="shoubu_p">
	<img alt="" src="images/dongtong2.png"style="width:50px;position:relative;left:-30px;">
	<p>|</p>
	<p class="logo" style="font:700 1.5em Raleway,Arial,Helvetica;position:relative;left:-60px;top:10px;">DongTong</p>
	<table class="backtable"style="font-weight: 600;">
		<tr>
			<td>
				<p><a href="/page/index">首页</a></p>
				<p><a href="/page/showCar" >我要买车</a></p>
				<p><a  href="javascript:showDialog();">我要卖车</a></p>
				<p> <a href="${basePath}/page/user" >个人中心</a></p>
				<img class="contact_us"alt="" src="images/contact.png"style="width:60px;position:absolute;right:50px;top:40px;">
			</td>
		</tr>
	</table>
	</div>
</div>

<div class="lianxiway"style="position:fixed;z-index:1;right:0px;width:80px;height:270px;background-color:#fff;border:1px solid #6e6e6e;line-height:2;">
				<div class="lianxi">
				<p>联系电话：098-8765-728</p>
				<p>地址：四川省成都市郫县箐蓉镇华迪有限公司405</p>
				<p class="shoufang"style="text-align:center;">收起</p>
				</div>
</div>


<div>
</div>

<!-- slider -->
<div id="carousel-banner" class="carousel slide" data-ride="carousel"style="z-index:-1;padding-top:0px;">
    <div class="carousel-inner" role="listbox">
        <div class="item active"><img src="images/banner1.jpg" class="img-responsive"style="z-index:-1;"></div>
        <div class="item"><img src="images/banner2.jpg" class="img-responsive"style="z-index:-1;"></div>
        <div class="item"><img src="images/banner3.jpg" class="img-responsive"style="z-index:-1;"></div>
    </div>
    
	<div class="ab-center">
	<div class="app"style="height:70px;background-color:orange;width:620px;margin-right:10px;padding-left:40px;float:left;">
	
	<img alt="" src="images/app.png"style="width:60px;">
	<p style="width:40px;display:inline-block;font-size:20px;">APP</p>
	<p style="width:80px;display:inline-block;font-size:20px;vertical-align:middle;margin-left:30px;">平台介绍</p>
	<p style="width:80px;display:inline-block;font-size:20px;vertical-align:middle;margin-left:30px;">服务保障</p>
	<div style="display:inline-block;z-index:1;"><p style="width:80px;display:inline-block;font-size:20px;vertical-align:middle;margin-left:30px;">联系方式</p></div>
</div>

<div class="erweima"style="display:inline-block;margin-top:8px;margin-left:40px;">
	<img alt="" src="images/erweima.png"style="width:50px;display:inline-block;">
</div>	
<div class="erweima"style="display:inline-block;margin-top:8px;margin-left:40px;">
	<img alt="" src="images/erweima.png"style="width:50px;display:inline-block;">
</div>

	</div>

    <!-- caption -->
    <div class="caption" style="margin-top: -100px;">
        <div class="ab-wrap">
            <div class="ab-center">
                <div class="top-information"style="margin-top:0px;">
                    <div style="margin-left: 30px;"><img src="images/logo0.png" style="width:320px;height:150px; " alt="1"></div>
                    <div class="text-center"  >
                    <h4 style="margin-top: 20px;margin-bottom: 10px;color: black"> 提供可靠快捷的二手车平台</h4>
                        <h4 style="margin-top: 20px;margin-bottom: 10px;color: black"> 线上预定，线下付款提车，避免中间差价</h4>
                        <h4 style="margin-top: 20px;margin-bottom: 10px; color: black">用户可浏览他人发布的二手车信息并预约</h4>
                    <h4 style="margin-top: 20px;margin-bottom: 10px; color: black">或是发布自己的二手车信息供他人购买</h4>
                        <h4 style="margin-top: 20px;margin-bottom: 10px; color: black"  >提供汽车信息搜索、筛选服务</h4>
                        <h4 style="margin-top: 20px;margin-bottom: 10px; color: black">用户的订单、收藏、历史信息管理</h4>
                    </div>
                    <div class="qr-sanjiao"></div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Controls -->
    <div class="next-prev">
        <a class="left" href="#carousel-banner" role="button" data-slide="prev"><i
                class="fa fa-3x fa-angle-left"style="width:30px;color:white;position:relative;right:40px;"><</i></a>
        <a class="right" href="#carousel-banner" role="button" data-slide="next"><i class="fa fa-3x fa-angle-right"style="width:30px;color:white;position:relative;right:40px;">></i></a>
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
<div style="margin-top:70px;margin-bottom:30px;">
	<p style="padding-left:40px;font-size:30px;height:30px;border-bottom:1px solid #6e6e6e;"><em style="border-bottom:4px solid green;">热门好车</em></p>
</div>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
                       data-gallery="">详细查看</a>
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
<div class="footer_bg1">
<div class="wrap">
	<div class="footer">
		<!-- scroll_top_btn -->
	    <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		 <a href="/page/index" id="toTop" style="display: block;height:34px;width:34px;">
		 <span id="toTopHover" style="opacity: 1;color:green"></span></a>
		<!--end scroll_top_btn -->
		<div class="copy">
			<p class="link" style="text-align:center;color:#ffffff;line-height:50px;">SouthWestJiaoTongUniversity西南交通大学; 2017.华迪实训公司-第二小组.</p>
		</div>
		<div class="clear"></div>
	</div>
</div>
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


<!-- jquery -->
<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>

<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>

<!-- gallery -->
<%--<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>--%>

<!-- custom script -->
<%--<script src="assets/script.js"></script>--%>
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