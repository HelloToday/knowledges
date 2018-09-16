package com.bjs.knowledge.designmodel.state.coderdemo;

public class MorningState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour()<12){
            System.out.println("now is "+work.getHour()+"工作精神共败北");
        }else{
            work.setCurrent(new NoonState());
            work.writeProgram();
        }
    }
}
