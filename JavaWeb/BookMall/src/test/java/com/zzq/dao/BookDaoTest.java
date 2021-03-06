package com.zzq.dao;

import com.zzq.dao.impl.BookDaoImpl;
import com.zzq.entity.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description BookDao测试类
 * @ClassName BookDaoTest
 * @Author zzq
 * @Date 2021/2/25 15:33
 */
class BookDaoTest {

    private final BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        Book book = new Book(null, "白夜行", "东野圭吾", new BigDecimal(75), 23, 32, null);
        int msg = bookDao.addBook(book);
        System.out.println(msg);
    }

    @Test
    void deleteBookById() {

    }

    @Test
    void updateBook() {
        Book book = new Book(3, "三体", "刘慈欣", new BigDecimal(50), 33, 20, null);
        int msg = bookDao.updateBook(book);
        System.out.println(msg);
    }

    @Test
    void countBooks() {
        Integer integer = bookDao.countBooks();
        System.out.println(integer);
    }

    @Test
    void countBooksByPrice(){
        Integer integer = bookDao.countBooksByPrice(20, 40);
        System.out.println(integer);
    }

    @Test
    void selectBookById() {
        Book book = bookDao.selectBookById(9);
        System.out.println(book);
    }

    @Test
    void selectBookByPage() {
        List<Book> books = bookDao.selectBookByPage(2, 5);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void selectBooks() {
        List<Book> books = bookDao.selectBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void selectBookByPrice(){
        List<Book> books = bookDao.selectBookByPrice(0, 5, 20, 40);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}