package mintree;

import java.util.Arrays;

/**
 * @Description 最小生成树：Dijkstra算法
 * @ClassName DijkstraAlgorithm
 * @Author zzq
 * @Date 2020/8/13 15:40
 */
public class DijkstraAlgorithm {
    public static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[][]{
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}};
        Graph1 graph = new Graph1(vertex, matrix);
        graph.Dijkstra(2);
    }
}

class VisitedVertex {
    public boolean[] alreadyVisited;    //是否已经访问过
    public int[] preVisited;    //记录父节点的索引
    public int[] distance;  //节点间的距离

    public VisitedVertex(int index, int length) {
        this.alreadyVisited = new boolean[length];
        this.preVisited = new int[length];
        this.distance = new int[length];
        this.alreadyVisited[index] = true;  //设置顶点为被访问过
        Arrays.fill(this.distance, 65535);  //将距离填充为65535
        this.distance[index] = 0;   //自己到自己的距离为0
    }

    /**
     * @Description 判断索引为index的节点是否被访问过
     * @Param [index]
     * @Return boolean
     * @Author zzq
     * @Date 2020/8/13 16:11
     */
    public boolean isVisited(int index) {
        return alreadyVisited[index];
    }

    /**
     * @Description 更新顶点到索引为index的节点的距离
     * @Param [index, distance]
     * @Return void
     * @Author zzq
     * @Date 2020/8/13 16:12
     */
    public void updateDistance(int index, int length) {
        this.distance[index] = length;
    }

    /**
     * @Description 更新前驱结点的索引为index
     * @Param [pre, index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/13 16:20
     */
    public void updatePre(int pre, int index) {
        this.preVisited[pre] = index;
    }

    /**
     * @Description 顶点到index节点的距离
     * @Param [index]
     * @Return int
     * @Author zzq
     * @Date 2020/8/13 17:50
     */
    public int getDistance(int index) {
        return this.distance[index];
    }

    /**
     * @Description 继续选择并返回新的访问节点
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/8/13 17:59
     */
    public int updateArray() {
        int index = 0;
        int min = 65535;
        for (int i = 0; i < alreadyVisited.length; i++) {
            if (!alreadyVisited[i] && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        alreadyVisited[index] = true;   //更新index被访问过
        return index;
    }
}

class Graph1 {
    public char[] vertex;  //节点数组
    public int[][] matrix; //邻接矩阵
    public VisitedVertex visitedVertex;     //已经访问过的节点的集合

    public Graph1(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void show() {
        for (int[] i : matrix)
            System.out.println(Arrays.toString(i));
    }

    public void Dijkstra(int index) {
        visitedVertex = new VisitedVertex(index, vertex.length);
        update(index);      //更新index节点到周围节点的距离和前驱节点
        for (int i = 1; i < vertex.length; i++) {
            index = visitedVertex.updateArray();    //选择并返回新的节点
            update(index);  //继续更新
        }
    }

    public void update(int index) {
        int length = 0;
        for (int i = 0; i < vertex.length; i++) {
            {
                length = visitedVertex.getDistance(index) + matrix[index][i];   //得到顶点到节点的距离
                if (!visitedVertex.isVisited(index) && length < visitedVertex.getDistance(i)) { //节点没有被访问过且和顶点的距离更小
                    visitedVertex.updateDistance(i, index);     //更新i节点的前驱为index
                    visitedVertex.updateDistance(i, length);    //更新顶点到i节点的距离
                }
            }
        }
    }
}
