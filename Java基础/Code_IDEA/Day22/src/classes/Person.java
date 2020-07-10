package classes;

import java.util.Objects;

/**
 * @author zzq
 * @creat 2020-05-27 11:09
 */
public class Person implements Comparable{
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals...");
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //按照姓名从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person person = (Person)o;
            if(this.name.equals(person.name)) {
                return Integer.compare(this.age,person.age);
            }else
                return this.name.compareTo(person.name);
        }else {
            throw new RuntimeException("输入类型错误");
        }
    }
}
