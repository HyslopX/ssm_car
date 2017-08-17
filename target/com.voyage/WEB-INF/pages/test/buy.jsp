<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "resources/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>我要买车</title>
    <!-- 头部 -->
    <style type="text/css">
        .header_btm {
            background-color: #000000;
            width: 100%;
            height: 57px;
            margin-bottom: 20px;
        }

        .logo {
            float: left;
            width: 10px;
        }

        .h_menu {
            font-family: 'bebas_neueregular';
            float: left;
            color: #ffffff;
            font-size: 1.2em;
            margin-left: 200px;
        }

        .h_menu ul li {
            display: inline-block;
        }

        .h_menu ul li a {
            text-decoration: none;
            padding-left: 0px;
        }

        .h_menu ul li a:hover {
            color: #f0f0f0;
            text-decoration: none;
        }

        .h_menu ul li.active a {
            color: #f0f0f0;
        }

        .h_menu ul li a {
            display: block;
            padding: 14px 18px;
            font-size: 1em;
            color: #ffffff;
        }

        .header_sub {
            padding: 0 3%;
        }
    </style>
    <!-- 中部 -->
    <style type="text/css">
        .agemin {
            width: 70px;
        }

        .agemax {
            width: 70px;
        }

        .pricemin {
            width: 70px;
        }

        .pricemax {
            width: 70px;
        }

        /*.carshow {*/
            /*display: inline-block;*/
        /*}*/

        .carshow a:hover {
            text-decoration: none;
        }

        .carinfo {
            font-size: 20px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .main1 {
            border-bottom: 1px solid #e6e6e6;
            margin-bottom: 20px;
            font-size: 30px;
        }

        .main1 span {
            border-bottom: 4px solid #22ac38;
        }
    </style>
    <!--c:foreach中 样式设计-->
    <style type="text/css">
        a.car_a{
            height: 300px;
            width:300px;
            text-decoration:none;
            color:#000000;
            /*display: inline-block;*/
            padding-left: 30px;
            padding-bottom: 10px;
        }
        a img.car1{
            width:285px;
        }
        td.car_td{
            padding: 30px;
        }
    </style>
    <!-- 尾部 -->
    <style type="text/css">
        .footer_bg1 {
            background-color: #000000;
            position: relative;
            bottom: 0;
            right: 0;
            left: 0;
            text-align: center;
        }

        #toTop {
            position: fixed;
            right: 10px;
            bottom: 15px;
            background: url(images/top_move.png) no-repeat right top;
        }

    </style>
    <script src="js/jquery-1.11.2.min.js"></script>


</head>
<body>
<!-- start header -->
<div class="header_btm">
    <div class="wrap">
        <div class="header_sub">
            <div class="logo">
                <a href="index.html"><img src="images/logo.png" alt="" style="width:50px;"> </a>
            </div>
            <div class="h_menu">
                <ul>
                    <li class="active"><a href="/page/index">主页|</a></li>
                    <li><a href="/page/showCar">买车信息|</a></li>
                    <li><a href="/page/showCar">好车推荐|</a></li>
                    <li><a href="/page/index">我要卖车|</a></li>
                    <li><a href="/page/user">个人中心</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clear"></div>

