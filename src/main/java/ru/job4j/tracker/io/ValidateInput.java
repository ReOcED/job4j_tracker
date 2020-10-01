package ru.job4j.tracker.io;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        int value = -1;
        boolean success = false;
        while (!success) {
            try {
                value = super.askInt(question);
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Не число");
            }
        }
        return value;
    }
}
