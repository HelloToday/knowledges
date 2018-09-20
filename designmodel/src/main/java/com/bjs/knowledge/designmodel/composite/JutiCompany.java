package com.bjs.knowledge.designmodel.composite;

import java.util.ArrayList;
import java.util.List;

public class JutiCompany extends Company {

    private List<Company> children = new ArrayList<>();

    public JutiCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
        children.add(c);
    }

    @Override
    public void remove(Company c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {

        for(int i =0;i<depth;i++){
            System.out.print("-");
        }
        System.out.println(name);

        for (int i = 0; i <children.size() ; i++) {
            children.get(i).display(depth+2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (int i = 0; i <children.size() ; i++) {
            children.get(i).lineOfDuty();
        }
    }
}
