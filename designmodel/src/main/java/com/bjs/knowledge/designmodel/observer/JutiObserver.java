package com.bjs.knowledge.designmodel.observer;

public class JutiObserver extends Observer {
    private String name;
    private String observerState;
    private JutiSubject subject;

    public JutiSubject getSubject() {
        return subject;
    }

    public void setSubject(JutiSubject subject) {
        this.subject = subject;
    }

    public JutiObserver(JutiSubject subject, String name) {
        this.name = name;
        this.subject = subject;
        this.observerState = observerState;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.printf("观察者%s状态是%s \n",name,observerState);
    }
}
