package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-04 13:18
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter2 前置代码");
        //获取线程名
        System.out.println("Filter2 线程名：" + Thread.currentThread().getName());
        //获取请求参数
        System.out.println("Filter2 " + servletRequest.getParameter("username"));
        //取出数据
        System.out.println("Filter2 取 Filter1 中保存的数据是：" + servletRequest.getAttribute("key1") );

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Filter2 后置代码");
    }

    @Override
    public void destroy() {

    }
}
