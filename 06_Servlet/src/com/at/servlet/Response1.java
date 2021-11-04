package com.at.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-07-22 9:56
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游：response1 ~");

        //方案一：

        //设置响应状态码302: 表示重定向 （已搬迁）
        resp.setStatus(302);

        //设置相应头。说明新地址在哪里
        resp.setHeader("Location","http://localhost:9945/06_Servlet/response2");

//        //方案二： （推荐）
//        resp.sendRedirect("http://localhost:9945/06_Servlet/response2");
    }
}
