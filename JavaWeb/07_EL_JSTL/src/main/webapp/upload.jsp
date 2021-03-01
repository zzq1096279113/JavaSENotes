<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>文件上传</title>
    </head>
    <body>
        <form action="http://localhost:8080/07_EL_JSTL/upLoadServlet" enctype="multipart/form-data" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>头像：</td>
                    <td><input type="file" name="photo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="上传"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
