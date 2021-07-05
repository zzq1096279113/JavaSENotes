package com.zzq.mapper;

import com.zzq.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @ClassName ProviderMapper
 * @Author zzq
 * @Date 2021/6/27 15:58
 */
public interface ProviderMapper {

    /**
     * @Description 增加用户信息
     * @Param [provider]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public void add(Provider provider);

    /**
     * @Description 通过条件查询providerList
     * @Param [proName, proCode, currentPageNo, pageSize]
     * @Return java.util.List<com.zzq.pojo.Provider>
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public List<Provider> getProviderList(@Param("proName") String proName,
                                          @Param("proCode") String proCode,
                                          @Param("from") Integer currentPageNo,
                                          @Param("pageSize") Integer pageSize);

    /**
     * @Description 获取供应商列表
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Provider>
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public List<Provider> getProList();

    /**
     * @Description 通过条件查询供应商记录数
     * @Param [proName, proCode]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public int getProviderCount(@Param("proName") String proName,
                                @Param("proCode") String proCode);

    /**
     * @Description 通过供应商Id删除供应商信息
     * @Param [delId]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public void deleteProviderById(@Param("id") Integer delId);

    /**
     * @Description 根据供应商Id获取供应商信息
     * @Param [id]
     * @Return com.zzq.pojo.Provider
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public Provider getProviderById(@Param("id") Integer id);

    /**
     * @Description 修改供应商
     * @Param [provider]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:59
     */
    public void modify(Provider provider);

}
