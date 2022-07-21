package com.wxjsxy.GUI;

import com.mysql.cj.log.Log;
import com.wxjsxy.Login.LoginWait;
import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.BookService;
import com.wxjsxy.View.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
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
public class removebookgui extends JFrame {
    AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(Test.class);
    BookService bookService= (BookService) configApplicationContext.getBean("bookservice");
    public  removebookgui()
    {
        JFrame jf=new JFrame("删除书籍");
        jf.setVisible(true);
        jf.setBounds(800,450,800,551);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        //容器
        Container container=getContentPane();
        jf.add(container);
        container.setLayout(null);
        JLabel l1=new JLabel("请输入你要删除的书名");
        TextField t1=new TextField();
        l1.setBounds(50,50,150,40);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(l1);
        t1.setBounds(50,100,100,30);
        container.add(t1);
        JButton button=new JButton("删除");
        button.setBounds(350,400,80,50);
        container.add(button);
        List<Map<String,Object>> list=new ArrayList<>();
        User user = null;
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book=new Book();
                book.setBookname(t1.getText());
                bookService.remove(book);
                JOptionPane.showMessageDialog(jf,"删除成功");
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
