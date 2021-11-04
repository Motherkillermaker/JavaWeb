package com.atguigu.DAO.impl;

import com.atguigu.DAO.OrderDAO;
import com.atguigu.pojo.Order;

/**
 * @author CJYong
 * @create 2021-08-03 17:26
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreatTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }

}

