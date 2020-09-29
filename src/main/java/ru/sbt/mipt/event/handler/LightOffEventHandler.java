package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.event.LightOffEvent;

public class LightOffEventHandler {
    final private LightOffEvent event;

    public LightOffEventHandler(LightOffEvent event) { this.event = event; }

    public void handle(){
        event.getDevice().setOn(false);
        System.out.println("Light " + event.getDevice().getId() + " in room " + event.getPlace().getName() + " was turned off.");
    }

}
