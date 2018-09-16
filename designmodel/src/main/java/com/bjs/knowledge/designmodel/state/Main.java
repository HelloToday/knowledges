package com.bjs.knowledge.designmodel.state;

public class Main {
    public static void main(String[] args){
        Context c = new Context(new JutiStateA());

        c.request();
        c.request();
        c.request();

    }
}
