package com.zzq.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description 过滤器1
 * @ClassName Filter1
 * @Author zzq
 * @Date 2021/2/10 18:26
 */
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("前置代码1");
        System.out.println("Filter1当前线程：" + Thread.currentThread().getName());
        chain.doFilter(request, response);
        System.out.println("后置代码1");
    }
}
