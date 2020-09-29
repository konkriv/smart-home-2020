package ru.sbt.mipt.factory;

import ru.sbt.mipt.model.place.SmartHome;

public interface SmartHomeReader {
    SmartHome loadState();
}
