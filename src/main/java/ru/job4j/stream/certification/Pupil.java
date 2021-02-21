package ru.job4j.stream.certification;

import java.util.List;

/**
 * 2. Аттестация [#49777]
 * Ученик.
 * Содержит имя ученика и List<Subject>
 * @author Aleksey Z
 * @version 0.1
 */

public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
