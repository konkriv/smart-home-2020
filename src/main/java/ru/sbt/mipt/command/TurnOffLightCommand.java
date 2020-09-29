package ru.sbt.mipt.command;

import ru.sbt.mipt.event.LightOffEvent;
import ru.sbt.mipt.event.handler.LightOffEventHandler;
import ru.sbt.mipt.model.device.Light;
import ru.sbt.mipt.model.place.Place;

public class TurnOffLightCommand {
    final private Place place;
    final private Light light;

    public TurnOffLightCommand(Place place, Light light) {
        this.place = place;
        this.light = light;
    }

    public void run(){ new LightOffEventHandler(new LightOffEvent(place, light)).handle(); }
}
