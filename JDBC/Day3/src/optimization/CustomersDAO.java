package optimization;

import Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于customers表的常用操作
 *
 * @author zzq
 * @creat 2020-07-25 9:11
 */
public interface CustomersDAO {
    /**
     * 将customer对象添加到数据库中
     *
     * @param connection
     * @param customer
     */
    void insert(Connection connection, Customer customer);

    /**
     * 针对指定的id删除记录
     *
     * @param connection
     * @param id
     */
    void deleteId(Connection connection, int id);

    /**
     * 针对指定的id修改
     *
     * @param connection
     * @param customer
     */
    void updateId(Connection connection, Customer customer);

    /**
     * 根据指定的id查询对应的Customer对象
     *
     * @param connection
     * @param id
     */
    Customer getOneCustomer(Connection connection, int id);

    /**
     * 查询表中所有记录构成的集合
     *
     * @param connection
     * @return
     */
    List<Customer> getAllCustomer(Connection connection);

    /**
     * 返回数据表中的数据的条目数
     *
     * @param connection
     * @return
     */
    long getCount(Connection connection);

    /**
     * 返回数据表中最大的生日
     *
     * @param connection
     * @return
     */
    Date getMaxBirth(Connection connection);
}
