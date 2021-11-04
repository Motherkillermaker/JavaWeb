package com.at.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-07-21 18:59
 */
public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        System.out.println("在servlet1(柜台1)中查看参数（材料）：" + username);

        // 传递到servlet2并查看 （给材料盖一个"章"）
        req.setAttribute("key1","柜台一的章");

        // 问路：servlet2(柜台2)怎么走
        // 请求转发必须以斜杠打头，/ 斜杠表示地址为： http://ip:port/工程名，映射到IEDA代码的web工程目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        //走向servlet2(柜台2)
        requestDispatcher.forward(req,resp);
    }
}
