package com.zzq.dao;

import com.zzq.entity.Order;

import java.util.List;

/**
 * @Description TODO
 * @ClassName OrderDao
 * @Author zzq
 * @Date 2021/3/2 20:29
 */
public interface OrderDao {
    /**
     * @Description 保存订单
     * @Param [order]
     * @Return void
     * @Author zzq
     * @Date 2021/3/2 20:33
     */
    public int saveOrder(Order order);

    /**
     * @Description 查询全部订单
     * @Param []
     * @Return java.util.List<com.zzq.entity.Order>
     * @Author zzq
     * @Date 2021/3/2 20:34
     */
    public List<Order> selectAllOrders();

    /**
     * @Description 修改订单状态
     * @Param [orderId, status]
     * @Return int
     * @Author zzq
     * @Date 2021/3/2 20:35
     */
    public int updateOrderStatus(String orderId, Integer status);

    /**
     * @Description 根据userId查询订单
     * @Param [userId]
     * @Return com.zzq.entity.Order
     * @Author zzq
     * @Date 2021/3/2 20:36
     */
    public Order selectOrderByUserId(Integer userId);
}
