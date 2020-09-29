package ru.sbt.mipt.emulator;

import ru.sbt.mipt.event.*;
import ru.sbt.mipt.model.device.*;
import ru.sbt.mipt.model.place.Place;
import ru.sbt.mipt.model.place.Room;
import ru.sbt.mipt.model.place.SmartHome;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SensorEventCreator {
    private final Random random = new Random();
    private final SmartHome smartHome;

    public SensorEventCreator(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public SensorEvent getNextEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        double genRandom = random.nextDouble();
        System.out.println(genRandom);
        if (genRandom < 0.05) return null; // null means end of event stream

        SensorEventType[] types = SensorEventType.values();
        SensorEventType sensorEventType = types[random.nextInt(types.length)];
        System.out.println(sensorEventType);

        String objectId = (List.of(SensorEventType.LIGHT_ON, SensorEventType.LIGHT_OFF).contains(sensorEventType))
                ? String.valueOf(random.nextInt(9) + 1) : String.valueOf(random.nextInt(4) + 1);


        System.out.println(objectId);

        if (sensorEventType.equals(SensorEventType.LIGHT_ON)) {
            LightInRoom lightInRoom = findLight(objectId);
            Place room = lightInRoom.room;
            TurnableDevice light = lightInRoom.light;
            return new LightOnEvent(room, light);
        }
        if (sensorEventType.equals(SensorEventType.LIGHT_OFF)) {
            LightInRoom lightInRoom = findLight(objectId);
            Place room = lightInRoom.room;
            TurnableDevice light = lightInRoom.light;
            return new LightOffEvent(room, light);
        }
        if (sensorEventType.equals(SensorEventType.DOOR_OPEN)) {
            DoorInRoom doorInRoom = findDoor(objectId);
            Place room = doorInRoom.room;
            CanBeOpenDevice door = doorInRoom.door;
            return new DoorOpenEvent(room, door);
        }
        if (sensorEventType.equals(SensorEventType.DOOR_CLOSED)) {
            DoorInRoom doorInRoom = findDoor(objectId);
            Place room = doorInRoom.room;
            CanBeOpenDevice door = doorInRoom.door;
            return new DoorCloseEvent(smartHome, room, door);
        }
        return null;
    }

    static class DoorInRoom {
        private final Door door;
        private final Room room;

        public DoorInRoom(Door door, Room room) {
            this.door = door;
            this.room = room;
        }
    }

    static class LightInRoom {
        private final Light light;
        private final Room room;

        public LightInRoom(Light light, Room room) {
            this.light = light;
            this.room = room;
        }
    }


    private SensorEventCreator.DoorInRoom findDoor(String objectId) {
        return smartHome.getRooms().stream()
                .flatMap(room -> getDoor(objectId, room).map(d -> new SensorEventCreator.DoorInRoom(d, room)))
                .findFirst()
                .orElse(null);
    }

    private Stream<Door> getDoor(String objectId, Room room) {
        return room.getDoors().stream()
                .filter(door -> door.getId().equals(objectId));
    }

    private SensorEventCreator.LightInRoom findLight(String objectId) {
        return smartHome.getRooms().stream()
                .flatMap(room -> getLight(objectId, room).map(d -> new SensorEventCreator.LightInRoom(d, room)))
                .findFirst()
                .orElse(null);
    }

    private Stream<Light> getLight(String objectId, Room room) {
        return room.getLights().stream()
                .filter(light -> light.getId().equals(objectId));
    }
}