package singleton;

/**
 * @Description 懒汉式：同步代码块（错误，可能会出现多个实例）
 * @ClassName Type5
 * @Author zzq
 * @Date 2020/9/14 16:47
 */
public class Type5 {
    public static void main(String[] args) {
        Single5 instance1 = Single5.getInstance();
        Single5 instance2 = Single5.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single5 {
    private static Single5 instance;

    private Single5() {
        super();
    }

    /**
     * @Description 将同步功能缩小到代码块中，但是无意义。因为如果多线程同时进入if条件中，还是会创建多个实例
     * @Param []
     * @Return singleton.Single4
     * @Author zzq
     * @Date 2020/9/14 16:49
     */
    public static synchronized Single5 getInstance() {
        if (instance == null) {
            synchronized (Single5.class) {      //将代码锁住
                return instance = new Single5();
            }
        } else
            return instance;
    }
}