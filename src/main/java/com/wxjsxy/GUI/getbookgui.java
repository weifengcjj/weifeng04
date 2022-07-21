package com.wxjsxy.GUI;
import com.wxjsxy.Dao.PrivilgeDao;
import com.wxjsxy.Dao.StudentDao;
import com.wxjsxy.Dao.UserDao;
import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.Privilge;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.BookService;
import com.wxjsxy.View.Test;
import com.wxjsxy.factory.Factory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.List;
import com.wxjsxy.GUI.*;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("bookdao")
public class getbookgui  extends  JFrame{
    JFrame jf;
    private JTable table = null;
    private JScrollPane scpDemo;
    private JTableHeader jth;
    AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(Test.class);
    BookService bookService= (BookService) configApplicationContext.getBean("bookservice");
    public getbookgui()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setResizable(false);
        JButton b1=new JButton("借阅");
        this.scpDemo = new JScrollPane();
        this.scpDemo.setBounds(100,50,500,470);
        add(scpDemo);
        b1.setBounds(50,50,100,50);
        this.add(b1);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weifeng6?characterEncoding=utf8",
                    "root","20040309cjj");
            String sql = "select * from springbook_copy1";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int sum = 0;
            while (rs.next()) {
                sum++;
            }
            rs=pstm.executeQuery();
            Object[][] datas=new Object[sum][7];
            sum=0;
            while(rs.next())
            {
                datas[sum][0]=Integer.valueOf( rs.getInt("id"));
                datas[sum][1]=rs.getString("bookname");
                datas[sum][2]=rs.getString("author");
                datas[sum][3]=rs.getDouble("price");
                datas[sum][4]=Integer.valueOf(rs.getInt("num"));
                datas[sum][5]=rs.getString("bookdesc");
                datas[sum][6]=Integer.valueOf(rs.getInt("booktype"));
                sum++;
            }
            String[] titles = { "id", "bookname","author","price","num","bookdesc","booktype"};
            this.table=new JTable(datas,titles);
            this.jth=this.table.getTableHeader();
            this.scpDemo.getViewport().add(table);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSize(900,900);

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-this.getSize().width)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-this.getSize().height)/2);
        //setVisible(true);
        b1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=table.getSelectedRow();
                String idd=table.getValueAt(id,0).toString();
                String bookname=table.getValueAt(id,1).toString();
                String author=table.getValueAt(id,2).toString();
                String price=table.getValueAt(id,3).toString();
                String num=table.getValueAt(id,4).toString();
                String booktsce=table.getValueAt(id,5).toString();
                String booktype=table.getValueAt(id,6).toString();
                Book book=new Book(Integer.parseInt(idd) ,bookname,author,Integer.parseInt(price),Integer.parseInt(num),booktsce,booktype);
                bookService.addjie(book);
                JOptionPane.showMessageDialog(jf,"借阅成功");
                bookService.jian(book);
                jf.dispose();
            }
        });
    }

}
