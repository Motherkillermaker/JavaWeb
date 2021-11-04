package com.atguigu.test;

import com.atguigu.DAO.OrderDAO;
import com.atguigu.DAO.impl.OrderDAOImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-08-03 17:47
 */
public class OrderDAOTest {

    @Test
    public void saveOrder() {

        OrderDAO orderDao = new OrderDAOImpl();

        orderDao.saveOrder(new Order("1234567891",new Date(),new BigDecimal(100),0, 1));
    }
}