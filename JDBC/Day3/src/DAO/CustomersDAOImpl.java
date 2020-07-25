package DAO;

import Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author zzq
 * @creat 2020-07-25 9:26
 */
public class CustomersDAOImpl extends BaseDAO implements CustomersDAO {
    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "insert into customers(name,email,birth) value(?,?,?)";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteId(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void updateId(Connection connection, Customer customer) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    @Override
    public Customer getOneCustomer(Connection connection, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> customers = getForList(connection, Customer.class, sql);
        return customers;
    }

    @Override
    public long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection, sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return getValue(connection, sql);
    }

}
