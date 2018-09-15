package com.bjs.knowledge.designmodel.simplefactory;

public abstract class Operation {
    private String numberA;
    private String numberB;

    public abstract double operate();


    public double getNumberA() {
        return Double.valueOf(numberA);
    }

    public void setNumberA(String numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return Double.valueOf(numberA);
    }

    public void setNumberB(String numberB) {
        this.numberB = numberB;
    }
}
