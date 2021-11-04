package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author CJYong
 * @create 2021-07-22 20:33
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 登录功能
     * @param user
     * @return 返回Null说明登录失败。返回有值说明登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已经存在，返回false表示用户名可用
     */
    public boolean existUsername(String username);

}
