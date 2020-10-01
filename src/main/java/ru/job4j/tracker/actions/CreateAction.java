package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.io.Input;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Create Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        tracker.add(new Item(input.askStr("Введите имя")));
        return true;
    }
}
