package tree;

/**
 * @Description 数组转二叉树
 * @ClassName ArrayBinary
 * @Author zzq
 * @Date 2020/8/6 8:59
 */
public class ArrayBinary {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.print("前序遍历：");
        arrayBinaryTree.preOrder();
        System.out.println();
        System.out.print("中序遍历：");
        arrayBinaryTree.midOrder();
        System.out.println();
        System.out.print("后序遍历：");
        arrayBinaryTree.postOrder();
        System.out.println();
    }
}

class ArrayBinaryTree {
    private int[] arr;  //存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void midOrder() {
        this.midOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * @Description 对数组从index处开始前序遍历
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 9:18
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历");
            return;
        }
        System.out.print(arr[index]);         //打印出当前元素
        if ((2 * index + 1) < arr.length)       //向左递归遍历
            preOrder(2 * index + 1);
        if ((2 * index + 2) < arr.length)       //向右递归遍历
            preOrder(2 * index + 2);
    }

    /**
     * @Description 对数组从index处开始中序遍历
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 9:25
     */
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能中序遍历");
            return;
        }
        if ((2 * index + 1) < arr.length)       //向左递归遍历
            midOrder(2 * index + 1);
        System.out.print(arr[index]);         //打印出当前元素
        if ((2 * index + 2) < arr.length)       //向右递归遍历
            midOrder(2 * index + 2);
    }

    /**
     * @Description 对数组从index处开始后序遍历
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/8/6 9:26
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能后序遍历");
            return;
        }
        if ((2 * index + 1) < arr.length)       //向左递归遍历
            postOrder(2 * index + 1);
        if ((2 * index + 2) < arr.length)       //向右递归遍历
            postOrder(2 * index + 2);
        System.out.print(arr[index]);         //打印出当前元素
    }
}