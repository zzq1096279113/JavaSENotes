package com.zzq.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @Description
 * @ClassName WebUtils
 * @Author zzq
 * @Date 2021/2/25 9:54
 */
public class WebUtils {

    /**
     * @Description 自动封装为bean对象
     * @Param [bean, map]
     * @Return T
     * @Author zzq
     * @Date 2021/2/25 14:31
     */
    public static <T> T mapToBean(T bean, Map map) {
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
