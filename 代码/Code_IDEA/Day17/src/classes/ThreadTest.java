package classes;

/**
 * 多线程的创建
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run()方法 --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()方法
 * <p>
 * 例：遍历100以内的所有偶数
 *
 * @author zzq
 * @creat 2020-05-23 16:14
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4. 通过此对象调用start()方法：①启动当前线程；②调用当前线程的run()方法
        t1.start();

        //问题一：我们不能通过直接调用run()的方式启动线程。
//        t1.run();

        //问题二：再启动一个线程，遍历100以内的偶数。不可以让已经start()的线程去执行。会报IllegalThreadStateException异常
//        t1.start();
        //需要重新创建一个对象
        MyThread t2 = new MyThread();
        t2.start();

        //仍然在主线程(main)中执行的
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1)
                System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
