package singleton;

/**
 * @Description 饿汉式：静态代码块（与静态常量一样）
 * @ClassName Type2
 * @Author zzq
 * @Date 2020/9/14 12:10
 */
public class Type2 {
    public static void main(String[] args) {
        Single2 instance1 = Single2.getInstance();
        Single2 instance2 = Single2.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single2 {
    private static final Single2 instance;

    static {    //在静态代码块中创建单例对象
        instance = new Single2();
    }

    private Single2() {     //私有化构造器
        super();
    }

    public static Single2 getInstance() {
        return instance;
    }
}

