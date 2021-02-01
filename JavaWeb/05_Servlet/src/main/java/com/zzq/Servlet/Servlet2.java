package com.zzq.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 请求的转发2
 * @ClassName Servlet2
 * @Author zzq
 * @Date 2020/12/22 21:45
 */
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        System.out.println("Servlet2中的password：" + password);
        String key = (String) request.getAttribute("key");  //得到业务1的标记
        if ("1".equals(key)) {    //判断是否可以执行业务2
            System.out.println("业务2处理完毕");
        } else {
            System.out.println("业务1异常，业务2未办理");
        }
    }
}
