package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Description 马踏棋盘：深度遍历+贪心算法
 * @ClassName HorseChessboard
 * @Author zzq
 * @Date 2020/8/14 13:43
 */
public class HorseChessboard {
    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int[][] broad = new int[Y][X];
        isFlag = new boolean[Y][X];
        long start = System.currentTimeMillis();
        traversal(broad, 0, 0, 1);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
        for (int[] i : broad) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    public static int X;    //棋盘的x轴
    public static int Y;    //棋盘的y轴
    public static boolean[][] isFlag;   //标记是否被访问过
    public static boolean finished;     //标记棋盘是否都被访问过了

    /**
     * @Description 马踏棋盘
     * @Param [chessboard, y, x, step]
     * @Return void
     * @Author zzq
     * @Date 2020/8/14 14:18
     */
    public static void traversal(int[][] chessboard, int y, int x, int step) {
        chessboard[y][x] = step;    //第y行第x列是步数为step
        isFlag[y][x] = true;    //标记为已访问
        ArrayList<Point> next = next(new Point(x, y));  //可以走的位置的集合
        sort(next);
        while (!next.isEmpty()) {    //只要集合不为空就继续
            Point remove = next.remove(0);  //取出一个可以走的位置
            if (!isFlag[remove.y][remove.x])    //如果没有访问过
                traversal(chessboard, remove.y, remove.x, step + 1);
        }
        if (step < X * Y && !finished) {    //没有完成，正在查找路径
            chessboard[y][x] = 0;
            isFlag[y][x] = false;
        } else {    //已经完成，返回正确路径
            finished = true;
        }
    }

    /**
     * @Description 根据当前位置计算出马可以走的位置的集合，最多有8个位置
     * @Param [curentPoint]
     * @Return java.util.ArrayList<java.awt.Point>
     * @Author zzq
     * @Date 2020/8/14 14:14
     */
    public static ArrayList<Point> next(Point curentPoint) {
        ArrayList<Point> points = new ArrayList<>();    //用于保存可以走通的位置
        Point point = new Point();
        if ((point.x = curentPoint.x - 2) >= 0 && (point.y = curentPoint.y - 1) >= 0)   //能够走5
            points.add(new Point(point));
        if ((point.x = curentPoint.x - 1) >= 0 && (point.y = curentPoint.y - 2) >= 0)   //能够走6
            points.add(new Point(point));
        if ((point.x = curentPoint.x + 1) < X && (point.y = curentPoint.y - 2) >= 0)   //能够走7
            points.add(new Point(point));
        if ((point.x = curentPoint.x + 2) < X && (point.y = curentPoint.y - 1) >= 0)   //能够走0
            points.add(new Point(point));
        if ((point.x = curentPoint.x - 2) >= 0 && (point.y = curentPoint.y + 1) < Y)   //能够走4
            points.add(new Point(point));
        if ((point.x = curentPoint.x - 1) >= 0 && (point.y = curentPoint.y + 2) < Y)   //能够走3
            points.add(new Point(point));
        if ((point.x = curentPoint.x + 1) < X && (point.y = curentPoint.y + 2) < Y)   //能够走2
            points.add(new Point(point));
        if ((point.x = curentPoint.x + 2) < X && (point.y = curentPoint.y + 1) < Y)   //能够走1
            points.add(new Point(point));
        return points;
    }

    /**
     * @Description 排序：对传入的next集合进行下一个位置个数从小到大排序
     * @Param [next]
     * @Return void
     * @Author zzq
     * @Date 2020/8/14 15:30
     */
    public static void sort(ArrayList<Point> next) {
        next.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(next(o1).size(), next(o2).size());   //用下一步所有位置的个数比较
            }
        });
    }
}
