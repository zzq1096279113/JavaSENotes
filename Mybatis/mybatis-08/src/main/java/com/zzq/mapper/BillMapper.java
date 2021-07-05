package com.zzq.mapper;

import com.zzq.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @ClassName BillMapper
 * @Author zzq
 * @Date 2021/6/27 15:54
 */
public interface BillMapper {

    /**
     * @Description 根据供应商Id查询订单数量
     * @Param [providerId]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:55
     */
    public int getBillCountByProviderId(@Param("providerId") Integer providerId);

    /**
     * @Description 增加订单
     * @Param [bill]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:55
     */
    public void add(Bill bill);

    /**
     * @Description 通过查询条件获取供应商列表-getBillList
     * @Param [productName, providerId, isPayment, from, pageSize]
     * @Return java.util.List<com.zzq.pojo.Bill>
     * @Author zzq
     * @Date 2021/6/27 15:55
     */
    public List<Bill> getBillList(@Param("productName") String productName,
                                  @Param("providerId") String providerId,
                                  @Param("isPayment") String isPayment);

    /**
     * @Description 通过条件查询，查询供货商数量
     * @Param [productName, providerId, isPayment]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:55
     */
    public int getBillCount(@Param("productName") String productName,
                            @Param("providerId") String providerId,
                            @Param("isPayment") String isPayment);

    /**
     * @Description 通过delId删除Bill
     * @Param [id]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:56
     */
    public void deleteBillById(@Param("id") Integer id);

    /**
     * @Description 通过billId获取Bill
     * @Param [id]
     * @Return com.zzq.pojo.Bill
     * @Author zzq
     * @Date 2021/6/27 15:56
     */
    public Bill getBillById(@Param("id") Integer id);

    /**
     * @Description 修改订单信息
     * @Param [bill]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:56
     */
    public void modify(Bill bill);

    /**
     * @Description 根据供应商Id删除订单信息
     * @Param [providerId]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 15:56
     */
    public void deleteBillByProviderId(@Param("providerId") Integer providerId);

}
