package exer;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author zzq
 * @creat 2020-05-27 10:46
 */
public class Test1 {

    @Test
    public void test1() {
        String s = "2017-08-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2017-08-16");
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Person[] p = new Person[4];
        p[0] = new Person("Tom",12);
        p[1] = new Person("Jerry",10);
        p[2] = new Person("zzp",21);
        p[3] = new Person("zzq",18);
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() > o2.getAge()) {
                    return 1;
                } else if(o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(p));
    }
}
