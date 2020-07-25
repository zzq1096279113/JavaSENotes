package connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zzq
 * @creat 2020-07-25 16:15
 */
public class DBCP {

    @Test
    public void test1() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource basicDataSource = new BasicDataSource();

        //设置基本信息
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("81082578");

        //设置其他涉及数据库连接池管理的相关属性：
        basicDataSource.setInitialSize(10);

        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
//        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        InputStream inputStream = new FileInputStream(new File("src/dbcp.properties"));
        properties.load(inputStream);
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
