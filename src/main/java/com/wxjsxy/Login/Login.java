package com.wxjsxy.Login;

import com.wxjsxy.Dao.PrivilgeDao;
import com.wxjsxy.Dao.StudentDao;
import com.wxjsxy.Dao.UserDao;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.StudentService;
import com.wxjsxy.factory.Factory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Login extends JFrame {

    PrivilgeDao privilgeDao= Factory.privilgeDao();
    UserDao userDao=Factory.usedao();
    StudentDao servise=Factory.getstudentDao();
    private DefaultTableModel model = null;
    public Login(String s, List<Map<String,Object>> list) {
        super(s);
        setVisible(true);
        setBounds(800,450,400,251);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        //容器
        Container container=getContentPane();
        container.setLayout(null);
        JLabel l=new JLabel("登录");
        l.setBounds(170,20,30,30);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l);
        JLabel l1=new JLabel("账号");
        JLabel l2=new JLabel("密码");
        //添加两个文本框
        TextField t1=new TextField();
        TextField t2=new TextField();
        l1.setBounds(50,50,50,20);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l1);
        t1.setBounds(100,50,170,30);

        l2.setBounds(50,80,50,20);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l2);
        t2.setBounds(100,80,170,30);
        container.add(t1);
        container.add(t2);
        //添加按钮
        JButton button=new JButton("登录");
        button.setBounds(150,120,80,50);
        container.add(button);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user=servise.USER(new User(t1.getText(),t2.getText()));
                if(user!=null)
                {
                    try {
                            new LoginWait(user,list);
//                        else{
//                            new LoginWait01(user,list);
//                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("恭喜你");
                    setVisible(false);
                }
                else{
                    new CW();
                }
            }
        });
    }
}
