package huffmancode;

/**
 * @Description 哈夫曼树的节点
 * @ClassName Node
 * @Author zzq
 * @Date 2020/8/7 17:13
 */
class Node implements Comparable<Node> {
    public Byte data;       //数据
    public int weight;      //权值
    public Node left;
    public Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder() {    //前序遍历
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

}
