package singleton;

/**
 * @Description 懒汉式：同步方法（线程安全，效率低，不推荐）
 * @ClassName Type4
 * @Author zzq
 * @Date 2020/9/14 16:44
 */
public class Type4 {
    public static void main(String[] args) {
        Single4 instance1 = Single4.getInstance();
        Single4 instance2 = Single4.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single4 {
    private static Single4 instance;

    private Single4() {
        super();
    }

    /**
     * @Description 加入了synchronized后将线程锁起来，保证单例模式的正确性
     * @Param []
     * @Return singleton.Single4
     * @Author zzq
     * @Date 2020/9/14 16:49
     */
    public static synchronized Single4 getInstance() {
        if (instance == null)
            return instance = new Single4();
        else
            return instance;
    }
}
