package com.zzq.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Description 重定向
 * @ClassName Response1
 * @Author zzq
 * @Date 2021/1/29 18:29
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response1已经废除，现使用Response2");
//        response.setStatus(302);    //设置状态响应码，表示重定向
//        response.setHeader("Location", "http://localhost:8080/05_Servlet_war/response2");   //设置响应头
        response.sendRedirect("http://localhost:8080/05_Servlet_war/response2");
    }
}
