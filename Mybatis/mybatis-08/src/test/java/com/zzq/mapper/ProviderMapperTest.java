package com.zzq.mapper;

import com.zzq.pojo.Provider;
import com.zzq.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName ProviderMapperTest
 * @Author zzq
 * @Date 2021/6/27 19:25
 */
public class ProviderMapperTest extends TestCase {

    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        mapper.add(new Provider(null,"BJ_GYS001","北京三木堂商贸有限公司","长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等","张国强","13566667777","北京市丰台区育芳园北路","010-58858787",1,new Date(),null,null));
    }

    public void testGetProviderList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providers = mapper.getProviderList(null, "BJ_GYS003", 0, 5);
        for (Provider provider : providers) {
            System.out.println(provider);
        }
    }

    public void testGetProList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providers = mapper.getProList();
        for (Provider provider : providers) {
            System.out.println(provider);
        }
    }

    public void testGetProviderCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int count = mapper.getProviderCount(null, null);
        System.out.println(count);
    }

    public void testDeleteProviderById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        mapper.deleteProviderById(2);
    }

    public void testGetProviderById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = mapper.getProviderById(2);
        System.out.println(provider);
    }

}