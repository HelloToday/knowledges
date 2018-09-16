package com.bjs.knowledge.designmodel.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
    List<String> parts = new ArrayList<String>();

    public  void add(String part){
        parts.add(part);
    }

    public  void show(){
        System.out.println("蟾皮创建");
        for (int i = 0; i <parts.size() ; i++) {
            System.out.println(parts.get(i));
        }
    }

}
