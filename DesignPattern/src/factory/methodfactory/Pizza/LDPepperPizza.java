package factory.methodfactory.Pizza;

/**
 * @Description 伦敦的胡椒披萨
 * @ClassName LDPepperPizza
 * @Author zzq
 * @Date 2020/9/15 16:32
 */
public class LDPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦的胡椒");
        System.out.println("正在准备伦敦的胡椒披萨的原材料");
    }
}
