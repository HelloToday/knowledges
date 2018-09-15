package com.bjs.knowledge.designmodel.simplefactory;

public class TestSimpleFactory {
    public static void main(String[] args){
        Operation add = SimpleFactory.createOperation("+");
        add.setNumberA("15");
        add.setNumberB("20");
        double result = add.operate();
        System.out.println(result);
    }

}
