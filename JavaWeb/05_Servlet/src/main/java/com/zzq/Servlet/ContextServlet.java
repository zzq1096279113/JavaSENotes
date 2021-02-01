package com.zzq.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description ContextServlet
 * @ClassName ContextServlet
 * @Author zzq
 * @Date 2020/12/14 20:47
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        
        //1、获取web.xml中配置的上下文参数context-param
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        //2、获取当前的工程路径，格式:/工程路径
        System.out.println("工程路径:" + context.getContextPath());

        //3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("绝对路径:" + context.getRealPath("/"));
    }
}
