package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}