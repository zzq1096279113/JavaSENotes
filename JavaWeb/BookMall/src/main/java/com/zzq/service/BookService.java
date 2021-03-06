package com.zzq.service;

import com.zzq.entity.Book;
import com.zzq.entity.Page;

import java.util.List;

/**
 * @Description TODO
 * @ClassName BookService
 * @Author zzq
 * @Date 2021/2/25 20:06
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Page<Book> page(Integer pageNo);

    public Page<Book> pageByPrice(Integer pageNo, Integer min, Integer max);

    public Book selectBookById(Integer id);

    public List<Book> selectBooks();

}
