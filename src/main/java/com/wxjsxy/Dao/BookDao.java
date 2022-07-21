package com.wxjsxy.Dao;

import com.sun.source.tree.LambdaExpressionTree;
import com.wxjsxy.Idao.IbookDao;
import com.wxjsxy.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.rmi.MarshalledObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@Component("bookdao")
public class BookDao implements IbookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    static List<Book> booklist=new ArrayList<>();
    @Override
    public void addbook(Book book) {
        String sql="insert into springbook values("+book.getId()+",'"+book.getBookname()+"'," +
                "'"+book.getAuthor()+"',"+book.getPrice()+","+book.getNum()+"," +
                "'"+book.getBookdesc()+"',"+book.getBooktype()+")";
        jdbcTemplate.update(sql);
    }

    @Override
    public void jian(Book book) {
        String sql="UPDATE springbook set num=num-1 where id ="+book.getId()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public void jia(Book book) {
        String sql="UPDATE springbook set num=num+1 where id ="+book.getId()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public void jian1(Book book) {
        String sql="UPDATE springbook_copy set num=num-1 where id ="+book.getId()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public void jia1(Book book) {
        String sql="UPDATE springbook_copy set num=num+1 where id ="+book.getId()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public void removebook(Book book) {
        String sql="delete  from springbook where bookname='"+book.getBookname()+"'";
        jdbcTemplate.update(sql);
    }

    @Override
    public void setbook(Book book) {
        String sql="update springbook set bookname='"+book.getBookname()+"',author='"+book.getAuthor()+"',price="+book.getPrice()+",num="+book.getNum()+",bookdesc='"+book.getBookdesc()+"' where id="+book.getId()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Book> getbook(List<Book> list) throws SQLException{
        String sql="select * from springbook"; //where springtest.id=?";
        for(Map<String,Object> map:jdbcTemplate.queryForList(sql))
        {
            //"id", "bookname","author","price","num","bookdesc","booktype"
            int id=(Integer)map.get("id");
            String bookname=(String) map.get("bookname");
            String author=(String) map.get("author");
            double price=(Double) map.get("price");
            int num=(Integer)map.get("num");
            String bookdesc=(String) map.get("bookdesc");
            String booktype=(String) map.get("booktype");
            list.add(new Book(id,bookname,author,price,num,bookdesc,booktype));
        }
        return list;
    }

    @Override
    public void addjie(Book book) {
        String sql="insert into springbook_copy1 values("+book.getId()+",'"+book.getBookname()+"'," +
                "'"+book.getAuthor()+"',"+book.getPrice()+","+book.getNum()+"," +
                "'"+book.getBookdesc()+"',"+book.getBooktype()+")";
        jdbcTemplate.update(sql);
    }
}
