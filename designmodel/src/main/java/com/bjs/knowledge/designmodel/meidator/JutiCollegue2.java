package com.bjs.knowledge.designmodel.meidator;

public class JutiCollegue2 extends Collegue{
    public JutiCollegue2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        mediator.send(message,this);
    }

    public void notify(String message){
        System.out.println("同事2得到消息:"+message);
    }
}
