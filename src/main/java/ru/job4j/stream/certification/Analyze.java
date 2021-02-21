package ru.job4j.stream.certification;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2. Аттестация [#49777]
 * Класс возвращает данные об учениках / предметах из stream
 * @author Aleksey Z
 * @version 0.1
 */

public class Analyze {
    /**
     * Средняя оценка по всем ученикам
     * @param stream стрим учеников
     * @return средняя оценка
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream()).mapToDouble(Subject::getScore).average().orElse(0D);
    }

    /**
     * Средняя оценка каждого ученика
     * @param stream стрим учеников
     * @return List с Tuple, в которых хранятся имя ученика и его средняя оценка.
     */

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream().map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Средняя оценка по каждому предмету.
     * @param stream стрим учеников
     * @return List с Tuple, в которых хранятся название предмета и средняя оценка по нему.
     */

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.
                map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Ученик с наибольшей суммой баллов.
     * @param stream стрим учеников
     * @return Tuple фамилия лучшего ученика и общая сумма его баллов.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects()
                .stream().mapToDouble(Subject :: getScore).sum()))
                    .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("default", 0D));
    }

    /**
     * Предмет с наибольшим количеством баллов.
     * @param stream стрим учеников
     * @return Tuple название предмета и общая сумма баллов по данному предмету для всех учеников.
     */

    public static Tuple bestSubject(Stream<Pupil> stream) {

        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject :: getScore)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .orElse(new Tuple("default", 0D));
    }

}