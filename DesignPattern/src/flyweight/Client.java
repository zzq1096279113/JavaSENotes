package flyweight;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/24 9:47
 */
public class Client {
    public static void main(String[] args) {
        ChessmanFactory instance = ChessmanFactory.getInstance();
        Chessman white1 = instance.getChessman("白");
        Chessman white2 = instance.getChessman("白");
        System.out.println(white1 == white2);
    }
}
