package classes;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * @author zzq
 * @creat 2020-05-24 16:11
 */
class Window3 extends Thread {

    private static int ticket = 100;
//    static Object o = new Object();

    public Window3(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show(){//同步监视器：Window3.class
        if (ticket > 0) {
            try {
                sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "， 票号为：" + ticket);
            ticket--;
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3("窗口1");
        Window3 w2 = new Window3("窗口2");
        Window3 w3 = new Window3("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}