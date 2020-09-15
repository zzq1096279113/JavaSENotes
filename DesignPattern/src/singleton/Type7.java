package singleton;

/**
 * @Description 静态内部类（推荐使用）
 * @ClassName Type7
 * @Author zzq
 * @Date 2020/9/14 18:27
 */
public class Type7 {
    public static void main(String[] args) {
        Single7 instance1 = Single7.getInstance();
        Single7 instance2 = Single7.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single7 {

    private Single7() {
        super();
    }

    /**
     * @Description 静态内部类：不随类的加载而加载，只有使用到类内的成员时，才会加载
     * @Param
     * @Return
     * @Author zzq
     * @Date 2020/9/14 18:31
     */
    private static class Single7Instance{
        private static final Single7 INSTANCE = new Single7();
    }

    /**
     * @Description 加载静态内部类时候是进程安全的。在用到静态内部类时，才会将类内部的静态属性加载
     * @Param []
     * @Return singleton.Single7
     * @Author zzq
     * @Date 2020/9/14 18:35
     */
    public static Single7 getInstance(){
        return Single7Instance.INSTANCE;
    }
}
