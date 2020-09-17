package prototype.improve;

/**
 * @Description 羊类
 * @ClassName Sheep
 * @Author zzq
 * @Date 2020/9/17 9:38
 */
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @Description 完整的克隆
     * @Param []
     * @Return java.lang.Object
     * @Author zzq
     * @Date 2020/9/17 10:06
     */
    @Override
    protected Sheep clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }

    @Override
    public String toString() {
        return "Sheep{" + "name='" + name + '\'' + ", age=" + age + ", color='" + color + '\'' + '}';
    }
}
