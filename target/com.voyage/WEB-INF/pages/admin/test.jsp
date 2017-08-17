<%--
  Created by IntelliJ IDEA.
  User: X
  Date: 2017/7/28
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/reset.css">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="font/css/font-awesome.min.css">
</head>
<body>
<style>
    .head_container{
        width:100%;
        height:60px;
        background: #303643;
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
        color:#FE7300;
        cursor: pointer;
        font-size:20px;
    }

</style>
<div class="head_container text-center">
    <div class="container">
        <div class="header">
            <div class="unionInfo col-md-7">
                <div class="col-sm-3 unionLogo center-block">
                    <img class="img-responsive" src="images/logoko.png" />
                </div>
                <div class="col-sm-8 unionContent text-center">
                    <ul class="list-inline">
                        <li class="col-sm-3"><a href="/page/index">首页</a></li>
                        <li class="col-sm-3"><a href="${basePath}/page/showCar" target="_blank" style="z-inedx:999;">我要买车</a></li>
                        <li class="col-sm-3"><a href="#">我要卖车</a></li>
                        <li class="col-sm-3"><a href="/page/user">个人中心</a></li>
                    </ul>
                </div>
            </div>

            <div class="userInfo col-md-5">
                <div class="col-sm-2 head_pic center-block">
                    <img class="img-responsive" src="images/buy.png"  />
                </div>
                <div class="col-sm-8 userContent text-center">
                    <ul class="list-inline">
                        <li class="col-sm-3" id="check_out" style="display: none"><a src="#">注销</a></li>
                        <li class="col-sm-3" id="check_in" style="width: 100px;"><a href="/login/login">登录注册</a></li>
                        <%--<li class="col-sm-3" id="sign_up"><a href="/login/login">注册</a></li>--%>

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
