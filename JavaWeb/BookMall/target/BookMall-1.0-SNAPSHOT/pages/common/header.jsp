<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();
    String contextPath = request.getContextPath();
    String basePath = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>