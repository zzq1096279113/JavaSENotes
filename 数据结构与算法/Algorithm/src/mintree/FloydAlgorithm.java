package mintree;

import java.util.Arrays;

/**
 * @Description 最小生成树：Floyd算法
 * @ClassName FloydAlgorithm
 * @Author zzq
 * @Date 2020/8/13 18:10
 */
public class FloydAlgorithm {
    public static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[][]{
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}};
        Graph2 graph = new Graph2(vertex, matrix);  //创建图对象
        graph.floyd();
        graph.show();
    }
}

class Graph2 {
    public char[] vertex;   //存放节点
    public int[][] distance;    //节点间距离
    public int[][] mid;     //存放中间节点

    public Graph2(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.distance = matrix;
        this.mid = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++)     //初始化中间节点
            Arrays.fill(this.mid[i], i);
    }

    /**
     * @Description 根据邻接矩阵得到节点之间最短路径
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/14 10:26
     */
    public void floyd() {
        int len;
        for (int i = 0; i < vertex.length; i++) {   //中间节点：中间节点固定，变换起点与终点
            for (int j = 0; j < vertex.length; j++) {   //起点
                for (int k = 0; k < vertex.length; k++) {   //终点
                    len = distance[j][i] + distance[i][k];      //起点->中间节点的距离+中间节点->终点的距离 = 起点到终点的距离
                    if (len < distance[j][k]) {   //如果得到的距离小于矩阵中的距离
                        distance[j][k] = len;   //更新距离
                        mid[j][k] = i;  //更新中间节点
                    }
                }
            }
        }
    }

    public void show() {
        System.out.println("距离数组：");
        for (int[] i : distance)
            System.out.println(Arrays.toString(i));
        System.out.println("中间数组：");
        for (int[] j : mid)
            System.out.println(Arrays.toString(j));
    }
}
