package com.at.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author CJYong
 * @create 2021-07-20 20:57
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("****************** doGet *************************");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名为：" + username);
        System.out.println("密码为为：" + password);
        System.out.println("兴趣爱好为：" + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("****************** doPost *************************");

        //设置请求体的字符集,解决post请求的中文乱码问题 （获取请求参数之前调用）
        req.setCharacterEncoding("UTF-8");

        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名为：" + username);
        System.out.println("密码为为：" + password);
        System.out.println("兴趣爱好为：" + Arrays.asList(hobby));
    }
}
