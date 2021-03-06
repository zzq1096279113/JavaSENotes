package com.zzq.service.impl;

import com.zzq.dao.impl.BookDaoImpl;
import com.zzq.dao.impl.OrderDaoImpl;
import com.zzq.dao.impl.OrderItemDaoImpl;
import com.zzq.entity.*;
import com.zzq.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName OrderServiceImpl
 * @Author zzq
 * @Date 2021/3/2 21:58
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDaoImpl orderDao = new OrderDaoImpl();
    private final OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    private final BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public String creatOrder(Cart cart, Integer userId) {
        OrderItem orderItem;
        String orderId = System.currentTimeMillis() + "" + userId;  //订单号唯一
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId); //创建一个订单
        orderDao.saveOrder(order);  //保存订单入库
        for (CartItem cartItem : cart.getItems().values()) {     //遍历购物车中的每一个商品，并保存
            orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.selectBookById(cartItem.getId());   //更新销量与库存
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();   //清空购物车
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.selectAllOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.updateOrderStatus(orderId, 1);
    }


}
