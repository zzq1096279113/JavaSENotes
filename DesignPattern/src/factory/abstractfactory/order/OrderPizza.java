package factory.abstractfactory.order;

import factory.abstractfactory.Pizza.Pizza;

import java.util.Scanner;

/**
 * @Description 订购披萨
 * @ClassName OrderPizza
 * @Author zzq
 * @Date 2020/9/15 10:06
 */
public class OrderPizza {
    AbstractFactory abstractFactory;

    public OrderPizza(AbstractFactory factory) {    //在创建对象时确定要使用的工厂
        setAbstractFactory(factory);
    }

    private void setAbstractFactory(AbstractFactory factory) {  //将设置调用实现类工厂私有化
        Pizza pizza;
        String orderType;
        while (true) {
            orderType = getType();
            pizza = factory.creatPizza(orderType);
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
