package connection;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zzq
 * @creat 2020-07-22 14:36
 */
public class ConnectionTest {
    //方式一
    @Test
    public void testConnection1() throws SQLException {
        //1.获取Driver的实现类对象
        Driver driver = new com.mysql.jdbc.Driver();

        //2.提供要连接的数据库
        //jdbc:mysql：协议
        //localhost：IP地址
        //3306：默认mysql的端口号
        //test：test数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.提供连接需要的用户名和密码
        Properties info = new Properties();
        //将用户名和密码封装在Properties中
        info.setProperty("user", "root");
        info.setProperty("password", "81082578");


        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }


    //方式二：在如下的程序中不出现第三方的API，使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception {
        //1.获取Driver的实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "81082578");

        //4.获取连接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }


    //方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        //1.获取Driver的实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        //2.提供三个基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "81082578";

        //3.注册驱动
        DriverManager.registerDriver(driver);

        //4.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }


    //方式四：可以只加载驱动，不用显示的注册驱动了。
    @Test
    public void testConnection4() throws Exception {
        //1.提供三个基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "81082578";

        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        /* 在mysql的Driver实现类中声明了如下操作
        static {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        } */

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }


    //方式五：将数据库连接需要的四个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
        好处：
        1、实现了数据和代码的分离，实现了解耦；
        2、如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void testConnection5() throws Exception {
        //1.读取配置文件中的四个基本信息
        InputStream iS = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(iS);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");

        //2.加载驱动
        Class.forName(driver);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }
}
