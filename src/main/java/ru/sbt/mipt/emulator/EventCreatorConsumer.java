package ru.sbt.mipt.emulator;

import ru.sbt.mipt.event.SensorEvent;
import ru.sbt.mipt.event.handler.EventHandler;

public class EventCreatorConsumer {
    private final SensorEventCreator eventCreator;
    private final EventHandler eventHandler;

    public EventCreatorConsumer(SensorEventCreator eventCreator, EventHandler eventHandler) {
        this.eventCreator = eventCreator;
        this.eventHandler = eventHandler;
    }

    public void listen() {
        while (true) {
            SensorEvent event = eventCreator.getNextEvent();
            if (event == null) break;

            eventHandler.handleEvent(event);
        }
    }
}