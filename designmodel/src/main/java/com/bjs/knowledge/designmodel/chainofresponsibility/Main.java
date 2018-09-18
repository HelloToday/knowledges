package com.bjs.knowledge.designmodel.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Handler h1 = new JutiHandler1();
        Handler h2 = new JutiHandler2();
        Handler h3 = new JutiHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        int[]  request = {2,4,13,18,33,3,30,23};

        for (int i = 0; i <request.length ; i++) {
            h1.handleRequest(request[i]);
        }
    }
}
