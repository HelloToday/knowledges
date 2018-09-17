package com.bjs.knowledge.designmodel.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notify2(){
        for (int i = 0; i <observers.size() ; i++) {
            observers.get(i).update();
        }
    }
}
