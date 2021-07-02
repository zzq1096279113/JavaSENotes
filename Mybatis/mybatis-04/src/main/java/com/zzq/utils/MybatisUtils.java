package com.zzq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Description Mybatis 工具类
 * @ClassName MybatisUtils
 * @Author zzq
 * @Date 2021/6/21 17:19
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 获取 SQLSessionFactory 对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 使用 SqlSessionFactory 创建 SqlSession 对象用于操作数据库
     * @Param []
     * @Return org.apache.ibatis.session.SqlSession
     * @Author zzq
     * @Date 2021/6/21 17:27
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
