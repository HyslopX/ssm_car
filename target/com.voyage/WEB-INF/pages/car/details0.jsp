<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "resources/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>汽车详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start details -->
    <link rel="stylesheet" type="text/css" href="css/productviewgallery.css" media="all"/>
    <%--<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/cloud-zoom.1.0.3.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script> X-1 --%>
    <%--<script type="text/javascript" src="js/jquery.fancybox-buttons.js"></script> X-2 --%>
    <%--<script type="text/javascript" src="js/jquery.fancybox-thumbs.js"></script> X-3 --%>
    <%--<script type="text/javascript" src="js/productviewgallery.js"></script>--%>
    <!-- start top_js_button -->
    <%--<script type="text/javascript" src="js/jquery.min.js"></script> X-4--%>
    <%--<script type="text/javascript" src="js/move-top.js"></script>         --%>
    <%--<script type="text/javascript" src="js/easing.js"></script>--%>

    <%--<script type="text/javascript">--%>
        <%--jQuery(document).ready(function ($) {--%>
            <%--$(".scroll").click(function (event) {--%>
                <%--event.preventDefault();--%>
                <%--$('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
        $(function(){


//            console(user);
                $("#order").click(function(){
                    var user = "${user}";  //若session无user值 判为游客登录 返回登录界面
                    if(user=="" || user==null) {
                        alert("请先登录");
                        window.location.href="/login/login"
                    }
                $.ajax({
                    type:"post",
                    url:"../order/create",
                    data:{id:${carInfo.carInfo.carId}},
                    success:function(data){
                        if(data == "success"){
                            alert("添加订单成功");
                        }else if(data == "fail"){
                            alert("您已添加该订单");
                        }
//                        alert(data);
//                        alert(typeof data);
//                        alert(JSON.stringify(data));

                    }
                });
            });
            $("#collect").click(function(){
                var user = "${user}";  //若session无user值 判为游客登录 返回登录界面
                if(user=="" || user==null) {
                    alert("请先登录");
                    window.location.href="/login/login"
                }
                $.ajax({
                    type:"post",
                    url:"../collect/collect",
                    data:{cid:${carInfo.carInfo.carId}},
                    <%--data:{carInfo:${carInfo}},--%>
                    success:function(data){
//                        alert(data);
//                        alert(typeof data);
//                        alert(JSON.stringify(data));
                        if(data == "success"){
                            alert("添加收藏成功");
                        }else if(data == "fail"){
                            alert("您已添加该收藏");
                        }
                    }
                });
            });
         });
    </script>
    <style type="text/css">
        .infor-main {
            height: 501px;
            margin-bottom: 50px
        }

        .product-detail {
            width: 602px;
            float: left;
            position: relative
        }

        .product-textbox {
            width: 562px;
            float: right;
            padding-left: 36px
        }

        .product-detail .bigimgbox {
            margin-bottom: 16px;
            position: relative;
            height: 402px
        }

        .product-detail .bigimg {
            width: 600px;
            height: 400px;
            border: 1px solid #e9e9e9
        }

        .product-detail a.next, .product-detail a.prev {
            position: absolute;
            z-index: 100;
            display: none;
            margin-top: 159px
        }

        .product-detail a.prev {
            left: 1px
        }

        .product-detail a.next {
            right: 1px
        }

        .product-detail .product-imgbox {
            width: 602px
        }

        .product-detail .bigimgbox:hover a.next, .product-detail .bigimgbox:hover a.prev {
            display: block
        }

        .product-detail .bigimgbox:hover a.disable {
            display: none
        }

        .product-detail .smallimgbox img {
            width: 116px;
            height: 78px;
            border: 1px solid #e9e9e9
        }

        .product-detail .prev-smallimg {
            left: -1px
        }

        .product-detail .next-smallimg {
            right: -1px
        }

        .product-detail .smallimgbox li {
            margin: 0 3px;
            padding: 0;
            height: 80px
        }

        .product-detail .icon-triangle-right {
            right: 16px
        }

        .product-detail .icon-triangle-left {
            left: 16px
        }

        .icon-collect-star, .icon-fenxi, .icon-jijiang, .icon-man, .icon-warn {
            position: absolute;
            z-index: 1
        }

        .icon-jijiang {
            width: 84px;
            height: 78px;
            top: -2px;
            left: 17px
        }

        .icon-collect-star {
            width: 35px;
            height: 30px;
            top: 1px;
            right: 97px;
            background-position: -86px 6px
        }

        .icon-collect-star:hover {
            background-position: -159px 6px
        }

        .icon-collect-star.active {
            width: 35px;
            height: 30px;
            top: 1px;
            right: 97px;
            background-position: -185px 6px
        }

        .icon-warn {
            width: 66px;
            height: 30px;
            line-height: 30px;
            padding-left: 30px;
            font-size: 14px;
            color: #fff;
            top: 1px;
            right: 1px
        }

        .icon-warn:before {
            content: "";
            background-position: -126px 0;
            width: 16px;
            height: 18px;
            top: 5px;
            left: 10px;
            position: absolute
        }

        .icon-warn:hover:before {
            background-position: -142px 0
        }

        a.icon-warn:hover {
            color: #22ac38;
            text-decoration: none
        }

        .bigimgbox .page-number {
            font-size: 14px;
            color: #fff;
            position: absolute;
            right: 10px;
            bottom: 5px;
            z-index: 9
        }

        a.next, a.prev {
            width: 50px;
            height: 90px
        }

        a.prev {
            background-position: -498px -270px
        }

        a.next {
            background-position: -566px -270px
        }

        a.prev:hover {
            background-position: -498px -362px
        }

        a.next:hover {
            background-position: -566px -362px
        }

        a.prev.disable {
            background-position: -498px -454px
        }

        a.next.disable {
            background-position: -566px -454px
        }

        a.next-smallimg, a.prev-smallimg {
            width: 32px;
            height: 80px;
            top: 0
        }

        a.prev-smallimg {
            background-position: -309px -557px
        }

        a.next-smallimg {
            background-position: -359px -557px
        }

        a.prev-smallimg:hover {
            background-position: -409px -557px
        }

        a.next-smallimg:hover {
            background-position: -459px -557px
        }

        a.prev-smallimg.disable {
            background-position: -509px -557px
        }

        a.next-smallimg.disable {
            background-position: -559px -557px
        }

        .product-detail a.next-smallimg.disable, .product-detail a.next.disable, .product-detail a.prev-smallimg.disable, .product-detail a.prev.disable {
            display: none;
            background: transparent
        }

        .popbox.active {
            z-index: 2001
        }

        .popbox a.next, .popbox a.prev {
            width: 50px;
            height: 90px
        }

        .popbox a.prev {
            background-position: 0 -255px
        }

        .popbox a.next {
            background-position: -68px -255px
        }

        .popbox a.prev:hover {
            background-position: -138px -255px
        }

        .popbox a.next:hover {
            background-position: -208px -255px
        }

        .popbox .disable a.prev, .popbox .disable a.prev:hover {
            background-position: -279px -255px
        }

        .popbox .disable a.next, .popbox .disable a:hover {
            background-position: -354px -255px
        }

        .prev-smallimg:hover span, .prev:hover span {
            background-position: -155px 0
        }

        .next-smallimg:hover span, .next:hover span {
            background-position: 0 0
        }

        a.prev-smallimg span, a.prev span {
            left: 18px
        }

        a.next-smallimg span, a.next span {
            right: 18px
        }

        .slidercon {
            width: 670px;
            height: 598px;
            margin-left: 10px;
            float: left
        }

        .bigimgbox {
            position: absolute;
            top: 10%;
            bottom: 19%;
            left: 0;
            right: 0;
            text-align: center
        }

        .bigimgbox .imginfor {
            height: 34px;
            line-height: 34px;
            color: #fff;
            font-size: 14px;
            position: absolute;
            left: auto;
            bottom: 0;
            right: auto;
            width: 1000px;
            padding: 0 10px;
            text-align: left;
            z-index: 1;
            box-sizing: border-box
        }

        .imgnumber {
            position: absolute;
            right: 10px;
            top: 0
        }

        .fourtab, .threetab {
            height: 67px;
            line-height: 67px;
            text-align: center;
            margin-bottom: 7px;
            font-size: 18px;
            width: 728px;
            position: absolute;
            bottom: 90px;
            left: 50%;
            margin-left: -364px
        }

        .fourtab li {
            width: 25%;
            float: left
        }

        .fourtab li a {
            color: #a5abb2;
            display: inline-block;
            padding-bottom: 3px;
            line-height: 36px
        }

        .fourtab li a:hover, .threetab li a:hover {
            text-decoration: none;
            color: #22ac38
        }

        .fourtab li.on a, .threetab li.on a {
            color: #22ac38;
            border-bottom: 3px solid #22ac38;
            padding-bottom: 0
        }

        .threetab li {
            width: 33.3%;
            float: left
        }

        .threetab li.engine {
            width: 33.4%;
            float: right
        }

        .threetab li.bugimg {
            display: none
        }

        .smallimgbox {
            position: relative;
            overflow: hidden;
            height: 84px
        }

        .smallimgbox li {
            float: left;
            padding: 3px;
            margin: 0 2px;
            cursor: pointer;
            position: relative
        }

        .smallimgbox img {
            width: 125px;
            height: 84px
        }

        .smallimgbox li.onimg {
            position: relative
        }

        .smallimgbox li.onimg .green-border {
            border: 3px solid #22ac38;
            display: inline-block;
            width: 112px;
            height: 74px;
            position: absolute;
            left: 0;
            top: 0
        }

        .det-picside li {
            position: absolute;
            width: 100%;
            height: 100%;
            cursor: pointer
        }

        .det-picside li img {
            max-width: 100%;
            height: 100%
        }

        .next-smallimg, .prev-smallimg {
            width: 60px;
            height: 84px;
            display: block;
            position: absolute;
            top: 3px
        }

        .prev-smallimg {
            left: 0
        }

        .next-smallimg .icon-next, .prev-smallimg .icon-prev {
            position: absolute
        }

        .next-smallimg {
            right: 0
        }

        .prev-smallimg:hover .icon-prev {
            background-position: -420px -289px
        }

        .next-smallimg:hover .icon-next {
            background-position: -437px -289px
        }

        .product-textbox .titlebox {
            display: inline-block;
            color: #495056;
            font-size: 24px;
            line-height: 30px;
            padding-top: 7px;
            max-height: 60px;
            overflow: hidden;
            margin-bottom: 22px
        }

        .product-textbox .labels {
            display: inline-block;
            padding: 0 7px;
            height: 24px;
            line-height: 24px;
            color: #7a838d;
            font-size: 14px;
            text-align: center;
            background-color: #f6f6f6;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            -ms-border-radius: 2px;
            border-radius: 2px;
            margin-right: 3px;
            vertical-align: top;
            margin-top: 7px
        }

        .assort {
            margin-bottom: 15px
        }

        .assort li {
            float: left;
            text-align: center;
            color: #a5abb2;
            line-height: 24px;
            font-size: 12px;
            position: relative
        }

        .assort li .active {
            display: inline-block
        }

        .assort li.one {
            width: 117px
        }

        .assort li.two {
            width: 146px
        }

        .assort li.three {
            width: 97px
        }

        .assort li.four {
            width: 117px
        }

        .assort li.last {
            width: 81px
        }

        .assort li:before {
            content: "";
            height: 34px;
            width: 1px;
            background-color: #e6e6e6;
            position: absolute;
            top: 9px;
            left: 0
        }

        .assort li.one:before {
            width: 0
        }

        .assort li a {
            color: #495056
        }

        .assort li a:hover {
            color: #22ac38;
            text-decoration: none
        }

        .assort li a .icon-green-right7x11 {
            margin: -3px 0 0 5px;
            vertical-align: middle;
            background-position: -394px -11px
        }

        .assort li a:hover .icon-green-right7x11 {
            margin: -3px 0 0 5px;
            vertical-align: middle;
            background-position: -394px 0
        }

        .assort li span {
            display: block;
            color: #495056;
            font-size: 18px;
            font-family: Microsoft Yahei;
            padding-bottom: 3px
        }

        #layer-tip {
            font-size: 12px;
            top: 34px;
            left: -91px;
            display: none
        }

        #layer-tip .icon-small-sanjiao {
            bottom: 48px;
            left: 167px
        }

        .assort li #layer-tip .icon-small-sanjiao {
            bottom: 46px
        }

        .em-sta {
            position: relative;
            cursor: pointer;
            z-index: 20
        }

        .tip-icon {
            background-position: -312px -37px;
            position: relative;
            display: inline-block;
            width: 17px;
            height: 17px;
            font-size: 12px;
            top: 2px;
            left: 2px
        }

        .price .tip-icon {
            vertical-align: middle;
            margin-top: -5px
        }

        .pricebox .tip-icon {
            vertical-align: middle;
            margin-top: -7px
        }

        .tip-icon.active {
            display: inline-block
        }

        .tip-icon .layer-tip {
            font-size: 12px;
            top: 30px;
            left: -220px
        }

        .tip-icon .bottom-layer .icon-small-sanjiao {
            bottom: 46px;
            left: 224px
        }

        .pricebox .tip-icon .layer-tip {
            left: -175px;
            width: 233px
        }

        .pricebox .tip-icon .icon-small-sanjiao {
            left: 178px
        }

        .assort li span.layer-tip {
            padding-bottom: 8px
        }

        .width1 {
            width: 233px;
            height: 43px
        }

        .width2 {
            width: 48px;
            min-height: 25px
        }

        .pricebox {
            margin-bottom: 22px
        }

        .pricebox .ico-type {
            color: #495056;
            font-size: 14px
        }

        .pricebox .pricestype {
            font-size: 28px;
            color: #f95523
        }

        .pricebox .newcarprice {
            text-decoration: line-through;
            color: #a5abb2;
            font-size: 14px;
            padding-left: 6px
        }

        .pricebox .price-fenxi {
            float: right;
            display: inline-block;
            vertical-align: middle;
            margin-top: 13px;
            font-size: 14px;
            color: #495056;
            cursor: pointer
        }

        .pricebox .icon-fenxi {
            background-position: -94px -65px;
            width: 11px;
            height: 12px;
            position: inherit;
            margin-left: 5px
        }

        .pricebox .price-fenxi .icon-fenxi {
            margin-bottom: -1px
        }

        a.loanbox, a.loanbox:hover {
            height: 48px;
            line-height: 48px;
            border: 1px solid #c6eccd;
            position: relative;
            padding-left: 95px;
            color: #22ac38;
            font-size: 14px;
            display: block;
            text-decoration: none;
            background-color: #f6fcf7;
            margin-bottom: 20px
        }

        a.loanbox .icon-man {
            background-position: 0 -85px;
            width: 62px;
            height: 81px;
            left: 17px;
            top: -19px
        }

        a.loanbox .monthpad {
            padding-left: 9px
        }

        a.loanbox .text-r {
            float: right;
            display: inline-block;
            padding-right: 8px
        }

        .product-textbox .icon-green-right7x11 {
            vertical-align: middle;
            margin-top: -3px
        }

        .service-protect {
            background-color: #f6f6f6;
            height: 140px;
            color: #495056;
            font-size: 14px;
            margin-bottom: 20px
        }

        .service-protect-title {
            padding-left: 10px;
            height: 56px;
            line-height: 56px;
            padding-bottom: 4px
        }

        .service-protect-title .label-green {
            margin-top: -2px
        }

        .service-protect .icon-service {
            height: 20px;
            vertical-align: middle;
            margin-top: -2px;
            margin-right: 10px
        }

        .service-protect .look-detail {
            color: #495056;
            float: right;
            padding-right: 9px
        }

        .service-protect a.look-detail:hover .icon-gray-right7x11 {
            background-position: -394px -11px
        }

        .service-protect .fc-other {
            color: #7a838d
        }

        .four-service, .three-service {
            padding-left: 10px;
            padding-bottom: 19px
        }

        .four-service li, .three-service li {
            float: left;
            position: relative;
            font-size: 14px;
            color: #495056
        }

        .four-service li.one {
            width: 192px
        }

        .four-service li.two {
            width: 120px
        }

        .four-service li.three {
            width: 126px
        }

        .four-service li.four {
            width: 114px
        }

        .three-service li.one {
            width: 225px
        }

        .three-service li.two {
            width: 186px
        }

        .three-service li.three {
            width: 135px;
            text-align: right
        }

        .four-service li:before, .three-service li:before {
            background-position: -94px -98px;
            width: 20px;
            height: 20px;
            content: "";
            display: block;
            position: absolute;
            left: 0;
            top: 1px
        }

        .three-service li.three:before {
            left: 5px
        }

        .four-service li span, .three-service li span {
            display: inline-block;
            padding-left: 22px;
            position: relative
        }

        .car-fuwu {
            padding-left: 10px
        }

        .buycar-bag {
            background-position: -89px -399px;
            width: 74px;
            height: 18px;
            vertical-align: middle;
            margin-top: -2px
        }

        .text-service {
            color: #495056;
            font-size: 14px;
            padding-right: 5px
        }

        .btnbox a {
            float: left
        }

        a.freephonebtn, a.graybtn, a.greenbtn, a.greenbtn:hover, a.orgbtn, a.orgbtn:hover {
            border-radius: 2px;
            text-align: center;
            text-decoration: none;
            font-size: 20px;
            display: inline-block;
            width: 174px;
            height: 48px;
            line-height: 48px;
            vertical-align: top;
            color: #fff;
            margin-right: 20px
        }

        a.orgbtn, a.orgbtn:hover {
            background-color: #fd6c34;
            position: relative
        }

        a.greenbtn, a.greenbtn:hover {
            width: 172px;
            background-color: #2abd53
        }

        a.graybtn {
            background-color: #bec6ce;
            display: none;
            position: relative
        }

        a.graybtn:hover {
            cursor: default;
            color: #fff
        }

        a.greenbtn:hover {
            background-color: #22ac38;
            color: #fff
        }

        a.orgbtn:hover {
            background-color: #f95523;
            color: #fff
        }

        a.freephonebtn {
            width: 172px;
            height: 46px;
            line-height: 46px;
            border: 1px solid #2abd53;
            background-color: #f6fcf7;
            color: #2abd53;
            margin-right: 0
        }

        a.greenbtn .icon-kan, a.greenbtn:hover .icon-kan {
            background-position: -276px 0
        }

        .right-phone {
            color: #a5abb2;
            font-size: 14px;
            display: inline-block;
            float: right
        }

        .right-phone .f24 {
            font-size: 24px;
            color: #2abd53;
            display: block;
            line-height: 22px;
            font-weight: 700
        }

        .soldmask {
            display: none;
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            background-color: rgba(0, 0, 0, .4);
            z-index: 5
        }

        .bigimgbox {
            position: relative
        }

        .bigimgbox .sold-icon-tingshou, .bigimgbox .sold-icon-yiding, .bigimgbox .sold-icon-yishou {
            width: 133px;
            height: 113px;
            overflow: hidden;
            background-position: -149px -54px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -57px;
            margin-left: -67px;
            z-index: 5;
            display: none
        }

        .bigimgbox .sold-icon-tingshou {
            background-position: -334px -55px
        }

        .bigimgbox .sold-icon-yiding {
            background-position: -504px -55px
        }

        .soldout .product-detail .bigimgbox:hover a.next, .soldout .product-detail .bigimgbox:hover a.prev, .soldout a.freephonebtn, .soldout a.greenbtn, .soldout a.orgbtn {
            display: none
        }

        .soldout .graybtn, .soldout .sold-icon-yishou, .soldout .soldmask {
            display: block
        }

        .soldout .icon-collect-star, .soldout .icon-collect-star.active, .soldout .icon-jijiang, .soldout .icon-warn {
            display: none
        }

        .bigimgbox .icon-jijiang {
            text-align: center;
            color: #fff
        }
.shoubu{border-radius:25px;background-color:#f0f0f0;margin-top:0px;margin-bottom:10px;border-bottom:1px solid #6e6e6e;box-shadow:2px 4px 6px #000;}
.shoubu p{display:inline-block;padding:20px 20px 5px 20px;}
.shoubu_p{padding:20px 20px 35px 20px;}
.shoubu p a:hover{text-decoration:none;box-shadow:1px 2px 1px #000;}

.backtable{border-radius:5px;display:inline-block;height:40px;padding:0px 45px 5px 45px;}
        .bigimgbox .icon-jijiang .f22 {
            font-size: 22px;
            display: block;
            line-height: 20px;
            padding-top: 12px;
            padding-bottom: 3px
        }

        .bigimgbox .icon-jijiang .f18 {
            font-size: 18px;
            display: block
        }

        .bigimg-pop {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            z-index: 1000
        }

        .bigimg-pop.active, .bigimg-pop.active .list, .bigimg-pop.active .mask {
            display: block
        }

        .bigimg-pop .list {
            position: absolute;
            top: 10%;
            bottom: 19%;
            left: 0;
            right: 0;
            text-align: center;
            z-index: 101
        }

        .bigimg-pop .list img {
            max-width: 100%;
            height: 100%
        }

        .popbox {
            position: fixed;
            z-index: 101;
            display: none;
            width: 100%;
            height: 100%;
            text-align: center;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0
        }

        .popbox .bigimgbox {
            position: absolute
        }

        .popbox .det-picside {
            position: absolute;
            width: 100%;
            height: 100%
        }

        .popbox .slidercon {
            margin: 0
        }

        .popbox .bigimgbox {
            bottom: 157px;
            top: 20px
        }

        .popbox a.next, .popbox a.prev {
            width: 52px;
            height: 94px;
            position: absolute;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            z-index: 100;
            top: 50%;
            margin-top: -47px;
            border-radius: 3px
        }

        .popbox a.prev {
            left: 20%
        }

        .popbox a.next {
            right: 20%
        }

        .popbox .slidercon {
            width: 100%;
            height: 100%
        }

        .popbox .smallimgbox {
            width: 1010px;
            height: 80px;
            padding: 0 55px;
            position: absolute;
            bottom: 10px;
            left: 50%;
            margin-left: -560px
        }

        .popbox .smallimgbox .wrapper {
            margin-left: -5px;
            width: 1024px
        }

        .popbox .smallimgbox li {
            width: 118px;
            height: 80px;
            padding: 0
        }

        .popbox .smallimgbox li img {
            width: 100%;
            height: 100%
        }

        .popbox .smallimgbox li.on .imgborder {
            border: 3px solid #22ac38;
            height: 74px;
            width: 112px;
            display: block;
            position: absolute;
            top: 0;
            left: 0
        }

        .popbox .next-smallimg, .popbox .prev-smallimg {
            top: 0
        }

        .popbox .prev-smallimg {
            left: 0
        }

        .popbox .next-smallimg {
            right: 0
        }

        .popbox .smallimgbox li {
            margin: 0 5px
        }

        a.next-left-box, a.prev-left-box {
            position: absolute;
            height: 80px;
            display: inline-block;
            width: 55px;
            top: 0
        }

        a.prev-left-box {
            left: 0
        }

        a.next-left-box {
            right: 0
        }

        .icon-next, .icon-prev {
            width: 12px;
            height: 22px;
            margin-top: 27px
        }

        .icon-prev {
            background-position: -420px -253px
        }

        .icon-next {
            background-position: -437px -253px
        }

        a.prev-left-box:hover .icon-prev {
            background-position: -420px -289px
        }

        a.next-left-box:hover .icon-next {
            background-position: -437px -289px
        }

        .disable a, a.disable {
            cursor: default
        }

        a.disable .icon-prev, a.disable:hover .icon-prev {
            background-position: -420px -327px;
            cursor: default
        }

        a.disable .icon-next, a.disable:hover .icon-next {
            background-position: -437px -327px;
            cursor: default
        }

        .big-next-box, .big-prev-box {
            height: 100%;
            position: absolute;
            top: 0;
            width: 50%
        }

        .big-prev-box {
            left: 0
        }

        .big-next-box {
            right: 0
        }

        .closed {
            display: inline-block;
            position: fixed;
            right: 20px;
            top: 20px;
            z-index: 102;
            -webkit-border-radius: 19px;
            border-radius: 19px;
            cursor: pointer;
            background-position: -425px -395px;
            width: 37px;
            height: 37px
        }

        .green-border {
            border: 3px solid #22ac38;
            position: absolute;
            top: 0;
            left: 0;
            width: 112px;
            height: 74px;
            display: none
        }

        .popbox .smallimgbox li.active .green-border {
            display: block;
            top: 0
        }

        .no-finance .loanbox {
            display: none
        }

        .no-finance .assort {
            margin-bottom: 13px
        }

        .no-finance .pricebox {
            margin-bottom: 20px
        }
    </style>
    <style type="text/css">
        a, abbr, acronym, address, applet, b, big, blockquote, body, caption, center, cite, code, dd, del, dfn, div, dl, dt, em, fieldset, font, form, h1, h2, h3, h4, h5, h6, html, i, iframe, img, ins, kbd, label, legend, li, object, ol, p, pre, q, s, samp, small, span, strike, strong, sub, sup, table, tbody, td, tfoot, th, thead, tr, tt, u, ul, var {
            margin: 0;
            padding: 0;
            border: 0;
            outline: 0
        }

        li, ol, ul {
            list-style: none
        }

        blockquote, q {
            quotes: none
        }

        blockquote:after, blockquote:before, q:after, q:before {
            content: "";
            content: none
        }

        :focus {
            outline: 0
        }

        del {
            text-decoration: line-through
        }

        table {
            border-collapse: collapse;
            border-spacing: 0
        }

        address, cite, code, dfn, em, i, var {
            font-style: normal
        }

        button, input[type=button], input[type=reset], input[type=submit] {
            cursor: pointer;
            -webkit-appearance: none
        }

        .vm {
            vertical-align: middle
        }

        .clearfix:after {
            content: " ";
            display: block;
            clear: both;
            height: 0;
            visibility: hidden
        }

        * + html .clearfix, * html .clearfix {
            zoom: 1
        }

        .fl {
            float: left
        }

        .fr {
            float: right
        }

        body {
            background: #fff
        }

        body, button, input, select, textarea {
            font: 12px/1.5 arial, helvetica, clean, sans-serif
        }

        a {
            text-decoration: none;
            color: #24d
        }

        a:hover {
            text-decoration: underline;
            color: #c00
        }
    </style>
    <!-- 头部-->
    <style type="text/css">
    	
    </style>
    <style type="text/css">
        .product-detail {
            height: 0px;
            width: 560px;
            float: left;
        }
    </style>
    <style type="text/css">
        .product-textbox {
            height: 0;
            width: 45.33%;
            float: right;
        }
    </style>
    <style type="text/css">

        .table1 {
            text-align: center;
            width: 380px;
            float: left;
            margin-bottom: 100px;
            margin-right: 2px;
        }

        .table1 th {
            background-color: #f5f5f5;
            font-size: 16px;
            height: 35px;
        }

        .detailcontent table {
            border: 1px solid #6e6e6e;
            font-size: 17px;
            rules: all
        }

        .titlediv {
            height: 47px;
            border-bottom: 1px solid #e6e6e6;
            margin-bottom: 30px;
            font-size: 22px;
        }

        .titlediv span {
            border-bottom: 4px solid #22ac38;
            display: inline-block;
            line-height: 43px;
        }

        .footer_bg1 {
            background-color: #6e6e6e;
        }

        .header_btm {
            background-color: #6e6e6e;
        }

        .product-image {
            float: left;
            width: 150px;
            height: 100px;
        }

        .more-views-container {
            width: 100px;
            height: 0;
        }

    </style>
    <style type="text/css">
        .span1_of_1 {
            width: 52.3333%;
            float: left;
        }

        div {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
        }
    </style>
</head>
<body>
<!-- start header -->
<div class="shoubu"style="text-align:center;font-size:30px;">
	<div class="shoubu_p">
	<img alt="" src="images/dongtong2.png"style="width:50px;position:relative;left:-300px;top: 20px;">
	<p>|</p>
	<p class="logo" style="font:700 1.5em Raleway,Arial,Helvetica;position:relative;left:200px;">DongTong</p>
	<table class="backtable"style="font-weight: 600;">
		<tr>
			<td>
				<p><a href="/page/index">首页</a></p>
				<p><a href="/page/showCar" >我要买车</a></p>
				<p><a  href="/page/index">我要卖车</a></p>
				<p> <a href="${basePath}/page/user" >个人中心</a></p>
					<img alt="" src="images/contact.png"style="width:50px;position:relative;left:20px;">
			</td>
		</tr>
	</table>
	</div>
</div>
<!-- start main -->
<div class="main_bg">
    <div class="wrap">
        <div class="main">
            <!-- start content -->
            <div class="single">
                <!-- start span1_of_1 -->

                <div class="infor-main service-open">
                    <div class="product-detail" id="page-slide" data-group-count="4">

                        <div>
                            <img alt="111" src="${carInfo.pic_url}" style="width: 700px;height: 450px;">
                        </div>

                    </div>
                    <!-- start span1_of_1 -->
                    <div class="product-textbox">
                        <div class="titlebox">
                            <p>${carInfo.carInfo.brand}  ${carInfo.carInfo.carName}  ${carInfo.carInfo.confName}</p>
                            <span class="labels">4s保养</span>
                        </div>

                        <ul class="assort clearfix">
                            <li class="one"><span>${carInfo.carInfo.carAge}</span>车齡</li>
                            <li class="two"><span>${carInfo.carInfo.carMileage}</span>表显里程</li>
                            <li class="three"><span>${carInfo.carInfo.licenseAddress}</span>上牌地</li>
                            <li class="four"><span>${carInfo.carInfo.carDamage}</span>车损状况</li>
                            <li class="last"><span>${carInfo.carInfo.gearbox}</span>变速箱</li>
                        </ul>

                        <div class="pricebox js-disprice">
                            <i class="ico-type">车主报价：</i>
                            <span class="pricestype">${carInfo.carInfo.price}  <span class="f14">万</span></span>
                        </div>

                        <div class="service-protect">
                            <div class="service-protect-title clearfix"><i class="icon-service">服务保障升级</i>
                                <i class="label-green">理赔高达4.68万</i><i class="label-green">保全车12大系统</i>
                            </div>
                            <ul class="four-service clearfix">
                                <li class="one">
                                    <span>1年2万公里售后保障<i class="icon-triangle-top"></i></span>
                                </li>
                                <li class="two">
                                    <span>14天可退<i class="icon-triangle-top"></i></span>
                                </li>
                                <li class="three">
                                    <span>259项检测<i class="icon-triangle-top"></i></span>
                                </li>
                                <li class="four">
                                    <span>优质个人车<i class="icon-triangle-top"></i></span>
                                </li>
                            </ul>
                            <%--<div class="car-fuwu">--%>
                                <%--<i class="ico-txt">服务费：</i><span>3500元（车价x4%，最低3500元） </span>--%>
                            <%--</div>--%>
                        </div>


                        <div class="btnbox clearfix">
                            <a id="order" rel="nofollow" href="javascript:void(0)" class="orgbtn js-apt">预约看车</a>
                                <span class="layer-tip js-layer-tip" style="width: 233px; height: 43px; display: none;">
                    <i class="icon-small-sanjiao"></i>
                        此车已有<i class="fc-green">59</i>人关注，预计很快售出，建议尽快<i class="fc-green js-apt"
                                                                        data-gzlog="tracking_type=click&amp;eventid=0460310000000074&amp;carid=14313937">预约看车</i>
                </span>
                            </a>
                            <a id="collect" rel="nofollow" href="javascript:void(0)" class="greenbtn js-bargain"
                               data-gzlog="tracking_type=click&amp;eventid=0460310000000075&amp;carid=14313937">添加收藏</a>

                        </div>
                    </div>                <!--    详情页右上方车源-->
                </div>
                <!-- start基本信息 -->
                <!-- start粗略浏览 -->
                <div class="titlediv">
                    <span>基本信息</span>
                </div>
                <!-- end粗略浏览 -->
                <div class="detailcontent">
                    <table border="1" class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">基本信息</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>厂商</td>
                            <td>${carInfo.carInfo.carName}</td>
                        </tr>
                        <tr>
                            <td>级别</td>
                            <td>${carInfo.carInfo.level}</td>
                        </tr>
                        <tr>
                            <td>发动机</td>
                            <td>${carInfo.carInfo.engine}</td>
                        </tr>
                        <tr>
                            <td>变速箱</td>
                            <td>${carInfo.carInfo.gearbox}</td>
                        </tr>
                        <tr>
                            <td>车身结构</td>
                            <td>${carInfo.carInfo.bodyStructure}</td>
                        </tr>
                        <tr>
                            <td>长*宽*高{mm)</td>
                            <td>${carInfo.carInfo.size}</td>
                        </tr>
                        <tr>
                            <td>最大车速(km/s}</td>
                            <td>${carInfo.carInfo.maximumspeed}</td>
                        </tr>
                        <tr>
                            <td>行李箱容积(L)</td>
                            <td>${carInfo.carInfo.cargoVolume}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">发动机参数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>排量(L)</td>
                            <td>${carEngineInfo.displacement}</td>
                        </tr>
                        <tr>
                            <td>进气形式</td>
                            <td>${carEngineInfo.intakeForm}</td>
                        </tr>
                        <tr>
                            <td>气缸排列形式</td>
                            <td>${carEngineInfo.cylinderArrangement}</td>
                        </tr>
                        <tr>
                            <td>气缸数</td>
                            <td>${carEngineInfo.cylinders}</td>
                        </tr>
                        <tr>
                            <td>最大马力(Ps)</td>
                            <td>${carEngineInfo.maximumHorsepower}</td>
                        </tr>
                        <tr>
                            <td>燃料类型</td>
                            <td>${carEngineInfo.fuel}</td>
                        </tr>
                        <tr>
                            <td>燃油标号</td>
                            <td>${carEngineInfo.fuelLabel}</td>
                        </tr>
                        <tr>
                            <td>供油方式</td>
                            <td>${carEngineInfo.oilsupplyMode}</td>
                        </tr>
                        <tr>
                            <td>排放标准</td>
                            <td>${carEngineInfo.enviromentStandard}</td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">底盘及制动</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>驱动方式</td>
                            <td>${carChassisBrakeInfo.driveMode}</td>
                        </tr>
                        <tr>
                            <td>助力类型</td>
                            <td>${carChassisBrakeInfo.autoPowerType}</td>
                        </tr>
                        <tr>
                            <td>前悬挂类型</td>
                            <td>${carChassisBrakeInfo.frontSuspensionType}</td>
                        </tr>
                        <tr>
                            <td>后悬挂类型</td>
                            <td>${carChassisBrakeInfo.rearSuspensionType}</td>
                        </tr>
                        <tr>
                            <td>前制动类型</td>
                            <td>${carChassisBrakeInfo.frontBrakeType}</td>
                        </tr>
                        <tr>
                            <td>后制动类型</td>
                            <td>${carChassisBrakeInfo.rearBrakeType}</td>
                        </tr>
                        <tr>
                            <td>驻车制动类型</td>
                            <td>${carChassisBrakeInfo.parkingBrakeType}</td>
                        </tr>
                        <tr>
                            <td>前轮胎规格</td>
                            <td>${carChassisBrakeInfo.frontWheelSize}</td>
                        </tr>
                        <tr>
                            <td>后轮胎规格</td>
                            <td>${carChassisBrakeInfo.rearWheelSize}</td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">安全配置</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>主/副驾驶安全气囊</td>
                            <td>${carSafetyInfo.frontAirbag}</td>
                        </tr>
                        <tr>
                            <td>前/后排头部气囊</td>
                            <td>${carSafetyInfo.headAirbag}</td>
                        </tr>
                        <tr>
                            <td>儿童座椅接口</td>
                            <td>${carSafetyInfo.childSeatInt}</td>
                        </tr>
                        <tr>
                            <td>胎压检测</td>
                            <td>${carSafetyInfo.tpms}</td>
                        </tr>
                        <tr>
                            <td>车内中控锁</td>
                            <td>${carSafetyInfo.carLock}</td>
                        </tr>
                        <tr>
                            <td>ABS防抱死系统</td>
                            <td>${carSafetyInfo.abs}</td>
                        </tr>
                        <tr>
                            <td>车身稳定控制</td>
                            <td>${carSafetyInfo.usc}</td>
                        </tr>
                        <tr>
                            <td>无钥匙启动</td>
                            <td>${carSafetyInfo.pss}</td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">外部配置</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>电动天窗</td>
                            <td>${carExternalInfo.electronicSunroof}</td>
                        </tr>
                        <tr>
                            <td>全景天窗</td>
                            <td>${carExternalInfo.panoramicSunroof}</td>
                        </tr>
                        <tr>
                            <td>电动吸合门</td>
                            <td>${carExternalInfo.electronicDoorPull}</td>
                        </tr>
                        <tr>
                            <td>电动后备箱</td>
                            <td>${carExternalInfo.electronicTrunk}</td>
                        </tr>
                        <tr>
                            <td>雨量感应雨刷</td>
                            <td>${carExternalInfo.rainSensingWipers}</td>
                        </tr>
                        <tr>
                            <td>后雨刷</td>
                            <td>${carExternalInfo.rearWiper}</td>
                        </tr>
                        <tr>
                            <td>前/后电动车窗</td>
                            <td>${carExternalInfo.powerWindow}</td>
                        </tr>
                        <tr>
                            <td>电动后视镜</td>
                            <td>${carExternalInfo.electronicRearviewMirror}</td>
                        </tr>
                        <tr>
                            <td>后视镜加热</td>
                            <td>${carExternalInfo.rearviewMirrorHeating}</td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table1">
                        <thead>
                        <tr>
                            <th align="center" colspan="2">内部配置</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>多功能方向盘</td>
                            <td>${carInternalInfo.mfSteeringWheel}</td>
                        </tr>
                        <tr>
                            <td>定速巡航</td>
                            <td>${carInternalInfo.dlcc}</td>
                        </tr>
                        <tr>
                            <td>自动空调</td>
                            <td>${carInternalInfo.automaticAirCon}</td>
                        </tr>
                        <tr>
                            <td>手动空调</td>
                            <td>${carInternalInfo.manualAirCon}</td>
                        </tr>
                        <tr>
                            <td>GPS导航</td>
                            <td>${carInternalInfo.gps}</td>
                        </tr>
                        <tr>
                            <td>倒车雷达</td>
                            <td>${carInternalInfo.parkingRedar}</td>
                        </tr>
                        <tr>
                            <td>倒车影像</td>
                            <td>${carInternalInfo.reverseVideo}</td>
                        </tr>
                        <tr>
                            <td>真皮座椅</td>
                            <td>${carInternalInfo.leatherSeat}</td>
                        </tr>
                        <tr>
                            <td>前后排座椅加热</td>
                            <td>${carInternalInfo.seatHeating}</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <!-- end基本信息 -->
                <!-- end content -->
            </div>
        </div>
    </div>
</div>
<!-- 页脚 -->
<div class="footer_bg1">
    <div class="wrap">
        <div class="footer">
            <!-- scroll_top_btn -->
            <%--<script type="text/javascript">--%>
                <%--$(document).ready(function () {--%>

                    <%--var defaults = {--%>
                        <%--containerID: 'toTop', // fading element id--%>
                        <%--containerHoverID: 'toTopHover', // fading element hover id--%>
                        <%--scrollSpeed: 1200,--%>
                        <%--easingType: 'linear'--%>
                    <%--};--%>


                    <%--$().UItoTop({easingType: 'easeOutQuart'});--%>

                <%--});--%>
            <%--</script>--%>
            <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
            <!--end scroll_top_btn -->
            <div class="copy">
                <p class="link">SouthWestJiaoTongUniversity西南交通大学; 2017.华迪实训公司-第二小组.</p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
</html>