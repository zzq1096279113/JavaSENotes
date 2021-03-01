<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>
<%
    pageContext.setAttribute("key1", "pageContext1");
    pageContext.setAttribute("key2", "pageContext2");
    request.setAttribute("key2", "request");
    session.setAttribute("key2", "session");
    application.setAttribute("key2", "application");
%>
${sessionScope.key2}
${requestScope.key2}
${applicationScope.key2}
</body>
</html>
