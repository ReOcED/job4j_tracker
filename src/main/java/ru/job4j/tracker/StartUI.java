package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            boolean success = false;
            int select = input.askInt("Выбор пункта меню");
            if (select == 1) {
                for (Item i : StartUI.showAll(input, tracker)) {
                    System.out.println(i);
                }
                success = true;
            } else if (select == 2) {
                success = StartUI.editItem(input, tracker);
            } else if (select == 3) {
                success = StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                Item item = StartUI.findById(input, tracker);
                if (item != null) {
                    System.out.println(item);
                    success = true;
                }
            } else if (select == 5) {
                Item [] items = StartUI.findByName(input, tracker);
                if(items.length > 0) {
                    success = true;
                    for (Item i : items) {
                        System.out.println(i);
                    }
                }
            } else if (select == 6) {
                run = false;
                success = true;
            }
            if (!success) {
                System.out.println("Ошибка");
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        tracker.add(new Item(input.askStr("Введите имя")));
    }

    public static Item[] showAll(Input input, Tracker tracker) {
        return tracker.findAll();
    }

    public static boolean editItem(Input input, Tracker tracker) {
        boolean result = false;
        String id = input.askStr("Enter id");
        Item item = tracker.findById(id);
        if (item != null) {
            item.setName(input.askStr("Enter new name"));
            result = tracker.replace(id, item);
        }
        return result;
    }
    public static boolean deleteItem(Input input, Tracker tracker) {
        return tracker.delete(input.askStr("Enter id"));
    }

    public static Item findById(Input input, Tracker tracker) {
        return tracker.findById(input.askStr("Enter id"));
    }

    public static Item[] findByName(Input input, Tracker tracker) {
        return tracker.findByName(input.askStr("Enter name"));
    }


    private void showMenu() {

        System.out.println("Menu.");
        System.out.println("1.Show all");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find by ID");
        System.out.println("5.Find by name");
        System.out.println("6.Exit");
        /* добавить остальные пункты меню. */
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        tracker.add(new Item("name"));
        tracker.add(new Item("name1"));
        new StartUI().init(input, tracker);
    }
}
