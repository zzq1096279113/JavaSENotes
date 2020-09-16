package factory.abstractfactory.Pizza;

/**
 * @Description 北京的奶酪披萨
 * @ClassName BJCheesePizza
 * @Author zzq
 * @Date 2020/9/15 10:02
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的奶酪");
        System.out.println("正在准备北京的奶酪披萨的原材料");
    }
}
