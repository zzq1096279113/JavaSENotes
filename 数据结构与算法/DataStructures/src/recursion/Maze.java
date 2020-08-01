package recursion;

/**
 * @Description 迷宫问题
 * @ClassName Maze
 * @Author zzq
 * @Date 2020/8/1 9:48
 */
public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];    //利用二维数组作为迷宫
        for (int i = 0; i < 7; i++) {   //设置迷宫的墙体为1
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {   //显示迷宫地图
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("***************路线*****************");
        findWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {   //显示探测后的地图
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @Description 根据传入的迷宫返回路线。    1表示墙，2表示可以走通，3表示走过但是不通
     * @Param [map, i, j]   map：迷宫地图    i，j：起始位置
     * @Return boolean
     * @Author zzq
     * @Date 2020/8/1 10:30
     */
    public static boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {     //通路已找到
            return true;
        } else {
            if (map[i][j] == 0) {    //如果当前点还没有走过，按照策略 下->右->上->左
                map[i][j] = 2;  //假定是可以走通的
                if (findWay(map, i + 1, j)) {     //向下走
                    return true;
                } else if (findWay(map, i, j + 1)) {   //向右走
                    return true;
                } else if (findWay(map, i - 1, j)) {   //向上走
                    return true;
                } else if (findWay(map, i, j - 1)) {   //向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {   //如果map[i][j]!==0，可能是1，2，3。
                return false;
            }
        }
    }
}
