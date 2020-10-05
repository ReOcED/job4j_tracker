package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.*;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int item = -1;
            while (item < 0 || item >= actions.length) {
                item = input.askInt("Choose valid menu item");
            }
            run = actions[item].execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        int i = 0;
        for (UserAction action : actions) {
            System.out.println(i++ + " " + action.name());
        }
    }


    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        tracker.add(new Item("name"));
        tracker.add(new Item("name1"));
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new EditAction(),
                new ExitAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ShowAllAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
