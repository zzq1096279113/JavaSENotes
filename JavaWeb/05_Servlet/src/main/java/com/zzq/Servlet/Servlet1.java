package com.zzq.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 请求的转发1
 * @ClassName Servlet1
 * @Author zzq
 * @Date 2020/12/22 21:45
 */
public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Servlet1中的username：" + username);
        request.setAttribute("key", "1");   //servlet1处理完毕的标记
        System.out.println("业务1处理完毕");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");    //得到servlet2的地址
        requestDispatcher.forward(request, response);   //跳转到servlet2
    }
}
