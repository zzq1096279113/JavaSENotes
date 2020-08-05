package tree;

/**
 * @Description 节点
 * @ClassName HeroNode
 * @Author zzq
 * @Date 2020/8/5 16:13
 */
class HeroNode {
    private int id;
    private String name;
    private HeroNode left;  //默认null
    private HeroNode right; //默认null

    public HeroNode(int id, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
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
    public HeroNode preOrderSearch(int id) {
        System.out.println("前序查找");
        if (this.id == id)      //先判断当前节点是否为寻找的节点
            return this;
        HeroNode result = null;
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
    public HeroNode midOrderSearch(int id) {
        HeroNode result = null;
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
    public HeroNode postOrderSearch(int id) {
        HeroNode result = null;
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
