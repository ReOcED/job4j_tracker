package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            boolean success = false;
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                for (Item i : tracker.findAll()) {
                    System.out.println(i);
                }
                success = true;
            } else if (select == 2) {
                System.out.println("Введите id");
                Item item = tracker.findById((scanner.nextLine()));
                if (item != null) {
                    System.out.println("Введите новое имя");
                    item.setName(scanner.nextLine());
                    tracker.replace(item.getId(), item);
                    success = true;
                }
            } else if (select == 3) {
                System.out.println("Введите id");
                success = tracker.delete((scanner.nextLine()));
            } else if (select == 4) {
                System.out.println("Введите id");
                Item item = tracker.findById((scanner.nextLine()));
                if (item != null) {
                    System.out.println(item);
                    success = true;
                }
            } else if (select == 5) {
                System.out.println("Введите имя");
                Item [] items = tracker.findByName((scanner.nextLine()));
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        tracker.add(new Item("name"));
        tracker.add(new Item("name1"));
        new StartUI().init(scanner, tracker);
    }
}
