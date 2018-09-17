package com.bjs.knowledge.designmodel.visitor;

public class JutiElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitJutiElementB(this);
    }
}
