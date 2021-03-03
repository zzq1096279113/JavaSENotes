package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Description 验证登录信息
 * @ClassName LoginServlet
 * @Author zzq
 * @Date 2021/2/10 16:53
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("root".equals(username) && "123456".equals(password)) {
            request.getSession().setAttribute("username", "root");  //验证成功，则将用户名存入session
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
