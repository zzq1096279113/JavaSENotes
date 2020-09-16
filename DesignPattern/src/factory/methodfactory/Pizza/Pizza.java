package factory.methodfactory.Pizza;

/**
 * @Description 将披萨类做成抽象类
 * @ClassName Pizza
 * @Author zzq
 * @Date 2020/9/15 9:56
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare(); //披萨不同，需要准备的原材料也不同，根据披萨具体实现。

    public void bake() {
        System.out.println("正在烘烤" + this.name + "披萨");
    }

    public void cut() {
        System.out.println("正在切割" + this.name + "披萨");
    }

    public void box() {
        System.out.println("正在打包" + this.name + "披萨");
    }

    public void setName(String name) {
        this.name = name;
    }
}
