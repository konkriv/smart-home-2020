package ru.sbt.mipt.event;

import ru.sbt.mipt.model.device.TurnableDevice;
import ru.sbt.mipt.model.place.Place;

public class LightOnEvent implements SensorEvent {
    final private Place place;
    final private TurnableDevice device;

    public LightOnEvent(Place place, TurnableDevice device) {
        this.place = place;
        this.device = device;
    }

    public Place getPlace() {
        return place;
    }

    public TurnableDevice getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "LightOnEvent{" +
                "place=" + place.getName() +
                ", device=" + device.getId() +
                '}';
    }
}
