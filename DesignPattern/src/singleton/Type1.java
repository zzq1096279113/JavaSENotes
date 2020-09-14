package singleton;

/**
 * @Description 饿汉式：静态常量（可用，但是可能会浪费内存）
 * @ClassName Type1
 * @Author zzq
 * @Date 2020/9/14 11:13
 */
public class Type1 {
    public static void main(String[] args) {
        Single1 instance1 = Single1.getInstance();
        Single1 instance2 = Single1.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single1 {
    private static final Single1 instance = new Single1();

    private Single1() {     //私有化构造器
        super();
    }

    public static Single1 getInstance() {
        return instance;
    }
}
