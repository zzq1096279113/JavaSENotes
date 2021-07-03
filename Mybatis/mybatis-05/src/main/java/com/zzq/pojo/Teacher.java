package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 教师类
 * @ClassName Teacher
 * @Author zzq
 * @Date 2021/6/25 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    private List<Student> students;

}
