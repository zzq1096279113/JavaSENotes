package uml.dependence;

/**
 * @Description 依赖
 * @ClassName PersonServiceBean
 * @Author zzq
 * @Date 2020/9/13 11:27
 */
public class PersonServiceBean {
    private PersonDao personDao;

    public void save(Person person) {
    }

    public IDCard getIDCard(Integer personID) {
        return null;
    }

    public void modify() {
        Department department = new Department();
    }
}
