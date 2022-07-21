package com.wxjsxy.Idao;

import com.wxjsxy.Dao.PrivilgeDao;
import com.wxjsxy.Dao.UserDao;
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
public interface IstudentDao {
    void setUserDao(UserDao userDao);
    void setprivilgeDao(PrivilgeDao privilgeDao);
    User USER(User user);
    User setPrivilge(User user);
    void addstu(User user);
    void remove(User user);
    void setStudent(User user);
    List<Map<String,Object>> getStudeng(List<Map<String,Object>> list) throws SQLException;
}
