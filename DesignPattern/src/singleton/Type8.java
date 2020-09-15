package singleton;

/**
 * @Description 枚举（推荐使用）
 * @ClassName Type8
 * @Author zzq
 * @Date 2020/9/14 18:40
 */
public class Type8 {
    public static void main(String[] args) {
        Single8 instance1 = Single8.INSTANCE;
        Single8 instance2 = Single8.INSTANCE;
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        instance1.sayOK();
        instance2.sayOK();
    }
}

enum Single8 {
    INSTANCE;

    public void sayOK() {
        System.out.println("OK!!!");
    }
}
