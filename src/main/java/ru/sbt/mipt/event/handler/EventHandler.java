package ru.sbt.mipt.event.handler;

import ru.sbt.mipt.event.SensorEvent;

public interface EventHandler {
    void handleEvent(SensorEvent event);
}
