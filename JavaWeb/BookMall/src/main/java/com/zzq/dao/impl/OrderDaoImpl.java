package com.zzq.dao.impl;

import com.zzq.dao.BaseDao;
import com.zzq.dao.OrderDao;
import com.zzq.entity.Order;

import java.util.List;

/**
 * @Description TODO
 * @ClassName OrderDaoImpl
 * @Author zzq
 * @Date 2021/3/2 20:37
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`creat_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreatTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> selectAllOrders() {
        String sql = "select `order_id`,`creat_time`,`price`,`status`,`user_id` from t_order";
        return selectList(Order.class, sql);
    }

    @Override
    public int updateOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set `status`=? where `order_id`=?";
        return update(sql, status, orderId);
    }

    @Override
    public Order selectOrderByUserId(Integer userId) {
        String sql = "select `order_id`,`creat_time`,`price`,`status`,`user_id` from t_order where `user_id`=?";
        return selectOne(Order.class, sql, userId);
    }
}
