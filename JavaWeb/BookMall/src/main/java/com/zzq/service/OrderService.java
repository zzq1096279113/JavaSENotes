package com.zzq.service;

import com.zzq.entity.Cart;
import com.zzq.entity.Order;

import java.util.List;

/**
 * @Description TODO
 * @ClassName OrderService
 * @Author zzq
 * @Date 2021/3/2 21:57
 */
public interface OrderService {

    public String creatOrder(Cart cart, Integer userId);

    public List<Order> showAllOrders();

    public void sendOrder(String orderId);

}
