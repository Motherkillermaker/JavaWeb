package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-04 12:35
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //获取用户发送到服务器的信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("62459".equals(username) && "123456".equals(password)) {
            //将用户的登录信息储存到session域中
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登录成功！！！");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
