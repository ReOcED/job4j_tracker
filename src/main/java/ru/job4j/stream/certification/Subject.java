package ru.job4j.stream.certification;

/**
 * 2. Аттестация [#49777]
 * Класс для хранения оценки по предмету.
 * Поля - имя (название) предмета и оценка по нему.
 * @author Aleksey Z
 * @version 0.1
 */

public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
