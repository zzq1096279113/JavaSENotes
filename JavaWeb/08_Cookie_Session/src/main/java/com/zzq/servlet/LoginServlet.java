package com.zzq.servlet; /**
 * @Description TODO
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/2/9 16:30
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("root".equals(username) && "123456".equals(password)) {
            Cookie cookie = new Cookie("username", username);   //登陆成功，将用户名保存为Cookie
            cookie.setMaxAge(60 * 60 * 24 * 7); //用户名Cookie保存7天
            response.addCookie(cookie);
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
