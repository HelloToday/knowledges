package com.bjs.knowledge.designmodel.state.coderdemo;

public class EveningState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.taskFinished()){
            System.out.println("开开心心不加班 回家陪女朋友了");
        }else{
            System.out.println("有TM加班");
        }
    }
}
