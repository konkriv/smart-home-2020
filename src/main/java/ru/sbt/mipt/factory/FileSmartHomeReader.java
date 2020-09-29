package ru.sbt.mipt.factory;

import com.google.gson.Gson;
import ru.sbt.mipt.model.place.SmartHome;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSmartHomeReader {
    public SmartHome loadState() {
        try {
            Gson gson = new Gson();
            Path path = new File(getClass().getClassLoader().getResource("smart-home-1.js").getFile()).toPath();
            String json = new String(Files.readAllBytes(path));
            return gson.fromJson(json, SmartHome.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}