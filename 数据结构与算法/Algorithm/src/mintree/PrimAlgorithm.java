package mintree;

import java.util.Arrays;

/**
 * @Description 最小生成树：Prim算法
 * @ClassName PrimAlgorithm
 * @Author zzq
 * @Date 2020/8/12 16:22
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        MinTree minTree = new MinTree();
        Graph graph = minTree.creatGraph(chars, weight);
        System.out.println("最小生成树为：");
        minTree.prim(graph, 0);
    }
}

class MinTree {
    /**
     * @Description 根据传入的字符数组与邻接矩阵，创建图
     * @Param [chars, weight]
     * @Return prim.Graph
     * @Author zzq
     * @Date 2020/8/12 16:40
     */
    public Graph creatGraph(char[] chars, int[][] weight) {
        int len = chars.length;
        Graph graph = new Graph(len);
        for (int i = 0; i < len; i++) {
            graph.data[i] = chars[i];
            System.arraycopy(weight[i], 0, graph.weight[i], 0, len);    //将邻接矩阵放入图中
        }
        return graph;
    }

    /**
     * @Description 最小生成树得到最短路径
     * @Param [graph, vertex]
     * @Return void
     * @Author zzq
     * @Date 2020/8/12 17:54
     */
    public void prim(Graph graph, int vertex) {
        int left = -1;      //用于标记两个节点的下标
        int right = -1;
        int minWeight = 10000;      //设置为较大值，找较小值
        boolean[] isFlag = new boolean[graph.count];    //标记节点是否访问过
        isFlag[vertex] = true;
        for (int i = 1; i < graph.count; i++) {     //遍历所有节点
            for (int j = 0; j < graph.count; j++) {     //遍历已经访问过的节点
                if (!isFlag[j])     //如果是没有访问过的节点，直接跳过
                    continue;
                for (int k = 0; k < graph.count; k++) {     //遍历没有访问过的节点
                    if (isFlag[k] || graph.weight[j][k] >= minWeight) {     //如果节点已经被访问过或路径大于最小路径，直接下次循环
                        continue;
                    }
                    left = j;
                    right = k;
                    minWeight = graph.weight[j][k];     //已经访问过的节点中路径最小的
                }
            }
            System.out.println("边：<" + graph.data[left] + "," + graph.data[right] + ">，权值：" + graph.weight[right][left]);
            isFlag[right] = true;
            minWeight = 10000;
        }

    }
}

class Graph {
    int count;  //节点个数
    char[] data;    //节点数据
    int[][] weight;     //邻接矩阵

    public Graph(int count) {
        this.count = count;
        this.data = new char[count];
        this.weight = new int[count][count];
    }

    public void show() {
        for (int[] i : this.weight)
            System.out.println(Arrays.toString(i));
    }
}
