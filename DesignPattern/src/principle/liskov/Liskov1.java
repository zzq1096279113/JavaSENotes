package principle.liskov;

/**
 * @Description 里氏替换原则
 * @ClassName Liskov1
 * @Author zzq
 * @Date 2020/9/12 11:22
 */
public class Liskov1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 + 3 = " + a.func1(11, 3));
        System.out.println("22 - 13 = " + a.func2(22, 13));
        B b = new B();
        System.out.println("1 * 8 = " + b.func1(1, 8));
        System.out.println("11 / 9 = " + b.func3(11, 9));
    }
}

/**
 * @Description 父类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 11:34
 */
class A {
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * @Description 父类为A，新添加方法func3，修改方法func1
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 11:34
 */
class B extends A {
    public int func1(int num1, int num2) {
        return num1 * num2;
    }

    public int func3(int num1, int num2) {
        return num1 / num2;
    }
}


