package com.atguigu.DAO.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CJYong
 * @create 2021-07-22 19:09
 */
public abstract class BaseDAO {

    //使用Dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     *update()方法用来执行： 增删改操作
     *返回-1说明执行失败。其他表示影响的数据库行数
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * queryForOne用于实现返回表中封装的一条记录
     * 返回-1说明执行失败。其他表示返回数据封装的对象
     * @param sql
     * @param args
     * @return
     */
    public<T> T queryForOne(Class<T> Type,String sql,Object ...args){
        //获取连接
        Connection conn = JdbcUtils.getConnection();
        //封装对象并返回
//        BeanHandler<User> handler = new BeanHandler<>(User.class);
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(Type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * queryForList用于实现返回表中封装的多条记录
     * 返回null说明执行失败。其他表示返回数据封装的对象
     * @param Type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> Type,String sql,Object ...args){
        //获取连接
        Connection conn = JdbcUtils.getConnection();
        //封装对象并返回
//        BeanHandler<User> handler = new BeanHandler<>(User.class);
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(Type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForValue(String sql,Object ...args){

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
