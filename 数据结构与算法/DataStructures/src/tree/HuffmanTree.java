package tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description 哈夫曼树：树的带权路径最短的树
 * @ClassName HuffmanTree
 * @Author zzq
 * @Date 2020/8/7 9:09
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = creatHuffmanTree(arr);
        node.preOrder();
    }

    /**
     * @Description 根据传入的数组创建哈夫曼树
     * @Param [arr]
     * @Return tree.Node
     * @Author zzq
     * @Date 2020/8/7 10:05
     */
    public static Node creatHuffmanTree(int[] arr) {
        Node left;
        Node right;
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i : arr) {     //遍历数组，转换为节点放入ArrayList中
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);    //从小到大排序
            left = nodes.get(0);   //取出节点权值最小的两颗二叉树
            right = nodes.get(1);
            Node parent = new Node(left.value + right.value);   //创建新节点，权值为左右子节点权值的和
            parent.left = left;     //构建新子树
            parent.right = right;
            nodes.remove(left);     //从ArrayList删除处理过的二叉树
            nodes.remove(right);
            nodes.add(parent);      //将新节点加入ArrayList中
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;      //节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;    //从小到大排序
    }
}
