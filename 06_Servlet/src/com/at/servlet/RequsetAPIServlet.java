package com.at.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-07-20 20:09
 */
public class RequsetAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getRequestURI()       获取请求的资源路径
        System.out.println("URI = " + req.getRequestURI());
//        getRequestURL()       获取请求的统一资源定位符（绝对路径）
        System.out.println("URL = " + req.getRequestURL());
//        getRemoteHost()       获取客户端的 ip 地址
        /**
         * 在 IDEA 中，使用 localhost 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
         * 在 IDEA 中，使用 127.0.0.1 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
         * 在 IDEA 中，使用 真实 ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址
         */
        System.out.println("IP = " + req.getRemoteHost());
//        getHeader()           获取请求头
        System.out.println("请求头为 ：" + req.getHeader("User-Agent"));
//        getMethod()          获取请求的方式 GET 或 POS
        System.out.println("请求方式方式为：" + req.getMethod());
    }
}
