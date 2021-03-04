package com.zzq.ajax;

import com.google.gson.Gson;
import com.zzq.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @ClassName AjaxServlet
 * @Author zzq
 * @Date 2021/2/19 14:58
 */
public class AjaxServlet extends BaseServlet{
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到javaScriptAjax请求");
        Person person = new Person(1, "zzq");
        Gson gson = new Gson();
        String personJson = gson.toJson(person); //将查询到的信息已json形式传回客户端（服务器）
        resp.getWriter().write(personJson);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到jQueryAjax请求");
        Person person = new Person(2, "zzp");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        resp.getWriter().write(personJson);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到jQueryGet请求");
        Person person = new Person(3, "zzm");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        resp.getWriter().write(personJson);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到jQueryPost请求");
        Person person = new Person(4, "zzj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        resp.getWriter().write(personJson);
    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到jQueryGetJSON请求");
        Person person = new Person(5, "zzz");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        resp.getWriter().write(personJson);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已收到jQuerySerialize请求");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));
    }
}
