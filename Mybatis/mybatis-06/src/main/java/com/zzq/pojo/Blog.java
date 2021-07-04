package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description Blog类
 * @ClassName Blog
 * @Author zzq
 * @Date 2021/6/26 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}