<div style="border-left:1px solid #e6e6e6;border-right:1px solid #e6e6e6;padding-top:10px;padding-bottom:30px;">
    <form id="form1" method="post"></form>
    <div class="screen"
         style="padding-top:10px;padding-bottom:10px;border-bottom:1px solid #6e6e6e;border-top:1px solid #6e6e6e;">
        <em style="margin-left:20px;margin-right:20px;">车龄</em>
        <input type="text" class="age1"value="0" name="car_age1">
        <em>-</em>
        <input type="text" class="age2" value="20" name="car_age2">
        <em>年</em>
        <%--<button>确定</button>--%>
    </div>
    <div class="screen" style="padding-top:10px;padding-bottom:10px;border-bottom:1px solid #6e6e6e;">
        <em style="margin-left:20px;margin-right:20px;">价格</em>
        <input type="text" class="price1" value="0" name="car_price1">
        <em>-</em>
        <input type="text" class="price2" value="1000" name="car_price2">
        <em>万</em>
        <%--<button>确定</button>--%>
    </div>

    <div class="selection" style="padding-top:10px;padding-bottom:10px;border-bottom:1px solid #6e6e6e;">
        <em style="margin-left:20px;margin-right:20px;">更多</em>
        品牌
        <select name="car_brand">
            <option value="0">不限</option>
            <option value="上汽大众">上汽大众</option>
            <option value="大众(进口)">大众（进口）</option>
            <option value="一汽n大众">一汽n大众</option>
        </select>
        车名
        <select name="car_name">
            <option value="0">不限</option>
            <option value="迈特威">迈特威</option>
            <option value="甲壳虫">甲壳虫</option>
            <option value="朗逸">朗逸</option>
            <option value="途安">途安</option>
            <option value="凌渡">凌渡</option>
            <option value="夏朗">夏朗</option>
            <option value="尚酷">尚酷</option>
            <option value="捷达">捷达</option>
            <option value="速腾">速腾</option>
            <option value="迈腾">迈腾</option>
        </select>
        车型
        <select name="car_level">
            <option value="0">不限</option>
            <option value="MPV">MPV</option>
            <option value="豪华车">豪华车</option>
            <option value="跑车">跑车</option>
            <option value="紧凑型车">紧凑型车</option>
            <option value="微型车">微型车</option>
            <option value="中大型SUV">中大型SUV</option>
            <option value="中型车">中型车</option>
            <option value="小型车">小型车</option>
        </select>
        变速箱
        <select name="car_gearbox">
            <option value="0">不限</option>
            <option value="5挡MT">5挡MT</option>
            <option value="5挡AMT">5挡AMT</option>
            <option value="6挡AT">6挡AT</option>
            <option value="6挡MT">6挡MT</option>
            <option value="6挡双离合">6挡双离合</option>
            <option value="7挡双离合">7挡双离合</option>
            <option value="8挡AT">8挡AT</option>
        </select>
        <a href="javascript:void(0)" id="btn">提交</a>
        <div class="clear"></div>
    </div>
    </form>
</div>
<!-- start main1 -->
<div class="main_bg1">
    <div class="wrap">
        <div class="main1">
            <span>车型展示</span>
        </div>
    </div>
