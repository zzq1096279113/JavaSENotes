package tree;

/**
 * @Description 平衡二叉树（AVL）
 * @ClassName AVLTree
 * @Author zzq
 * @Date 2020/8/9 10:21
 */
public class AVLTree {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTreeDemo avlTreeDemo = new AVLTreeDemo();
        for (int i : arr)
            avlTreeDemo.add(new AVLTreeNode(i));
        avlTreeDemo.midOrder();
    }
}

class AVLTreeDemo {
    public AVLTreeNode root; //根节点

    /**
     * @Description 节点的添加
     * @Param [node]
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 21:10
     */
    public void add(AVLTreeNode node) {
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
    public AVLTreeNode search(int value) {
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
    public AVLTreeNode searchParent(int value) {
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
    public int deleteRightMin(AVLTreeNode node) {
        AVLTreeNode target = node;
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
    public int deleteLeftMax(AVLTreeNode node) {
        AVLTreeNode target = node;
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
            AVLTreeNode targetNode = search(value);      //查找节点
            if (targetNode == null)     //如果没有找到节点，则节点不存在，直接返回
                return;
            AVLTreeNode parentNode = searchParent(value);    //查找父节点
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

class AVLTreeNode {
    int value;
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }

    /**
     * @Description 返回当前节点的左子树高度
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/8/9 10:32
     */
    public int leftHeight() {
        return this.left == null ? 0 : this.left.height();
    }

    /**
     * @Description 返回当前节点的左子树高度
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/8/9 10:33
     */
    public int rightHeight() {
        return this.right == null ? 0 : this.right.height();
    }

    /**
     * @Description 返回以当前节点为根节点的树的高度
     * @Param []
     * @Return int
     * @Author zzq
     * @Date 2020/8/9 10:30
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    /**
     * @Description 左旋转
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/8/9 14:39
     */
    public void leftRotate() {
        AVLTreeNode avlTreeNode = new AVLTreeNode(this.value);      //以当前节点，创建新的节点
        avlTreeNode.left = this.left;       //新节点的左子树设置当前节点的左子树
        avlTreeNode.right = this.right.left;    //新节点的右子树设置为当前节点右子树的左子树
        this.value = this.right.value;      //当前节点的值换位右子节点的值
        this.right = this.right.right;      //当前节点的右子树设置为当前节点右子树的右子树
        this.left = avlTreeNode;        //当前节点的左子树设置为新节点
    }

    /**
     * @Description 右旋转
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/8/9 14:39
     */
    public void rightRotate() {
        AVLTreeNode avlTreeNode = new AVLTreeNode(this.value);  //新节点
        avlTreeNode.left = this.left.right; //新节点左子树指向当前节点左子树的右子节点
        avlTreeNode.right = this.right;     //新节点右子树指向当前节点的右子树
        this.value = this.left.value;       //当前节点的值改为当前节点左子节点的值
        this.left = this.left.left;     //当前节点左子节点指向左子节点的左子节点
        this.right = avlTreeNode;       //当前节点右子节点指向新节点
    }

    /**
     * @Description 二叉排序树
     * @Param [node]
     * @Return void
     * @Author zzq
     * @Date 2020/8/8 18:03
     */
    public void add(AVLTreeNode node) {
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
        if (rightHeight() - leftHeight() > 1) {     //判断是否需要左旋转
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight())    //如果右子树的左子树大于右子树的右子树
                this.right.rightRotate();   //对当前节点的右节点进行右旋
            leftRotate();       //再对当前节点进行右旋转
        } else if (leftHeight() - rightHeight() > 1) {  //判断是否需要右旋转
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight())    //如果左子树的右子树大于左子树的左子树
                this.left.leftHeight();     //对当前节点的左节点进行左旋
            rightRotate();      //再对当前节点进行右旋转
        }
    }

    public AVLTreeNode search(int value) {
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
    public AVLTreeNode searchParent(int value) {
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



