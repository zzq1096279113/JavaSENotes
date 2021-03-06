package com.zzq.dao;

import com.zzq.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @Description 基础Dao类
 * @ClassName BaseDao
 * @Author zzq
 * @Date 2021/2/21 9:35
 */
public abstract class BaseDao {

    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * @Description 对数据库的增删改语句
     * @Param [sql, args]
     * @Return int
     * @Author zzq
     * @Date 2021/2/21 9:42
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 查询一个javabean的语句
     * @Param [type, sql, args]
     * @Return T
     * @Author zzq
     * @Date 2021/2/21 9:46
     */
    public <T> T selectOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 查询多个返回list集合
     * @Param [type, sql, args]
     * @Return java.util.List<T>
     * @Author zzq
     * @Date 2021/2/21 9:49
     */
    public <T> List<T> selectList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 查询返回单个数据的语句
     * @Param [sql, args]
     * @Return java.lang.Object
     * @Author zzq
     * @Date 2021/2/21 9:52
     */
    public Object selectSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
