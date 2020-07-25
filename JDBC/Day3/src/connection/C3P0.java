package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;


/**
 * @author zzq
 * @creat 2020-07-25 14:05
 */
public class C3P0 {
    //方式一：硬编码
    @Test
    public void test1() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("81082578");

        //初始时数据库连接池的连接数
        comboPooledDataSource.setInitialPoolSize(10);

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
    }


    //方式二：配置文件
    @Test
    public void test2() throws Exception {
        ComboPooledDataSource helloC3P0 = new ComboPooledDataSource("helloC3P0");
        Connection connection = helloC3P0.getConnection();
        System.out.println(connection);
    }
}
