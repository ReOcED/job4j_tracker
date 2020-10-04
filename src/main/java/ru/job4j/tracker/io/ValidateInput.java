package ru.job4j.tracker.io;

public class ValidateInput implements Input {
    private final Input in;

    public ValidateInput(Input in) {
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
        boolean success = false;
        while (!success) {
            try {
                value = in.askInt(question);
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Не число");
            }
        }
        return value;
    }
}
