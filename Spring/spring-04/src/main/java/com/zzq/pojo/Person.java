package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @Description 人类
 * @ClassName Person
 * @Author zzq
 * @Date 2021/6/30 10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    @Resource(name = "cat1")
    private Cat cat;
    @Resource(name = "dog2")
    private Dog dog;

}
