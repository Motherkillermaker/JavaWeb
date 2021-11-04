package WebServlet;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-01 14:00
 */
public class CookieServlet extends BaseServlet{

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","value1");

        //getContextPath() - 得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");        // - 工程路径后 + /abc

        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    protected void
    life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");

        cookie.setMaxAge(60*60);   //设置cookie一小时之后被删除，无效

        resp.addCookie(cookie);

        resp.getWriter().write(cookie.getName() + "将在一小时后删除");

    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先找到你要删除的 Cookie 对象
        Cookie cookie = CookieUtils.findCookie("key3", req.getCookies());
        if (cookie != null) {

        // 调用 setMaxAge(0);
            cookie.setMaxAge(0); // 表示马上删除，都不需要等待浏览器关闭

        // 调用 response.addCookie(cookie);
            resp.addCookie(cookie);
            resp.getWriter().write(cookie.getName() + "的 Cookie 已经被删除");
        }

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");

        cookie.setMaxAge(-1);   //设置存活时间

        resp.addCookie(cookie);

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法一：

//      1、先创建一个要修改的同名（指的就是 key）的 Cookie 对象
//      2、在构造器，同时赋于新的 Cookie 值。

//        Cookie cookie = new Cookie("key1","newValue1");

//      3、调用 response.addCookie( Cookie ) - 通知客户端保存修改
//        resp.addCookie(cookie);
//
//        resp.getWriter().write( cookie.getName() + "的cookie已经修改完成");

        //方法二

        // 1、先查找到需要修改的 Cookie 对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            // 2、调用 setValue()方法赋于新的 Cookie 值。
            cookie.setValue("newValue1");
            // 3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);

            resp.getWriter().write(cookie.getName() + "的cookie已经修改完成");

        }

    }

    protected void creatCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 创建 Cookie 对象
        Cookie cookie1 = new Cookie("key1","value1");
        Cookie cookie2 = new Cookie("key2","value2");
        Cookie cookie3 = new Cookie("key3","value3");

        //2 通知客户端保存 Cookie  （关键代码不能省略）
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }


        Cookie iwantcookie = CookieUtils.findCookie("key3",cookies);

//        for (Cookie cookie : cookies) {
//
//            if ("key1".equals(cookie.getName())){
//                iwantcookie = cookie;
//                break;
//            }
//        }
//        如果不等于Null，说明赋过值，也就是找到了cookie
        if (iwantcookie != null){
            resp.getWriter().write("找到了需要的cookie");
        }


    }

}
