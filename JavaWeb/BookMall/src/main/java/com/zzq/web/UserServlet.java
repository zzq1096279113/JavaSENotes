package com.zzq.web;

import com.google.gson.Gson;
import com.zzq.entity.User;
import com.zzq.service.UserService;
import com.zzq.service.impl.UserServiceImpl;
import com.zzq.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Description 根据隐藏域信息分别处理业务
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/2/24 15:09
 */
public class UserServlet extends BaseServlet {

    private final UserService userService = new UserServiceImpl();  //调用的service层

    /**
     * @Description 注册
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 16:26
     */
    protected void registered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String code = request.getParameter("code");
        User user = WebUtils.mapToBean(new User(), request.getParameterMap());
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY); //获取session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);  //删除session中的验证码
        //2、检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {    //验证码正确
            if (!userService.existUser(user.getUsername())) {   //如果用户名不存在
                userService.registeredUser(user);   //将用户信息保存到数据库
                response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");    //跳转到注册成功页面
            } else {    //如果用户名已经存在
                request.setAttribute("msg", "用户名重复！");
                request.setAttribute("password", user.getPassword());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }

        } else {    //验证码错误，返回注册页面
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    /**
     * @Description 登录
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 16:26
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.loginUser(username, password);
        if (user == null) {
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("username", username);    //将用户登录之后的信息保存入session中
            request.getSession().setAttribute("userId", user.getId());
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        }
    }

    /**
     * @Description 注销
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 16:26
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();  //立刻销毁session对象
        response.sendRedirect(request.getContextPath());    //重定向回首页
    }


    /**
     * @Description 用户名是否已存在
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/3 21:49
     */
    protected void usernameExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"); //获取请求参数
        boolean existUser = userService.existUser(username);    //查询是否存在
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("existUser", existUser);    //将结果封装
        Gson gson = new Gson();
        String json = gson.toJson(map);     //转化为json
        response.getWriter().write(json);   //回传
    }
}
