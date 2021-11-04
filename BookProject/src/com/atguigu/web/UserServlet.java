package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author CJYong
 * @create 2021-07-27 16:46
 */
public class UserServlet extends BaseServlet {

    //web层不能直接操作DAO层。创建UserService对象操纵数据库
    private UserService userService = new UserServiceImpl();

    /**
     * 检查用户名是否存在
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 username
        String username = req.getParameter("username");

        // 调用 userService.existsUsername();
        boolean existsUsername = userService.existUsername(username);

        // 把返回的结果封装成为 map 对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        //将 Map 封装称为 json 对象在客户端和服务器端传输
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        //通过响应的字符输出流输出
        resp.getWriter().write(json);
    }

    /**
     * 用户注销功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
        // 2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());

    }

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录功能的servlet程序

//        1.获取请求参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");

//        2.调用xxxService.xxx()处理业务（UserService.Login）
            User loginUser = userService.login(new User(null, username, password, null));

//        3.根据Login()方法的返回值判断是否登录成功
            if (loginUser == null) {
//                失败,跳回登录页面
//                    把错误信息和回显的表单项信息保存到Request域中
                req.setAttribute("msg", "用户名或者密码错误");
                req.setAttribute("username", username);


                System.out.println("用户名或者密码错误，请重新输入！");
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

            } else {
//                成功，跳转到login_success.html页面

                //保存用户登录成功的信息
                req.getSession().setAttribute("user",loginUser);

                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

            }
    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注册功能的servlet程序

            // 获取Session中的验证码
            String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
            // 删除 Session中的验证码
            req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

            //1.获取请求参数 (客户端发送请求，告诉服务器请求的参数是什么)
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String code = req.getParameter("code");


        //  把所有请求的参数都注入到user对象中,并返回属性已经被赋值的bean对象
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        //2.检查 验证码是否正确  (要求验证码为abcd)
            if (token!= null && token.equalsIgnoreCase(code)) {
                //正确
                //3.检查用户名是否可用
                if (userService.existUsername(username)) {
                    //不可用
                    System.out.println("用户名[" + username + "]已存在，请重新输入用户名！ ");
                    //            把回显信息保存到request域当中
                    req.setAttribute("msg", "用户名已存在 ！");
                    req.setAttribute("username", username);
                    req.setAttribute("email", email);

//                        跳回注册页面
                    req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

                } else {
//                   可用
//                      调用service保存到数据库
                    userService.register(new User(null, username, password, email));
//                      跳转到注册成功页面
                    req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
                }

            } else {
//            把回显信息保存到request域当中
                req.setAttribute("msg", "验证码错误！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                //不正确
                System.out.println("验证码[" + code + "]错误");
//                   跳回注册页面(请求转发：从一个页面跳转到另一个页面)
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过反射来获取action的值，从而只用专注于完成相关的业务方法代码

        String action = req.getParameter("action");

        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);

//            System.out.println(method);

            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

