package exer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq
 * @creat 2020-05-28 16:49
 */
public class ListExer {
    /*
        区分List中remove(int index)和remove(Object obj)
    */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
        list.remove(2);
//        list.remove(Integer.valueOf(2));
    }
}
