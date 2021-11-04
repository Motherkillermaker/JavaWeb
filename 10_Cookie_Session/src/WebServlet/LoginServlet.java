package WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-01 16:40
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("62459".equals(username) && "123456".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);    //当前cookie一周内有效
            resp.addCookie(cookie);
            System.out.println("登录成功！");

        }else {
            //登录失败
            System.out.println("登录失败");
        }

    }
}
