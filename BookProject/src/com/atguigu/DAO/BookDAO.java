package com.atguigu.DAO;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author CJYong
 * @create 2021-07-28 15:56
 */
public interface BookDAO {
    //增
    public int addBook(Book book);
    //删
    public int deleteBookById(Integer id);
    //改
    public int updateBook(Book book);
    //查（单个记录）
    public Book queryBookById(Integer id);
    //查（多个记录）
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
