package com.bjs.knowledge.designmodel.builder;

public class Director {
   public  void  construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
