package ru.sbt.mipt.event;

import ru.sbt.mipt.model.device.CanBeOpenDevice;
import ru.sbt.mipt.model.place.Place;

public class DoorOpenEvent implements SensorEvent{
    final private Place place;
    final private CanBeOpenDevice device;

    public DoorOpenEvent(Place place, CanBeOpenDevice device) {
        this.place = place;
        this.device = device;
    }

    public Place getPlace() {
        return place;
    }

    public CanBeOpenDevice getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "DoorOpenEvent{" +
                "place=" + place.getName() +
                ", device=" + device.getId() +
                '}';
    }
}
