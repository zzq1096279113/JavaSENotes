package com.zzq.dao;

import com.zzq.dao.impl.OrderDaoImpl;
import com.zzq.entity.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName OrderDaoTest
 * @Author zzq
 * @Date 2021/3/2 21:06
 */
class OrderDaoTest {

    private final OrderDaoImpl orderDao = new OrderDaoImpl();

    @Test
    void saveOrder() {
        Order order = new Order("123457", new Date(), new BigDecimal(90), 1, 4);
        orderDao.saveOrder(order);
    }

    @Test
    void selectAllOrders() {
        List<Order> orders = orderDao.selectAllOrders();
        for (Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    void updateOrderStatus() {
        orderDao.updateOrderStatus("123457", 0);
    }

    @Test
    void selectOrderByUserId() {
        Order order = orderDao.selectOrderByUserId(4);
        System.out.println(order);
    }
}