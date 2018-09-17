package com.bjs.knowledge.designmodel.visitor;

public class JutiElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitJutiElementA(this);
    }
}
