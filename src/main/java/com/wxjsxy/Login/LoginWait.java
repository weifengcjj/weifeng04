package com.wxjsxy.Login;

import com.wxjsxy.Dao.PrivilgeDao;
import com.wxjsxy.Dao.StudentDao;
import com.wxjsxy.Dao.UserDao;
import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.Privilge;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.BookService;
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

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class LoginWait extends JFrame {
    Panel panel;
    User user;
    Book book;
    JScrollPane pane;
    private  JMenuBar jMenuBar=new JMenuBar();//菜单
    private static Map<String,String> map=new HashMap<>();
    PrivilgeDao privilgeDao= Factory.privilgeDao();
    UserDao userDao=Factory.usedao();
    StudentDao setUserDao=Factory.getstudentDao();
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null;
    JFrame jf=new JFrame();
    Getbookvalue getbookvalue=new Getbookvalue();
    List list=new ArrayList<>();
    private JScrollPane scpDemo;
    private JTableHeader jth;

    private JButton b1=new JButton("增加书籍");
    private JButton b2=new JButton("删除书籍");
    private JButton b3=new JButton("修改书籍");
    private JButton b4=new JButton("刷新");
    public LoginWait(User user,List<Map<String,Object>> list1) throws SQLException {
        super("图书管理系统");
        this.setSize(330,400);

        this.setLayout(null);

        this.setLocation(100,50);

// 创建组件
        this.scpDemo = new JScrollPane();
        this.scpDemo.setBounds(100,50,500,470);
        add(this.scpDemo);
        b1.setBounds(650,50,100,50);
        this.add(b1);
        b2.setBounds(650,100,100,50);
        this.add(b2);
        b3.setBounds(650,150,100,50);
        this.add(b3);
        b4.setBounds(650,200,100,50);
        this.add(b4);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weifeng6?characterEncoding=utf8",
                    "root","20040309cjj");

            String sql = "select * from springbook";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            int sum = 0;

            while (rs.next()) {

                sum++;
            }
            rs=pstm.executeQuery();
            Object[][] datas=new Object[sum][8];
            sum=0;
            while(rs.next())
            {
                datas[sum][0]=Integer.valueOf( rs.getInt("id"));
                datas[sum][1]=rs.getString("bookname");
                datas[sum][2]=rs.getString("author");
                datas[sum][3]=Integer.valueOf(rs.getInt("price"));
                datas[sum][4]=Integer.valueOf(rs.getInt("num"));
                datas[sum][6]=rs.getString("bookdesc");
                datas[sum][7]=Integer.valueOf(rs.getInt("booktype"));
                sum++;
            }
            String[] titles = { "id", "bookname","author","price","num","bookdesc","booktype"};
            this.table=new JTable(datas,titles);
            this.jth=this.table.getTableHeader();
            this.scpDemo.getViewport().add(table);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        for(Map<String,Object> map:list1)
//        {
////
////            sum++;
//            for(String i: map.keySet())
//            {
//                list.add(map.get(i));
//            }
//
//        }





        //model.addRow(new String[]{"id", "bookname","author","price","num","bookdesc","booktype"});
        //pane=new JScrollPane(table);
        //panel.add(pane);

//                    list=bookService.getbook(list);
//                    for(Map<String,Object> map:list)
//                    {
//                        for(String i: map.keySet())
//                        {
//                            list1.add(map.get(i));
//                        }
//                    }
        //add(addBtn, BorderLayout.NORTH);
        //list=getbookvalue.getvalue(list);
        //model.addRow(new String[]{String.valueOf(list.get(0)),String.valueOf(list.get(1)),String.valueOf(list.get(2)),String.valueOf(list.get(3)),String.valueOf(list.get(4)),String.valueOf(list.get(5)),String.valueOf(list.get(6))});

//        add(new JScrollPane(table));
//        setSize(400, 300);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);

        this.user=user;
        setUserDao.setUserDao(userDao);
        setUserDao.setprivilgeDao(privilgeDao);
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭事件

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-this.getSize().width)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-this.getSize().height)/2);
        setVisible(true);
        init();

    }
    private void showDialog(String title){
        String name= map.get(title);
        try {
            Class c=Class.forName("com.wxjsxy.Login.Login");
            Constructor declaredConstructor = c.getDeclaredConstructor(Frame.class, String.class);
            //获取指定的构造方法
            Object o = declaredConstructor.newInstance(this, title);
            JDialog j= (JDialog)o;
            j.setSize(350,350);
            j.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-j.getSize().width)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-j.getSize().height)/2);
            //窗口位置
            j.setVisible(true);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
    }


    private void init() {
        setJMenuBar(jMenuBar);
        user=setUserDao.setPrivilge(user);
            JMenu j1=new JMenu("用户设置");
            jMenuBar.add(j1);
            JMenuItem i1=new JMenuItem("退出程序");
            j1.add(i1);

//        for(Privilge privilge:user.getList())
//        {
//            JMenu jMenu=new JMenu((privilge.getName()));
//            jMenuBar.add(jMenu);
//            for(Privilge p1:privilge.getList())
//            {
//                map.put(p1.getName(),"com.xxx.view.MyDialog");
//                JMenuItem it=new JMenuItem(p1.getName());
//                jMenu.add(it);
//                it.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        showDialog((e.getActionCommand()));
//                    }
//                });
//        }
//    }
                        b1.addActionListener(new AbstractAction() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent e) {
                                                     new addbookgui();
                                                 }
                                             });
                        b2.addActionListener(new AbstractAction() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent e) {
                                                     new removebookgui();
                                                     int id=table.getSelectedRow();
                                                     for(int i=0;i<table.getRowCount();i++)
                                                     {
                                                         if(Integer.parseInt(table.getValueAt(i,0).toString())==Integer.parseInt(String.valueOf(id)))
                                                         {
                                                             int index=i;
                                                             if(index<0||index>=table.getRowCount())
                                                             {
                                                                 return;
                                                             }
                                                             model.removeRow(index);
                                                             model.fireTableDataChanged();
                                                             break;
                                                         }
                                                     }
                                                 }
                                             });
                        b3.addActionListener(new AbstractAction() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      new setbookgui();
                                                  }
                                              });
                        b4.addActionListener(new AbstractAction() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        try {
                                                            new LoginWait(user,list).setVisible(true);
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                        });
                        i1.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(jf,"退出成功");
                                System.exit(0);

                            }
                        });
}
}

