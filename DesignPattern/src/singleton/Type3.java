package singleton;

/**
 * @Description 懒汉式：线程不安全（不要使用此方法）
 * @ClassName Type3
 * @Author zzq
 * @Date 2020/9/14 16:36
 */
public class Type3 {
    public static void main(String[] args) {
        Single3 instance1 = Single3.getInstance();
        Single3 instance2 = Single3.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Single3 {
    private static Single3 instance;

    private Single3() {
        super();
    }

    public static Single3 getInstance() {   //当调用方法时，才创建对象
        if(instance == null)
            return instance = new Single3();
        else
            return instance;
    }
}
