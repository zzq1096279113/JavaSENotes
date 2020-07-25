package dbutils;

import Bean.Customer;
import Util.JDBCUtilDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.jupiter.api.Test;

import java.security.spec.NamedParameterSpec;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * commons-dbutils是Apache组织提供的一个开源JDBC工具类库，封装了针对于数据库的增删改查操作
 *
 * @author zzq
 * @creat 2020-07-25 18:39
 */
public class QueryRunnerTest {

    @Test
    public void test1() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "insert into customers(name,email,birth) value(?,?,?)";
            queryRunner.update(connection, sql, "蔡徐坤", "caixukun@126.com", "1996-03-21");
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test2() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            //BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
            BeanHandler<Customer> customerBeanHandler = new BeanHandler<>(Customer.class);
            Customer customer = queryRunner.query(connection, sql, customerBeanHandler, 23);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test3() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select id,name,email,birth from customers where id < ?";
            //BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
            BeanListHandler<Customer> customerBeanListHandler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = queryRunner.query(connection, sql, customerBeanListHandler, 23);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test4() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";

            //MapHandler:是ResultSetHandler接口的实现类，对应表中的一条记录。将字段及相应字段的值作为map中的key和value
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> map = queryRunner.query(connection, sql, mapHandler, 20);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test5() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select id,name,email,birth from customers where id < ?";

            //MapListHandler:是ResultSetHandler接口的实现类，对应表中的多条记录。将字段及相应字段的值作为map中的key和value。将这些map添加到List中
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> mapList = queryRunner.query(connection, sql, mapListHandler, 20);
            mapList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test6() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select count(*) from customers";
            ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            Long query = queryRunner.query(connection, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test7() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select max(birth) from customers";
            ScalarHandler<Date> scalarHandler = new ScalarHandler<>();
            Date query = queryRunner.query(connection, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }


    @Test
    public void test8() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtilDruid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ResultSetHandler<Customer> resultSetHandler = new ResultSetHandler<>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
//                    return new Customer(12, "zzq", "16161616@qq.com", new Date(564654654564L));
                    if(resultSet.next()){
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        Date birth = resultSet.getDate("birth");
                        Customer customer = new Customer(id, name, email, birth);
                        return customer;
                    }
                    return null;
                }
            };
            Customer customer = queryRunner.query(connection, sql, resultSetHandler, 12);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDruid.closeConnection(connection, null);
        }
    }
}
