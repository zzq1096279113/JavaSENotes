<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Calculation</title>
    </head>
    <body>
        <%--关系运算--%>
        ${22 == 22}<br>
        ${11 != 22}<br>
        ${1 < 2}<br>
        ${1 > 2}<br>
        ${121 <= 121}<br>
        ${212 >= 212}<br>
        <hr/>
        <%--逻辑运算--%>
        ${12 == 12 && 1 != 3}<br>
        ${1 > 3 || 4 != 4}<br>
        ${!true}<br>
        <hr/>
        <%--算数运算--%>
        ${12 + 12}<br>
        ${12 * 12}<br>
        ${15 - 12}<br>
        ${15 / 12}<br>
        ${12 % 12}<br>
    </body>
</html>
