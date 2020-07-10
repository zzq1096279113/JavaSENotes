package exer1;

import java.util.List;

/**
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方 法来操作 User 对象，
 *
 * @author zzq
 * @creat 2020-05-31 11:49
 */
public class Test {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        //save()
        userDAO.save("1001",new User(1001,34,"周杰伦"));
        userDAO.save("1002",new User(1002,20,"昆凌"));
        userDAO.save("1003",new User(1003,25,"蔡依林"));

        //update()
        userDAO.update("1003",new User(1003,30,"方文山"));

        //delete
        userDAO.delete("1001");

        //list
        List<User> list = userDAO.list();
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
