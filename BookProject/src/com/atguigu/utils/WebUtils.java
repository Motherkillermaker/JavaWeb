package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author CJYong
 * @create 2021-07-28 11:02
 */
public class WebUtils {

    /**
     * 把Map的值注入到对应的javabean属性中
     *
     *DAO层
     *service层
     *Web层   耦合度高）
     * 将参数以Map的形式传入可以在三个层都可以使用。若改成httpservlet参数则只能在web层使用
     * @param value
     * @param bean
     */

    public static <T> T copyParamToBean(Map value, T bean){

        try {
            User user = new User();
            System.out.println("注入之前：" + bean);
            // 把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;


        //        try {
//            User user = new User();
//            System.out.println("注入之前：" + user);
//            // 把所有请求的参数都注入到user对象中
//            BeanUtils.populate(user,req.getParameterMap());
//            System.out.println("注入之后：" + user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 将字符串转换为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            if (strInt == null){
                return defaultValue;
            }else {
                return Integer.parseInt(strInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defaultValue;
    }
}
