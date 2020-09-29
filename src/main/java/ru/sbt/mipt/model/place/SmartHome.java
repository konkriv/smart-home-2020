package ru.sbt.mipt.model.place;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
//
//    private Light getLight(String objectId) {
//        return getRooms().stream().flatMap(room ->
//                room.getLights().stream().filter(light ->
//                        light.getId().equals(objectId)).findFirst().orElse(null));
////                .collect(Collectors.toList());
//    }
}
