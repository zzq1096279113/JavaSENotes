package factory.abstractfactory.order;

import java.util.Scanner;

/**
 * @Description 披萨店
 * @ClassName PizzaStore
 * @Author zzq
 * @Date 2020/9/15 17:17
 */
public class PizzaStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入披萨店区域：");
        switch (scanner.next()) {
            case "bj" -> new OrderPizza(new BJFactory());
            case "ld" -> new OrderPizza(new LDFactory());
            default -> throw new RuntimeException("披萨店选择错误");
        }
    }
}
