package com.bjs.knowledge.designmodel.state.coderdemo;

public class Work {
    private State current;

    private  double hour;

    private  double Hour;

    private boolean finish = false;

    public boolean taskFinished(){
        return finish;
    }
    public void setTaskFinished(boolean finish){
        this.finish = finish;
    }
    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public Work(State current) {
        this.current = current;
    }

    public void writeProgram(){
        this.current.writeProgram(this);
    }

}
