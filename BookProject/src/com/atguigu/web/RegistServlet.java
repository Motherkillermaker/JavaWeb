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
 * @create 2021-07-23 19:10
 */
public class RegistServlet extends HttpServlet {

    //web层不能直接操作DAO层。创建UserService对象操纵数据库
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数 (客户端发送请求，告诉服务器请求的参数是什么)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查 验证码是否正确  (要求验证码为abcd)
        if("abcd".equalsIgnoreCase(code)){
        //正确
            //3.检查用户名是否可用
            if (userService.existUsername(username)){
                    //不可用
                System.out.println("用户名[" + username +"]已存在，请重新输入用户名！ ");
                //            把回显信息保存到request域当中
                req.setAttribute("msg","用户名已存在 ！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

//                        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else {
//                   可用
//                      调用service保存到数据库
                userService.register(new User(null, username, password, email));
//                      跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }


        }else {
//            把回显信息保存到request域当中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

        //不正确
            System.out.println("验证码[" + code + "]错误");
//                   跳回注册页面(请求转发：从一个页面跳转到另一个页面)
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
