package com.bjs.knowledge.designmodel.state;

public class JutiStateB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new JutiStateA());
    }
}
