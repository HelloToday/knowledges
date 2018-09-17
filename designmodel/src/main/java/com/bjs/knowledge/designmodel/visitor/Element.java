package com.bjs.knowledge.designmodel.visitor;

public abstract class Element {
    public abstract void accept(Visitor visitor);
}
