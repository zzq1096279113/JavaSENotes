package com.zzq.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description response对象与字符乱码问题
 * @ClassName ResponseIOServlet
 * @Author zzq
 * @Date 2021/1/29 17:57
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");     //设置服务器字符集为UTF-8
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");     //设置浏览器字符集为UTF-8
        response.setContentType("text/html; charset=UTF-8");    //同时设置服务器和客户端字符集为UTF-8
        PrintWriter writer = response.getWriter();  //得到字符流
        writer.print("欢迎来到Response");
        writer.close();
    }
}
