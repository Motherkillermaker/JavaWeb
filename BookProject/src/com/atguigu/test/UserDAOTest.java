package com.atguigu.test;

import com.atguigu.DAO.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import org.junit.Test;
import com.atguigu.utils.JdbcUtils;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-07-22 20:03
 */
public class UserDAOTest {

    UserDAOImpl userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if (userDAO.queryUserByUsername("admin12") == null){
            System.out.println("用户名可用 ！");
        }else {
            System.out.println("用户名已经存在！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null,"张三丰","624597867","zhangsanfeng@163.com")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDAO.queryUserByUsernameAndPassword("admin1","admin") == null){
            System.out.println("用户名或者密码错误，登录失败 ！");
        }else {
            System.out.println("登录成功 ！");
        }
    }
}