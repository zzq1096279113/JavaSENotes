package classes1;

import org.junit.jupiter.api.Test;

/**
 * @author zzq
 * @creat 2020-05-31 10:00
 */
public class DAOTest {//表的共性操作的DAO

    @Test
    public void test1(){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        customerDAO.add(customer);
        customerDAO.remove(2);

    }


    @Test
    public void test2(){
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student();
        studentDAO.add(student);

    }

}
