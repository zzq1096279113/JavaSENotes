package uml.implementation;

/**
 * @Description 实现
 * @ClassName PersonServiceBean
 * @Author zzq
 * @Date 2020/9/13 11:49
 */
public class PersonServiceBean implements PersonService {
    @Override
    public void delete(Integer id) {
        System.out.println("正在删除");
    }
}
