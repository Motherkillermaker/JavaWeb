package com.atguigu.web;

import com.atguigu.DAO.BookDAO;
import com.atguigu.DAO.OrderDAO;
import com.atguigu.DAO.OrderItemDAO;
import com.atguigu.DAO.impl.BookDAOImpl;
import com.atguigu.DAO.impl.OrderDAOImpl;
import com.atguigu.DAO.impl.OrderItemDAOImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author CJYong
 * @create 2021-08-03 18:13
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        // 获取 Userid
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        //查看当前线程名
//        System.out.println("orderServlet程序在[" + Thread.currentThread().getName() + "]中");

        Integer userId = loginUser.getId();

        // 调用 orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, userId);

        // req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        //防止表单重复提交
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
