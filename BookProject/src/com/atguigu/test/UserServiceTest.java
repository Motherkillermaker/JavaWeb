package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-07-22 20:44
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void register() {
        userService.register(new User(null,"张丰","624597867","1231231312"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null,"张丰","624597867",null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("张三fdfd")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可以使用！");
        }
    }
}