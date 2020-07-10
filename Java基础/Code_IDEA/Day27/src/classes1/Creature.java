package classes1;

import java.io.Serializable;

/**
 * @author zzq
 * @creat 2020-06-03 16:54
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    public void eat(){
        System.out.println("生物进食");
    }

    private void breath(){
        System.out.println("生物呼吸");
    }
}
