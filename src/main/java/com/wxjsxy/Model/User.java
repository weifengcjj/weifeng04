package com.wxjsxy.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class User {
    private String user;
    private String password;
    private String rid;
    private List<Privilge> list=new ArrayList<Privilge>();


    public User() {
    }

    public User(String user, String password,String rid) {
        this.user = user;
        this.password = password;
        this.rid=rid;
    }
    public User(String user, String password ){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public List<Privilge> getList() {
        return list;
    }

    public void addList(Privilge privilge) {
        this.list.add(privilge);
    }

    @Override
    public String toString() {
        return "user{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", rid=" + rid +
                '}';
    }
}
