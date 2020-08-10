package graph;

import java.util.*;

/**
 * @Description 图的创建
 * @ClassName Graph
 * @Author zzq
 * @Date 2020/8/10 9:25
 */
public class Graph {
    private ArrayList<String> vertexList;       //存储顶点的集合
    private int[][] edges;      //存储邻接矩阵的二维数组
    private int edgesCount;     //边的数量

    public Graph(int n) {       //n为顶点的个数
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<String>(n);
    }

    /**
     * @Description 插入顶点
     * @Param [vertex]
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 9:41
     */
    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    public void insertVertex(String[] vertex) {
        Collections.addAll(this.vertexList, vertex);
    }

    /**
     * @Description 设置路径
     * @Param [v1, v2, weight]
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 9:42
     */
    public void insertEdges(int v1, int v2, int weight) {
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        this.edgesCount++;
    }

    /**
     * @Description 顶点的个数
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/8/10 9:43
     */
    public int getVertexCount() {
        return this.vertexList.size();
    }

    /**
     * @Description 边的个数
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/8/10 9:43
     */
    public int getEdgesCount() {
        return this.edgesCount;
    }

    /**
     * @Description 根据索引返回对应的数据
     * @Param [index]
     * @Return java.lang.String
     * @Author zzq
     * @Date 2020/8/10 9:45
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * @Description 返回两顶点的权值
     * @Param [v1, v2]
     * @Return int
     * @Author zzq
     * @Date 2020/8/10 9:46
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * @Description 显示整个链接矩阵
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 9:47
     */
    public void showEdges() {
        for (int[] i : edges)
            System.out.println(Arrays.toString(i));
    }

    /**
     * @Description 深度优先遍历：回溯
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 13:51
     */
    public void dfs() {
        boolean[] isFlag = new boolean[getVertexCount()];
        dfs(0, isFlag);
    }

    private void dfs(int index, boolean[] isFlag) {
        System.out.println(getValueByIndex(index));     //访问并输出
        isFlag[index] = true;       //标记为已访问
        for (int i = index + 1; i < getVertexCount(); i++) {    //回溯算法
            if (edges[index][i] == 1 && !isFlag[i]) {   //如果相邻节点路径为1，且没有被访问过
                dfs(i, isFlag);
            }
        }
    }

    /**
     * @Description 广度优先遍历
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/10 14:08
     */
    public void bfs() {
        int head;
        boolean[] isFlag = new boolean[getVertexCount()];
        LinkedList<Integer> queue = new LinkedList<>();     //保存索引的队列
        for (int i = 0; i < getVertexCount(); i++) {
            if (!isFlag[i]) {
                System.out.println(getValueByIndex(i));     //访问并输出
                isFlag[i] = true;       //标记为已访问
                queue.addFirst(i);
                while (!queue.isEmpty()) {
                    i = queue.removeFirst();
                    for (int j = 0; j < getVertexCount(); j++) {
                        if (edges[i][j] == 1 && !isFlag[j]) {
                            System.out.println(getValueByIndex(j));     //访问并输出
                            isFlag[j] = true;       //标记为已访问
                            queue.addFirst(j);
                        }
                    }
                }
            }

        }


    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] ver = {"A", "B", "C", "D", "E"};
        graph.insertVertex(ver);
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
//        graph.showEdges();
        graph.bfs();
    }
}
