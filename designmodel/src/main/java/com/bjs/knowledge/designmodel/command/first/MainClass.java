package com.bjs.knowledge.designmodel.command.first;

public class MainClass {
    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeChickenWingCommand = new BakeChickenWing(boy);

        Waiter girl = new Waiter();

        girl.setOrder(bakeMuttonCommand1);
        girl.Notify();
        girl.setOrder(bakeMuttonCommand2);
        girl.Notify();
        girl.setOrder(bakeChickenWingCommand);
        girl.Notify();
    }
}
