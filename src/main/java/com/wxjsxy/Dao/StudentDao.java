package com.wxjsxy.Dao;

import com.wxjsxy.Idao.IstudentDao;
import com.wxjsxy.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Component("studengdao")

public class StudentDao implements IstudentDao {
    @Autowired
    private UserDao userDao;
    private PrivilgeDao privilgeDao;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
    public void setprivilgeDao(PrivilgeDao privilgeDao) {
        this.privilgeDao=privilgeDao;
    }
    @Override
    public User USER(User user) {
        user=userDao.SelectGet(user);
        if(user!=null)
        {
            return user;
        }
        else {
            System.out.println("无信息");
            return null;
        }
    }
    @Override
    public User setPrivilge(User user) {
        return privilgeDao.SelectGet(user);
    }
    @Override
    public void addstu(User user) {
        System.out.println("success insert student");
        String sql="insert into user values('"+ user.getUser()+"','"+ user.getPassword()+"',"+ user.getRid()+")";
        //("+student.getId()+",'"+student.getName()+"',"+student.getAge()+")"
        jdbcTemplate.update(sql);
    }

    @Override
    public void remove(User user) {
        String sql="delete  from user where name="+ user.getUser()+"";
        jdbcTemplate.update(sql);
    }

    @Override
    public void setStudent(User user) {
        String sql="update user set name='"+ user.getUser()+"','"+ user.getPassword()+"',where account_number='"+ user.getUser()+"'";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Map<String,Object>> getStudeng(List<Map<String,Object>> list) throws SQLException {
        String sql="select * from user"; //where springtest.id=?";
        list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
