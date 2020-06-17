package classes4;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 *
 * 常用的方法：ofNullable(T t)、orElse(T t)
 *
 * @author zzq
 * @creat 2020-06-08 8:31
 */
public class OptionalTest {
    /*
        Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional.empty() : 创建一个空的 Optional 实例
        Optional.ofNullable(T t)：t可以为null
    */
    @Test
    public void test1(){
        Girl girl = new Girl();
        //Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional<Girl> girl1 = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //Optional.ofNullable(T t)：t可以为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);

        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl girl2 = girl1.orElse(new Girl("迪丽热巴"));
        System.out.println(girl2);
    }



    @Test
    public void test3(){
//        Boy boy = null;
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName():
    public String getGirlName(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时boy2一定非空
        Boy boy2 = boy1.orElse(new Boy(new Girl("大力")));
        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        //此时girl2一定非空
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));
        return girl2.getName();
    }

}
