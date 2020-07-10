package classes1;

/**
 * @author zzq
 * @creat 2020-06-03 16:54
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation("abc")
    private Person(String name) {
        this.name = name;
    }

    Person(int age, int id) {
        this.age = age;
        this.id = id;
    }

    public String display(String interests, int age) {
        return interests + age;
    }

    @MyAnnotation("!@#")
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public void info() throws NullPointerException, ClassCastException {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
