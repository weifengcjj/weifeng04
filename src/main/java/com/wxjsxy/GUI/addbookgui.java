package com.wxjsxy.GUI;

import com.mysql.cj.log.Log;
import com.wxjsxy.Login.LoginWait;
import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.BookService;
import com.wxjsxy.View.Test;
import com.wxjsxy.factory.Factory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
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
@ComponentScan("bookdao")
public class addbookgui extends JFrame {

    AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(Test.class);
    BookService bookService= (BookService) configApplicationContext.getBean("bookservice");
    LoginWait loginWait=null;
    public  addbookgui(LoginWait loginWait)
    {
        this.loginWait=loginWait;
    }
    public  addbookgui()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame jf=new JFrame("添加书籍");
        jf.setVisible(true);
        jf.setBounds(800,450,800,551);
        jf.setResizable(false);
        //容器
        Container container=getContentPane();
        jf.add(container);
        container.setLayout(null);
        JLabel l0=new JLabel("id");
        JLabel l1=new JLabel("名称");
        JLabel l2=new JLabel("作者");
        JLabel l3=new JLabel("价格");
        JLabel l4=new JLabel("数量");
        JLabel l5=new JLabel("评价");
        JLabel l6=new JLabel("类型");
        //添加两个文本框
        TextField t0=new TextField();
        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();
        TextField t4=new TextField();
        TextField t5=new TextField();
        TextField t6=new TextField();
        l0.setBounds(50,50,50,20);
        l0.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l0);
        t0.setBounds(50,100,100,30);

        l1.setBounds(150,50,50,20);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l1);
        t1.setBounds(150,100,100,30);

        l2.setBounds(250,50,50,20);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l2);
        t2.setBounds(250,100,100,30);

        l3.setBounds(350,50,50,20);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l3);
        t3.setBounds(350,100,100,30);

        l4.setBounds(450,50,50,20);
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l4);
        t4.setBounds(450,100,100,30);

        l5.setBounds(550,50,50,20);
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l5);
        t5.setBounds(550,100,100,30);

        l6.setBounds(650,50,50,20);
        l6.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l6);
        t6.setBounds(650,100,100,30);

        container.add(t0);
        container.add(t1);
        container.add(t2);
        container.add(t3);
        container.add(t4);
        container.add(t5);
        container.add(t6);
        //添加按钮
        JButton button=new JButton("添加");
        button.setBounds(350,400,80,50);
        container.add(button);
        List<Map<String,Object>> list=new ArrayList<>();
        User user = null;

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book=new Book(Integer.parseInt(t0.getText().trim()),t1.getText(),t2.getText(),Integer.parseInt(t3.getText().trim()),Integer.parseInt(t4.getText().trim()),t5.getText(),t6.getText());
                bookService.add(book);
                JOptionPane.showMessageDialog(jf,"添加成功");
                //jf.dispose();
                jf.dispose();
//                try {
//                    new LoginWait(user,list);
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
            }
        });
    }

}
