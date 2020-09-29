package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.event.DoorOpenEvent;

public class DoorOpenEventHandler {
    final private DoorOpenEvent event;

    public DoorOpenEventHandler(DoorOpenEvent event) {
        this.event = event;
    }

    public void handle(){
        event.getDevice().setOpen(true);
        System.out.println("Door " + event.getDevice().getId() + " in room " + event.getPlace().getName() + " was opened.");
    }
}
