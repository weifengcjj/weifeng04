package com.wxjsxy.Service;
import com.wxjsxy.Idao.IbookDao;
import com.wxjsxy.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Component("bookservice")
public class BookService {
    @Autowired
    private IbookDao ib;
    public void add(Book book)
    {
        ib.addbook(book);
    }
    public void remove(Book book){
        ib.removebook(book);
    }
    public void setbook(Book book)
    {
        ib.setbook(book);
    }
    public List<Book> getbook(List<Book> list) throws SQLException {
        List<Book> map=ib.getbook(list);
        return map;
    }
    public void addjie(Book book)
    {
        ib.addjie(book);
    }
    public void jian(Book book)
    {
        ib.jian(book);
    }
    public void jia(Book book)
    {
        ib.jia(book);
    }
    public void jian1(Book book)
    {
        ib.jian1(book);
    }
    public void jia1(Book book)
    {
        ib.jia1(book);
    }
}
