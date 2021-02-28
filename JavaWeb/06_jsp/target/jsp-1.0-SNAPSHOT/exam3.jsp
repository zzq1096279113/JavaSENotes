<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代码脚本</title>
</head>
<body>
<%--1. 代码脚本----if 语句--%>
<%
    int i = 131;
    if (i == 131) {
        System.out.println("答案正确");
    } else {
        System.out.println("答案错误");
    }
%>

<%--2. 代码脚本----for 循环语句--%>
<%
    for (int j = 0; j < 5; j++) {
        System.out.println(j);
    }
%>

<%--3. 翻译后java 文件中_jspService 方法内的代码都可以写--%>
<%
    String contentType = request.getHeader("Content-Type");
    System.out.println(contentType);
%>
</body>
</html>
