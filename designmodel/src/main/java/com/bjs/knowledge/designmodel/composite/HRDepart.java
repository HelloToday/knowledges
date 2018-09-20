package com.bjs.knowledge.designmodel.composite;

import com.sun.javafx.binding.StringFormatter;

public class HRDepart extends Company {
    public HRDepart(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {

    }

    @Override
    public void remove(Company c) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth ; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(String.format("%s 公司招聘人员管理",name));
    }
}
