package decorator;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/20 19:15
 */
public class Client {
    public static void main(String[] args) {
        LongBlack longBlack = new LongBlack();  //先有咖啡
        Milk milk = new Milk(longBlack);    //再加牛奶
        Sugar sugar = new Sugar(milk);  //再加糖
        System.out.println(sugar.getDescription());
        System.out.println(sugar.cost());
    }
}
