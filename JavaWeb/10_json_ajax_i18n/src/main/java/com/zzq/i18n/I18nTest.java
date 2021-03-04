package com.zzq.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Description TODO
 * @ClassName I18nTest
 * @Author zzq
 * @Date 2021/2/20 10:20
 */
public class I18nTest {

    @Test
    public void test1() {
//        Locale locale = Locale.getDefault();    //获取系统默认的语言国家
//        System.out.println(locale);
        Locale china = Locale.CHINA;
        Locale us = Locale.US;
    }

    @Test
    public void test2() {
        Locale locale = Locale.US;  //得到需要的Locale文件
        ResourceBundle i18n = ResourceBundle.getBundle("i18n", locale); //通过指定的basename和Locale对象，读取相应地配置文件
        System.out.println(i18n.getString("username"));
        System.out.println(i18n.getString("password"));
        System.out.println(i18n.getString("sex"));
        System.out.println(i18n.getString("age"));
    }
}
