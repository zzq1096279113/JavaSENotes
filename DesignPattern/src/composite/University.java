package composite;

import java.util.ArrayList;

/**
 * @Description 大学
 * @ClassName University
 * @Author zzq
 * @Date 2020/9/21 19:11
 */
public class University extends OrganizationComponent {
    ArrayList<OrganizationComponent> organization = new ArrayList<>();  //大学中装的是院系

    public University(String name, String description) {
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
        System.out.println("----" + getName() + "----");
        for (OrganizationComponent o : organization)
            o.show();
    }
}
