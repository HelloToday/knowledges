package com.bjs.knowledge.degisnmodel.prototype;

public abstract class Propotype{
    private String id;

    public Propotype(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  abstract Propotype clone();

}
