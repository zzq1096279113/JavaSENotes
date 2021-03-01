package com.zzq.EL_JSTL.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Description 下载文件
 * @ClassName DownloadServlet
 * @Author zzq
 * @Date 2021/2/3 19:28
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        //1、获取要下载文件名
        String downloadFileName = "ASCII码表.jpg";

        //2、通过响应头告诉客户端数据类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);  //获取要下载文件的类型
        response.setContentType(mimeType);  //设置数据类型

        //3、通过响应头告诉客户端数据是用于下载
        //设置请求头Content-Disposition表示数据如何处理，attachment表示附件
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));

        //4、读取要下载的内容(通过ServletContext可以获得)
        InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);    //以流的方式获取资源

        //5、把文件回传给客户端
        ServletOutputStream outputStream = response.getOutputStream();  //获取响应的输出流
        IOUtils.copy(inputStream, outputStream);    //读取输入流的数据复制给输出流输出
    }

}
