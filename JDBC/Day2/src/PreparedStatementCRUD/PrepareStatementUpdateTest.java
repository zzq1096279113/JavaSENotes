package PreparedStatementCRUD;

import org.junit.jupiter.api.Test;
import util.JDBCUtil;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 使用PrepareStatement来替换Statement，实现对数据表的增删改
 *
 * @author zzq
 * @creat 2020-07-23 9:16
 */
public class PrepareStatementUpdateTest {


    //向Customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement pS = null;
        try {
            //1.读取配置文件中的四个基本信息
            InputStream iS = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(iS);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driver = pros.getProperty("driver");

            //2.加载驱动
            Class.forName(driver);

            //3.获取连接
            connection = DriverManager.getConnection(url, user, password);

            //4.获取prepareStatement的实例
            String sql = "insert into customers(name,email,birth) value (?,?,?)";//?：占位符
            pS = connection.prepareStatement(sql);

            //5.填充占位符
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse("1900-12-23");
            pS.setString(1, "哪吒");
            pS.setString(2, "nezha@gmail.com");
            pS.setDate(3, new java.sql.Date(parse.getTime()));

            //6.执行操作
            pS.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.关闭连接
            try {
                if (pS != null)
                    pS.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    //修改Customers表的一条记录
    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtil.getConnection();

            //2.预编译sql语句，返回prepareStatement实例
            String sql = "update customers set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            //3.填充占位符
            preparedStatement.setString(1, "莫扎特");
            preparedStatement.setInt(2, 18);

            //4.执行
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }


    @Test
    public void testCommonUpdate() {
//        String sql = "delete from customers where id = ?";
//        update(sql,3);
        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD", 4);
    }


    //通用的增删改操作
    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtil.getConnection();

            //2.预编译sql语句，返回prepareStatement实例
            preparedStatement = connection.prepareStatement(sql);

            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            //4.执行
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }

}
