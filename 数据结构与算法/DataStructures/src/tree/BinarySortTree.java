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
        binarySortTreeDemo.delete(5);
        binarySortTreeDemo.delete(9);
        binarySortTreeDemo.delete(12);
        binarySortTreeDemo.delete(7);
        binarySortTreeDemo.delete(3);
        binarySortTreeDemo.delete(10);
        binarySortTreeDemo.delete(1);
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

    /**
     * @Description 删除并返回以node为根节点的树的最小节点
     * @Param [node]
     * @Return int
     * @Author zzq
     * @Date 2020/8/9 9:14
     */
    public int deleteRightMin(BinarySortNode node) {
        BinarySortNode target = node;
        while (target.left != null)
            target = target.left;
        delete(target.value);
        return target.value;
    }

    /**
     * @Description 删除并返回以node为根节点的树的最大节点
     * @Param [node]
     * @Return int
     * @Author zzq
     * @Date 2020/8/9 9:35
     */
    public int deleteLeftMax(BinarySortNode node) {
        BinarySortNode target = node;
        while (target.right != null)
            target = target.right;
        delete(target.value);
        return target.value;
    }

    /**
     * @Description 根据传入的值从树中删除节点。分为了三种情况：删除节点为叶子节点，删除节点有一个子树，删除节点有两个子树
     * @Param [value]
     * @Return void
     * @Author zzq
     * @Date 2020/8/9 9:27
     */
    public void delete(int value) {
        if (root == null) {     //如果节点为空，直接返回
            return;
        } else if (root.value == value && root.left == null && root.right == null) {        //如果树只有一个根节点，且根节点就是要删除的节点，将树置空
            root = null;
            return;
        } else if (root.value != value && root.left == null && root.right == null) {        //如果树只有一个根节点，且根节点不是要删除的节点
            return;
        } else if (root.left != null && root.right == null && root.value == value) {        //如果根节点只有一个左子节点，且根节点是要删除的节点
            root = root.left;
            return;
        } else if (root.right != null && root.left == null && root.value == value) {        //如果根节点只有一个右子节点，且根节点是要删除的节点
            root = root.right;
            return;
        } else {
            BinarySortNode targetNode = search(value);      //查找节点
            if (targetNode == null)     //如果没有找到节点，则节点不存在，直接返回
                return;
            BinarySortNode parentNode = searchParent(value);    //查找父节点
            if (targetNode.left == null && targetNode.right == null) {              //如果找到是叶子结点
                if (parentNode.left != null && parentNode.left == targetNode)           //如果父节点的左子节点就是targetNode
                    parentNode.left = null;
                else if (parentNode.right != null && parentNode.right == targetNode)    //如果父节点的右子节点就是targetNode
                    parentNode.right = null;
            } else if (targetNode.left != null && targetNode.right != null) {       //如果节点有两个子树
                int min = deleteRightMin(targetNode.right);     //到targetNode的右边找最小值，删除并返回
//                int max = deleteLeftMax(targetNode.left);     //到targetNode的左边找最大值，删除并返回
                targetNode.value = min;     //将最小值赋给当前节点
            } else {        //只有一颗子树的情况
                if (targetNode.left != null) {      //如果要删除的节点有左子树
                    if (parentNode.left == targetNode)     //且要删除的节点是父节点的左子节点
                        parentNode.left = targetNode.left;
                    else if (parentNode.right == targetNode) //且要删除的节点是父节点的右子节点
                        parentNode.right = targetNode.left;
                } else {        //如果要删除的节点有右子树
                    if (parentNode.left == targetNode)     //且要删除的节点是父节点的左子节点
                        parentNode.left = targetNode.right;
                    else if (parentNode.right == targetNode) //且要删除的节点是父节点的右子节点
                        parentNode.right = targetNode.right;
                }
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
