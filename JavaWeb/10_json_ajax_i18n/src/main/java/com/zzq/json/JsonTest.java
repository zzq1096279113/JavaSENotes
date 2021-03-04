package com.zzq.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzq.pojo.Person;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description json测试类
 * @ClassName JsonTest
 * @Author zzq
 * @Date 2021/2/17 15:10
 */
public class JsonTest {

    /**
     * @Description javaBean和json的互转
     * @Param []
     * @Return .
     * @Author zzq
     * @Date 2021/2/17 15:11
     */
    @Test
    public void test1(){
        Person person = new Person(1, "zzq");
        Gson gson = new Gson(); //创建Gson实例
        String personJsonToString = gson.toJson(person);  //toJson方法会把java对象转化为Json字符串
        System.out.println(personJsonToString);
        Person personStringToJson = gson.fromJson(personJsonToString, Person.class);    //将json字符串转化为特定类型
        System.out.println(personStringToJson);
    }

    /**
     * @Description List和Json的互转
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2021/2/17 15:18
     */
    @Test
    public void test2(){
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "zzq"));
        personList.add(new Person(2, "zzp"));
        personList.add(new Person(3, "zzm"));
        personList.add(new Person(4, "zzj"));

        Gson gson = new Gson();
        String toString = gson.toJson(personList);
        System.out.println(toString);

        ArrayList<Person> personArrayList = gson.fromJson(toString, new PersonListType().getType());
        for (Person p: personArrayList) {
            System.out.println(p);
        }
    }

    /**
     * @Description map和Json的互转
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2021/2/19 14:43
     */
    @Test
    public void test3(){
        HashMap<String, Person> stringPersonHashMap = new HashMap<>();
        stringPersonHashMap.put("001", new Person(1, "zzq"));
        stringPersonHashMap.put("002", new Person(2, "zzp"));
        stringPersonHashMap.put("003", new Person(3, "zzm"));
        stringPersonHashMap.put("004", new Person(4, "zzj"));

        Gson gson = new Gson();
        String mapToJson = gson.toJson(stringPersonHashMap);
        System.out.println(mapToJson);

//        HashMap<String, Person> stringToMap = gson.fromJson(mapToJson, new PersonMapType().getType());
        HashMap<String, Person> stringToMap = gson.fromJson(mapToJson, new TypeToken<HashMap<String, Person>>(){}.getType());
    }
}
