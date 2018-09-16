package com.bjs.knowledge.designmodel.state;

public class JutiStateA extends State {
    @Override
    public void handle(Context context) {
        context.setState(new JutiStateB());
    }
}
