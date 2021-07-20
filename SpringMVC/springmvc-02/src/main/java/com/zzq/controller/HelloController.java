package com.zzq.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description HelloController
 * @ClassName HelloController
 * @Author zzq
 * @Date 2021/7/5 17:25
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 业务代码
        String result = "Hello World!";
        modelAndView.addObject("message", result);
        // 视图跳转
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
