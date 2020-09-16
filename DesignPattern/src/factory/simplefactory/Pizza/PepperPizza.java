package factory.simplefactory.Pizza;

/**
 * @Description 胡椒披萨
 * @ClassName PepperPizza
 * @Author zzq
 * @Date 2020/9/15 10:21
 */
public class PepperPizza extends Pizza {
    protected String name = "胡椒";

    @Override
    public void prepare() {
        System.out.println("正在准备胡椒披萨的原材料");
    }
}
