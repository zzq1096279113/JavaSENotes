package connection;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;


/**
 * @author zzq
 * @creat 2020-07-25 17:07
 */
public class Druid {

    @Test
    public void test1() throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File("src/Druid.properties"));
        properties.load(fileInputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
