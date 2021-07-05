package com.zzq.mapper;

import com.zzq.pojo.Bill;
import com.zzq.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName BillMapperTest
 * @Author zzq
 * @Date 2021/6/27 16:17
 */
public class BillMapperTest extends TestCase {

    public void testGetBillCountByProviderId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCountByProviderId = mapper.getBillCountByProviderId(2);
        System.out.println(billCountByProviderId);
    }

    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        mapper.add(new Bill(null, "BILL2016_002", "香皂、肥皂、药皂", "日用品-皂类", "块", new BigDecimal(1000), new BigDecimal(10000), 2, 13, 1, new Date(), null, null, null));
    }

    public void testGetBillList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> list = mapper.getBillList("大豆油", "6", null);
        for (Bill bill : list) {
            System.out.println(bill);
        }
    }

    public void testGetBillCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int num = mapper.getBillCount("大豆油", "6", null);
        System.out.println(num);
    }

    public void testDeleteBillById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        mapper.deleteBillById(6);
    }

    public void testGetBillById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = mapper.getBillById(2);
        System.out.println(bill);
    }


    public void testDeleteBillByProviderId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        mapper.deleteBillByProviderId(2);
    }
}