package com.zzq.service;

import com.zzq.entity.Book;
import com.zzq.entity.Page;
import com.zzq.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @ClassName BookServiceTest
 * @Author zzq
 * @Date 2021/2/25 20:21
 */
class BookServiceTest {
    private final BookServiceImpl bookService = new BookServiceImpl();

    @Test
    void addBook() {
        Book book = new Book(null, "高等数学", "蒋青", new BigDecimal(45), 100, 200, null);
        bookService.addBook(book);
    }

    @Test
    void deleteBook() {

    }

    @Test
    void updateBook() {
        Book book = new Book(23, "高等数学", "王强", new BigDecimal(45), 100, 200, null);
        bookService.updateBook(book);
    }

    @Test
    void selectBookById() {
        Book book = bookService.selectBookById(12);
        System.out.println(book);
    }

    @Test
    void selectBooks() {
        List<Book> books = bookService.selectBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void page(){
        Page<Book> page = bookService.page(2);
        List<Book> books = page.getItems();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void pageByPrice(){
        Page<Book> page = bookService.pageByPrice(1, 20, 40);
        List<Book> books = page.getItems();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}