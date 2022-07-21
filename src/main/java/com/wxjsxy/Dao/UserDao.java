package com.wxjsxy.Dao;

import com.wxjsxy.Model.User;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@Component("userdao")
public class UserDao {
    public static Statement constudentDao() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/weifeng6?characterEncoding=utf8",
                            "root","20040309cjj").createStatement();
        }
        catch (Exception e){
            System.out.println("连接失败");
        }
        return null;
    }
    public static User SelectGet(User user) {
        String sql = "SELECT `user`.account_number,`user`.passworld,role.id,role.`name` " +
                "FROM role INNER JOIN `user` ON `user`.rid = role.id " +
                "WHERE account_number="+user.getUser()+" AND passworld = "+user.getPassword()+"";
        ResultSet rs = null;
        try {
            rs=constudentDao().executeQuery(sql);
            if (rs.next()) {
                user.setRid(rs.getString("name"));
            }
            else {
                return  null;
            }
            rs.close();
            return user;
        } catch (SQLException var9) {
            var9.printStackTrace();
        }
        return null;
    }
}

