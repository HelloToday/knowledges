package com.bjs.knowledge.designmodel.observer;

public class Main {
    public static void main(String[] args){
        JutiSubject s = new JutiSubject();

        s.attach(new JutiObserver(s ,"x"));
        s.attach(new JutiObserver(s ,"y"));
        s.attach(new JutiObserver(s ,"z"));

        s.setSubjectState("ABC");
        s.notify2();

    }
}
