package ru.job4j.lambda;

import java.util.function.Supplier;

public class Visibility {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4};
        int[] total = {0};
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total[0] = add(
                    () -> total[0] + num
            );
        }

        System.out.println(total[0]);

    }


    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
