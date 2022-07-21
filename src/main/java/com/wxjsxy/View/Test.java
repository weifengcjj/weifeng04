package com.wxjsxy.View;

import com.wxjsxy.Login.Getbookvalue;
import com.wxjsxy.Login.Login;
import com.wxjsxy.Model.Book;
import com.wxjsxy.Model.User;
import com.wxjsxy.Service.BookService;
import com.wxjsxy.Service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ComponentScan("com.wxjsxy")
public class Test {
    public static void main(String[] args) throws SQLException {

//        Scanner scanner=new Scanner(System.in);
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(Test.class);
        //StudentService studentservie = (StudentService) configApplicationContext.getBean("studentservice");
        BookService bookService= (BookService) configApplicationContext.getBean("bookservice");

        //System.out.println(studentservie);
//        System.out.println("请开始你的表演:");
//        System.out.println("请输入你要查询的ID:");
//        int a=scanner.nextInt();
          //studentservie.add(user);

//        for(Map<String, Object> map:list)
//        {
//            System.out.println(map);
//        }
//        System.out.println(bookService);
        List<Map<String,Object>> list=new ArrayList<>();
//        list=bookService.getbook(list);

        Login login=new Login("图书管理系统",list);

//        List list1=new ArrayList();
//        for(Map<String,Object> map:list)
//        {
//           for(String i: map.keySet())
//           {
//               list1.add(map.get(i));
//
//           }
//
//        }
//        for(Object a:list1)
//        {
//            System.out.println(a.toString());
//        }

    }
   
}
