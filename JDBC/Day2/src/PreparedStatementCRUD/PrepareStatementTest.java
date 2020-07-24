package PreparedStatementCRUD;

import Bean.User;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * 演示使用PreparedStatement替换Statement，解决SQL注入问题
 * 
 * PreparedStatement好处:
 *  1.PreparedStatement操作Blob的数据，而Statement做不到。
 *  2.PreparedStatement可以实现更高效的批量操作。
 *
 * @author zzq
 * @creat 2020-07-23 17:33
 */
public class PrepareStatementTest {

    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        // SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '=1 or '1' = '1';
        String sql = "SELECT user,password FROM user_table WHERE USER = ? AND PASSWORD = ?";
        User returnUser = getInstance(User.class,sql,user,password);
        if (returnUser != null)
            System.out.println("登陆成功!");
        else
            System.out.println("用户名或密码错误！");
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
}
