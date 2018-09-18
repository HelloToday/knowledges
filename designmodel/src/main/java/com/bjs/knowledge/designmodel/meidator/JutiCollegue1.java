package com.bjs.knowledge.designmodel.meidator;

public class JutiCollegue1 extends Collegue{
    public JutiCollegue1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        mediator.send(message,this);
    }

    public void notify(String message){
        System.out.println("同事1得到消息:"+message);
    }
}
