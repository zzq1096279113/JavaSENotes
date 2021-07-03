package com.zzq.mapper;

import com.zzq.pojo.Teacher;

import java.util.List;

/**
 * @Description 教师Mapper
 * @ClassName TeacherMapper
 * @Author zzq
 * @Date 2021/6/25 20:45
 */
public interface TeacherMapper {

    /**
     * @Description 查询所有教师
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Teacher>
     * @Author zzq
     * @Date 2021/6/26 10:09
     */
    List<Teacher> getAllTeacher();

    /**
     * @Description 查询老师对应的所有学生信息
     * @Param []
     * @Return com.zzq.pojo.Teacher
     * @Author zzq
     * @Date 2021/6/26 10:27
     */
    Teacher getTeacherAndStudent();
}
