package tree;

/**
 * @Description 二叉树
 * @ClassName BinaryTree
 * @Author zzq
 * @Date 2020/8/5 10:43
 */
public class BinaryTree {
    public static void main(String[] args) {
        //建立二叉树关系
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //创建二叉树
        BinaryTreeDemo binaryTreeDemo = new BinaryTreeDemo(node1);

//        //前序遍历打印
//        System.out.println("前序遍历为：");
//        binaryTreeDemo.preOrder();
//        System.out.println();
//
//        //中序遍历打印
//        System.out.println("中序遍历为：");
//        binaryTreeDemo.midOrder();
//        System.out.println();
//
//        //后序遍历打印
//        System.out.println("后序遍历为：");
//        binaryTreeDemo.postOrder();

//        //前序查找
//        HeroNode heroNode = binaryTreeDemo.preOrderSearch(5);
//        System.out.println(heroNode);
//        //中序查找
//        HeroNode heroNode = binaryTreeDemo.midOrderSearch(5);
//        System.out.println(heroNode);
//        //后序查找
//        HeroNode heroNode = binaryTreeDemo.postOrderSearch(99);
//        System.out.println(heroNode);

        System.out.println("删除前：");
        binaryTreeDemo.preOrder();
        binaryTreeDemo.deleteNode(5);
        System.out.println("删除后：");
        binaryTreeDemo.preOrder();
    }
}

