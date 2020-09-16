package factory.methodfactory.Pizza;

/**
 * @Description 北京的胡椒披萨
 * @ClassName BJPepperPizza
 * @Author zzq
 * @Date 2020/9/15 10:21
 */
public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的胡椒");
        System.out.println("正在准备北京的胡椒披萨的原材料");
    }
}
