package com.bjs.knowledge.designmodel.chainofresponsibility;

public class JutiHandler1 extends Handler {


    @Override
    public void handleRequest(int request) {
        if(request>=0 &&request<10){
            System.out.println(String.format("%s 处理请求 %s",this.getClass().getName(),request));
        }else if(this.successor!=null){
            successor.handleRequest(request);
        }
    }
}
