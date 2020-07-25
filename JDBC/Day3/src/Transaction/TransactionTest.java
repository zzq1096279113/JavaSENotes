package Transaction;

import Util.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 1.事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * > 一组逻辑操作单元：一个或多个DML操作。
 * <p>
 * 2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存下来；
 * 要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 * <p>
 * 3.数据一旦提交，就不可回滚
 * <p>
 * 4.哪些操作会导致数据的自动提交？
 * ①DDL操作一旦执行，都会自动提交。
 * ②DML默认情况下，一旦执行，就会自动提交。
 * ③默认在关闭连接时，会自动的提交数据
 *
 * @author zzq
 * @creat 2020-07-24 14:47
 */
public class TransactionTest {
    @Test
    public void test1() {
        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        String sql2 = "update user_table set balance = balance + 100 where user = ?";

        update(sql1, "AA");
        update(sql2, "BB");

        System.out.println("转账成功");
    }


    //Version 1.0
    public int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
        return 0;
    }


    @Test
    public void test2() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();

            //关闭自动提交
            connection.setAutoCommit(false);

            //AA减少100
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(connection, sql1, "AA");


            //BB增加100
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(connection, sql2, "BB");

            System.out.println("转账成功");

            //提交数据
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚数据
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                //修改为自动提交：主要针对于使用数据库连接池时
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtil.closeConnection(connection, null);
        }
    }


    //Version 2.0：考虑上事务
    //增删改
    public int update(Connection connection, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(null, preparedStatement);
        }
        return 0;
    }


    @Test
    public void test3() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        User user = getInstance(connection, User.class, sql,"CC");
        System.out.println(user);
    }

    @Test
    public void test4() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update(connection,sql,5000,"CC");
        System.out.println("修改结束");
    }


    //Version 2.0：考虑上事务
    //查
    public <T> T getInstance(Connection connection,Class<T> clazz, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(null, preparedStatement, resultSet);
        }
        return null;
    }
}
