package com.zzq.Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("HelloServlet被构造");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet被初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @Description service方法就是用来处理请求和响应的
     * @Param [servletRequest, servletResponse]
     * @Return void
     * @Author zzq
     * @Date 2020/12/7 14:03
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;    //强制类型转换（ServletRequest没有getMethod()方法，他的子类HttpServletRequest有）
        String method = httpServletRequest.getMethod();     //获取请求方式
        if("GET".equals(method)){
            System.out.println("get请求");
        } else if ("POST".equals(method)){
            System.out.println("post请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet被销毁");
    }
}