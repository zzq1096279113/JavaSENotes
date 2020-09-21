package composite;

/**
 * @Description 专业
 * @ClassName Department
 * @Author zzq
 * @Date 2020/9/21 19:43
 */
public class Department extends OrganizationComponent {
    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    public void show() {
        System.out.println("--" + getName() + "--");
    }
}
