package com.zzq.mapper;

import com.zzq.pojo.Student;

import java.util.List;

/**
 * @Description 学生Mapper
 * @ClassName StudentMapper
 * @Author zzq
 * @Date 2021/6/25 20:45
 */
public interface StudentMapper {

    /**
     * @Description 查询所有学生
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Student>
     * @Author zzq
     * @Date 2021/6/26 10:09
     */
    List<Student> getAllStudent();

    /**
     * @Description 获得学生老师信息
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Student>
     * @Author zzq
     * @Date 2021/6/25 21:12
     */
    List<Student> getStudentAndTeacher();

}
