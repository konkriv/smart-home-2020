package ru.sbt.mipt.model.device;

public class Door implements CanBeOpenDevice{
    private final String id;
    private final boolean open;

    public Door(String id, boolean isOpen) {
        this.id = id;
        this.open = isOpen;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        open = open;
    }
}
