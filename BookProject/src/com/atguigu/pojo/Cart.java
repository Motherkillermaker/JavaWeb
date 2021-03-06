package com.atguigu.pojo;

import java.math.BigDecimal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CJYong
 * @create 2021-08-02 16:42
 */
public class Cart {

    /**
     * 购物车对象
     */

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    /**
     * 添加商品项
     * key是商品编号，value是商品信息
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //先查看购物车是否有该商品，如果已经添加。则数量累加，总金额更新。若没有添加则直接放到集合中
        CartItem item = items.get(cartItem.getId());

        if (item == null){
            //之前没有添加过商品
            items.put(cartItem.getId(),cartItem);
        }else {
            //已经添加过的情况
            item.setCount(item.getCount() + 1);   //数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));  //更新总金额  （价格*数量）
        }


    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);

    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();

    }

    /**
     * 修改商品数量
     * @param count
     */
    public void updateCount(Integer id,Integer count){
        //先查看购物车中是否有此商品，如果有则修改商品数量并更新总金额

        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);     //修改商品数量

            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));  //更新总金额  （价格*数量）

        }

    }






    public Cart() {
    }

    public Integer getTotalCount() {

        Integer totalCount = 0;

        for (Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }


    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
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
