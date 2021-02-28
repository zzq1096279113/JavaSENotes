<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error500.jsp"
         language="java" %>
<%--        language            属性表示jsp翻译后是什么语言文件。暂时只支持java。--%>
<%--        contentType         属性表示jsp返回的数据类型是什么。也是源码中response.setContentType()参数值--%>
<%--        pageEncoding        属性表示当前jsp页面文件本身的字符集。--%>
<%--        import              属性跟java源代码中一样。用于导包，导类。--%>
<%--        autoFlush           属性设置当out输出流缓冲区满了之后，是否自动刷新冲级区。默认值是true。--%>
<%--        buffer              属性设置out输出流缓冲区的大小。默认是8kb--%>
<%--        errorPage           属性设置当jsp页面运行时出错时，自动跳转去的错误页面路径。--%>
<%--        isErrorPage         属性设置当前jsp页面是否是错误信息页面。默认是false。如果是true 可以获取异常信息。--%>
<%--        session             属性设置访问当前jsp页面，是否会创建HttpSession对象。默认是true。--%>
<%--        extends             属性设置jsp翻译出来的java类默认继承谁。--%>
<html>
    <head>
        <title>Hello</title>
    </head>
    <body>
        Hello jsp!
    </body>
</html>
<%--    jsp页面本质上就是一个servlet程序 在第一次被访问时翻译成为java文件并编译--%>
<%--    文件中继承了HttpJspBase类，而HttpJspBase类继承了HttpServlet类--%>
