<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域对象</title>
</head>
<body>
<%--pageContext     (PageContextImpl 类)         当前jsp页面范围内有效，跳出当且按页面失效--%>
<%--request         (HttpServletRequest 类)      一次请求内有效，结束一次请求失效--%>
<%--session         (HttpSession 类)             一个会话范围内有效（从打开浏览器访问服务器，直到关闭浏览器）--%>
<%--application     (ServletContext 类)          整个web工程范围内都有效（只要web工程不停止，数据都在）--%>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域对象：<%=pageContext.getAttribute("key")%><br/>
request域对象：<%=request.getAttribute("key")%><br/>
session域对象：<%=session.getAttribute("key")%><br/>
application域对象：<%=application.getAttribute("key")%><br/>
<jsp:forward page="scope2.jsp"/>
</body>
</html>
