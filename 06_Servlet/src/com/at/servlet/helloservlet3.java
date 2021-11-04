package com.at.servlet; /**
 * @author CJYong
 * @create 2021-07-19 16:09
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class helloservlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloservlet3的Get方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloservlet3的Post方法");
    }
}
