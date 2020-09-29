package ru.sbt.mipt.command;

import ru.sbt.mipt.model.place.SmartHome;

public class TurnOffAllLightsCommand {
    final private SmartHome smartHome;

    public TurnOffAllLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void run() {
        smartHome.getRooms().forEach(room ->
                room.getLights().forEach(light ->
                        new TurnOffLightCommand(room, light).run()
                )
        );
    }
}
