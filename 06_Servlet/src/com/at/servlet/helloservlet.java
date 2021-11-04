package com.at.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**实现servlet接口的方式使用servlet程序
 * @author CJYong
 * @create 2021-07-19 13:55
 */
public class helloservlet implements Servlet {

    public helloservlet(){
        System.out.println("1 构造器方法");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service方法-hello servlet 被访问了");
        // 类型转换 （因为子接口含有getmethod方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();

        System.out.println(method);

    }

    /**
     * get请求方法
     * @return
     */
    public void doGet(){
        System.out.println("Get 请求");
    }

    /**
     * get请求方法
     * @return
     */
    public void doSet(){
        System.out.println("Set 请求");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destory销户方法");
    }


}
