package com.atguigu.test;

import java.lang.reflect.Method;

/**
 * @author CJYong
 * @create 2021-07-28 10:22
 */
public class UserServletTest {

    public void login(){
        System.out.println("这是login程序");
    }

    public void regist(){
        System.out.println("这是regist程序");
    }

    public void upDateUser(){
        System.out.println("这是upDateUser程序");
    }

    public void updateUserPassword(){
        System.out.println("这是updateUserPassword程序");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(method);

            method.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
