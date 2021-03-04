package com.zzq.pojo;

/**
 * @Description 人
 * @ClassName Person
 * @Author zzq
 * @Date 2021/2/17 15:09
 */
public class Person {
    private Integer ID;
    private String name;

    public Person() {
    }

    public Person(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
