package flyweight;

import java.util.HashMap;

/**
 * @Description 工厂
 * @ClassName ChessmanFactory
 * @Author zzq
 * @Date 2020/9/24 10:43
 */
public class ChessmanFactory {
    private static ChessmanFactory instance = new ChessmanFactory();    //用单例模式来做工厂
    private static HashMap<String, Chessman> pool;

    private ChessmanFactory() {
        pool = new HashMap<>();
        pool.put("白", new WhiteChess());
        pool.put("黑", new BlackChess());
    }

    public static ChessmanFactory getInstance() {
        return instance;
    }

    public Chessman getChessman(String name) {
        return pool.get(name);
    }
}
