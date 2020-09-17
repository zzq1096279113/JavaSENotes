package prototype.improve;


/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/17 9:40
 */
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "white");
        Sheep clone1 = sheep.clone();
        Sheep clone2 = sheep.clone();
        Sheep clone3 = sheep.clone();
        Sheep clone4 = sheep.clone();
        Sheep clone5 = sheep.clone();
        System.out.println(clone1.toString());
        System.out.println(clone2.toString());
        System.out.println(clone3.toString());
        System.out.println(clone4.toString());
        System.out.println(clone5.toString());
    }
}
