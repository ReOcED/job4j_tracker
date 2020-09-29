package ru.job4j.tracker.inputs;

import ru.job4j.tracker.inputs.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());

    }
}
