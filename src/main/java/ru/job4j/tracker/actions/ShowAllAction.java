package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.io.Input;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item i : tracker.findAll()) {
            System.out.println(i);
        }
        return true;
    }
}
