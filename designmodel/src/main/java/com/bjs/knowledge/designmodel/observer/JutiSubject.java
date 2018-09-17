package com.bjs.knowledge.designmodel.observer;

public class JutiSubject extends Subject {
    private  String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
