package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[size++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(String id) {
        int index = this.indexOf(id);
        return index < 0 ? null : this.items[index];
    }

    public boolean replace(String id, Item item) {
        boolean rsl = false;
        int index = this.indexOf(id);
        if (index >= 0) {
            item.setId(this.items[index].getId());
            this.items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(String id) {
        boolean rsl = false;
        int index = this.indexOf(id);
        if (index != -1) {
            this.items[index] = this.items[--size];
            rsl = true;
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.size];
        int rslSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[rslSize++] = items[i];
            }
        }
        return Arrays.copyOf(result, rslSize);
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, size);
    }
}