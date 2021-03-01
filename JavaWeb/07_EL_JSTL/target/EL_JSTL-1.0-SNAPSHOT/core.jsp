<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>core核心库</title>
</head>
<body>
    <%--i. <c:set />--%>
    <%--作用：set标签可以往域中保存数据--%>
    保存之前：${pageScope.key}<br/>
    <c:set scope="page" var="key" value="pageContextValue"/>
    保存之后：${pageScope.key}<br/>
    <hr/>
    <%--ii. <c:if />--%>
    <%--if 标签用来做if 判断。--%>
    <c:if test="${12 == 12}">
        <h1>相等</h1>
    </c:if>
    <hr/>
    <%--iii. <c:choose> <c:when> <c:otherwise>标签 --%>
    <%--作用：多路判断。跟switch ... case .... default 非常接近--%>
    <%
        request.setAttribute("height", 185);
    %>
    <c:choose>
        <c:when test="${height < 160}">
            <h3>身高比较矮</h3>
        </c:when>
        <c:when test="${160 <= height && height < 180}">
            <h3>身高正常</h3>
        </c:when>
        <c:when test="${180 <= height}">
            <h3>身高比较高</h3>
        </c:when>
        <c:otherwise>
            <h3>身高不太正常</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
