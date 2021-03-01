package com.zzq.EL_JSTL.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName Person
 * @Author zzq
 * @Date 2021/2/2 11:06
 */
public class Person {
    private String name;
    private int age;
    private String[] phones;
    private List<String> cities;
    private Map<String, Object> map;

    public Person() {
    }

    public Person(String name, int age, String[] phones, List<String> cities, Map<String, Object> map) {
        this.name = name;
        this.age = age;
        this.phones = phones;
        this.cities = cities;
        this.map = map;
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

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
