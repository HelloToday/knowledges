package com.bjs.knowledge.designmodel.command.first;

public class BakeChickenWing extends Command {

    public BakeChickenWing(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void exeCommand() {
        receiver.bakeChickenWing();
    }
}
