package com.zzq.service;

import com.zzq.entity.Cart;
import com.zzq.entity.CartItem;
import com.zzq.entity.Order;
import com.zzq.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @ClassName OrderServiceTest
 * @Author zzq
 * @Date 2021/3/2 22:08
 */
class OrderServiceTest {
    private final OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    void creatOrder() {
        Cart cart = new Cart();
        CartItem item1 = new CartItem(1, "数据结构与算法", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item2 = new CartItem(1, "剑指offer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item3 = new CartItem(2, "高等数学", 1, new BigDecimal(50), new BigDecimal(50));
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        String s = orderService.creatOrder(cart, 2);
        System.out.println(s);
    }

    @Test
    void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    void sendOrder(){
        orderService.sendOrder("16147423927642");
    }
}