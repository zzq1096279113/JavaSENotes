package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Description HelloServlet
 * @ClassName com.zzq.servlet.HelloServlet
 * @Author zzq
 * @Date 2021/7/5 10:48
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取前端参数
        String method = request.getParameter("method");
        // 2.调用业务层处理业务
        if ("add".equals(method)) {
            request.getSession().setAttribute("message", "add方法被执行");
        } else if ("delete".equals(method)) {
            request.getSession().setAttribute("message", "delete方法被执行");
        } else {
            request.getSession().setAttribute("message", "其他方法被执行");
        }
        // 3.视图转发或重定向
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
