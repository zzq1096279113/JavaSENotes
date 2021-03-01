<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>示例</title>
    </head>
    <body>
        <%
            request.setAttribute("key", "数据");
        %>
        表达式脚本输出key的值：<%=request.getAttribute("key")%><br>
        EL表达式输出key的值：${key}<br>
    </body>
</html>
