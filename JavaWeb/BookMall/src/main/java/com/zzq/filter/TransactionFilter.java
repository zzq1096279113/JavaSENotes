package com.zzq.filter;

import com.zzq.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description 给所有service加上事务管理
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/3/3 21:30
 */
public class TransactionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
