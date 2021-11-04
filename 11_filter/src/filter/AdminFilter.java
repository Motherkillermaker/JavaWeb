package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-04 12:13
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("1.filter构造器方法AdminFilter()");

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.filter的init(FilterConfig filterConfig)初始化");

        // 1、获取 Filter 的名称 filter-name 的内容
        System.out.println("filter-name 的值是：" + filterConfig.getFilterName());

        // 2、获取在 web.xml 中配置的 init-param 初始化参数
        System.out.println("初始化参数 username 的值是：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数 url 的值是：" + filterConfig.getInitParameter("url"));

        // 3、获取 ServletContext 对象
        System.out.println(filterConfig.getServletContext());

    }

    /**
     * doFilter方法专门用于拦截请求，以此来做权限检查。
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.filter的doFilter() 过滤方法");

        HttpServletRequest httpServletRequest =(HttpServletRequest)servletRequest;

        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        //如果等于null说明还没有登录
        if (user == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            //让程序继续往下访问用户的目标资源 （重要，不能省略）
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("4.filter的destroy()销毁方法");

    }
}
