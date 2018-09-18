package com.bjs.knowledge.designmodel.command.first;

public abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }
    abstract public void exeCommand();
}
