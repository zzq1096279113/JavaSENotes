package singleton;

/**
 * @Description 双重检查（线程安全，效率较高，推荐使用）
 * @ClassName Type6
 * @Author zzq
 * @Date 2020/9/14 16:47
 */
public class Type6 {
    public static void main(String[] args) {
        Single6 instance1 = Single6.getInstance();
        Single6 instance2 = Single6.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single6 {
    private static volatile Single6 instance;

    private Single6() {
        super();
    }

    /**
     * @Description 双重检查：将通过第一个条件的多个线程处理
     * @Param []
     * @Return singleton.Single6
     * @Author zzq
     * @Date 2020/9/14 17:14
     */
    public static synchronized Single6 getInstance() {
        if (instance == null) {     //第一次检查：判断是否已经创建实例
            synchronized (Single6.class) {      //将代码锁住，防止多线程同时执行
                if (instance == null)       //第二次检查：判断是否在其他线程已经创建实例
                    instance = new Single6();
            }
        }
        return instance;
    }
}