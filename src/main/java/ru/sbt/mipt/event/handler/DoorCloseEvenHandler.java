package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.command.TurnOffAllLightsCommand;
import ru.sbt.mipt.event.DoorCloseEvent;

public class DoorCloseEvenHandler {
    final private DoorCloseEvent event;

    public DoorCloseEvenHandler(DoorCloseEvent event) {
        this.event = event;
    }

    public void handle() {
        event.getDevice().setOpen(false);
        System.out.println("Door " + event.getDevice().getId() + " in room " + event.getPlace().getName() + " was closed.");

        if (event.getPlace().getName().equals("hall")) {
            System.out.println("Send command to turn off all lights in home");
            new TurnOffAllLightsCommand(event.getSmartHome()).run();
        }
    }
}