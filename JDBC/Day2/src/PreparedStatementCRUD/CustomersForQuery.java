package PreparedStatementCRUD;

import Bean.Customers;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;


import javax.sound.midi.Soundbank;
import javax.sql.rowset.FilteredRowSet;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对于Customers表的操作
 *
 * @author zzq
 * @creat 2020-07-23 13:47
 */
public class CustomersForQuery {
    @Test
    public void ForQueryTest1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 1);

            //执行并返回结果集
            resultSet = preparedStatement.executeQuery();

            //处理结果集
            if (resultSet.next()) {//判断结果集的下一条是否有数据，如果有数据返回true，并指针下移；如果返回false，指针不动
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //方式一：
                //            System.out.println("id=" + id + ",name=" + name + ",email=" + email + ",birth" + birth);

                //方式二：
                //            Object[] data = new Object[]{id,name,email,birth};

                //方式三：将数据封装为一个对象
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
    }


    @Test
    public void ForQueryTest2() {
        String sql1 = "select id,name,email from customers where id = ?";
        Customers customers1 = ForCustomers(sql1, 13);
        System.out.println(customers1);

        String sql2 = "select name,email from customers where name = ?";
        Customers customers2 = ForCustomers(sql2, "周杰伦");
        System.out.println(customers2);
    }


    public Customers ForCustomers(String sql, Object... args) {
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

            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()){
                //创建Customers对象
                Customers customers = new Customers();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);

                    //给customers对象指定的某个属性，赋值为value：反射
                    Field declaredField = Customers.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(customers,value);
                }
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
