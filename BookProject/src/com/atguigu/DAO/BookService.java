package com.atguigu.DAO;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author CJYong
 * @create 2021-07-28 16:37
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
