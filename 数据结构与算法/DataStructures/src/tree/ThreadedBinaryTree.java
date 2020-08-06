package tree;

/**
 * @Description 线索二叉树
 * @ClassName ThreadBinaryTree
 * @Author zzq
 * @Date 2020/8/6 10:16
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNode1 node1 = new HeroNode1(1, "tom");
        HeroNode1 node2 = new HeroNode1(3, "jack");
        HeroNode1 node3 = new HeroNode1(6, "smith");
        HeroNode1 node4 = new HeroNode1(8, "mary");
        HeroNode1 node5 = new HeroNode1(10, "king");
        HeroNode1 node6 = new HeroNode1(14, "dim");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTreeDemo threadedBinaryTreeDemo = new ThreadedBinaryTreeDemo(node1);
        threadedBinaryTreeDemo.threadedNode();

//        HeroNode1 left = node5.getLeft();
//        System.out.println(left);
//        HeroNode1 right = node5.getRight();
//        System.out.println(right);
        System.out.println("遍历线索化二叉树：");
        threadedBinaryTreeDemo.threadedList();
    }

    /**
     * @Description 线索二叉树结构
     * @ClassName ThreadedBinaryTreeDemo
     * @Author zzq
     * @Date 2020/8/6 10:35
     */
    static class ThreadedBinaryTreeDemo {  //线索化二叉树
        private HeroNode1 root;
        private HeroNode1 pre;  //默认为null，总是指向node的前一个节点

        public ThreadedBinaryTreeDemo(HeroNode1 root) {
            this.root = root;
        }

        public void threadedNode() {
            threadedNode(root);
        }

        /**
         * @Description 中序线索化二叉树
         * @Param [node]
         * @Return void
         * @Author zzq
         * @Date 2020/8/6 14:32
         */
        public void threadedNode(HeroNode1 node) {  //node为需要线索化的节点
            if (node == null)
                return;
            threadedNode(node.getLeft());   //线索化左子树
            if (node.getLeft() == null) {
                node.setLeft(pre);      //设置当前节点的左指针指向前驱结点
                node.setLeftType(1);    //修改当前节点的左指针类型
            }
            if (pre != null && pre.getRight() == null) {
                pre.setRight(node);     //设置前驱节点的右指针指向当前节点
                pre.setRightType(1);    //修改前驱节点的右指针类型
            }
            pre = node; //每处理一个节点后，让当前节点成为下一个节点的前驱节点
            threadedNode(node.getRight());  //线索化右子树
        }

        /**
         * @Description 遍历线索化二叉树
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/6 14:33
         */
        public void threadedList() {
            HeroNode1 node = root;  //存放当前节点的变量
            while (node != null) {
                while (node.getLeftType() == 0)     //找到左子树中第一个leftType=1的节点
                    node = node.getLeft();
                System.out.println(node);
                while (node.getRightType() == 1) {   //继续从这个节点获取后续节点
                    node = node.getRight();
                    System.out.println(node);
                }
                node = node.getRight(); //当找到没有后继节点时候直接下一个
            }
        }

        /**
         * @Description 对二叉树进行前序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 17:08
         */
        public void preOrder() {
            if (this.root != null)
                this.root.preOrder();
            else
                System.out.println("当前二叉树为空");
        }

        /**
         * @Description 对二叉树进行中序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 17:08
         */
        public void midOrder() {
            if (this.root != null)
                this.root.midOrder();
            else
                System.out.println("当前二叉树为空");
        }

        /**
         * @Description 对二叉树进行后序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 17:08
         */
        public void postOrder() {
            if (this.root != null)
                this.root.postOrder();
            else
                System.out.println("当前二叉树为空");
        }

        /**
         * @Description 前序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 17:08
         */
        public HeroNode1 preOrderSearch(int id) {
            if (this.root != null)
                return this.root.preOrderSearch(id);
            else
                return null;
        }

        /**
         * @Description 中序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 17:09
         */
        public HeroNode1 midOrderSearch(int id) {
            if (this.root != null)
                return this.root.midOrderSearch(id);
            else
                return null;
        }

        /**
         * @Description 后序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 17:09
         */
        public HeroNode1 postOrderSearch(int id) {
            if (this.root != null)
                return this.root.postOrderSearch(id);
            else
                return null;
        }

        /**
         * @Description 按照id删除节点
         * @Param [id]
         * @Return void
         * @Author zzq
         * @Date 2020/8/6 10:36
         */
        public void deleteNode(int id) {
            if (root != null) {
                if (root.getId() == id) {   //如果二叉树只有一个节点，判断是否需要删除
                    root = null;
                } else {
                    this.root.delete(id);
                }
            } else {
                System.out.println("当前二叉树为空");
            }
        }
    }

    /**
     * @Description 线索节点
     * @ClassName HeroNode1
     * @Author zzq
     * @Date 2020/8/6 10:35
     */
    static class HeroNode1 {
        private int id;
        private String name;
        private HeroNode1 left;
        private HeroNode1 right;
        private int leftType;   //如果为0，表示节点指向左子树；如果为1，表示节点指向前驱节点
        private int rightType;  //如果为0，表示节点指向右子树；如果为1，表示节点指向后继节点

        public HeroNode1(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode1 getLeft() {
            return left;
        }

        public void setLeft(HeroNode1 left) {
            this.left = left;
        }

        public HeroNode1 getRight() {
            return right;
        }

        public void setRight(HeroNode1 right) {
            this.right = right;
        }

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        /**
         * @Description 前序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 10:50
         */
        public void preOrder() {
            System.out.println(this);   //先输出父结点
            if (this.left != null)   //如果左子树不为空，左递归
                this.left.preOrder();
            if (this.right != null)  //如果右子树不为空，右递归
                this.right.preOrder();
        }

        /**
         * @Description 中序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 10:53
         */
        public void midOrder() {
            if (this.left != null)   //如果左子树不为空，左递归
                this.left.midOrder();
            System.out.println(this);   //先输出父结点
            if (this.right != null)  //如果右子树不为空，右递归
                this.right.midOrder();
        }

        /**
         * @Description 后序遍历
         * @Param null
         * @Return void
         * @Author zzq
         * @Date 2020/8/5 10:54
         */
        public void postOrder() {
            if (this.left != null)   //如果左子树不为空，左递归
                this.left.postOrder();
            if (this.right != null)  //如果右子树不为空，右递归
                this.right.postOrder();
            System.out.println(this);   //输出父结点
        }

        /**
         * @Description 前序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 16:06
         */
        public HeroNode1 preOrderSearch(int id) {
            System.out.println("前序查找");
            if (this.id == id)      //先判断当前节点是否为寻找的节点
                return this;
            HeroNode1 result = null;
            if (this.left != null)  //再判断左子节点是否为空，不为空向左递归
                result = this.left.preOrderSearch(id);
            if (result != null)      //判断遍历左节点后是否找到了目标
                return result;
            if (this.right != null) //最后判断右子节点是否为空，不为空向右递归
                result = this.right.preOrderSearch(id);
            return result;
        }

        /**
         * @Description 中序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 16:07
         */
        public HeroNode1 midOrderSearch(int id) {
            HeroNode1 result = null;
            if (this.left != null)  //判断左子节点是否为空，不为空向左递归
                result = this.left.midOrderSearch(id);
            if (result != null)     //判断遍历左节点后是否找到了目标
                return result;
            System.out.println("中序查找");
            if (this.id == id)      //再判断当前节点是否为寻找的节点
                return this;
            if (this.right != null) //最后判断右子节点是否为空，不为空向右递归
                result = this.right.midOrderSearch(id);
            return result;
        }

        /**
         * @Description 后序查找
         * @Param [id]
         * @Return tree.HeroNode
         * @Author zzq
         * @Date 2020/8/5 16:07
         */
        public HeroNode1 postOrderSearch(int id) {
            HeroNode1 result = null;
            if (this.left != null)  //判断左子节点是否为空，不为空向左递归
                result = this.left.postOrderSearch(id);
            if (result != null)     //判断遍历左节点后是否找到了目标
                return result;
            if (this.right != null) //再判断右子节点是否为空，不为空向右递归
                result = this.right.postOrderSearch(id);
            if (result != null)     //判断遍历右节点后是否找到了目标
                return result;
            System.out.println("后序查找");
            if (this.id == id)      //最后判断当前节点是否为寻找的节点
                return this;
            return null;
        }

        /**
         * @Description 删除节点，连同子树一起删除
         * @Param [id]
         * @Return void
         * @Author zzq
         * @Date 2020/8/6 10:30
         */
        public void delete(int id) {
            if (this.left != null && this.left.id == id) {      //左子节点不为空并且就是要删除的节点
                this.left = null;   //左子节点置空
                return;
            }
            if (this.right != null && this.right.id == id) {    //右子节点不为空并且就是要删除的节点
                this.right = null;  //右子节点置空
                return;
            }
            if (this.left != null) {     //向左递归
                this.left.delete(id);
            }
            if (this.right != null) {    //向右递归
                this.right.delete(id);
            }
        }
    }
}

