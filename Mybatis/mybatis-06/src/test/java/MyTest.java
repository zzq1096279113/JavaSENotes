import com.zzq.mapper.BlogMapper;
import com.zzq.pojo.Blog;
import com.zzq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/26 11:10
 */
public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(1);
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9);
        mapper.addBlog(blog);

        blog.setId(2);
        blog.setTitle("Java如此简单");
        blog.setCreateTime(new Date());
        blog.setViews(99);
        mapper.addBlog(blog);

        blog.setId(3);
        blog.setTitle("Spring如此简单");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(4);
        blog.setTitle("微服务如此简单");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<>();
//        map.put("title", "Java");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<>();
//        map.put("title", "Java");
//        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<>();
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("高等数学");
        blog.setAuthor("张三");
        mapper.updateBlog(blog);
    }
}
