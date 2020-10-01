package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.io.Input;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find By Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(tracker.findById(input.askStr("Enter id")));
        return true;
    }
}
