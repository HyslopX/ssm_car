<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/resources/";
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
   <title>Login</title>
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]><script src="js/html5shiv.js"></script><script src="js/respond.min.js"></script><![endif]-->
   <!-- Bootstrap CSS-->
   <link rel="stylesheet" href="css/bootstrap.css">
   <!-- Vendor CSS-->
   <link rel="stylesheet" href="css/font-awesome.min.css">
   <link rel="stylesheet" href="css/animate+animo.css">
   <!-- App CSS-->
   <link rel="stylesheet" href="css/app.css">
   <!-- Modernizr JS Script-->
   <script src="js/modernizr.js" type="application/javascript"></script>
   <!-- FastClick for mobiles-->
   <script src="js/fastclick.js" type="application/javascript"></script>
</head>

<body>
   <!-- START wrapper-->
   <div style="height: 100%; padding: 20px 0; background-image:url(${basePath}/resources/img/background.jpg)" class="row row-table">
      <div class="col-lg-3 col-md-6 col-sm-8 col-xs-12 align-middle">
         <div data-toggle="play-animation" data-play="fadeInDown" data-offset="0" class="panel b0">
            <p class="text-center mb-lg">
               <br>
               <a href="#">
                  <img src="img/logo.jpg" alt="Image" class="block-center img-rounded">
               </a>
            </p>
            <div id="accordion" data-toggle="collapse-autoactive" class="panel-group">
               <!-- START panel-->
               <div class="panel radius-clear b0 shadow-clear">
                  <div class="panel-heading radius-clear panel-heading-active"><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="text-muted btn-block text-center">用户登录</a>
                  </div>
                  <div id="collapseOne" class="panel-collapse collapse in">
                     <div class="panel-body">
                        <form role="form" class="mb-lg" method="post">

                           <div class="form-group has-feedback">
                              <label for="exampleInputName">用户名</label>
                              <input id="exampleInputName" name="username" type="name" placeholder="Enter name" value="" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
                           <div class="form-group has-feedback">
                              <label for="exampleInputPassword1">密  码</label>
                              <input id="exampleInputPassword1" name="password" type="password" placeholder="Password" value="" class="form-control">
                              <span class="fa fa-lock form-control-feedback text-muted"></span>
                           </div>
						   <div class="form-group has-feedback">
                              <label for="exampleInputPassword3">验证码</label>
                             <div class="code-box" id="code-box">
						<input id="exampleInputPassword3" type="text" name="code" class="code-input" />
						<p></p>
						<span>>>></span>
					         </div>                     
                           </div>					   						  						 
                          <input type="button" id="login_btn" class="btn btn-block btn-primary" value="登录"> </input>
                        </form>
                     </div>
                  </div>
               </div>
               <!-- END panel-->

               <!-- START panel-->
               <div class="panel radius-clear b0 shadow-clear">
                  <div class="panel-heading radius-clear"><a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="text-muted btn-block text-center">新用户注册GO</a>
                  </div>
                  <div id="collapseTwo" class="panel-collapse collapse">
                     <div class="panel-body">
                        <form role="form" id="regform" class="mb-lg" method="post" action="${basePath}/register?action=register">
                           <div class="form-group has-feedback">
                              <label for="signupInputName">用户名</label>
                              <input id="signupInputName" name="username" type="name" placeholder="字母数字组成，字母开头，8-15位" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
                           <div class="form-group has-feedback">
                              <label for="signupInputPassword1">密  码</label>
                              <input id="signupInputPassword1" name="upassword" type="password" placeholder="Password" class="form-control">
                              <span class="fa fa-lock form-control-feedback text-muted"></span>
                           </div>
                           <div class="form-group has-feedback">
                              <label for="signupInputRePassword1">确认密码</label>
                              <input id="signupInputRePassword1" name="repeatpassword" type="password" placeholder="ReType Password" class="form-control">
                              <span class="fa fa-lock form-control-feedback text-muted"></span>
                           </div>
						   <div class="form-group has-feedback">
                              <label for="signupInputEmail1">邮箱</label>
                              <input id="signupInputEmail1" name="uemail" type="email" placeholder="Enter email" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
						   <div class="form-group has-feedback">
                              <label for="signupInputPhone">手机号码</label>
                              <input id="signupInputPhone" name="uphone" type="phone" placeholder="请输入正确的11位手机号码" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
                           <div class="clearfix">
                              <div class="checkbox c-checkbox pull-left mt0">
                                 <label>
                                    <input id="check" type="checkbox" value="">
                                    <span class="fa fa-check"></span>同意 <a href="#">协议</a>
                                 </label>
                              </div>
                           </div>
                           <input type="button" id="register_btn" value="提交" class="btn btn-block btn-primary"> </input>
                        </form>
                     </div>
                  </div>
               </div>
               <!-- END panel-->
               <!-- START panel-->
               <div class="panel radius-clear b0 shadow-clear">
                  <div class="panel-heading radius-clear"><a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="text-muted btn-block text-center">忘记密码?</a>
                  </div>
                  <div id="collapseThree" class="panel-collapse collapse">
                     <div class="panel-body">
                        <form role="form">
                           <p class="text-center">输入邮箱地址以接受密码找回邮件</p>
                           <div class="form-group has-feedback">
                              <label for="resetInputEmail1">邮件地址</label>
                              <input id="resetInputEmail1" type="email" placeholder="Enter email" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
                           <button type="submit" class="btn btn-danger btn-block">重置</button>
                        </form>
                     </div>
                  </div>
				  <div class="panel-heading radius-clear">
				       </span><a href="/login/visitor">跳过登录，以游客身份浏览</a>
				  </div>
               </div>
               <!-- END panel-->
               <div class="panel radius-clear b0 shadow-clear">
                  <div class="panel-heading radius-clear"><a data-toggle="collapse" data-parent="#accordion" href="#collapseFourth" class="text-muted btn-block text-center">管理员登录</a>
                  </div>
                  <div id="collapseFourth" class="panel-collapse collapse">
                     <div class="panel-body">
                        <form role="form" class="mb-lg" method="post">

                           <div class="form-group has-feedback">
                              <label for="adminInputName">用户名</label>
                              <input id="adminInputName" name="username" type="name" placeholder="Enter name" value="" class="form-control">
                              <span class="fa fa-envelope form-control-feedback text-muted"></span>
                           </div>
                           <div class="form-group has-feedback">
                              <label for="adminInputPassword1">密  码</label>
                              <input id="adminInputPassword1" name="password" type="password" placeholder="Password" value="" class="form-control">
                              <span class="fa fa-lock form-control-feedback text-muted"></span>
                           </div>
                           <%--<div class="form-group has-feedback">--%>
                              <%--<label for="adminInputPassword3">验证码</label>--%>
                              <%--<div class="code-box" id="code-box1">--%>
                                 <%--<input id="adminInputPassword3" type="text" name="code" class="code-input" />--%>
                                 <%--<p></p>--%>
                                 <%--<span>>>></span>--%>
                              <%--</div>--%>
                           <%--</div>--%>
                           <input type="button" id="admin_login_btn" class="btn btn-block btn-primary" value="登录"> </input>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- END wrapper-->
   <!-- START Scripts-->
   <!-- Main vendor Scripts-->
   <script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <!-- Animo-->
   <script src="js/animo.min.js"></script>
   <!-- Custom script for pages-->
   <script src="js/pages.js"></script>
   <!--验证码scrips-->
   <script src="js/login.js"></script>
   <script>

	window.addEventListener('load',function(){

    //code是后台传入的验证字符串
    var code = "jsaidaisd656",
        codeFn = new moveCode(code);

    //获取当前的code值
    console.log(codeFn.getCode());

    //改变code值
    code = '46asd546as5';
    codeFn.setCode(code);

    //重置为初始状态
    codeFn.resetCode();
    });
    </script>

   <!--登录js-->
   <script type="text/javascript">
       $("#login_btn").click(function () {
           var username = $.trim($("#exampleInputName").val());
           var password = $.trim($("#exampleInputPassword1").val());
           if (username == "") {
               alert("用户名不能为空！");
               return false;
           } else if (password == "") {
               alert("密码不能为空！");
               return false;
           }
           //ajax去服务器端校验
           var data = {username: username, password: password};

           $.ajax({
               type: "POST",
               url: "../login/checklogin",
               data: data,

               success: function (msg) {
                   if (msg == "success") {
                       window.location.href = "/login/home";
                   }
                   else if (msg == "fail") {
                       alert("用户名或密码错误！");
                   }
               }
           });
       });

   </script>

   <!--注册JS-->
   <script type="text/javascript">
       $("#register_btn").click(function(){
           var username = $.trim($("#signupInputName").val());
           var password = $.trim($("#signupInputPassword1").val());
           var repeatpassword = $.trim($("#signupInputRePassword1").val());
           var email = $.trim($("#signupInputEmail1").val());
           var phone = $.trim($("#signupInputPhone").val());
           //var check=$.trim($("#check").val());

           //用户名，手机号，邮箱的正则表达式
           var user_reg=/^[a-zA-Z][a-zA-Z0-9]{7,14}$/;
           var phone_reg=/^((13[0-9])|(14[5|7])|(15[0-3]|[5-9])|(18[0,5-9]))[0-9]{8}$/;
           var email_reg=/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;

           if(username == ""){
               alert("用户名不能为空！");
               return false;
           }else if(!user_reg.test(username)){
               alert("用户名格式不正确！");
               return false;
           }
           else if(password == ""){
               alert("密码不能为空！");
               return false;
           }
           else if(repeatpassword!=password){
               alert("两次输入密码不相同！")
               return false;
           }
           else if(email==""){
               alert("电子邮箱不能为空");
               return false;
           }
           else if(!email_reg.test(email)){
               alert("电子邮箱格式不正确");
               return false;
           }
           else if(phone==""){
               alert("手机号码不能为空");
               return false;
           }
           else if(!phone_reg.test(phone)){
               alert("手机号格式不正确");
               return false;
           }
           else if(!$("#check").is(":checked")){
               alert("请同意协议后再注册！");
               return false;
           }
          else { $("#regform").submit();}
       });

   </script>
   <!-- END Scripts-->
   <script type="text/javascript">
       $("#admin_login_btn").click(function () {
           var username = $.trim($("#adminInputName").val());
           var password = $.trim($("#adminInputPassword1").val());
           if (username == "") {
               alert("用户名不能为空！");
               return false;
           } else if (password == "") {
               alert("密码不能为空！");
               return false;
           }
           //ajax去服务器端校验
           var data = {username: username, password: password};

           $.ajax({
               type: "POST",
               url: "../login/adminlogin",
               data: data,

               success: function (msg) {
                   if (msg == "success") {
                       window.location.href = "/login/history";
                   }
                   else if (msg == "fail") {
                       alert("用户名或密码错误！");
                   }
               }
           });
       });
   </script>
</body>

</html>