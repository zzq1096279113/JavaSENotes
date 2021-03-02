package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description Session
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/2/9 20:08
 */
public class SessionServlet extends BaseServlet {

    /**
     * @Description 创建或获取Session
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 20:10
     */
    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        if (session.isNew()) {
            writer.println("创建Session");
        } else {
            writer.println("获取Session");
        }
        writer.println("Session的ID：" + session.getId());
    }

    /**
     * @Description 设置Session域中的数据
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 20:19
     */
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("username", "root");
        request.getSession().setAttribute("password", "123456");
    }

    /**
     * @Description 获取Session域中的数据
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 20:19
     */
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.getWriter().print("username：" + session.getAttribute("username"));
        response.getWriter().print("password：" + session.getAttribute("password"));
    }

    protected void getTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().print("Session默认超时时长为：" + maxInactiveInterval + "s");
    }

    protected void setTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        response.getWriter().print("Session超时时长设置为3s");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
