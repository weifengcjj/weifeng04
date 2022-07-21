package com.wxjsxy.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Book {
    private int id;
    private String bookname;
    private String author;
    private double price;
    private int num;
    private String bookdesc;
    private String booktype;
    List<Book> list=new ArrayList<>();

    public  Book()
    {

    }
    public Book(int id, String bookname, String author, double price, int num, String bookdesc, String booktype) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.num = num;
        this.bookdesc = bookdesc;
        this.booktype = booktype;
    }

    public List<Book> getList() {
        return list;
    }

    public void addList(Book book) {
        this.list.add(book);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBookdesc() {
        return bookdesc;
    }

    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

}
