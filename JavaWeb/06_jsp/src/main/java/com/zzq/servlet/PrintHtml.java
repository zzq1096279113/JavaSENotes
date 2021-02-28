package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 用servlet程序打印页面
 * @ClassName PrintHtml
 * @Author zzq
 * @Date 2021/1/31 14:28
 */
public class PrintHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>示例</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        这是一个html页面\n" +
                "    </body>\n" +
                "</html>");
    }
}
