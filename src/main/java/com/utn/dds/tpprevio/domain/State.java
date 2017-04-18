package com.utn.dds.tpprevio.domain;
public class State {

    private final String id;
    private final String name;

    public State(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "["+id+"]-" + name 
                ;
    }
}
