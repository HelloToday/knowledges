package com.bjs.knowledge.designmodel.state.coderdemo;

public class Main {
    public static void main(String[] args){
        Work worker = new Work(new MorningState());
        worker.setHour(9);
        worker.writeProgram();
        worker.setHour(12.3);
        worker.writeProgram();
        worker.setHour(14);
        worker.writeProgram();
        worker.setHour(16);
        worker.writeProgram();
        worker.setHour(18);
        worker.writeProgram();
    }

}