</div>
<!-- start main -->
<div class="carshow">
    <table class="table-detail">
        <tbody class="tbody-dom">
        <tr>
            <c:forEach items="${itemsList}" var="item" varStatus="status" begin="0" end="19">
            <td class="car_td">
            <a  class="car_a" href="/page/details?id=${item.carInfo.carId}">
                <img alt="" src="${item.pic_url}" class="car1">
                <div class="carinfo">
                    <div class="item_name">${item.carInfo.brand}  ${item.carInfo.carName } </div>
                    <div class="item_conf">${item.carInfo.confName}</div>
                    <div class="car_age">车龄：${item.carInfo.carAge}年 | 行程：${item.carInfo.carMileage}万公里</div>
                    <div class="car_price">标价：${item.carInfo.price}万</div>
                </div>
            </a>
            </td>
                <c:if test="${status.count % 4 == 0}">
        </tr>
        <tr>
            </c:if>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(function () {
        var discussListDom = $(".table-detail").find(".tbody-dom");
//        console.log(discussListDom.html());
//            var discussListDom = document.getElementsByName("tbody-dom");
        $("#btn").click(function () {
            var brand = $("select[name='car_brand']").val();
            var carName = $("select[name='car_name']").val();
            var gearbox = $("select[name='car_gearbox']").val();
//            alert(gearbox);
            var level = $("select[name='car_level']").val();
            var age1 = $("input[name='car_age1']").val();
            var age2 = $("input[name='car_age2']").val();
            var price1 = $("input[name='car_price1']").val();
            var price2 = $("input[name='car_price2']").val();
            var params = {
                brand: brand,
                carName: carName,
                gearbox: gearbox,
                level: level,
                age1: age1,
                age2: age2,
                price1: price1,
                price2: price2
            };
//            alert(121);
            $.ajax({
                type: "post",
                url: "../carInfo/selectCar",
                data: params,
                success: function (data) {
//                        alert(data);
//                        alert(typeof data);
//                    alert(JSON.stringify(data));
//                        discussListDom.children().remove();
//                    alert(discussListDom.attr("innerHTML"));
                    addDiscuss(data, discussListDom);
                }
            });
        });
        function addDiscuss(data, discussListDom) {
//            discussListDom.children().removeAll();

            discussListDom.find("tr").remove();
//            alert(data.length);
            for (var i = 0; i < data.length; i++) {
                if (i + 3 <= data.length - 1) {
                    var liDom = $("<tr></tr>");
                    var message = "";
//                    alert(i);
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i].carInfo.carName+"  "+data[i].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i].carInfo.carAge+"| 行程："+data[i].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+1].carInfo.carName+"  "+data[i+1].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+1].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+1].carInfo.carAge+"| 行程："+data[i+1].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i+1].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+2].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+2].carInfo.carName+"  "+data[i+2].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+2].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+2].carInfo.carAge+"| 行程："+data[i+2].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i+2].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+3].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+3].carInfo.carName+"  "+data[i+3].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+3].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+3].carInfo.carAge+"| 行程："+data[i+3].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i].carInfo.price+"</div></div></a></div>";
                    i = i + 3;
//                    alert(message);
//                    alert("end:"+i);
                    liDom.html(message);
                    discussListDom.append(liDom);
                }else if(i+2<=data.length-1){
                    var liDom = $("<tr></tr>");
                    var message = "";
//                    alert(i);
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i].carInfo.carName+"  "+data[i].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i].carInfo.carAge+"| 行程："+data[i].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+1].carInfo.carName+"  "+data[i+1].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+1].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+1].carInfo.carAge+"| 行程："+data[i+1].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i+1].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+2].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+2].carInfo.carName+"  "+data[i+2].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+2].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+2].carInfo.carAge+"| 行程："+data[i+2].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i+2].carInfo.price+"</div></div></a></div>";
                    i = i + 2;
                    liDom.html(message);
                    discussListDom.append(liDom);
                } else if (i + 1 == data.length - 1) {
//                    alert("if222"+i);
                    var liDom = $("<tr></tr>");
                    var message = "";
                    message = "<td class='car_td'> <a  class='car_a' href='/page/details?id=" + data[i].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i].carInfo.carName+"  "+data[i].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i].carInfo.carAge+"| 行程："+data[i].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i].carInfo.price+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i+1].carInfo.carName+"  "+data[i+1].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i+1].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i+1].carInfo.carAge+"| 行程："+data[i+1].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i+1].carInfo.price+"</div></div></a></div>";
                    i = i + 1;
                    liDom.html(message);
                    discussListDom.append(liDom);
                }
                else {
                    var liDom = $("<tr></tr>");
                    var message = "";
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].carInfo.carId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'>"+data[i].carInfo.carName+"  "+data[i].carInfo.brand+" </div>"+
                        "<div class='item_conf'>"+data[i].carInfo.confName+"</div>"+
                        "<div class='car_age'>车龄: "+data[i].carInfo.carAge+"| 行程："+data[i].carInfo.carMileage+"</div>"+
                        "<div class='car_price'>标价："+data[i].carInfo.price+"</div></div></a></div>";
//                    i=i+1;
                    liDom.html(message);
                    discussListDom.append(liDom);
                }
            }
            //------------X--------------
        };
    });

</script>
</body>
</html>