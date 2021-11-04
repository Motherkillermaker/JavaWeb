package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author CJYong
 * @create 2021-08-03 17:58
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

}
