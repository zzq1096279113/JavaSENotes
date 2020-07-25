package DAO;

import Bean.Customer;
import Util.JDBCUtil;
import Util.JDBCUtilC3P0;
import Util.JDBCUtilDBCP;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author zzq
 * @creat 2020-07-25 9:47
 */
class CustomersDAOImplTest {

    CustomersDAOImpl cus = new CustomersDAOImpl();

    @Test
    void insert() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            Customer customer = new Customer(1, "码云", "mayun@gmail.com", new Date(435346464359L));
            cus.insert(connection, customer);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, null);
        }
    }

    @Test
    void deleteId() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            cus.deleteId(connection, 25);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, null);
        }
    }

    @Test
    void updateId() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            Customer customer = new Customer(18, "贝多芬", "beiduofen@126.com", new Date(453465656L));
            cus.updateId(connection, customer);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, null);
        }
    }

    @Test
    void getOneCustomer() {
        Connection connection = null;
        try {
            connection = JDBCUtilC3P0.getConnection();
            Customer customer = cus.getOneCustomer(connection, 13);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilC3P0.closeConnection(connection, null,null);
        }
    }

    @Test
    void getAllCustomer() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            List<Customer> list = cus.getAllCustomer(connection);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, null);
        }
    }

    @Test
    void getCount() {
        Connection connection = null;
        try {
            connection = JDBCUtilDBCP.getConnection();
            long count = cus.getCount(connection);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilDBCP.closeConnection(connection, null,null);
        }
    }

    @Test
    void getMaxBirth() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            Date maxBirth = cus.getMaxBirth(connection);
            System.out.println(maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, null);
        }
    }
}