package com.zzq.servlet;

import com.zzq.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Description 接收Cookie
 * @ClassName CookieServlet
 * @Author zzq
 * @Date 2021/2/9 10:15
 */
public class CookieServlet extends BaseServlet {

    /**
     * @Description 创建Cookie
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 10:51
     */
    protected void creatCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username", "zzq");
        //2.通知客户端（浏览器）保存Cookie
        response.addCookie(cookie);
        response.getWriter().print("Cookie已经创建");
    }

    /**
     * @Description 修改Cookie
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 10:51
     */
    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、先创建一个要修改的同名（指的就是key）的Cookie对象，同时赋于新的Cookie值。
        Cookie cookie = new Cookie("username", "root");

        //2、调用response.addCookie(Cookie);
        response.addCookie(cookie);
        response.getWriter().print("Cookie已经修改");
    }

    /**
     * @Description 设置cookie存活时间为0，即立即删除
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 14:49
     */
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.findCookie("username", cookies);
        if(cookie != null){
            cookie.setMaxAge(0);    //设置为0，马上删除
            response.addCookie(cookie);
            response.getWriter().print("Cookie已经删除");
        }
    }

    protected void path(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("password", "123456");
        cookie.setPath(request.getContextPath());
    }

    /**
     * @Description 遍历显示所有Cookie
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/9 10:51
     */
    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies ){
            response.getWriter().println(c.getName() + ":" + c.getValue());
        }
    }

}
