<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/header.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script type="text/javascript">
        $(function () {	//页面加载完成之后
            $("#sub_btn").click(function () {	//给注册按钮绑定单击事件
                let errorMessage = $(".errorMsg");
                let username = $("#username").val();
                let reg = /^\w{5,12}$/;         //正则表达式：由字母，数字下划线组成，并且长度为5到12位
                if (!reg.test(username)) {        //用正则表达式对输入的内容校验
                    errorMessage.text("用户名不合法！");
                    return false;
                }
                let password = $("#password").val();
                if (!reg.test(password)) {
                    errorMessage.text("密码不合法！");
                    return false;
                }
                let rePassword = $("#repwd").val();
                if (rePassword !== password) {
                    errorMessage.text("两次密码不一致！");
                    return false;
                }
                let email = $("#email").val();
                let regEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/; //验证邮箱的正则表达式
                if (!regEmail.test(email)) {
                    errorMessage.text("邮箱格式不合法！");
                    return false;
                }
                let code = $("#code").val();        //得到验证码
                let trim = $.trim(code);            //去除验证码前后的空格
                if (trim === null || trim === "") {
                    errorMessage.text("验证码错误！");
                    return false;
                }
                errorMessage.text("");
            });
            $("#code_img").click(function (){   //给验证码图片绑定点击事件
                this.src = "${basePath}kaptcha.jpg?random=" + new Date();
            });
            $("#username").blur(function (){
               let username = this.value;
               $.getJSON("${basePath}userServlet", "action=usernameExists&username=" + username, function (data){
                    if(data.existUser){
                        $(".errorMsg").text("用户名已存在！");
                    }else {
                        $(".errorMsg").text("用户名可用！");
                    }
               });
            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${empty requestScope.msg ? "" : requestScope.msg}</span>
                    <!-- 此处为显示错误信息 -->
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="registered">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${empty requestScope.username ? "" : requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"
                               value="${empty requestScope.password ? "" : requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"
                               value="${empty requestScope.password ? "" : requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${empty requestScope.email ? "" : requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 90px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>