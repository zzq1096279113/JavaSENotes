package com.zzq.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Description get与post
 * @ClassName ParameterServlet
 * @Author zzq
 * @Date 2020/12/21 21:31
 */
public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------doPost-------");
        request.setCharacterEncoding("UTF-8");  //设置请求体的字符集为UTF-8，解决中文乱码问题
        show(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------doGet-------");
        show(request);
    }

    private void show(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码："+ password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));
    }
}
