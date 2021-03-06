package com.zzq.dao;

import com.zzq.entity.Book;

import java.util.List;

/**
 * @Description BookDao接口
 * @ClassName BookDao
 * @Author zzq
 * @Date 2021/2/25 15:16
 */
public interface BookDao {
    /**
     * @Description 添加图书
     * @Param [book]
     * @Return int
     * @Author zzq
     * @Date 2021/2/25 15:17
     */
    public int addBook(Book book);

    /**
     * @Description 根据id删除图书
     * @Param [id]
     * @Return int
     * @Author zzq
     * @Date 2021/2/25 15:18
     */
    public int deleteBookById(Integer id);

    /**
     * @Description 修改图书信息
     * @Param [book]
     * @Return int
     * @Author zzq
     * @Date 2021/2/25 15:19
     */
    public int updateBook(Book book);

    /**
     * @Description 总图书数量
     * @Param []
     * @Return int
     * @Author zzq
     * @Date 2021/2/27 19:51
     */
    public Integer countBooks();

    /**
     * @Description 价格区间的图书总数
     * @Param [min, max]
     * @Return java.lang.Integer
     * @Author zzq
     * @Date 2021/2/28 21:23
     */
    public Integer countBooksByPrice(Integer min, Integer max);

    /**
     * @Description 根据id搜索图书
     * @Param [id]
     * @Return com.zzq.entity.Book
     * @Author zzq
     * @Date 2021/2/25 15:19
     */
    public Book selectBookById(Integer id);

    /**
     * @Description 通过页码查询
     * @Param [page]
     * @Return java.util.List<com.zzq.entity.Book>
     * @Author zzq
     * @Date 2021/2/27 20:02
     */
    public List<Book> selectBookByPage(Integer begin, Integer pageSize);

    /**
     * @Description 得到价格区间的图书信息
     * @Param [begin, pageSize, min, max]
     * @Return java.util.List<com.zzq.entity.Book>
     * @Author zzq
     * @Date 2021/2/28 21:27
     */
    public List<Book> selectBookByPrice(Integer begin, Integer pageSize, Integer min, Integer max);

    /**
     * @Description 查询图书集合
     * @Param []
     * @Return java.util.List<com.zzq.entity.Book>
     * @Author zzq
     * @Date 2021/2/25 15:20
     */
    public List<Book> selectBooks();

}
