package flyweight;

/**
 * @Description 围棋
 * @ClassName IgoChessman
 * @Author zzq
 * @Date 2020/9/24 10:40
 */
public abstract class Chessman {
    public abstract String chessColor();

    public void display() {
        System.out.println("棋子:" + this.chessColor());
    }
}
