package factory.abstractfactory.Pizza;

/**
 * @Description 伦敦的奶酪披萨
 * @ClassName LDCheesePizza
 * @Author zzq
 * @Date 2020/9/15 16:31
 */
public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦的奶酪");
        System.out.println("正在准备伦敦的奶酪披萨的原材料");
    }
}
