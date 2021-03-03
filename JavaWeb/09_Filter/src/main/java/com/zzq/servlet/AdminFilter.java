package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 权限过滤器
 * @ClassName AdminFilter
 * @Author zzq
 * @Date 2021/2/10 16:38
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("构造Filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始Filter");
    }

    @Override
    public void destroy() {
        System.out.println("销毁Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("使用Filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
