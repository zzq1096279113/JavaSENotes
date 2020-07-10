package classes;

/**
 * @author zzq
 * @creat 2020-06-03 13:33
 */
public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("Person()");
    }

    private Person(String name) {
        this.name = name;
        System.out.println("private Person()");
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
