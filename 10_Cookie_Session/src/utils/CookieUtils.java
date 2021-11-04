package utils;

import javax.servlet.http.Cookie;

/**
 * @author CJYong
 * @create 2021-08-01 15:12
 */
public class CookieUtils {
    /**
     * 查找指定名称的cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies){

        if (name ==null || cookies == null || cookies.length == 0){
            return null;
        }

        for (Cookie cookie : cookies) {

            if (name.equals(cookie.getName())){
                return cookie;
            }
        }

        return null;

    }
}
