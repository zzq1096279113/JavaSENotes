package tree;

/**
 * @Description 二叉树结构
 * @ClassName BinaryTreeDemo
 * @Author zzq
 * @Date 2020/8/5 16:13
 */
class BinaryTreeDemo {
    private HeroNode root;

    public BinaryTreeDemo(HeroNode root) {
        this.root = root;
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
    public HeroNode preOrderSearch(int id) {
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
    public HeroNode midOrderSearch(int id) {
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
    public HeroNode postOrderSearch(int id) {
        if (this.root != null)
            return this.root.postOrderSearch(id);
        else
            return null;
    }

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
