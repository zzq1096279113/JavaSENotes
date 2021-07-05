package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description Role实体类
 * @ClassName Role
 * @Author zzq
 * @Date 2021/6/27 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer id;   //id
    private String roleCode; //角色编码
    private String roleName; //角色名称
    private Integer createdBy; //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy; //更新者
    private Date modifyDate;//更新时间

}
