<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>empty</title>
    </head>
    <body>
        <%
            //1、值为null 值的时候，为空
            request.setAttribute("emptyNull", null);

            //2、值为空串的时候，为空串
            request.setAttribute("emptyString", "");

            //3、Object类型数组，长度为零的时候
            request.setAttribute("emptyArray", new Object[]{});

            //4、list集合，元素个数为零
            request.setAttribute("emptyList", new ArrayList<Integer>());

            //5、map集合，元素个数为零
            request.setAttribute("emptyString", new HashMap<String, String>());
        %>
        ${empty emptyNull}<br>
        ${empty emptyString}<br>
        ${empty emptyArray}<br>
        ${empty emptyList}<br>
    </body>
</html>
