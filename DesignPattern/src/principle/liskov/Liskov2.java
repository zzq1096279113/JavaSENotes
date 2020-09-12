package principle.liskov;

/**
 * @Description 里氏替换原则：已改进
 * @ClassName Liskov2
 * @Author zzq
 * @Date 2020/9/12 11:31
 */
public class Liskov2 {
    public static void main(String[] args) {
        AA a = new AA();
        System.out.println("11 + 3 = " + a.func1(11, 3));
        System.out.println("22 - 13 = " + a.func2(22, 13));
        BB b = new BB();
        System.out.println("1 * 8 = " + b.func1(1, 8));
        System.out.println("11 / 9 = " + b.func3(11, 9));
    }
}

/**
 * @Description 将B提升到与A同一级别，使得两者同时继承同一父类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 15:14
 */
class Base{
    public int func2(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * @Description 继承Base类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 11:34
 */
class AA extends Base{
    public int func1(int num1, int num2) {
        return num1 + num2;
    }
}

/**
 * @Description 继承Base类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 11:34
 */
class BB extends Base {
    public int func1(int num1, int num2) {
        return num1 * num2;
    }

    public int func3(int num1, int num2) {
        return num1 / num2;
    }
}

