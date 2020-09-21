package composite;

import java.util.ArrayList;

/**
 * @Description 院系
 * @ClassName College
 * @Author zzq
 * @Date 2020/9/21 19:39
 */
public class College extends OrganizationComponent {
    ArrayList<OrganizationComponent> organization = new ArrayList<>();  //院系中装的是专业

    public College(String name, String description) {
        super(name, description);
    }

    @Override
    public void add(OrganizationComponent o) {
        organization.add(o);
    }

    @Override
    public void remove(OrganizationComponent o) {
        organization.remove(o);
    }

    @Override
    public void show() {
        System.out.println("---" + getName() + "---");
        for (OrganizationComponent o : organization)
            o.show();
    }
}
