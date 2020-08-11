package dyamic;

import java.util.Arrays;

/**
 * @Description 动态规划：背包问题
 * @ClassName KnapsackProblem
 * @Author zzq
 * @Date 2020/8/11 15:15
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3};   //物品的重量
        int[] value = {1500, 3000, 2000};   //物品的价值
        int m = 4;  //背包的容量
        int n = value.length;   //物品的个数
        int[][] v = new int[n + 1][m + 1];
        String[][] strings = new String[n + 1][m + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (j < weight[i - 1]) {     //因为i从1开始，所以需要减1
                    v[i][j] = v[i - 1][j];
                    strings[i][j] = String.valueOf(v[i - 1][j]);
                } else {
                    if (v[i - 1][j] > value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = v[i - 1][j];
                        strings[i][j] = v[i - 1][j] + " ";
                    } else {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                        strings[i][j] = value[i - 1] + "+" + v[i - 1][j - weight[i - 1]];
                    }
                }
            }
        }
        for (int[] i : v)
            System.out.println(Arrays.toString(i));
        for (String[] s : strings)
            System.out.println(Arrays.toString(s));
    }
}
