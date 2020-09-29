package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.event.*;

public class EventHandlerImpl implements EventHandler {
    public void handleEvent(SensorEvent event) {
        System.out.println("Got event: " + event);
        if (event instanceof LightOnEvent) { new LightOnEventHandler((LightOnEvent) event).handle(); }
        if (event instanceof LightOffEvent) { new LightOffEventHandler((LightOffEvent) event).handle(); }
        if (event instanceof DoorOpenEvent) { new DoorOpenEventHandler((DoorOpenEvent) event).handle(); }
        if (event instanceof DoorCloseEvent) { new DoorCloseEvenHandler((DoorCloseEvent) event).handle(); }
    }
}
