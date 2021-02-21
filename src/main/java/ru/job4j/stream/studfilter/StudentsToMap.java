package ru.job4j.stream.studfilter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsToMap {
    public static Map<String, Student> mapStud(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student :: getSurname, st -> st));
    }
}
