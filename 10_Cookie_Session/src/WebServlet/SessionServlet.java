package WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-02 11:49
 */
public class SessionServlet extends BaseServlet{

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Session 对象
        HttpSession session = req.getSession();

        // 让 Session 会话马上超时
        session.invalidate();

        resp.getWriter().write("Session 已经设置为超时（无效）");
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //设置当前session对象3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置为3秒后超时");

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("session的默认超时时长为："  + maxInactiveInterval + "秒");

    }

    /**
     * 往 Session 中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("key1", "value1");

        resp.getWriter().write("已经往 Session 中保存了数据");
    }
    /**
     * 获取 Session 域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object attribute = req.getSession().getAttribute("key1");

        resp.getWriter().write("从 Session 中获取出 key1 的数据是：" + attribute);
    }


    protected void creatOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建出来的
        boolean isNew = session.isNew();
        //获取session会话的唯一标设ID
        String id = session.getId();

        resp.getWriter().write("当前session会话的id为：" + id + " <br/> ");
        resp.getWriter().write("当前session是否为新创建：" + isNew + " <br/> ");
    }

}


