package com.zzq.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 图书管理权限过滤
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/3/3 20:09
 */
public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        if (username == null) {     //如果未登录
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
