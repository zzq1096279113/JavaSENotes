package queue;

import java.util.Scanner;

/**
 * @author zzq
 * @creat 2020-06-03 17:09
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("*****数组模拟队列*****");
        ArrayQueue arrayQueue = new ArrayQueue(5);
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
                    arrayQueue.showQueue();
                    System.out.println();
                    break;
                case 'a':
                    System.out.print("请输入一个整数：");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出数据为：" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("队列头数据为：" + head);
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

//使用数组模拟类
class ArrayQueue {

    private int maxSize;//数组最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private int[] arr;//存放数据的数组

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部：指向队列头的前一个位置
        rear = -1;//指向队列尾部：指向队列尾部的位置
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列（入队列）
    public void addQueue(int n) {
        if (isFull()) {     //先判断队列是否已满
            System.out.println("队列已满");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;  //赋值
    }

    //从队列取数据（出队列）
    public int getQueue() {
        if (isEmpty()) {    //先判断队列是否为空
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] = " + arr[i] + "  ");
        }
    }

    //显示队列头数据（不取数据，只显示）
    public int headQueue() {
        if (isEmpty()) {
            //先判断队列是否为空
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
