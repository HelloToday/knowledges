package com.bjs.knowledge.designmodel.state.coderdemo;

public class AfternooState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour()<17){
            System.out.println("xia wu 状态不错 继续保持"+ work.getHour());
        }else{
            work.setCurrent(new EveningState());
            work.writeProgram();
        }
    }
}
