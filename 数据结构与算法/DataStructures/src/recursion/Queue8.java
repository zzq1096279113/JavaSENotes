package recursion;

/**
 * @Description 递归解决八皇后问题
 * @ClassName Queue8
 * @Author zzq
 * @Date 2020/8/1 13:43
 */
public class Queue8 {
    int max = 8;
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
    }

    /**
     * @Description 放置第n个皇后的递归方法
     * @Param [n]
     * @Return void
     * @Author zzq
     * @Date 2020/8/1 14:24
     */
    public void check(int n) {
        if (n == max) {     //皇后编号从0开始
            show();
            return;
        }
        for (int i = 0; i < max; i++) {     //放入皇后
            array[n] = i;
            if (judgment(n)) {       //判断是否冲突
                check(n + 1);     //如果不冲突，接着放下一个皇后
            }   //如果冲突，继续循环。
        }
    }

    /**
     * @Description 判断第n个皇后的加入是否和前面已经加入的皇后冲突
     * @Param [n]
     * @Return boolean
     * @Author zzq
     * @Date 2020/8/1 14:03
     */
    public boolean judgment(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {   //array[i] == array[n]：判断第n个皇后是否与前面的皇后在同一列
                return false;                                   //Math.abs(i - n) == Math.abs(array[i] - array[n])：计算斜率，判断是否在同一斜线上
            }
        }
        return true;
    }

    /**
     * @Description 打印array数组
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/1 13:51
     */
    public void show() {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
