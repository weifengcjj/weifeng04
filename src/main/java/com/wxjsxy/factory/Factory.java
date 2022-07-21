package com.wxjsxy.factory;

import com.wxjsxy.Dao.PrivilgeDao;
import com.wxjsxy.Dao.StudentDao;
import com.wxjsxy.Dao.UserDao;
import com.wxjsxy.Service.BookService;
import com.wxjsxy.Service.StudentService;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Factory {
    public static StudentDao getstudentDao()
    {
        return  new StudentDao();
    }
    public static StudentService getstudentService()
    {
        return new StudentService();
    }

    public static UserDao usedao()
    {
        return new UserDao();
    }
    public static PrivilgeDao privilgeDao()
    {
        return new PrivilgeDao();
    }
    public static BookService bookService()
    {
        return new BookService();
    }
}
