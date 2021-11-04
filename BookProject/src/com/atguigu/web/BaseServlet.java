package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author CJYong
 * @create 2021-07-28 10:38
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决响应中文乱码问题
        req.setCharacterEncoding("UTF-8");

        //解决post请求中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");



        //通过反射来获取action的值，从而只用专注于完成相关的业务方法代码


        String action = req.getParameter("action");

        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);

//            System.out.println(method);

            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
            //把异常抛给filter过滤器
            throw new RuntimeException();
        }

    }
}
