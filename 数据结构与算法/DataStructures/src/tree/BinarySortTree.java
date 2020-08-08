package tree;

/**
 * @Description 二叉排序树
 * @ClassName BinarySortTree
 * @Author zzq
 * @Date 2020/8/8 17:37
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTreeDemo binarySortTreeDemo = new BinarySortTreeDemo();
        for (int i : arr)
            binarySortTreeDemo.add(new BinarySortNode(i));
        System.out.println("二叉排序树为：");
        binarySortTreeDemo.midOrder();
        binarySortTreeDemo.delete(2);
        System.out.println("删除后的二叉排序树为：");
        binarySortTreeDemo.midOrder();
    }
}

class BinarySortTreeDemo {
    public BinarySortNode root; //根节点

    /**
     * @Description 节点的添加
     * @Param [node]
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 21:10
     */
    public void add(BinarySortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * @Description 查找节点
     * @Param [value]
     * @Return tree.BinarySortNode
     * @Author zzq
     * @Date 2020/8/8 21:10
     */
    public BinarySortNode search(int value) {
        if (root == null)
            return null;
        else
            return root.search(value);
    }

    /**
     * @Description 查找父节点
     * @Param [value]
     * @Return tree.BinarySortNode
     * @Author zzq
     * @Date 2020/8/8 21:10
     */
    public BinarySortNode searchParent(int value) {
        if (root == null)
            return null;
        else
            return root.searchParent(value);
    }

    public void delete(int value) {
        if (root == null) {     //如果节点为空，直接返回
            return;
        } else if (root.value == value && root.left == null && root.right == null) {    //如果树只有一个根节点，且根节点就是要删除的节点，将树置空
            root = null;
            return;
        } else {
            BinarySortNode targetNode = search(value);      //查找节点
            if (targetNode == null)     //如果没有找到节点，则节点不存在，直接返回
                return;
            BinarySortNode parentNode = searchParent(value);    //查找父节点
            if (targetNode.left == null && targetNode.right == null) {          //如果找到是叶子结点
                if (parentNode.left != null && parentNode.left == targetNode)           //如果父节点的左子节点就是targetNode
                    parentNode.left = null;
                else if (parentNode.right != null && parentNode.right == targetNode)    //如果父节点的右子节点就是targetNode
                    parentNode.right = null;
            }

        }
    }

    /**
     * @Description 中序遍历
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 21:11
     */
    public void midOrder() {
        if (root != null)
            root.midOrder();
        else
            System.out.println("当前二叉排序树为空");
    }
}

class BinarySortNode {
    int value;
    BinarySortNode left;
    BinarySortNode right;

    public BinarySortNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }

    /**
     * @Description 二叉排序树
     * @Param [node]
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 18:03
     */
    public void add(BinarySortNode node) {
        if (node == null)
            return;
        if (node.value < this.value) {   //如果传入节点的值小于当前根节点的值
            if (this.left == null)       //如果左子节点为空，直接添加到左子节点
                this.left = node;
            else    //如果左子节点不为空，递归
                this.left.add(node);
        } else {                        //如果传入节点的值大于等于当前根节点的值
            if (this.right == null)
                this.right = node;      //如果右子节点为空，直接添加到右子节点
            else
                this.right.add(node);
        }
    }

    /**
     * @Description 根据传入的value查找节点，找到返回该节点；如果没有找到，返回null
     * @Param [value]
     * @Return tree.BinarySortNode
     * @Author zzq
     * @Date 2020/8/8 20:22
     */
    public BinarySortNode search(int value) {
        if (this.value == value)     //该节点就是查找的节点
            return this;
        else if (value < this.value)        //如果查找的值小于当前节点，向左子树递归
            return this.left == null ? null : this.left.search(value);
        else                                //如果查找的值大于当前节点，向右子树递归
            return this.right == null ? null : this.right.search(value);
    }

    /**
     * @Description 根据传入的值，返回查找节点的父节点
     * @Param [value]
     * @Return tree.BinarySortNode
     * @Author zzq
     * @Date 2020/8/8 20:32
     */
    public BinarySortNode searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;        //当前节点的左子节点或右子节点是查找的节点，返回当前节点
        } else {
            if (value < this.value && this.left != null)        //查找的值小于节点的值，且节点有左子树，向左递归
                return this.left.searchParent(value);
            else if (this.value <= value && this.right != null) //查找的值大于等于节点的值，且节点有左子树，向左递归
                return this.right.searchParent(value);
            else
                return null;    //没有找到父节点
        }
    }

    /**
     * @Description 中序遍历
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 18:04
     */
    public void midOrder() {
        if (this.left != null)
            this.left.midOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.midOrder();
    }
}
