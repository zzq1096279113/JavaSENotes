package com.zzq.EL_JSTL.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description 处理上传的文件
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/2/3 16:44
 */

public class UpLoadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {    //判断收到的request是否为“multipart/form-data”
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);     //获取表单集合
                for (FileItem file : fileItems) {
                    if (file.isFormField()) {
                        System.out.println("表单项的name属性值：" + file.getFieldName());  //getFieldName获取表单项的name属性值
                        System.out.println("表单项的value属性值：" + file.getString("UTF-8")); //UTF-8解决乱码问题
                    } else {
                        System.out.println("表单项的name属性值：" + file.getFieldName());
                        System.out.println("上传的文件名：" + file.getName());
                        file.write(new File("F:\\" + file.getName()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("上传的数据不是文件类型");
        }
    }
}
