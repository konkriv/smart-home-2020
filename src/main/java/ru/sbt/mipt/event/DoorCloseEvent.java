package ru.sbt.mipt.event;

import ru.sbt.mipt.model.device.CanBeOpenDevice;
import ru.sbt.mipt.model.place.Place;
import ru.sbt.mipt.model.place.SmartHome;

public class DoorCloseEvent implements SensorEvent{
    final private SmartHome smartHome;
    final private Place place;
    final private CanBeOpenDevice device;

    public DoorCloseEvent(SmartHome smartHome, Place place, CanBeOpenDevice device) {
        this.smartHome = smartHome;
        this.place = place;
        this.device = device;
    }

    public SmartHome getSmartHome() {return smartHome;}
    public Place getPlace() {
        return place;
    }
    public CanBeOpenDevice getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "DoorCloseEvent{" +
                "place=" + place.getName() +
                ", device=" + device.getId() +
                '}';
    }
}
