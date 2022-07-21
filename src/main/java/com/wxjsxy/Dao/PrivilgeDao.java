package com.wxjsxy.Dao;

import com.wxjsxy.Model.Privilge;
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
@Component("privilgedao")
public class PrivilgeDao {
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
        String sql = "SELECT a.`name`,b.`name` FROM `user` \n" +
                "INNER JOIN role ON role.id = `user`.rid \n" +
                "INNER JOIN intermediate ON role.id = intermediate.rid \n" +
                "INNER JOIN privilege a ON a.id = intermediate.pid \n" +
                "INNER JOIN privilege b on a.id = b.pid\n" +
                "WHERE `user`.account_number = '"+user.getUser()+"'";
        try {
            ResultSet rs = null;
            rs = constudentDao().executeQuery(sql);
            String quanxian="";
            Privilge privilege=null;
            while (rs.next())
            {
                if(!quanxian.equals(rs.getString(1)));
                {
                    quanxian=rs.getString(1);
                    privilege=new Privilge(quanxian);
                    user.addList(privilege);
                }
                privilege.addList(new Privilge(rs.getString(2)));
            }
            rs.close();
            return  user;
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return null;
    }
}
