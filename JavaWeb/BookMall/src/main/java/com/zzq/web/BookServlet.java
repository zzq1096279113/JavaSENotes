package com.zzq.web;

import com.zzq.entity.Book;
import com.zzq.entity.Page;
import com.zzq.service.impl.BookServiceImpl;
import com.zzq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description Book模块
 * @ClassName BookServlet
 * @Author zzq
 * @Date 2021/2/25 20:28
 */
public class BookServlet extends BaseServlet {

    private final BookServiceImpl bookService = new BookServiceImpl();

    /**
     * @Description 添加图书
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/26 15:30
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求的参数，封装成为bean对象
        Book book = WebUtils.mapToBean(new Book(), request.getParameterMap());
        //2、调用addBook方法
        bookService.addBook(book);
        //3、跳回到图书列表页面
//        request.getRequestDispatcher("/manager/bookServlet?action=select").forward(request, response);
        int pageTotal = Integer.parseInt(request.getParameter("pageTotal")) + 1;    //跳回最后一页
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageTotal);
    }

    /**
     * @Description 根据id删除图书
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/26 15:30
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求的参数，封装成为bean对象
        Integer id = Integer.valueOf(request.getParameter("id"));
        //2、调用service中的delete方法
        bookService.deleteBook(id);
        //3、跳回到图书列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=1");
    }

    /**
     * @Description 修改图书
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/26 16:21
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求的参数，封装成为bean对象
        Book book = WebUtils.mapToBean(new Book(), request.getParameterMap());
        //2、调用service中的updateBook方法
        bookService.updateBook(book);
        //3、跳回到图书列表页面
        String pageNo = request.getParameter("pageNo");
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    /**
     * @Description 列出所有图书
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/26 15:30
     */
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过bookService查询全部图书
        List<Book> books = bookService.selectBooks();
        //2、把图书信息保存到request域中
        request.setAttribute("books", books);
        //3、请求转发
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * @Description 根据id查询book对象
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/26 16:21
     */
    public void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取图书编号
        Integer id = Integer.valueOf(request.getParameter("id"));
        //2、通过service方法查询对象
        Book book = bookService.selectBookById(id);
        //3、将对象保存
        request.setAttribute("book", book);
        //4、请求转发
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
     * @Description 分页功能
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/2/28 10:23
     */
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取当前页码
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        //2、通过页码获取当前页信息
        Page<Book> page = bookService.page(pageNo);
        page.setUrl("manager/bookServlet?action=page");
        //3、页面信息保存到request域中
        request.setAttribute("page", page);
        //4、跳转到显示页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
