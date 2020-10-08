package iterator;

/**
 * @Description 系
 * @ClassName Department
 * @Author zzq
 * @Date 2020/9/30 11:23
 */
public class Department {
    private String name;
    private String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

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
