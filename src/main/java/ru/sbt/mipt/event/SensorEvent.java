package ru.sbt.mipt.event;

import ru.sbt.mipt.model.device.Device;
import ru.sbt.mipt.model.place.Place;

public interface SensorEvent {
    Place getPlace();
    Device getDevice();
}
