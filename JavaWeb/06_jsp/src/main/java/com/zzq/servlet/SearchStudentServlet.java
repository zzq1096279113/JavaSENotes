package com.zzq.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Description 查询学生信息，通过jsp页面传回给客户端
 * @ClassName ${NAME}
 * @Author zzq
 * @Date 2021/2/1 17:26
 */

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "zzp", 21));
        students.add(new Student(2, "zzq", 22));
        students.add(new Student(3, "zzm", 20));
        students.add(new Student(4, "zzj", 23));
        students.add(new Student(5, "zzh", 24));
        request.setAttribute("studentList", students);
        request.getRequestDispatcher("/test/test2.jsp").forward(request, response);
    }
}
