package stack;

import java.util.Scanner;

/**
 * @Description 使用数组模拟栈
 * @ClassName ArrayStack
 * @Author zzq
 * @Date 2020/7/28 16:30
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        char key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println();
            System.out.println("a: 入栈");
            System.out.println("p: 出栈");
            System.out.println("s: 显示栈");
            System.out.println("e: 退出程序");
            System.out.print("请输入指令：");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayStack.show();
                    break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case 'p':
                    try {
                        int result = arrayStack.pop();
                        System.out.println("出栈数据为：" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("请输入正确的指令!");
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack {
    private int maxSize;    //栈的大小
    private int[] array;    //数据放在该数组中
    private int top = -1;   //默认栈顶为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    /**
     * @Description 入栈操作
     * @Param [value]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 16:40
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;  //栈顶向上移
        array[top] = value; //将数据放入栈顶
    }

    /**
     * @Description 出栈操作
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/7/28 16:41
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = array[top]; //保存栈顶的数据
        top--;  //移动栈顶
        return value;   //返回栈顶的数据
    }

    /**
     * @Description 遍历显示栈中数据
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 16:47
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {    //从栈顶向下遍历直到索引为0
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }

    /**
     * @Description 判断栈是否已满
     * @Param null
     * @Return boolean
     * @Author zzq
     * @Date 2020/7/28 16:37
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * @Description 判断栈是否为空
     * @Param []
     * @Return boolean
     * @Author zzq
     * @Date 2020/7/28 16:38
     */
    public boolean isEmpty() {
        return top == -1;
    }

}