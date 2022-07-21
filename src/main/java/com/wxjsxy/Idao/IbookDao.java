package com.wxjsxy.Idao;

import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public interface IbookDao {
    void addbook(Book book);
    void jian(Book book);
    void jia(Book book);
    void jian1(Book book);
    void jia1(Book book);
    void removebook(Book book);
    void setbook(Book book);
    List<Book> getbook(List<Book> list)throws SQLException;
    void addjie(Book book);
}
