package com.atguigu.test;

import com.atguigu.DAO.BookService;
import com.atguigu.DAO.impl.BookServiceImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author CJYong
 * @create 2021-07-28 16:43
 */
public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"钢铁是怎样练成的", "保尔.柯察金", new BigDecimal(21232), 3131, 41543614, null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);

    }

    @Test
    public void updateBook() {
        bookService.addBook(new Book(null,"钢铁是怎样练成的", "保尔.柯察金", new BigDecimal(21232), 3131, 41543614, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));

    }

    @Test
    public void queryBooks() {
        for(Book queryBook : bookService.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(2, Page.PAGE_SIZE));
    }



    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(2, Page.PAGE_SIZE,10,50));
    }

}

