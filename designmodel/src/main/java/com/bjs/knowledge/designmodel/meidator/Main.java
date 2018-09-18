package com.bjs.knowledge.designmodel.meidator;

public class Main {

    public static void main(String[] args){
        JutiMediatror jutiMediatror = new JutiMediatror();

        JutiCollegue1 collegue1 = new JutiCollegue1(jutiMediatror);
        JutiCollegue2 collegue2 = new JutiCollegue2(jutiMediatror);

        jutiMediatror.setJutiCollegue1(collegue1);
        jutiMediatror.setJutiCollegue2(collegue2);

        collegue1.send("吃饭了吗");
        collegue2.send("没有呢 ，你打算请客？");
    }


}
