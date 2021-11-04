package com.atguigu.DAO.impl;

import com.atguigu.DAO.OrderItemDAO;
import com.atguigu.pojo.OrderItem;

/**
 * @author CJYong
 * @create 2021-08-03 17:41
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {

    @Override
    public int savaOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(), orderItem.getOrderId());
    }

}
