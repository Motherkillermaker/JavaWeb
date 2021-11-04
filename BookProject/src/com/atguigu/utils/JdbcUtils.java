package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author CJYong
 * @create 2021-07-22 18:23
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    //创建ThreadLocal来绑定数据库连接，避免线程安全问题
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            Properties pros = new Properties();
            //读取相应的配置文件
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            pros.load(is);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池中的连接
     * 返回null说明获取连接失败
     */
    public static Connection getConnection(){
        //从ThreadLocal中获取连接
        Connection conn = conns.get();
        //若第一次中ThreadLocal中没有连接
        if (conn == null){
            try {
                //从数据库连接池中获取连接
                conn = dataSource.getConnection();
                //保存到ThreadLocal对象中，供后面的jdbc操作使用
                conns.set(conn);

                //设置为手动管理事务
                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    /**
     * 提交事务,并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null){
            //不等于null，说明之前使用过连接和操作过数据库

            try {
                //提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，不然就会出错（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();

    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null){
            //不等于null，说明之前使用过连接和操作过数据库

            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，不然就会出错（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();

    }

    /**
     * 关闭数据库连接池
     */
//    public static void closeConnection(Connection conn){
//        if(conn != null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


}
