package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.inputs.Input;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id");
        Item item = tracker.findById(id);
        if (item != null) {
            item.setName(input.askStr("Enter new name"));
            tracker.replace(id, item);
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
