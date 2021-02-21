package ru.job4j.collectionslite.sets;

import java.util.Objects;

public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return number.equals(task.number);

    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
