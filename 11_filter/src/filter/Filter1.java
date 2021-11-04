package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-04 13:18
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter1 前置代码");
        //获取线程名
        System.out.println("Filter1 线程名：" + Thread.currentThread().getName());
        //获取请求参数
        System.out.println("Filter1 " + servletRequest.getParameter("username"));
        //保存数据
        servletRequest.setAttribute("key1","value1");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Filter1 后置代码");
    }

    @Override
    public void destroy() {

    }
}
