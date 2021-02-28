<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>九九乘法表</title>
    </head>
    <body>
        <%--练习一：在jsp页面中输出九九乘法口诀表--%>
        <table align="center">
            <%for (int i = 1; i <= 9; i++) {%>
            <tr>
                <%for (int j = 1; j <= i; j++) {%>
                <td><%=j + "x" + i + "=" + (i * j) %></td>
                <%}%>
            </tr>
            <%}%>
        </table>
    </body>
</html>
