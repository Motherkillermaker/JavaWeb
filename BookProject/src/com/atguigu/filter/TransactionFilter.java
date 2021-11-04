package com.atguigu.filter;

import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-04 17:33
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            /**
             * 使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch。来进行实现的管理
             */

            filterChain.doFilter(servletRequest,servletResponse);

            JdbcUtils.commitAndClose();         // 提交事务

        } catch (Exception e) {

            JdbcUtils.rollbackAndClose();       //回滚事务

            e.printStackTrace();

            throw new RuntimeException(e);      //把异常抛给Tomcat服务器友好的展示错误页面
        }

    }

    @Override
    public void destroy() {

    }
}
