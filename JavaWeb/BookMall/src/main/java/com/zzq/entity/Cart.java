package com.zzq.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 购物车类
 * @ClassName Cart
 * @Author zzq
 * @Date 2021/3/1 20:43
 */
public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();   //购物车中的商品

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {  //遍历所有的数量并相加
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {  //遍历所有的数量并相加
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * @Description 购物车中添加商品
     * @Param [item]
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 20:52
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());    //用物品的id在购物车中搜索
        if (item == null) {   //说明购物车中原来没有此物品
            this.items.put(cartItem.getId(), cartItem);
        } else {  //购物车中原来有此物品
            item.setCount(cartItem.getCount() + item.getCount());     //更新数量
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));  //更新总价值
        }
    }

    /**
     * @Description 根据id删除商品
     * @Param [id]
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 21:04
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * @Description 清空购物车
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2021/3/1 21:04
     */
    public void clear() {
        items.clear();
    }

    public void update(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
