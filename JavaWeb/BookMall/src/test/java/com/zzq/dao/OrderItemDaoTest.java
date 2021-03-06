package com.zzq.dao;

import com.zzq.dao.impl.OrderItemDaoImpl;
import com.zzq.entity.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


/**
 * @Description TODO
 * @ClassName OrderItemDaoTest
 * @Author zzq
 * @Date 2021/3/2 21:50
 */
class OrderItemDaoTest {

    private final OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Test
    void saveOrderItem() {
        OrderItem orderItem = new OrderItem(null, "高等数学",1, new BigDecimal(45), new BigDecimal(45), "123456");
        orderItemDao.saveOrderItem(orderItem);
    }

    @Test
    void selectOrderItemByOrderId() {
        OrderItem orderItem = orderItemDao.selectOrderItemByOrderId("123456");
        System.out.println(orderItem);
    }
}