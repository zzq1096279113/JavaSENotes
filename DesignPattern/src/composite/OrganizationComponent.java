package composite;

/**
 * @Description 将学校、学院、专业看做一种组织，一种平级的关系
 * @ClassName OrganizationComponent
 * @Author zzq
 * @Date 2020/9/21 17:33
 */
public abstract class OrganizationComponent {
    private String name;
    private String description;

    public OrganizationComponent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(OrganizationComponent o) {
        throw new UnsupportedOperationException();  //如果不重写此方法，调用此方法时会报出不支持此操作的异常
    }

    public void remove(OrganizationComponent o) {
        throw new UnsupportedOperationException();
    }

    public abstract void show();    //显示信息方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
