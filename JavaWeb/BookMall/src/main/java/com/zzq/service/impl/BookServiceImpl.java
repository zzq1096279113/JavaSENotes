package com.zzq.service.impl;

import com.zzq.dao.impl.BookDaoImpl;
import com.zzq.entity.Book;
import com.zzq.entity.Page;
import com.zzq.service.BookService;

import java.util.List;

/**
 * @Description Book的service层
 * @ClassName BookServiceImpl
 * @Author zzq
 * @Date 2021/2/25 20:13
 */
public class BookServiceImpl implements BookService {
    private final BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Page<Book> page(Integer pageNo) {
        Page<Book> page = new Page<>();
        Integer pageSize = Page.PAGE_SIZE;          //得到每页记录数
        Integer countBooks = bookDao.countBooks();  //总记录数
        Integer pageTotal = countBooks / pageSize;  //计算总页数
        if (countBooks % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        pageNo = page.getPageNo();
        Integer begin = (pageNo - 1) * pageSize;    //页面的起始
        List<Book> books = bookDao.selectBookByPage(begin, pageSize);  //当前页的记录
        page.setPageCount(countBooks);
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        Integer pageSize = Page.PAGE_SIZE;          //得到每页记录数
        Integer countBooks = bookDao.countBooksByPrice(min, max);  //价格区间中总记录数
        Integer pageTotal = countBooks / pageSize;  //计算总页数
        if (countBooks % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        pageNo = page.getPageNo();
        Integer begin = (pageNo - 1) * pageSize;    //页面的起始
        List<Book> books = bookDao.selectBookByPrice(begin, pageSize, min, max);  //当前页的记录
        page.setPageCount(countBooks);
        page.setItems(books);
        return page;
    }

    @Override
    public Book selectBookById(Integer id) {
        return bookDao.selectBookById(id);
    }

    @Override
    public List<Book> selectBooks() {
        return bookDao.selectBooks();
    }
}
