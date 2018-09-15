package com.bjs.knowledge.designmodel.simplefactory;

public class SimpleFactory {
    public static Operation createOperation(String operate){
        if("+".equals(operate)){
            return new OperationAdd();
        }
        return null;
    }
}
