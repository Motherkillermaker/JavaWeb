package com.atguigu.DAO;

import com.atguigu.pojo.User;

/**
 * @author CJYong
 * @create 2021-07-22 19:42
 */

public interface UserDAO {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return  如果返回Null说明没有这个用户，查到了说明该用户名不可用
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他则是sql语句影响的行数
     */
    public int saveUser(User user);

    /**
     *根据用户名和密码查询用户信息
     * @param username
     * @return 如果返回Null说明用户名或者密码错误。反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);


}
