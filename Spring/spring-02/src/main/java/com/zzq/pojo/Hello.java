package com.zzq.pojo;

/**
 * @Description Hello类
 * @ClassName Hello
 * @Author zzq
 * @Date 2021/6/29 10:11
 */
public class Hello {

    private String name;

//    public Hello() {
//        System.out.println("Hello无参构造器");
//    }

    public Hello(String name) {
        System.out.println("Hello有参构造器");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Hello的setName方法");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
