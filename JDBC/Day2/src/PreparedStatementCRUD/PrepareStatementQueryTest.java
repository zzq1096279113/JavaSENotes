package PreparedStatementCRUD;

import Bean.Customers;
import Bean.Order;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PrepareStatement实现针对于不同表的通用的查询操作
 *
 * @author zzq
 * @creat 2020-07-23 17:02
 */
public class PrepareStatementQueryTest {
    @Test
    public void testGetInstance() {
        String sql = "select id,name,email from customers where id = ?";
        Customers instance = getInstance(Customers.class, sql, 19);
        System.out.println(instance);

        String sql1 = "SELECT order_id AS orderId,order_name AS orderName,order_date AS orderDate FROM `order` WHERE order_id = ?";
        Order instance1 = getInstance(Order.class, sql1, 2);
        System.out.println(instance1);
    }


    @Test
    public void testGetForList() {
        String sql = "select id,name,email from customers where id < ?";
        List<Customers> forList = getForList(Customers.class, sql, 5);
        forList.forEach(System.out::println);

        String sql1 = "SELECT order_id AS orderId,order_name AS orderName,order_date AS orderDate FROM `order` WHERE order_id < ?";
        List<Order> forList1 = getForList(Order.class, sql1, 4);
        forList1.forEach(System.out::println);
    }


    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给customers对象指定的某个属性，赋值为value：反射
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }


    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给customers对象指定的某个属性，赋值为value：反射
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
