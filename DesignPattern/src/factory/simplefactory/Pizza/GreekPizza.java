package factory.simplefactory.Pizza;

/**
 * @Description 希腊披萨
 * @ClassName GreekPizza
 * @Author zzq
 * @Date 2020/9/15 10:04
 */
public class GreekPizza extends Pizza {
    protected String name = "希腊";

    @Override
    public void prepare() {
        System.out.println("正在准备希腊披萨的原材料");
    }
}
