package principle.segregation;

/**
 * @Description 接口隔离原则2
 * @ClassName Segregation2
 * @Author zzq
 * @Date 2020/9/11 20:43
 */
public class Segregation2 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.depend1(new BB());   //AA类通过接口依赖（使用）BB类
        aa.depend2(new BB());
        aa.depend3(new BB());

        CC cc = new CC();
        cc.depend1(new DD());   //CC类通过接口依赖（使用）DD类
        cc.depend4(new DD());
        cc.depend5(new DD());
    }
}

class AA {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

class CC {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}

class BB implements Interface1, Interface2 {
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
}

class DD implements Interface1, Interface3 {
    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
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

/*
    将Interface接口拆分为三个接口，类AA和类CC分别与需要的接口建立依赖关系。
*/
interface Interface1 {
    void operation1();
}

interface Interface2 {
    void operation2();

    void operation3();
}

interface Interface3 {
    void operation4();

    void operation5();
}


