package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 学生类
 * @ClassName Student
 * @Author zzq
 * @Date 2021/6/25 20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private Teacher teacher;

}
