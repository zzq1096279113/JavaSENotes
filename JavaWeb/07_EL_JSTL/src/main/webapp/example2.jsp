<%@ page import="com.zzq.EL_JSTL.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>输出多种类型</title>
    </head>
    <body>
        <%
            Person person = new Person();
            person.setName("zzq");
            person.setAge(25);
            person.setPhones(new String[]{"13322209998", "65465456156"});
            ArrayList<String> cities = new ArrayList<>();
            cities.add("北京");
            cities.add("上海");
            cities.add("深圳");
            person.setCities(cities);
            HashMap<String, Object> map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
            person.setMap(map);
            session.setAttribute("key", person);
        %>
        输出Person：${key}<br>
        输出Person的name属性：${key.name}<br>
        输出Person的age属性：${key.age}<br>
        输出Person的phone属性：${key.phones}<br>
        输出Person的city属性：${key.cities}<br>
        输出Person的map属性：${key.map}<br>
    </body>
</html>
