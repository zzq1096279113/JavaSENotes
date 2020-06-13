package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 *
 * @author zzq
 * @creat 2020-05-30 16:38
 */
public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);

        //建议：实例化时指明类的泛型
        Order<String> stringOrder = new Order<>("orderAA",1001,"orderAA:1001");
        stringOrder.setOrderT("1001:AA");
        System.out.println(stringOrder);
    }


    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(1122);

        SubOrder<String> stringSubOrder = new SubOrder<>();
        stringSubOrder.setOrderT("1321");
    }


    @Test
    public void test3() {

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;
    }
}
