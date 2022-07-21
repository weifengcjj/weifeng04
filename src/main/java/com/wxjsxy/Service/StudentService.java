package com.wxjsxy.Service;

import com.wxjsxy.Idao.IstudentDao;
import com.wxjsxy.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Component("studentservice")
public class StudentService {
    @Autowired
    private IstudentDao is;
    public User user(User user)
    {
        user= is.USER(user);
        return user;
    }
    public void add(User user)
    {
        is.addstu(user);
    }
    public void remove(User user){
        is.remove(user);
    }
    public void setStudent(User user)
    {
        is.setStudent(user);
    }
    public List<Map<String,Object>> getStudent(List<Map<String,Object>> list) throws SQLException {
        List<Map<String,Object>> map=is.getStudeng(list);
        return map;
    }
}
