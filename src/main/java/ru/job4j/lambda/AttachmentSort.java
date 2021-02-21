package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 3", 100),
                new Attachment("image 2", 34),
                new Attachment("image 1", 13)
        );
        Comparator<Attachment>  comparator =  new Comparator<>() {
            @Override
            public int compare(Attachment a1, Attachment a2) {
                return a1.getName().compareTo(a2.getName());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
    }
}
