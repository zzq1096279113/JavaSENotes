<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zzq.servlet.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--练习二：jsp输出一个表格，里面有5个学生信息。--%>
<%
    ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("studentList");
%>
<table align="center" border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <%
        for (Student s : students) {
    %>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
