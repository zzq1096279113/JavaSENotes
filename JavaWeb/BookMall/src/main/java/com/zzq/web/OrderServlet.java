package com.zzq.web;

import com.zzq.entity.Cart;
import com.zzq.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 订单模块
 * @ClassName OrderServlet
 * @Author zzq
 * @Date 2021/3/3 19:39
 */
public class OrderServlet extends BaseServlet {

    private final OrderServiceImpl orderService = new OrderServiceImpl();

    /**
     * @Description 生成订单
     * @Param [request, response]
     * @Return void
     * @Author zzq
     * @Date 2021/3/3 19:40
     */
    protected void creatOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");   //获取参数
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {     //如果userId为null，说明没有登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
            return;
        }
        String orderId = orderService.creatOrder(cart, userId); //创建订单保存并返回订单号
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
