package com.bjs.knowledge.designmodel.simplefactory;

public class OperationAdd extends Operation {
    @Override
    public double operate() {
        double numberA = this.getNumberA();
        double numberB = this.getNumberB();
        return numberA+numberB;
    }
}
