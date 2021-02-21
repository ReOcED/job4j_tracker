package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(Predicate<Attachment> p, List<Attachment> l) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment a : l) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 3", 101),
                new Attachment("image 2", 34),
                new Attachment("image 1", 13)
        );

        Predicate<Attachment> size = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };

        Predicate<Attachment> name = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("1");
            }
        };

        for (Attachment a : SearchAtt.filter(size, attachments)) {
            System.out.println(a);
        }

        for (Attachment a : SearchAtt.filter(name, attachments)) {
            System.out.println(a);
        }
    }
}
