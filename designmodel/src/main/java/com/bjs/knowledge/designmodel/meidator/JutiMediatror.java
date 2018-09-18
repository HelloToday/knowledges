package com.bjs.knowledge.designmodel.meidator;

public class JutiMediatror extends Mediator{
    private JutiCollegue1 jutiCollegue1;
    private JutiCollegue2 jutiCollegue2;

    public JutiCollegue1 getJutiCollegue1() {
        return jutiCollegue1;
    }

    public void setJutiCollegue1(JutiCollegue1 jutiCollegue1) {
        this.jutiCollegue1 = jutiCollegue1;
    }

    public JutiCollegue2 getJutiCollegue2() {
        return jutiCollegue2;
    }

    public void setJutiCollegue2(JutiCollegue2 jutiCollegue2) {
        this.jutiCollegue2 = jutiCollegue2;
    }

    @Override
    public void send(String message, Collegue collegue) {
        if(collegue == jutiCollegue1){
            jutiCollegue2.notify(message);
        }else{
            jutiCollegue1.notify(message);
        }
    }
}
