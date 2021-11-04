package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CJYong
 * @create 2021-08-03 15:59
 */
public class Order {

    private String orderId;
    private Date CreatTime;
    private BigDecimal price;
    // 0表示为发货，1表示已经发货，2表示已经签收
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date creatTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.CreatTime = creatTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.CreatTime = creatTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", creatTime=" + CreatTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
