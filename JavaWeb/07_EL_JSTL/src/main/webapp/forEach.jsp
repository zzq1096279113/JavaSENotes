<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach</title>
</head>
<body>
    <%
        request.setAttribute("key", new String[]{"zzq", "zzm", "zzp", "zzj"});
    %>
    <%--1. 遍历1 到10，输出--%>
    <c:forEach begin="1" end="10" var="i">
        ${ i }
    </c:forEach><br>

    <%--2. 遍历Object 数组--%>
    <c:forEach items="${requestScope.key}" var="s">
        ${ s }
    </c:forEach>
</body>
</html>
