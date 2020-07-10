package exer1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author zzq
 * @creat 2020-05-31 16:06
 */
public class Test1 {

    @Test
    public void test1() {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (String s : strings) {
            System.out.println(s);
        }
        for (Integer i : values) {
            System.out.println(i);
        }
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e);
        }
    }


    @Test
    public void test2() {
        List<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }


//    @Test
//    public ArrayList<String> test3() {

//        public List<String> getList(HashMap<String, String> map){
//            ArrayList<String> strings = new ArrayList<>();
//            Collection<String> values = map.values();
//            for(String s : values){
//                strings.add(s);
//            }
//            return strings;
//        }
//    }


    @Test
    public void test4() throws IOException {
        File file = new File("F:\\173\\313\\zzq\\a.txt");
        File file1 = new File(file.getParent(), "b.txt");
        file1.createNewFile();
    }
}
