package servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJYong
 * @create 2021-08-06 13:27
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryAjax请求过来了");

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryGetAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryGetAjax请求过来了");

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryPostAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryPostAjax请求过来了");

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryGetJSON请求过来了");

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQuerySerialize请求过来了");

        System.out.println("用户名" + req.getParameter("username"));
        System.out.println("密码" + req.getParameter("password"));

        Person person = new Person(55,"张三丰");

        //json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }
}
