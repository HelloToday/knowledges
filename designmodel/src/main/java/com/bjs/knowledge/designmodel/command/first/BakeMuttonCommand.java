package com.bjs.knowledge.designmodel.command.first;

public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void exeCommand() {
        receiver.bakeMutton();
    }
}
