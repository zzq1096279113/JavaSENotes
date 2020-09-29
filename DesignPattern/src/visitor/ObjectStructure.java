package visitor;

import java.util.LinkedList;

/**
 * @Description 人的集合
 * @ClassName ObjectStructure
 * @Author zzq
 * @Date 2020/9/28 22:48
 */
public class ObjectStructure {
    private LinkedList<Person> persons = new LinkedList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public void remove(Person person) {
        persons.remove(person);
    }

    public void show() {
        for (Person p : persons)
            System.out.println(p.speak);
    }
}
