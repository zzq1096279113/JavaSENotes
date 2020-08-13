package mintree;

import java.util.Arrays;

/**
 * @Description 最小生成树：Kruskal算法
 * @ClassName KruskalAlgorithm
 * @Author zzq
 * @Date 2020/8/12 18:27
 */
public class KruskalAlgorithm {
    private static final int INF = Integer.MAX_VALUE;   //整数最大值
    private int edgeNum;    //边的数量
    private char[] vertexs; //节点数组
    private int[][] weight; //邻接矩阵

    public KruskalAlgorithm(char[] vertexs, int[][] weight) {
        this.vertexs = Arrays.copyOf(vertexs, vertexs.length);
        this.weight = Arrays.copyOf(weight, weight.length);
        for (int[] i : this.weight)
            for (int j : i) {
                if (j != INF && j != 0)
                    edgeNum++;
            }
    }

    /**
     * @Description 得到边的数组
     * @Param null
     * @Return mintree.Edge[]
     * @Author zzq
     * @Date 2020/8/13 11:46
     */
    public Edge[] getEdge() {
        int index = 0;
        Edge[] edges = new Edge[edgeNum / 2];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {   //遍历二维数组上半个三角形
                if (weight[i][j] != INF) {        //如果边的权值不等于最大值
                    edges[index] = new Edge(vertexs[i], vertexs[j], weight[i][j]);  //创建对象加入数组
                    index++;
                }
            }
        }
        return edges;
    }

    /**
     * @Description 对边进行选择排序：根据权值从小到大
     * @Param [edges]
     * @Return void
     * @Author zzq
     * @Date 2020/8/13 11:00
     */
    public void sort(Edge[] edges) {
        int min;
        Edge temp;
        for (int i = 0; i < edges.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < edges.length; j++) {
                if (edges[j].edgeWeight < edges[min].edgeWeight)
                    min = j;
            }
            if (min != i) {
                temp = edges[i];
                edges[i] = edges[min];
                edges[min] = temp;
            }
        }
    }

    /**
     * @Description 根据传入的字符返回在数组中的索引
     * @Param [c]
     * @Return int
     * @Author zzq
     * @Date 2020/8/13 12:17
     */
    public int getIndex(char c) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == c)
                return i;
        }
        return -1;
    }

    /**
     * @Description 获取索引为i的节点的终点
     * @Param [end, i]
     * @Return int
     * @Author zzq
     * @Date 2020/8/13 12:01
     */
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0)
            i = ends[i];
        return i;
    }

    /**
     * @Description 显示邻接矩阵
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/13 11:58
     */
    public void show() {
        for (int[] i : this.weight)
            System.out.println(Arrays.toString(i));
    }

    /**
     * @Description 最小生成树：kruskal算法
     * @Param null
     * @Return mintree.Edge[]
     * @Author zzq
     * @Date 2020/8/13 14:49
     */
    public Edge[] kruskal() {
        int front, rear, m, n;
        int index = 0;
        Edge[] edge = getEdge();    //得到所有的边的集合
        Edge[] result = new Edge[vertexs.length - 1];   //用于保存边，边的数量应为节点数量减1
        int[] ends = new int[edgeNum];      //用于保存树每个节点的终点索引
        sort(edge);     //按照边的权值从小到大排序
        for (int i = 0; i < edgeNum; i++) {     //遍历数组的边
            if (index == result.length)     //判断找到的边是否足够了
                break;
            front = getIndex(edge[i].start);    //边的前面节点的索引
            rear = getIndex(edge[i].end);       //边的后面节点的索引
            m = getEnd(ends, front);    //得到起点节点的终点
            n = getEnd(ends, rear);     //得到终点节点的终点
            if (m != n) {    //判断终点是否相等
                result[index] = edge[i];    //加入到结果数组中
                ends[m] = n;    //因为边已经通过判定加入到了结果中，所以m节点的终点指向n
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};   //节点
        int[][] weight = new int[][]{
                /*A   B   C   D   E   F   G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        KruskalAlgorithm graph = new KruskalAlgorithm(vertexs, weight);
        Edge[] kruskal = graph.kruskal();
        for (Edge e : kruskal)
            System.out.println(e);
    }
}

class Edge {
    char start;     //边的起点
    char end;       //边的终点
    int edgeWeight; //边的权值

    public Edge(char start, char end, int edgeWeight) {
        this.start = start;
        this.end = end;
        this.edgeWeight = edgeWeight;
    }

    @Override
    public String toString() {
        return "Edge<" + start + ", " + end + ">, edgeWeight：" + edgeWeight;
    }
}
