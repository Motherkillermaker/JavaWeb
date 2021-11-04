package com.atguigu.test;

import com.atguigu.DAO.OrderItemDAO;
import com.atguigu.DAO.impl.OrderDAOImpl;
import com.atguigu.DAO.impl.OrderItemDAOImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-08-03 17:50
 */
public class OrderItemDAOTest {

    @Test
    public void savaOrderItem() {

        OrderItemDAO orderItemDao = new OrderItemDAOImpl();

        orderItemDao.savaOrderItem(new OrderItem(null,"java 从入门到精通", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567891"));

        orderItemDao.savaOrderItem(new OrderItem(null,"javaScript 从入门到精通", 2,new
                BigDecimal(100),new BigDecimal(200),"1234567891"));

        orderItemDao.savaOrderItem(new OrderItem(null,"Netty 入门", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567891"));
    }
}