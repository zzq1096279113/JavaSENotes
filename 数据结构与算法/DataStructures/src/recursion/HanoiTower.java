package recursion;

/**
 * @Description 汉诺塔（分治算法）
 * @ClassName HanoiTower
 * @Author zzq
 * @Date 2020/8/10 16:19
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(64);
    }

    /**
     * @Description 汉诺塔的移动：递归
     * @Param [num, A, B, C]
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 16:28
     */
    public static void hanoiTower(int num) {
        char A = 'A';
        char B = 'B';
        char C = 'C';
        hanoiTower(num, A, B, C);
    }

    public static void hanoiTower(int num, char A, char B, char C) {
        if (num == 1)        //如果只有一个盘
            System.out.println(A + " -> " + C);
        else {
            hanoiTower(num - 1, A, C, B);   //A上面部分通过C移动到B
            System.out.println(A + " -> " + C);     //将A最后一个移动到C
            hanoiTower(num - 1, B, A, C);   //B上面部分通过A移动到C
        }
    }
}
