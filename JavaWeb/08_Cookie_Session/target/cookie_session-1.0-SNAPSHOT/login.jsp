<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="http://localhost:8080/08_cookie_session/loginServlet" method="get">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${cookie.username.value}"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <input type="submit" value="提交">
        </tr>
    </table>
</form>
</body>
</html>
