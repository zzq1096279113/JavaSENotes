package com.zzq.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description JdbcUtils工具类
 * @ClassName JdbcUtils
 * @Author zzq
 * @Date 2021/2/20 16:54
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream inputStream;
        Properties properties = new Properties();
        try {
            inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");  //读取jdbc.properties配置文件
            properties.load(inputStream);   //从流中加载数据
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 获取数据库连接池中的连接
     * @Param []
     * @Return java.sql.Connection
     * @Author zzq
     * @Date 2021/2/20 16:55
     */
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);    //关闭自动提交
                threadLocal.set(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * @Description 提交事务并关闭连接
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2021/3/3 21:12
     */
    public static void commitAndClose() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.commit();    //提交事务
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }

    /**
     * @Description 回滚事务并关闭连接
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2021/3/3 21:17
     */
    public static void rollbackAndClose() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.rollback();  //回滚事务
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }


//    /**
//     * @Description 关闭数据库连接，将连接放回数据库连接池
//     * @Param [connection]
//     * @Return void
//     * @Author zzq
//     * @Date 2021/2/20 16:56
//     */
//    public static void closeConnection(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
