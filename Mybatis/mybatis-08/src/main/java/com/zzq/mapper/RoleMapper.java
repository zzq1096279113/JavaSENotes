package com.zzq.mapper;

import com.zzq.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @ClassName RoleMapper
 * @Author zzq
 * @Date 2021/6/27 16:01
 */
public interface RoleMapper {

    /**
     * @Description 获取角色列表
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Role>
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public List<Role> getRoleList();

    /**
     * @Description 增加角色信息
     * @Param [role]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public int add(Role role);

    /**
     * @Description 通过Id删除Role
     * @Param [delId]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public void deleteRoleById(@Param("id") Integer delId);

    /**
     * @Description 修改角色信息
     * @Param [role]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public void modify(Role role);

    /**
     * @Description 通过Id获取role
     * @Param [id]
     * @Return com.zzq.pojo.Role
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public Role getRoleById(@Param("id") Integer id);

    /**
     * @Description 根据roleCode，进行角色编码的唯一性验证
     * @Param [roleCode]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:02
     */
    public int roleCodeIsExist(@Param("roleCode") String roleCode);

}
