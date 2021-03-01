<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>相同</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("key", "pageContext");
            request.setAttribute("key", "request");
            session.setAttribute("key", "session");
            application.setAttribute("key", "application");
            //当四个域中都有相同的key的数据的时候，EL表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。
        %>
    ${key}
    </body>
</html>
