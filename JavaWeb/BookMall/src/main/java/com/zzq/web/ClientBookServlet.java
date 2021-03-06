package com.zzq.web;

import com.zzq.entity.Book;
import com.zzq.entity.Page;
import com.zzq.service.BookService;
import com.zzq.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @ClassName ClientBookServlet
 * @Author zzq
 * @Date 2021/2/28 20:43
 */
public class ClientBookServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取当前页码
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        //2、通过页码获取当前页信息
        Page<Book> page = bookService.page(pageNo);
        page.setUrl("clientBookServlet?action=page");
        //3、页面信息保存到request域中
        request.setAttribute("page", page);
        //4、跳转到显示页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取当前页码
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Integer min = Integer.valueOf(request.getParameter("min"));
        Integer max = Integer.valueOf(request.getParameter("max"));
        //2、通过页码获取当前页信息
        Page<Book> page = bookService.pageByPrice(pageNo, min, max);
        StringBuilder stringBuilder = new StringBuilder("clientBookServlet?action=pageByPrice");
        if (request.getParameter("min") != null) {
            stringBuilder.append("&min=").append(min);
        }
        if (request.getParameter("max") != null) {
            stringBuilder.append("&max=").append(max);
        }
        page.setUrl(String.valueOf(stringBuilder));
        //3、页面信息保存到request域中
        request.setAttribute("page", page);
        //4、跳转到显示页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

}
