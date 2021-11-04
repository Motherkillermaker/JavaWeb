package com.atguigu.threadlocal;

/**
 * @author CJYong
 * @create 2021-08-04 16:32
 */
public class OrderService {

    public void createOrder(){

        String name = Thread.currentThread().getName();

        System.out.println("OrderService 当前线程[" + name + "]中保存的数据是：" + ThreadLocalTest.threadLocal.get());

        new OrderDao().saveOrder();
    }
}

