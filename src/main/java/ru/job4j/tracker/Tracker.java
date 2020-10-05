package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        size++;
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    private int indexOf(String id) {
        int result = -1;
        int index = 0;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    public Item findById(String id) {
        int index = this.indexOf(id);
        return index < 0 ? null : this.items.get(index);
    }

    public boolean replace(String id, Item item) {
        int index = this.indexOf(id);
        if (index != -1) {
            this.items.set(index, item);
        }
        return index != -1;
    }

    public boolean delete(String id) {
        return this.items.removeIf(item -> item.getId().equals(id));
    }

    public ArrayList<Item> findByName(String key) {
        return new ArrayList<Item>(items.stream().filter(item -> item.getName().contains(key)).collect(Collectors.toList()));

    }

    public ArrayList<Item> findAll() {
        return new ArrayList<Item>(this.items);
    }

}