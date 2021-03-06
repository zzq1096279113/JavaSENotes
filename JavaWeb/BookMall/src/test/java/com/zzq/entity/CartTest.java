package com.zzq.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @ClassName CartTest
 * @Author zzq
 * @Date 2021/3/1 21:12
 */
class CartTest {

    private final Cart cart = new Cart();

    @Test
    void addItem() {
        CartItem item1 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item2 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item3 = new CartItem(2, "asdf", 1, new BigDecimal(50), new BigDecimal(50));
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        CartItem item1 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item2 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item3 = new CartItem(2, "asdf", 1, new BigDecimal(50), new BigDecimal(50));
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        System.out.println(cart);
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    void clear() {
        CartItem item1 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item2 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item3 = new CartItem(2, "asdf", 1, new BigDecimal(50), new BigDecimal(50));
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void update() {
        CartItem item1 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item2 = new CartItem(1, "qwer", 2, new BigDecimal(30), new BigDecimal(60));
        CartItem item3 = new CartItem(2, "asdf", 1, new BigDecimal(50), new BigDecimal(50));
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        System.out.println(cart);
        cart.update(2, 3);
        System.out.println(cart);
    }
}