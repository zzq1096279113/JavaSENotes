package Blob;

import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用PreparedStatement实现批量数据的操作
 * <p>
 * update、delete本身就具有批量操作的效果。
 * 此时的批量操作，主要指的是批量插入。
 *
 * @author zzq
 * @creat 2020-07-24 13:47
 */
public class InsertTest {
    //方式一：使用Statement


    //方式二：使用PreparedStatement
    @Test
    public void testInsert1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtil.getConnection();
            String sql = "insert into goods(name) value(?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <= 5000; i++) {
                preparedStatement.setObject(1, "name_" + i);
                preparedStatement.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }


    //方式三：addBatch()、executeBatch()、clearBatch()
    @Test
    public void testInsert2() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtil.getConnection();
            String sql = "insert into goods(name) value(?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <= 5000; i++) {
                preparedStatement.setObject(1, "name_" + i);
                preparedStatement.addBatch();
                if (i % 500 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }


    //方式四（最终版）：设置连接不允许自动提交数据
    @Test
    public void testInsert3() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtil.getConnection();
            //设置不允许自动提交数据
            connection.setAutoCommit(false);
            String sql = "insert into goods(name) value(?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <= 5000; i++) {
                preparedStatement.setObject(1, "name_" + i);
                preparedStatement.addBatch();
                if (i % 500 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            //提交数据
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }
}
