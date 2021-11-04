package com.atguigu.test;

import com.atguigu.DAO.BookDAO;
import com.atguigu.DAO.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-07-28 16:19
 */
public class BookDAOTest {

    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null, "很纯很暧昧","鱼人二代",new BigDecimal(999),12213,7877878,null));
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDAO.addBook(new Book(22, "三体","刘慈欣",new BigDecimal(999),12213,7877878,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook : bookDAO.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDAO.queryForPageItems(8, 4);
        //使用增强For循环打印输出
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDAO.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDAO.queryForPageItemsByPrice(0, 4,10,50);
        //使用增强For循环打印输出
        for(Book book : books){
            System.out.println(book);
        }
    }


}