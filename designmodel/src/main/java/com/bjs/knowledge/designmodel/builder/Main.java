package com.bjs.knowledge.designmodel.builder;

public class Main {
    public static void main(String[] args){
        Director director = new Director();
        Builder b1 = new JutiBuilder();
        Builder b2 = new JutiBuilder2();

        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }

}
