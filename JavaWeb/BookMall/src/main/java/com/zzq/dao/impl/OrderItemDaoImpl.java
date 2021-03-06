package com.zzq.dao.impl;

import com.zzq.dao.BaseDao;
import com.zzq.dao.OrderItemDao;
import com.zzq.entity.OrderItem;

/**
 * @Description TODO
 * @ClassName OrderItemDaoImpl
 * @Author zzq
 * @Date 2021/3/2 20:38
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?);";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public OrderItem selectOrderItemByOrderId(String orderId) {
        String sql = "select `name`,`count`,`price`,`total_price`,`order_id` from t_order_item where `order_id`=?;";
        return selectOne(OrderItem.class, sql, orderId);
    }
}
