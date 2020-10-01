package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.io.Input;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        if (!tracker.delete(input.askStr("Enter id"))) {
            System.out.println("Not found");
        }
        return true;
    }
}
