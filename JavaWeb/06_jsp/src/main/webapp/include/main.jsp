<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主题信息<br>
<%--    静态包含：不会额外翻译java文件，而是把被包含的jsp页面全部拷贝到包含的位置执行输出--%>
<%--    <%@include file="/include/footer.jsp"%>--%>
<%--    动态包含：会额外翻译被包含的jsp页面，通过代码调用被包含的jsp页面执行输出--%>
    <jsp:include page="/include/footer.jsp"/>
</body>
</html>
