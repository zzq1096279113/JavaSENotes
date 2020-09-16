package factory.methodfactory.order;

import factory.methodfactory.Pizza.Pizza;
import java.util.Scanner;

/**
 * @Description 订购披萨
 * @ClassName OrderPizza
 * @Author zzq
 * @Date 2020/9/15 10:06
 */
public abstract class OrderPizza {

    public OrderPizza() {
        Pizza pizza;
        String orderType;
        while (true) {
            orderType = getType();
            pizza = creatPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }

    abstract Pizza creatPizza(String orderType);

    private String getType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入披萨种类:");
        return scanner.next();
    }

}
