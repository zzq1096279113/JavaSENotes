package principle.segregation;

/**
 * @Description 接口隔离原则：未隔离
 * @ClassName Segregation
 * @Author zzq
 * @Date 2020/9/11 20:31
 */
public class Segregation1 {
    public static void main(String[] args) {

    }
}

/**
 * @Description 类A通过接口Interface1依赖B类，但是只会使用到1、2、3方法
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 20:37
 */
class A {
    public void depend1(Interface i) {
        i.operation1();
    }

    public void depend2(Interface i) {
        i.operation2();
    }

    public void depend3(Interface i) {
        i.operation3();
    }
}

class C {
    public void depend1(Interface i) {
        i.operation1();
    }

    public void depend4(Interface i) {
        i.operation4();
    }

    public void depend5(Interface i) {
        i.operation5();
    }
}

/**
 * @Description 类B实现了Interface1接口
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 20:38
 */
class B implements Interface {
    @Override
    public void operation1() {
        System.out.println("B实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B实现了operation5");
    }
}

/**
 * @Description 类D实现了Interface1接口
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 20:39
 */
class D implements Interface {
    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operation5");
    }
}

interface Interface {
    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}
