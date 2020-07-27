package queue;

import java.util.Scanner;

/**
 * @author zzq
 * @creat 2020-06-04 14:39
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("****数组模拟环形队列****");
        CircleArray array = new CircleArray(4);
        Scanner scanner = new Scanner(System.in);
        char c = 0;
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("e(exit): 退出程序");
            c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    array.showQueue();
                    System.out.println();
                    break;
                case 'a':
                    System.out.print("请输入一个整数：");
                    int i = scanner.nextInt();
                    array.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = array.getQueue();
                        System.out.println("取出数据为：" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i1 = array.headQueue();
                        System.out.println("队列头数据为：" + i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}

class CircleArray {

    private int maxSize;//数组最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private int[] arr;//存放数据的数组

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头的位置
        rear = 0;//指向队列尾部后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {     //先判断队列是否满
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;  //赋值，考虑取模
        rear = (rear + 1) % maxSize;    //将rear后移
    }

    //从队列取数据
    public int getQueue() {
        if (isEmpty()) {    //先判断队列是否为空
            throw new RuntimeException("队列为空");
        }
        int value = arr[front]; //保存front对应的值保存
        front = (front + 1) % maxSize;  //修改front,考虑取模
        return value;   //返回值
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //从front考试遍历
        for (int i = front; i < (front + size()); i++) {
            System.out.println("arr[" + (i % maxSize) + "] = " + arr[(i % maxSize)]);
        }
    }

    //显示队列头数据（不是取数据，只是显示）
    public int headQueue() {
        //先判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    //当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}