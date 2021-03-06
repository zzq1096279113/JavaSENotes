package com.zzq.dao.impl;

import com.zzq.dao.BaseDao;
import com.zzq.dao.BookDao;
import com.zzq.entity.Book;

import java.util.List;

/**
 * @Description TODO
 * @ClassName BookDaoImpl
 * @Author zzq
 * @Date 2021/2/25 15:21
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`imgPath`) values(?,?,?,?,?,?);";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where `id`=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`imgPath`=? where `id`=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Integer countBooks() {
        String sql = "select count(*) from t_book";
        Number count = (Number) selectSingleValue(sql);
        return count.intValue();
    }

    @Override
    public Integer countBooksByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where `price` between ? and ?";
        Number count = (Number) selectSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public Book selectBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`imgPath` from t_book where `id`=?";
        return selectOne(Book.class, sql, id);
    }

    @Override
    public List<Book> selectBookByPage(Integer begin, Integer pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`imgPath` from t_book limit ?,?";
        return selectList(Book.class, sql, begin, pageSize);
    }

    @Override
    public List<Book> selectBookByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`imgPath` from t_book where `price` between ? and ? limit ?,?";
        return selectList(Book.class, sql, min, max, begin, pageSize);
    }

    @Override
    public List<Book> selectBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`imgPath` from t_book";
        return selectList(Book.class, sql);
    }
}
