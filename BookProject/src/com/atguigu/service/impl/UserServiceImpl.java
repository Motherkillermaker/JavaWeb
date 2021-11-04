package com.atguigu.service.impl;

import com.atguigu.DAO.UserDAO;
import com.atguigu.DAO.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @author CJYong
 * @create 2021-07-22 20:38
 */
public class UserServiceImpl implements UserService{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null){
            //等于null,说明没查到。表示可用
            return false;
        }

        return true;
    }
}
