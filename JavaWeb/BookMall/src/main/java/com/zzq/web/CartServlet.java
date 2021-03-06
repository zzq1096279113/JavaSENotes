package com.zzq.web;

import com.google.gson.Gson;
import com.zzq.entity.Book;
import com.zzq.entity.Cart;
import com.zzq.entity.CartItem;
import com.zzq.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Description 购物车模块
 * @ClassName CartServlet
 * @Author zzq
 * @Date 2021/3/1 20:42
 */
public class CartServlet extends BaseServlet {

    private final BookServiceImpl bookService = new BookServiceImpl();

    /**
     * @Description 添加商品到购物车
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/2 15:47
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");     //获取请求参数
        Book book = bookService.selectBookById(Integer.valueOf(id));    //获取book对象
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());    //转换为商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(item);     //加入到购物车中
        request.getSession().setAttribute("lastAdd", item.getName());   //将最后加入的商品名放入session域中
        HashMap<String, Object> result = new HashMap<>();
        result.put("totalCount", cart.getTotalCount());
        result.put("lastAdd", item.getName());
        Gson gson = new Gson();
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }

    /**
     * @Description 购物车中删除商品
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/2 15:47
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");     //获取请求参数
        Cart cart = (Cart) request.getSession().getAttribute("cart");   //获取购物车对象
        if (cart != null) {
            cart.deleteItem(Integer.valueOf(id));       //在购物车中删除商品
        }
        response.sendRedirect(request.getHeader("referer"));    //重定向回原来的页面
    }

    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));       //获取请求参数
        Integer count = Integer.valueOf(request.getParameter("count"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");       //获取购物车对象
        if (cart != null) {
            cart.update(id, count);         //商品数量
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    /**
     * @Description 清空购物车
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/2 15:47
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        response.sendRedirect(request.getHeader("referer"));    //重定向回原来的页面
    }
}
