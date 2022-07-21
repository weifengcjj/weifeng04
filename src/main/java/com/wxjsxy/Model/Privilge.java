package com.wxjsxy.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Privilge {
    private String  name;
    List<Privilge> list=new ArrayList<>();

    public Privilge(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Privilge> getList() {return list;}
    public void addList(Privilge privilge) {this.list.add(privilge);}
}
