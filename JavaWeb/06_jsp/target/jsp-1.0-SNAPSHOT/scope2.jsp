<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext域对象：<%=pageContext.getAttribute("key")%><br/>
request域对象：<%=request.getAttribute("key")%><br/>
session域对象：<%=session.getAttribute("key")%><br/>
application域对象：<%=application.getAttribute("key")%><br/>
</body>
</html>
