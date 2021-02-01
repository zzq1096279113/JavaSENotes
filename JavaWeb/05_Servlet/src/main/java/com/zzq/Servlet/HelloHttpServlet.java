package com.zzq.Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 初识HttpServlet
 * @ClassName HelloHttpServlet
 * @Author zzq
 * @Date 2020/12/10 17:01
 */
public class HelloHttpServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init开始初始化");
    }

    /**
     * @Description 在get请求时被调用
     * @Param [req, resp]
     * @Return void
     * @Author zzq
     * @Date 2020/12/10 17:03
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求时被调用");
    }

    /**
     * @Description 在post请求时被调用
     * @Param [req, resp]
     * @Return void
     * @Author zzq
     * @Date 2020/12/10 17:03
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求时被调用");
    }
}
