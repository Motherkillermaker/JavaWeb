package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author CJYong
 * @create 2021-07-22 19:03
 */
public class JdbcUtilsTest {

    @Test
    public void test1(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
//            JdbcUtils.closeConnection(conn);
        }

    }
}
