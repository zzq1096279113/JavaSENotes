package factory.simplefactory.order;

import factory.simplefactory.Pizza.Pizza;

import java.util.Scanner;

/**
 * @Description 订购披萨
 * @ClassName OrderPizza
 * @Author zzq
 * @Date 2020/9/15 10:06
 */
public class OrderPizza {
    SimpleFactory simpleFactory;

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        Pizza pizza;
        String orderType;
        this.simpleFactory = simpleFactory;
        while (true) {
            orderType = getType();
            pizza = this.simpleFactory.creatPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }

    private String getType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入披萨种类:");
        return scanner.next();
    }

}
