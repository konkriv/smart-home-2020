package ru.sbt.mipt.entrypoint;

import ru.sbt.mipt.emulator.EventCreatorConsumer;
import ru.sbt.mipt.emulator.SensorEventCreator;
import ru.sbt.mipt.event.handler.EventHandlerImpl;
import ru.sbt.mipt.factory.FileSmartHomeReader;
import ru.sbt.mipt.model.place.SmartHome;

public class SmartHomeApplication {
    public static void main(String... args) {
        SmartHome smartHome = initializeSmartHome();
        run(smartHome);
    }

    private static SmartHome initializeSmartHome() {
        return new FileSmartHomeReader().loadState();
    }

    private static void run(SmartHome smartHome) {
        new EventCreatorConsumer(new SensorEventCreator(smartHome), new EventHandlerImpl()).listen();
    }
}
