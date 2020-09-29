package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.event.LightOnEvent;

public class LightOnEventHandler {
    final private LightOnEvent event;

    public LightOnEventHandler(LightOnEvent event) {
        this.event = event;
    }

    public void handle(){
        event.getDevice().setOn(true);
        System.out.println("Light " + event.getDevice().getId() + " in room " + event.getPlace().getName() + " was turned on.");
    }

}
