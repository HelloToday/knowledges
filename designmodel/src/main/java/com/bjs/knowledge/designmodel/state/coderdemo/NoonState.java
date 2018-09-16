package com.bjs.knowledge.designmodel.state.coderdemo;

public class NoonState extends State{

    @Override
    public void writeProgram(Work work) {
        if(work.getHour()<13){
            System.out.println("又累又饿该睡午觉了");
        }else{
            work.setCurrent(new AfternooState());
            work.writeProgram();
        }
    }
}
