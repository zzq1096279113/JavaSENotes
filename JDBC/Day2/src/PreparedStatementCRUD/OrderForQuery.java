package PreparedStatementCRUD;

import Bean.Order;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对于order表的通用查询操作
 *
 * @author zzq
 * @creat 2020-07-23 14:56
 */
public class OrderForQuery {
    /*
    针对于表的字段名与类的属性名不一致的情况：
        1、必须声明sql时，使用类的属性名命名字段别名
        2、使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName()，获取列的别名
        说明：如果sql没有给字段起别名，getColumnLabel()获取的就是别名
     */
    @Test
    public void OrderForQueryTest1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 2);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
    }


    @Test
    public void OrderForQueryTest2() {
        String sql = "SELECT order_id AS orderId,order_name AS orderName,order_date AS orderDate FROM `order` WHERE order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);
    }


    //通用的针对于order表的查询操作
    public Order orderForQuery(String sql, Object... args) {
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
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值：通过ResultSet
                    Object columnValue = resultSet.getObject(i + 1);

                    //获取每个列的别名：通过ResultSetMetaData
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    //将对象指定的属性赋值为指定的值：通过反射
                    Field declaredField = Order.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(order, columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
