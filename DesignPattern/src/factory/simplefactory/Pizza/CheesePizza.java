package factory.simplefactory.Pizza;

/**
 * @Description 奶酪披萨
 * @ClassName CheesePizza
 * @Author zzq
 * @Date 2020/9/15 10:02
 */
public class CheesePizza extends Pizza {
    protected String name = "奶酪";

    @Override
    public void prepare() {
        System.out.println("正在准备奶酪披萨的原材料");
    }
}
