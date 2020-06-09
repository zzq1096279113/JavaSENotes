package classes;

/**
 * 例：创建三个窗口卖票，总票数为100。
 *
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用"当前类.class"充当同步监视器。
 *
 * @author zzq
 * @creat 2020-05-24 10:05
 */
class Window extends Thread {

    private static int ticket = 100;
//    static Object o = new Object();

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            //synchronized(o){
            synchronized(Window.class) {
                if (ticket > 0) {
                    try {
                        sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "， 票号为：" + ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }

}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");
        Window w3 = new Window("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
