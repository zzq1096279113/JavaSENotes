package com.zzq.utils;

import javax.servlet.http.Cookie;

/**
 * @Description Cookie工具类
 * @ClassName CookieUtils
 * @Author zzq
 * @Date 2021/2/9 10:44
 */
public class CookieUtils {

    /**
     * @Description 查找指定的Cookie对象
     * @Param [name, cookies]
     * @Return javax.servlet.http.Cookie
     * @Author zzq
     * @Date 2021/2/9 10:48
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) { //如果找到了，直接返回
                return c;
            }
        }
        return null;    //如果没找到，则返回null
    }
}
