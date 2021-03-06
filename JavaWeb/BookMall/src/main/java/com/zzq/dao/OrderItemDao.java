package com.zzq.dao;

import com.zzq.entity.OrderItem;

/**
 * @Description TODO
 * @ClassName OrderItemDao
 * @Author zzq
 * @Date 2021/3/2 20:29
 */
public interface OrderItemDao {
    /**
     * @Description 保存订单详细信息
     * @Param [orderItem]
     * @Return void
     * @Author zzq
     * @Date 2021/3/2 20:30
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * @Description 通过订单id查询订单详细信息
     * @Param [id]
     * @Return com.zzq.entity.OrderItem
     * @Author zzq
     * @Date 2021/3/2 20:32
     */
    public OrderItem selectOrderItemByOrderId(String orderId);
}
