package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description User实体类
 * @ClassName User
 * @Author zzq
 * @Date 2021/7/1 15:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;
}
