package com.bjs.knowledge.designmodel.visitor;

public class Main {
    public static void main(String[] args){
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new JutiElementA());
        objectStructure.attach(new JutiElementB());

        JutiVisitor1 jutiVisitor1 = new JutiVisitor1();
        JutiVisitor2 jutiVisitor2 = new JutiVisitor2();

        objectStructure.accept(jutiVisitor1);
        objectStructure.accept(jutiVisitor2);
    }

}
