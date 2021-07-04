package com.zzq.mapper;

import com.zzq.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName BlogMapper
 * @Author zzq
 * @Date 2021/6/26 11:00
 */
public interface BlogMapper {

    /**
     * @Description 添加博客
     * @Param [blog]
     * @Return void
     * @Author zzq
     * @Date 2021/6/26 11:07
     */
    void addBlog(Blog blog);

    /**
     * @Description if查询
     * @Param [map]
     * @Return java.util.List<com.zzq.pojo.Blog>
     * @Author zzq
     * @Date 2021/6/26 15:16
     */
    List<Blog> queryBlogIf(Map<String, String> map);

    /**
     * @Description choose查询
     * @Param [map]
     * @Return java.util.List<com.zzq.pojo.Blog>
     * @Author zzq
     * @Date 2021/6/26 15:16
     */
    List<Blog> queryBlogChoose(Map<String, String> map);

    /**
     * @Description 修改博客
     * @Param [blog]
     * @Return void
     * @Author zzq
     * @Date 2021/6/26 15:39
     */
    void updateBlog(Blog blog);
}
