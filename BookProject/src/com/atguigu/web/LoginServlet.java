package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-07-23 21:07
 */
public class LoginServlet extends HttpServlet {

    //web层不能直接操作DAO层。创建UserService对象操纵数据库
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//        2.调用xxxService.xxx()处理业务（UserService.Login）
        User loginUser = userService.login(new User(null, username, password, null));

//        3.根据Login()方法的返回值判断是否登录成功
        if (loginUser ==null){
//                失败,跳回登录页面
//                    把错误信息和回显的表单项信息保存到Request域中
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);


            System.out.println("用户名或者密码错误，请重新输入！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
//                成功，跳转到login_success.html页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }

    }
}
