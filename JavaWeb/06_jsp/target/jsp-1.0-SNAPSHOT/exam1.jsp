<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明脚本</title>
</head>
<body>
<%--1、声明类属性--%>
<%!
    private int id;
    private String name;
    private static HashMap<Integer, String> map;
%>

<%--2、声明static静态代码块--%>
<%!
    static {
        map = new HashMap<>();
        map.put(1, "zzq");
        map.put(2, "zzp");
        map.put(3, "zzm");
        map.put(4, "zzj");
    }
%>

<%--3、声明类方法--%>
<%!
    public void show() {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
%>

<%--4、声明内部类--%>
<%!
    public static class Example {
        public String name = "Emisa";
        public int age = 25;
    }
%>
</body>
</html>
