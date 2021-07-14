package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description User类
 * @ClassName User
 * @Author zzq
 * @Date 2021/6/30 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    @Value("zzq")
    private String name;
    @Value("12")
    private int age;

}
